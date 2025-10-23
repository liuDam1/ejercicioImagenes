package es.etg.es.imagen;

import java.io.File;
import java.io.IOException;

public class Main {
    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String MSG_ERROR_FICHERO = "Error: El archivo no existe";
    public static final String FICHERO_ENTRADA = "src/main/resources/dados.png";
    public static final String FICHERO_SALIDA = "src/main/resources/dados.jpg";
    public static final String[] COMANDO = { "convert", FICHERO_ENTRADA, FICHERO_SALIDA };
    
    public static void main(String[] args) {
        try {
            File archivoEntrada = new File(FICHERO_ENTRADA);
            if (!archivoEntrada.exists()) {
                System.out.println(MSG_ERROR_FICHERO);
                System.exit(1);
            }
            
            ejecutarComando(COMANDO);
            System.exit(0);
        } catch (IOException e) {
            System.out.println(MSG_ERROR);
            System.exit(34);
        } catch (InterruptedException e) {
            System.out.println(MSG_ERROR);
            System.exit(35);
        }
    }

    private static Process ejecutarComando(String[] comando) throws IOException, InterruptedException {
        Process proceso = Runtime.getRuntime().exec(comando);
        int exitCode = proceso.waitFor();
        
        if (exitCode != 0) {
            System.exit(35);
        }
        
        return proceso;
    }
}