package logic;

public class ManejoMatriz {

    public static void escalonar(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double pivote = 1, aux = 0;

        int contador = 2;

        for (int i = 0; i < filas; i++) {

            if (i < filas) {

                contador += 9;

                if (matriz[i][i] == 0) {
                    double[] temp = matriz[i];
                    matriz[i] = matriz[i + 1];
                    matriz[i + 1] = temp;
                }

                contador += 6;
                pivote = matriz[i][i];
                System.out.println("Pivote: " + pivote);

                for (int j = i; j < columnas; j++) {
                    matriz[i][j] /= pivote;
                    contador += 6;
                }

                for (int k = i + 1; k < filas; k++) {
                    contador += 3;
                    contador += 3;
                    System.out.println("i: " + i);
                    System.out.println("k: " + k);
                    aux = matriz[k][i];
                    System.out.println(aux);
                    for (int z = 0; z < columnas; z++) {
                        double temp = matriz[k][z];
                        matriz[k][z] -= aux * matriz[i][z];
                        System.out.println(temp + " -= " + aux + " * " + matriz[i][z]);
                        contador += 9;

                    }
                    EscribirMatrizConsola(matriz);

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
        int N = m.length, formula, contadorCambios = 0;
        double determinante = 1;

        int contador = 3;

        for (int i = 0; i < N - 1; i++) {
            contador += 9;

            if (m[i][i] == 0) {
                //contador += 13;
                double[] temp = m[i];
                m[i] = m[i + 1];
                m[i + 1] = temp;
                contadorCambios++;

            }
            //contador += 3;

            //contador += 3;
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

        for (int i = 0; i < contadorCambios; i++) {
            determinante *= -1;
        }

        formula = (16 * ((N * N * N) - (3 * (N * N)) + (3 * N) + (((int) Math.pow((N - 2), 2) * (((int) Math.pow((N - 2), 2)))) / 4) - 1)) + (5 * ((N * N) - (2 * N) - ((N - 2) * (N - 2) / 2) + 1)) + (6 * ((N - 1) + 1)) + 3;

        resultados[0] = determinante;
        resultados[1] = contador;
        resultados[2] = formula;

        return resultados;
    }

    public static void EscribirMatrizConsola(double[][] Matriz) {

        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("---------------------");
    }

    public static void test() {
        int i, k, j;
        double[][] m = {
            {4, 5, 2, 3}, {3, 5, 3, 7}, {-3, 5, 1, 3}, {5, -5, -9, 3}
        };

        int n = 4;
        int c = 0;
        c = c + 1;
        for (i = 0; i < n - 1; i++) {
            c = c + 5;

            if (m[i][i] == 0) {
                //contador += 13;
                double[] temp = m[i];
                m[i] = m[i + 1];
                m[i + 1] = temp;

            }

            for (k = i + 1; k < n; k++) {
                c = c + 4;
                for (j = i + 1; j < n; j++) {
                    c = c + 16;
                    m[k][j] = m[k][j] - (m[k][i] * m[i][j]) / m[i][i];
                }// j
                c = c + 1;
            } // k
            c = c + 1;
        }
        c = c + 2;

        double d = 1;
        System.out.println(c);
        for (i = 0; i < n; i++) {
            d = d * m[i][i];
        }
    }
}
