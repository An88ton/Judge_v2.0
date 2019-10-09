package HitApple;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Transfer {

   // private final String ADDRESS = "http://localhost:8080/gameСommands/setSequence?choice=true";

    public void sendResult(boolean result) {
        try {
            String urlParameters = "choice=true";
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            String request = "http://localhost:8080/gameСommands/setSequence";
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
            }
        }catch (IOException e){

        }
    }
}
