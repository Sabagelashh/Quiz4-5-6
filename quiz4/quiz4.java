// quiz4/Quiz4.java
package quiz4;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class Quiz4 {
    public static void main(String[] args) {
        // JSON format description
        String jsonFormat = "{ \"message\": \"User's message\", \"history\": \"Conversation history\" }";
        System.out.println("JSON Format for POST request: " + jsonFormat);

        // Example conversation
        String exampleConversation = "User: Hello\nChatbot: Good day\nUser: What time is it?\nChatbot: 9:00 AM\n";
        System.out.println("Example conversation:\n" + exampleConversation);

        // JSON examples
        Map<String, String> chatData1 = new HashMap<>();
        chatData1.put("message", "Hello");
        chatData1.put("history", "");

        Map<String, String> chatData2 = new HashMap<>();
        chatData2.put("message", "What time is it?");
        chatData2.put("history", "Hello, Good day");

        Gson gson = new Gson();
        String jsonExample1 = gson.toJson(chatData1);
        String jsonExample2 = gson.toJson(chatData2);

        System.out.println("JSON Example 1: " + jsonExample1);
        System.out.println("JSON Example 2: " + jsonExample2);
    }
}
