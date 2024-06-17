// quiz5/UsrerInteractionManager.java
package quiz5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class UsrerInteractionManager {
    private CommunicationManager commManager;

    public UsrerInteractionManager(CommunicationManager commManager) {
        this.commManager = commManager;
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();
        while (true) {
            System.out.print("User: ");
            String userMessage = scanner.nextLine();
            if (userMessage.equalsIgnoreCase("exit")) break;
            String response = commManager.sendMessage(userMessage, String.join(", ", history));
            System.out.println("Chatbot: " + response);
            history.add(userMessage);
            history.add(response);
        }
        scanner.close();
    }
}