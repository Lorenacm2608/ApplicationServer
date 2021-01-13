/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.seguridad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

/**
 * Esta clase se encargará de la desencriptación de datos.
 *
 * @author Fredy
 */
public class Seguridad {

    private static PrivateKey privateKey;
    private static Cipher cipher;
    private static final Logger LOGGER = Logger.getLogger(Seguridad.class.getName());

    /**
     * Retorna el contenido de un fichero
     *
     * @param path Path del fichero
     * @return El texto del fichero
     */
    private static byte[] fileReader(String path) {
        byte ret[] = null;
        File file = new File(path);
        try {
            ret = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Transformar cadena hexadecimal en un array de bytes
     *
     * @param s
     * @return
     */
    private static byte[] hexStringToByteArray(String contrasenia) {
        if (contrasenia.length() % 2 == 1) {
            throw new IllegalArgumentException(
                    "Invalid hexadecimal String supplied.");
        }

        byte[] bytes = new byte[contrasenia.length() / 2];
        for (int i = 0; i < contrasenia.length(); i += 2) {
            bytes[i / 2] = hexToByte(contrasenia.substring(i, i + 2));
        }
        return bytes;
    }

    public static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if (digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: " + hexChar);
        }
        return digit;
    }

    /**
     * Contraseña encriptada con clave pública y convertida a hexadecimal
     *
     * @param contrasenia
     * @return contrasenia desincriptada
     */
    public static String desencriptarContrasenia(String contrasenia) {
        String pass = "";
        try {
            byte fileKey[] = fileReader("Private.key");
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(fileKey);
            privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytesDesencriptados = cipher.doFinal(hexStringToByteArray(contrasenia));
            pass = new String(bytesDesencriptados);

        } catch (Exception ex) {
            LOGGER.severe("Error al desencriptar con clave privada");
        }
        return cifradoSha(pass, "SHA1");
    }

    /**
     * Cifrado Sha1 para poder almacenar en la bd
     *
     * @param contrasenia
     * @param tipo de cifrado
     * @return contrasenia cifrada con SHA1
     */
    private static String cifradoSha(String contrasenia, String tipo) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance(tipo);
            md.update(contrasenia.getBytes());
            byte[] db = md.digest();
            hash = DatatypeConverter.printHexBinary(db).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Error al cifrar SHA1 " + e.getMessage());
        }
        return hash;
    }

}
