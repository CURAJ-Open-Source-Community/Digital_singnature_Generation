/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakey;
import java.io.FileOutputStream;
import java.security.*;
import javax.crypto.*;
//import com.jcraft.jsch.KeyPair;
/**
 *
 * @author mnnit
 */
public class JavaKey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
       //JSch jsch=new JSch();
       KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
       keyPairGenerator.initialize(1024);
       
       KeyPair keyPair = keyPairGenerator.generateKeyPair();
       
       //KeyPair keyPair=KeyPair.genKeyPair(jsch, KeyPair.DSA);
      // keyPair.setPassphrase("admin");
       //keyPair.writePrivateKey("mysk");
       // keyPair.writePublicKey("mysk"+".pub", "");
       
       
        System.out.println("private key is = "+keyPair.getPrivate().toString());
       System.out.println("public key is = "+keyPair.getPublic().toString());
       String pk=keyPair.getPublic().toString();
        
        Signature signature = Signature.getInstance("SHA1WithDSA");
        SecureRandom secureRandom = new SecureRandom();
        //KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
       //KeyPair keyPair = keyPairGenerator.generateKeyPair();
       //secureRandom.
        FileOutputStream keyfos = new FileOutputStream("suepk");
        
        keyfos.write(keyPair.getPrivate().getEncoded());
         keyfos.close();
         keyfos = new FileOutputStream("pubkey");
        
        keyfos.write(keyPair.getPublic().getEncoded());
         keyfos.close();
         
        //PrivateKey sk=keyPair.getPrivate();
       //PublicKey pub = keyPair.getPublic();
        //byte[] digitalSignature = keyPair.getSignature("Tarun".getBytes()); 
        
       signature.initSign(keyPair.getPrivate(), secureRandom);
        byte[] data = "Tarun3".getBytes("UTF-8");
        signature.update(data);
          byte[] digitalSignature = signature.sign();
          keyfos = new FileOutputStream("sign");
          keyfos.write(digitalSignature);
           keyfos.close();
          System.out.println("Digital Signature is : "+ digitalSignature);
         
          Signature signature2 = Signature.getInstance("SHA1WithDSA");

          signature2.initVerify(keyPair.getPublic());
           
           byte[] data2 = "Tarun3".getBytes("UTF-8");
           signature2.update(data2);

            boolean verified = signature2.verify(digitalSignature);
            System.out.println("Is signature is valid? : "+ verified);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        // TODO code application logic here
    }
    
}
