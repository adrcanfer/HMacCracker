package main;

import algorithm.HMacDecode;
import algorithm.HMacEncode;
import algorithm.Utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
	static String message = "34567891 987654 300";
	static String mac = "ada141975ed739fe27e50cab4b5dd5a7c96553b1";
	static long start = System.currentTimeMillis();
	
	/*public static void main(String[] args) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
		System.out.println("Generando claves");
		String[] elementos = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f".split(",");
        int n = 8;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
		String key = hash(elementos, "", n, r);
	}
	
	public static String hash(String[] elem, String act, int n, int r) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException  {
		String key ="";
		if (n == 0) {
			System.out.println(act);
			if (mac.equals(HmacSha1Signature.calculateRFC2104HMAC(message, act))) {
				System.out.println("Found!!!!!!!!!!!!!!!!!");
				System.out.println(act);
				key = act;
				long stop = System.currentTimeMillis();
				System.out.println(stop-start);
				throw new IllegalAccessError(act);
			}
		} else {
			for (int i = 0; i < r; i++) {
				hash(elem, act + elem[i] + "", n - 1, r);
				if(key != "") {
					break;
				}
			}
		}
		return key;


	}*/

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
		HMacEncode hMacEncode = new HMacEncode("HmacSHA1", "hola");
		String hmac = hMacEncode.generateHMAC();
		HMacDecode hMacDecode = new HMacDecode("HmacSHA1", "hola", hmac);
		String key = hMacDecode.hackKey();
		System.out.println(key);
	}

}
