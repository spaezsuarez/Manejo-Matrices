package logic;

public class ManejoMatriz {
    
    private boolean isNan = false;

    public boolean getIsNan() {
        return isNan;
    }    

    public void escalonar(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double pivote = 1, aux = 0;

        for (int i = 0, j = 0; i < filas; i++, j++) {

            //Seleccionar el pivote
            if (matriz[i][j] != 0) {
                pivote = matriz[i][j];

            } else if (hayColumnasCeros(matriz, i, j)) {
                while(matriz[i][j] == 0){
                    j++;
                }
                pivote = matriz[i][j];
            } else {
                for (int k = i + 1; k < filas; k++) {
                    if (matriz[k][j] != 0) {
                        double[] temp = matriz[i];
                        matriz[i] = matriz[k];
                        matriz[k] = temp;
                        break;
                    }
                }
            }

            pivote = matriz[i][j];
            //Dividir la fila sobre el pivote
            for (int x = i; x < columnas; x++) {
                matriz[i][x] /= pivote;
            }

            //Convertir las filas de abajo cero
            for (int k = i + 1; k < filas; k++) {
                aux = matriz[k][j];
                for (int z = 0; z < columnas; z++) {
                    matriz[k][z] -= aux * matriz[i][z];
                }

            }
        }

  
    }

    public double rangoMatriz(double[][] matriz) {
        double rango = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    rango++;
                    break;
                }
            }

        }

        return rango;
    }

    public boolean hayColumnasCeros(double[][] ref, int row, int col) {
        int contadorColumnasCeros = 0;
        for (int i = row + 1; i < ref.length; i++) {
            if (ref[i][col] == 0) {
                contadorColumnasCeros++;
            }
        }
        
        return contadorColumnasCeros == ((ref.length - 1) - row);
    }

    
    public double[] Determinante(double[][] m) {

        double[] resultados = new double[3];
        int N = m.length, contadorCambios = 0;
        double determinante = 1,formula;

        int contador = 3;

        for (int i = 0; i < N - 1; i++) {
            contador += 6;

            int iterador = i + 1;
            while (m[i][i] == 0 && iterador < m.length) {
                if (hayColumnasCeros(m,i,i)) {
                    isNan = true;
                    break;
                }
                double[] temp = m[i];
                m[i] = m[iterador];
                m[iterador] = temp;
                contadorCambios++;
                iterador++;

            }
            //contador += 3;

            for (int k = i + 1; k < N; k++) {
                contador += 5;
                for (int j = i + 1; j < N; j++) {
                    contador += 16;
                    m[k][j] = m[k][j] - (m[k][i] * m[i][j]) / m[i][i];
                }
            }

        }

        for (int w = 0; w < N; w++) {
            determinante *= m[w][w];
        }

        for (int z = 0; z < contadorCambios; z++) {
            determinante *= -1;
        }

        formula = (21 * Math.pow(N, 2)) - (31 * N) + (((32 * Math.pow(N, 3)) - (159 * Math.pow(N, 2)) + (223 * N) - 96) / 6) + 10;

        resultados[0] = determinante;
        resultados[1] = contador;
        resultados[2] = formula;

        return resultados;
    }

}
