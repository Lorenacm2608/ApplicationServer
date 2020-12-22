package flyshoes.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Lorena
 */
public class CifradoMD5 {

    public void cifrarTextoMD5(String texto) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte dataBytes[] = texto.getBytes(); // Texto a bytes
            messageDigest.update(dataBytes);
            byte resumen[] = messageDigest.digest(); // Se calcula el resumen

            /* System.out.println("Resumen del Mensaje: " + new String(resumen));
            System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));
             */
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    static String Hexadecimal(byte[] resumen) {
        String HEX = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1) {
                HEX += "0";
            }
            HEX += h;
        }
        return HEX.toUpperCase();
    }
}
