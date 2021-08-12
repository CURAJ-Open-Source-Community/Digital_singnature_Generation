/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakey;
import java.io.FileOutputStream;
import java.security.*;
import javax.crypto.*;
import java.io.FileInputStream;
import java.security.spec.X509EncodedKeySpec;
/**
 *
 * @author mnnit
 */
public class CheckDS {
    
    //PrivateKey sk=keyPair.getPrivate();
     public static void main(String[] args) {
    try{
    FileInputStream rk = new FileInputStream("pubkey");
    byte[] pubkey = new byte[rk.available()];
    rk.read(pubkey);
    X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pubkey);
    KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
    PublicKey pub = keyFactory.generatePublic(pubKeySpec);
    
    FileInputStream sigfis = new FileInputStream("sign");
    byte[] sigToVerify = new byte[sigfis.available()]; 
    sigfis.read(sigToVerify);
    sigfis.close();
    System.out.println("Digital Signature is : "+ sigToVerify);
    Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
    sig.initVerify(pub);
    byte[] data = "Tarun3".getBytes("UTF-8");
       sig.update(data);
       boolean verifies = sig.verify(sigToVerify);

      System.out.println("signature verifies: " + verifies);
       //PublicKey pub = keyPair.getPublic();
    }
    catch(Exception e)
    {
        
    }
     }
}
