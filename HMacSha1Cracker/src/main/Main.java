package main;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
		List<String> keys = generateKeys24bits();
		String message = " 231456789 487654 500";
		String mac = "5807A9647ED99E98B8D197E608C1DE8BCFFA571F";
		for (String key : keys) {
			System.out.println(key);
			if (mac.equals(HmacSha1Signature.calculateRFC2104HMAC(message, key))) {
				System.out.println(key);
				break;
			}
		}

	}

	private static List<String> generateKeys32bits() {
		String[] characters = "0 1 2 3 4 5 6 7 8 9 A B C D E F".split(" ");
		String key = "";
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < 16; k++) {
					for (int l = 0; l < 16; l++) {
						for (int m = 0; m < 16; m++) {
							for (int n = 0; n < 16; n++) {
								for (int o = 0; o < 16; o++) {
									for (int p = 0; p < 16; p++) {
										key = characters[i] + characters[j] + characters[k] + characters[l]
												+ characters[m] + characters[n] + characters[o] + characters[p];
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

	private static List<String> generateKeys24bits() {
		String[] characters = "0 1 2 3 4 5 6 7 8 9 A B C D E F".split(" ");
		String key = "";
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < 16; k++) {
					for (int l = 0; l < 16; l++) {
						for (int m = 0; m < 16; m++) {
							for (int n = 0; n < 16; n++) {
								key = characters[i] + characters[j] + characters[k] + characters[l] + characters[m]
										+ characters[n];
								keys.add(key);
							}
						}
					}
				}
			}
		}
		return keys;
	}

}
