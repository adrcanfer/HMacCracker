package algorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static algorithm.Utils.hexToString;

public class HMacEncode {
    private String hmac_algorithm;
    private String message;
    private SecretKey key;

    public HMacEncode(String hmac_algorimth, String message){
        this.hmac_algorithm = hmac_algorimth;
        this.message = message;
    }

    public String generateHMAC() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(hmac_algorithm);

        mac.init(getKey());
        mac.update(message.getBytes());
        byte[] hmac = mac.doFinal();
        System.out.println(hmac.toString());
        return hexToString(hmac);
    }

    public SecretKey getKey() throws NoSuchAlgorithmException {
        if(key == null){
            KeyGenerator keyGenerator= KeyGenerator.getInstance(hmac_algorithm);
            SecretKey secretKey = keyGenerator.generateKey();
            key = secretKey;
        }
        return key;
    }

    public String getKeyString() throws NoSuchAlgorithmException {
        return getKey().toString();
    }
}
