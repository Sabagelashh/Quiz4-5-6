// quiz5/CommunicationManager.java
package quiz5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class CommunicationManager {
    private static final String CHATBOT_URL = "http://your-chatbot-service-url.com/api/chat";

    public String sendMessage(String message, String history) {
        HttpClient client = HttpClient.newHttpClient();
        Map<String, String> chatData = new HashMap<>();
        chatData.put("message", message);
        chatData.put("history", history);

        Gson gson = new Gson();
        String json = gson.toJson(chatData);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(CHATBOT_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                return "Error: " + response.statusCode() + " - " + response.body();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: Unable to communicate with the chatbot service.";
        }
    }
}
