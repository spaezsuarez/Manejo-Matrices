package logic;

public class ManejoMatriz {

    public static void escalonar(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double pivote = 1, aux = 0;

        int contador = 2;

        for (int i = 0; i < filas; i++) {
            
            contador += 9;
            
            if (matriz[i][i] == 0) {
                int iterador = i + 1;
                contador += 2;
                do {
                    double[] temp = matriz[i];
                    matriz[i] = matriz[iterador];
                    matriz[iterador] = temp;
                    iterador++;
                    contador += 11;

                } while (matriz[i][i] == 0);
                contador += 3;
            }

            contador += 3;
            pivote = matriz[i][i];
           

            for (int j = i; j < filas; j++) {
                matriz[i][j] /= pivote;
                contador += 6;
            }

            for (int k = 0; k < filas; k++) {
                contador += 3;
                if (i < k) {
                    contador += 3;
                    aux = matriz[k][i];
                    for (int z = 0; z < columnas; z++) {
                        matriz[k][z] -= aux * matriz[i][z];
                        contador += 9;
                    }
                }
            }

        }

    }

    public static double rangoMatriz(double[][] matriz) {
        double rango = 0;
        int contadorFila = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    contadorFila++;
                }
            }
            if (contadorFila != matriz.length) {
                rango++;
            }
            contadorFila = 0;

        }

        return rango;
    }

    public static double[] Determinante(double[][] m) {

        double[] resultados = new double[3];
        int N = m.length, formula;
        double determinante = 1;
        
        int contador = 3;

        for (int i = 0; i < N - 1; i++) {
            contador += 9;

            if (m[i][i] == 0) {
                int iterador = i + 1;
                contador += 2;
                do {
                    double[] temp = m[i];
                    m[i] = m[iterador];
                    m[iterador] = temp;
                    iterador++;
                    contador += 10;

                } while (m[i][i] == 0);
                contador += 3;
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

        for (int i = 0; i < N; i++) {
            determinante *= m[i][i];
        }

        formula = 16 * ((N * N * N) - (3 * (N * N)) + (3 * N) + (((int) Math.pow(N - 2, 2) * (((int) Math.pow(N - 2, 2)))) / 4) - 1) + 5 * ((N * N) - (2 * N) - ((N - 2) * (N - 2) / 2) + 1) + 6 * ((N - 1) + 1) + 3;;

        resultados[0] = determinante;
        resultados[1] = contador;
        resultados[2] = formula;

        return resultados;
    }

}
