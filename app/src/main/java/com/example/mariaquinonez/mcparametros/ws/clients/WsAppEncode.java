package com.example.mariaquinonez.mcparametros.ws.clients;

/**
 * Created by maria.quinonez on 19/12/2017.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;
import android.util.Base64;
import android.util.Log;

import com.example.mariaquinonez.mcparametros.BuildConfig;


public class WsAppEncode {

    public static String hashSHA256(String pJson){
        try{
            byte ptext[] = pJson.getBytes();
            pJson = new String(ptext, "ISO-8859-1");
            String secretKey="475b72303336755ec79f";
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeToString(sha256_HMAC.doFinal(pJson.getBytes()), Base64.DEFAULT);
            hash = hash.replace("\n", "");
            String hashUrlEncoded = URLEncoder.encode(hash);
            return hashUrlEncoded;
        }catch (Exception e){
            Log.d(null, "Error in hash generation . "  + e.getMessage());
        }

        return null;
    }
public static String encoded(String pJson){

    String encode = URLEncoder.encode(pJson);
    Log.d("JsonEncodificado@",encode);
    return encode;
}

}
