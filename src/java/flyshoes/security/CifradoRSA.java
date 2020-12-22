/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyshoes.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author 2dam
 */
public class CifradoRSA {

    //Método para guardar la clave dentro del fichero indicado
    public static void saveKey(Key key, String ejemploRSA_Publickey) throws IOException {
        byte[] publicKeyBytes = key.getEncoded();
        FileOutputStream fos = new FileOutputStream(ejemploRSA_Publickey);
        fos.write(publicKeyBytes);
        fos.close();
    }

    //Método para cargar la clave pública, se encarga de leer el fichero indicado 
    public static PublicKey loadPublicKey(String ejemploRSA_Publickey) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream fis = new FileInputStream(ejemploRSA_Publickey);
        int numBtyes = fis.available();
        byte[] bytes = new byte[numBtyes];
        fis.read(bytes);
        fis.close();

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(bytes);
        PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
        return keyFromBytes;
    }

    //Método para cargar la clave privada, se encarga de leer el fichero indicado
    public static PrivateKey loadPrivateKey(String ejemploRSA_Publickey) throws InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        FileInputStream fis = new FileInputStream(ejemploRSA_Publickey);
        int numBtyes = fis.available();
        byte[] bytes = new byte[numBtyes];
        fis.read(bytes);
        fis.close();

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
        return keyFromBytes;
    }

    //Cipher. Funcionalidad de cifrado y descifrado
    private static Cipher rsa;

    public static void main(String[] args) throws NoSuchPaddingException, IOException, InvalidKeySpecException {
        try {
            //Generar el par de claves
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            //Se guarda la clave pública en el fichero indicado
            saveKey(publicKey, "EjemploRSA_Public.key");
            publicKey = loadPublicKey("EjemploRSA_Public.key");

            //Se guarda la clave privada en el fichero indicado
            saveKey(privateKey, " EjemploRSA_Private.key");
            privateKey = loadPrivateKey(" EjemploRSA_Private.key");

            //Obtener la clase para encriptat/desencriptar
            rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            //Texto que queremos encriptar
            String text = "Hola Mundo!";

            //Proceso de encriptamiento de la clave publica
            rsa.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encriptado = rsa.doFinal(text.getBytes());

            //Encriptamiento
            for (byte b : encriptado) {
                System.out.println(Integer.toHexString(0xFF & b));
            }

            //Desencriptamiento de la clave privada
            rsa.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytesDesencriptados = rsa.doFinal(encriptado);
            String textoDesencriptado = new String(bytesDesencriptados);

            //Texto desencriptado
            System.out.println("Mensaje desencriptado --> " + textoDesencriptado);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CifradoRSA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(CifradoRSA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(CifradoRSA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(CifradoRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
