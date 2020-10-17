package logic;

import static java.lang.Double.NaN;

public class ManejoMatriz {

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

        /*for (int i = 0; i < filas; i++) {

            if (i < filas) {
                pivote = matriz[i][i];
                
                int iterador = i + 1;
                while (matriz[i][i] == 0 && iterador < matriz.length) {
                    if (hayColumnasCeros(matriz, i)) {
                        pivote = matriz[i][i+1];
                        break;
                    }
                    double[] temp = matriz[i];
                    matriz[i] = matriz[iterador];
                    matriz[iterador] = temp;
                    iterador++;

                }
                
                System.out.println(pivote);

                for (int j = i; j < columnas; j++) {
                    matriz[i][j] /= pivote;

                }

                for (int k = i + 1; k < filas; k++) {

                    aux = matriz[k][i];
                    for (int z = 0; z < columnas; z++) {
                        double temp = matriz[k][z];
                        matriz[k][z] -= aux * matriz[i][z];

                    }
                    System.out.println("------------------------------------");
                    imprimir(matriz);

                }
            }

        }*/
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
        //System.out.println(contadorColumnasCeros == (ref.length - row +1));
        return contadorColumnasCeros == ((ref.length - 1) - row);
    }

    public boolean hayColumnasCeros(double[][] ref, int col) {
        int contadorColumnasCeros = 0;
        for (int i = 0; i < ref.length; i++) {
            if (ref[i][col] == 0) {
                contadorColumnasCeros++;
            }
        }
        return contadorColumnasCeros >= (ref.length - 1);
    }

    public double[] Determinante(double[][] m) {

        double[] resultados = new double[3];
        int N = m.length, formula, contadorCambios = 0;
        double determinante = 1;

        int contador = 3;

        for (int i = 0; i < N - 1; i++) {
            contador += 6;

            int iterador = i + 1;
            while (m[i][i] == 0 && iterador < m.length) {
                if (hayColumnasCeros(m, i)) {
                    determinante = NaN;
                    break;
                }
                double[] temp = m[i];
                m[i] = m[iterador];
                m[iterador] = temp;
                contadorCambios++;
                iterador++;

            }
            contador += 3;

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

        //formula = (16 * ((N * N * N) - (3 * (N * N)) + (3 * N) + (((int) Math.pow((N - 2), 2) * (((int) Math.pow((N - 2), 2)))) / 4) - 1)) + (5 * ((N * N) - (2 * N) - ((N - 2) * (N - 2) / 2) + 1)) + (6 * ((N - 1) + 1)) + 3;
        formula = (21 * (int) Math.pow(N, 2)) - (36 * N) + (((32 * (int) Math.pow(N, 3)) - (159 * (int) Math.pow(N, 2)) + (253 * N) - 126) / 6) + 24;

        resultados[0] = determinante;
        resultados[1] = contador;
        resultados[2] = formula;

        return resultados;
    }

}
