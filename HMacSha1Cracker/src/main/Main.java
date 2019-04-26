package main;

import algorithm.HMacDecode;
import algorithm.HMacEncode;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
        String message = "Hello World!!";
        HMacEncode hMacEncode = new HMacEncode("HmacSHA1", "ab2300", message);
        String hmac = hMacEncode.generateHMAC();
        System.out.println(hmac);
        System.out.println(hMacEncode.getKey());
        String[] elementos = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f".split(",");
        //String[] elementos = "0,1,2,3,4,5,6,7,8,9".split(",");
        int n = 6; // Tipos para escoger
        int r = elementos.length; // Elementos elegidos
        long start = System.currentTimeMillis();
        HMacDecode hMacDecode = new HMacDecode("HmacSHA1", message, hmac);
        long stop = System.currentTimeMillis();
        String key = hMacDecode.hackKey(elementos, n, r);
        System.out.println("Clave:" + key);
        System.out.println("Tiempo:" + (stop - start));
    }

}
