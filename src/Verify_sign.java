package javakey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mnnit
 */
import java.security.*;
import javax.crypto.*;
import com.jcraft.jsch.KeyPair;
public class Verify_sign {
    public static void main(String arg[])
    {
        Signature signature = Signature.getInstance("SHA256WithDSA");
        SecureRandom secureRandom = new SecureRandom();
        //KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
       // KeyPair keyPair = keyPairGenerator.generateKeyPair();
       //secureRandom.
        
        //PrivateKey sk=keyPair.getPrivate();
       // PublicKey pub = keyPair.getPublic();
        
      
       // signature.initSign(keyPair.getPrivate(), secureRandom);
        byte[] data = "Tarun".getBytes("UTF-8");
        signature.update(data);
          byte[] digitalSignature = signature.sign();
          
          System.out.println("Digital Signature is : "+ digitalSignature);
         
          Signature signature2 = Signature.getInstance("SHA256WithDSA");

          // signature2.initVerify(keyPair.getPublic());
           
           byte[] data2 = "Tarun".getBytes("UTF-8");
           signature2.update(data2);

            boolean verified = signature2.verify(digitalSignature);
            System.out.println("Is signature is valid? : "+ verified);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
