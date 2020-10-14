package logic;

public class ManejoMatriz {

    public static void escalonar(double[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        double pivote = 1, aux = 0;

        int contador = 2;

        for (int i = 0; i < filas; i++) {

            pivote = matriz[i][i];
            contador += 5;

            for (int j = i; j < filas; j++) {
                matriz[i][j] /= pivote;
                contador += 6;
            }
            contador += 2;

            for (int k = 0; k < filas; k++) {
                contador += 3;
                if (i < k) {
                    contador += 5;
                    aux = matriz[k][i];
                    for (int z = 0; z < filas; z++) {
                        matriz[k][z] -= aux * matriz[i][z];
                        contador += 9;
                    }
                }
            }

            contador += 2;
        }

    }

    public static double[] Determinante(double[][] m) {

        double[] resultados = new double[3];
        int N = m.length, formula;
        int contador = 3;
        double determinante = 1;

         for (int i = 0; i < N - 1; i++) {
            contador = contador + 5;
            /*  
        if(m[i][i]==0){
            //intercambiar fila i con una fila
              //posterior
          }
             */
            for (int k = i + 1; k < N; k++) {
                contador = contador + 4;
                for (int j = i + 1; j < N; j++) {
                    contador = contador + 16;
                    m[k][j] = m[k][j] - (m[k][i] * m[i][j]) / m[i][i];
                }// j
                contador = contador + 1;
            } // k
            contador = contador + 1;
        }

        for (int i = 0; i < N; i++) {
            determinante *= m[i][i];
        }

        formula = 16 * (1);
        resultados[0] = determinante;
        resultados[1] = contador;
        resultados[2] = formula;

        return resultados;
    }

    public static double test(double[][] m) {
        int i, k, j;
        
        int n = 4;
        int c = 0;
        c = c + 1;
        for (i = 0; i < n - 1; i++) {
            c = c + 5;
            /*  
        if(m[i][i]==0){
            //intercambiar fila i con una fila
              //posterior
          }
             */
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
        for (i = 0; i < n; i++) {
            d = d * m[i][i];
        }

        return d;
    }

}
