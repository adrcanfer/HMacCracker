package algorithm;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {
    List<String> keys;

    public KeyGenerator(){
        this.keys = new ArrayList<>();
    }

    public List<String> generateKey(String[] elem, String act, int n, int r) {
        if (n == 0) {
            keys.add(act);
        } else {
            for (int i = 0; i < r; i++) {
                generateKey(elem, act + elem[i] + "", n - 1, r);
            }
        }
        return keys;
    }
}
