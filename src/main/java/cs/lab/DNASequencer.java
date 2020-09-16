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
            if(ResultadoSecuencia.contains(part.get(i))){
                logger.info("Ya contenia la cadena de caracter.");
            }
            else {
                StringBuilder comun = new StringBuilder();
                for (int j = 0; j < ResultadoSecuencia.length(); j++) {
                    for (int k = 0; k < part.get(i).length(); k++) {
                        if(ResultadoSecuencia.charAt(i)==part.get(i).charAt(j)){
                            comun.append(ResultadoSecuencia.charAt(i)).append(" ");
                            break;
                        }
                    }
                }
                ResultadoSecuencia=ResultadoSecuencia.concat(part.get(i).replace(comun,""));
                logger.info(ResultadoSecuencia);
            }
        }
        logger.info("Final: "+ResultadoSecuencia);
        return ResultadoSecuencia;
    }
}

