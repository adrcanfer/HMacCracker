package algorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HMacDecode {
    private String hmac_algorithm;
    private String message;
    private String hmac;

    public HMacDecode(String hmac_algorithm, String message, String hmac){
        this.hmac_algorithm = hmac_algorithm;
        this.message = message;
        this.hmac = hmac;
    }

    public String hackKey(String[] elem, int n, int r) throws NoSuchAlgorithmException, InvalidKeyException {
        boolean status = false;
        String res = "";
        System.out.println("Generating keys...........");
        KeyGenerator keyGenerator = new KeyGenerator();
        List<String> keys = keyGenerator.generateKey(elem, "", n, r);
        System.out.println(keys.size());
        System.out.println("Generation finished.");
        System.out.println("Calculating hmac..........");
        for (String key: keys){
            HMacEncode hMacEncode = new HMacEncode(hmac_algorithm, key, message);
            String calculatedHMac = hMacEncode.generateHMAC();
            if(calculatedHMac.equals(hmac)){
               res = key;
               System.out.println("Found key.");
               break;
            }
        }
        return res;
    }

}
