package algorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static algorithm.Utils.hexToString;

public class HMacEncode {
    private String hmac_algorithm;
    private String message;
    private String key;

    public HMacEncode(String hmac_algorithm, String key, String message){
        this.hmac_algorithm = hmac_algorithm;
        this.key = key;
        this.message = message;
    }

    public String generateHMAC() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(hmac_algorithm);
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), hmac_algorithm);
        mac.init(signingKey);
        mac.update(message.getBytes());
        byte[] hmac = mac.doFinal();
        return hexToString(hmac);
    }

    public String getKey() throws NoSuchAlgorithmException {
        return key;
    }


}
