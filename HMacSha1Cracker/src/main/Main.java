package main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
		List<String> keys = generateKeys();
		String message = "hola";
		String mac = "6457f8187d7165dca3985a7f188c3bff22e7f4c7";
		for (String key : keys) {
			if(mac.equals(HmacSha1Signature.calculateRFC2104HMAC(message, key))){
				System.out.println(key);
			}
		}
		
		
	}
	
	private static List<String> generateKeys() {
		String[] characters = "0 1 2 3 4 5 6 7 8 9 A B C D E F".split(" ");
		String key = "";
		List<String> keys = new ArrayList<>();
		for (int i=0; i<16; i++) {
			for(int j=i; j<16; j++) {
				for(int k=j; k<16; k++) {
					for(int l=k; l<16; l++) {
						for(int m=l; m<16; m++) {
							for(int n=m; n<16; n++) {
								for(int o=n; o<16; o++) {
									for(int p=o; p<16; p++) {
										key = characters[i] + characters[j] + characters[k] + characters[l] + characters[m]+ characters[n]+ characters[o]+ characters[p];
										keys.add(key);
									}
								}
							}
						}
					}
				}
			}
		}
		return keys;
	}

}
