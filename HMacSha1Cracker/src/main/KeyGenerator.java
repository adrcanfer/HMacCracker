package main;

import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {

	static int count = 0;

	public static List<String> combinaciones(String primero, String cadena, int lenght) {
		List<String> res = new ArrayList<>();
		if (cadena.length() == 2) {
			count = count + 2;
			System.out.println(primero + cadena.charAt(1) + "" + cadena.charAt(0));
			System.out.println(primero + cadena.charAt(0) + "" + cadena.charAt(1));
		} else {
			for (int i = 0; i < cadena.length(); i++) {
				combinaciones(primero + cadena.charAt(i), quitarLetra(cadena, i), lenght);
			}
		}
		return res;
	}

	public static String quitarLetra(String cadena, int i) {
		if (i == 0) {
			return cadena.substring(i + 1, cadena.length());
		} else {
			if (i == cadena.length()) {
				return cadena.substring(0, cadena.length() - 1);
			} else {
				return cadena.substring(0, i) + cadena.substring(i + 1, cadena.length());
			}
		}
	}

	public static void main(String args[]) {
		String cadena = "abcde";
		System.out.println("combinaciones de :" + cadena);
		combinaciones("", cadena, 1);
		System.out.println("total:" + count);
	}

}
