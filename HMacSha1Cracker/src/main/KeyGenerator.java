package main;

import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {
	
	public static void main(String[] args) {
		String[] elementos = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f".split(",");
		int n = 6; // Tipos para escoger
		int r = elementos.length; // Elementos elegidos
		generate(elementos, "", n, r);
	}

	public static List<String> generate(String[] elem, String act, int n, int r) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			res.add(act);
			System.out.println(act);
		} else {
			for (int i = 0; i < r; i++) {
				generate(elem, act + elem[i] + "", n - 1, r);
			}
		}
		return res;
	}
}
