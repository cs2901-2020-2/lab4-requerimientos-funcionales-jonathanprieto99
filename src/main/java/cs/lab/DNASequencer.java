package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        String ResultadoSecuencia="";
        for (int i = 0; i < part.size(); i++) {
            if (ResultadoSecuencia.equals("")){
                ResultadoSecuencia=part.get(i);
            }
            else {
                String comun="";
                for (int j = 0; j < ResultadoSecuencia.length(); j++) {
                    //logger.info("Word1: "+ResultadoSecuencia);
                    for (int k = 0; k < part.get(i).length(); k++) {
                        //logger.info("Word2: "+part.get(i));
                        if(ResultadoSecuencia.charAt(j)==part.get(i).charAt(k)){
                            comun+=ResultadoSecuencia.charAt(j);
                            break;
                        }
                    }
                }
                logger.info("Comun: "+comun);
                logger.info("Principal: "+ResultadoSecuencia);
                logger.info("Agregar: "+part.get(i).replace(comun,""));
                ResultadoSecuencia=ResultadoSecuencia.concat(part.get(i));
                logger.info("Concatenado: "+ResultadoSecuencia);
                ResultadoSecuencia=ResultadoSecuencia.replace(comun,"");
                logger.info("Esta Aca: "+ResultadoSecuencia);
            }
        }
        logger.info("Final: "+ResultadoSecuencia);
        return ResultadoSecuencia;
    }
}

