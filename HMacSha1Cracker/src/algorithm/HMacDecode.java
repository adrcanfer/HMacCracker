package algorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static algorithm.Utils.hexToString;

public class HMacDecode {
    private String hmac_algorithm;
    private String message;
    private String hmac;

    public HMacDecode(String hmac_algorimth, String message, String hmac){
        this.hmac_algorithm = hmac_algorimth;
        this.message = message;
        this.hmac = hmac;
    }

    public String hackKey() throws NoSuchAlgorithmException, InvalidKeyException {
        boolean status = false;
        String key = "";
        while (!status){
            Mac mac = Mac.getInstance(hmac_algorithm);
            KeyGenerator keyGenerator= KeyGenerator.getInstance(hmac_algorithm);
            SecretKey secretKey = keyGenerator.generateKey();
            mac.init(secretKey);
            mac.update(message.getBytes());
            byte[] hmac = mac.doFinal();
            if(hexToString(hmac).equals(hmac)){
                key = secretKey.toString();
                break;
            }
        }
        return key;
    }

}
