package flyshoes.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Lorena
 */
public class CifradoSHA {

    /**
     * Aplica SHA al texto pasado por parámetro
     *
     * @param texto
     */
    public void cifrarTexto(String texto) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            byte dataBytes[] = texto.getBytes(); // Texto a bytes
            messageDigest.update(dataBytes);
            byte resumen[] = messageDigest.digest(); // Se calcula el resumen

            System.out.println("Mensaje original: " + texto);
   
            System.out.println("Resumen del Mensaje: " + new String(resumen));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CifradoSHA cifradoSHA = new CifradoSHA();
        cifradoSHA.cifrarTexto("Mensaje super secreto");
    }
}
