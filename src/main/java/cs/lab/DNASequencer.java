package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){

        String cadenaresultante = "";

        for (String s : part) {
            if (cadenaresultante.length() == 0) {
                cadenaresultante = s;
            } else {
                cadenaresultante = imprimiradn(cadenaresultante, s);
            }

        }

        logger.info(cadenaresultante);
        return cadenaresultante;

    }

    public String reverse(String palabra)
    {
        StringBuilder sb = new StringBuilder(palabra);
        return (sb.reverse().toString());
    }

    public int [][] buildmatrix(String palabra1, String palabra2){

        int sizeword1=palabra1.length();
        int sizeword2=palabra2.length();

        int [][] matriz = new int[sizeword1+1][sizeword2+1];

        for (int i = 0; i < sizeword1; ++i){
            for (int j = 0; j <= sizeword2; ++j){
                if(i == 0){
                    matriz[i][j] = j;
                }
                else if(j == 0){
                    matriz[i][j] = i;
                }
                else if(palabra1.charAt(i-1) == palabra2.charAt(j-1)){
                    matriz[i][j] = 1 + matriz[i-1][j-1];
                }
                else{
                    matriz[i][j] = 1 + Math.min(matriz[i - 1][j], matriz[i][j - 1]);

                }
            }
        }
        return matriz;
    }

    public String imprimiradn(String palabra1, String palabra2){


        int [][] matriz = buildmatrix(palabra1,palabra2);


        StringBuilder palabraresultante= new StringBuilder();

        int tamanowhile1 = palabra1.length();
        int tamanowhile2 = palabra2.length();

        while (tamanowhile1 > 0 && tamanowhile2 > 0)
        {
            if (palabra1.charAt(tamanowhile1 - 1) == palabra2.charAt(tamanowhile2 - 1))
            {
                palabraresultante.append(palabra1.charAt(tamanowhile1 - 1));
                --tamanowhile1;
                --tamanowhile2;
            }

            else if (matriz[tamanowhile1 - 1][tamanowhile2] > matriz[tamanowhile1][tamanowhile2 - 1])
            {
                palabraresultante.append(palabra2.charAt(tamanowhile2 - 1));
                --tamanowhile2;
            }

            else
            {
                palabraresultante.append(palabra1.charAt(tamanowhile1 - 1));
                --tamanowhile1;
            }
        }

        while (tamanowhile1 > 0)
        {
            palabraresultante.append(palabra1.charAt(tamanowhile1 - 1));
            --tamanowhile1;
        }

        while (tamanowhile2 > 0)
        {
            palabraresultante.append(palabra2.charAt(tamanowhile2 - 1));
            --tamanowhile2;
        }

        palabraresultante = new StringBuilder(reverse(palabraresultante.toString()));

        return palabraresultante.toString();
    }
}

