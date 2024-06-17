// quiz6/SpecialCommunicationManager.java
package quiz6;

import quiz5.CommunicationManager;

public class SpecialCommunicationManager extends CommunicationManager {
    private final String commonUrl;
    private final String specialUrl;

    public SpecialCommunicationManager(String commonUrl, String specialUrl) {
        this.commonUrl = commonUrl;
        this.specialUrl = specialUrl;
    }

    @Override
    public String sendMessage(String message, String history) {
        String url = commonUrl;
        if (message.contains("help") || history.contains("help")) {
            url = specialUrl;
        }

        return super.sendMessage(message, history, url);
    }

    // Overloaded sendMessage method that accepts the URL as a parameter
    protected String sendMessage(String message, String history, String url) {
        // Implementation from CommunicationManager, but with the provided URL
        HttpClient client = HttpClient.newHttpClient();
        Map<String, String> chatData = new HashMap<>();
        chatData.put("message", message);
        chatData.put("history", history);

        Gson gson = new Gson();
        String json = gson.toJson(chatData);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
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
