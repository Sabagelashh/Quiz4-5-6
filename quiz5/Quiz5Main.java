// quiz5/Quiz5Main.java
package quiz5;

import quiz6.SpecialCommunicationManager;

public class Quiz5Main {
    public static void main(String[] args) {
        String commonUrl = "http://your-chatbot-service-url.com/api/chat";
        String specialUrl = "http://your-special-chatbot-service-url.com/api/special-chat";
        SpecialCommunicationManager specialCommManager = new SpecialCommunicationManager(commonUrl, specialUrl);
        UsrerInteractionManager uiManager = new UsrerInteractionManager(specialCommManager);
        uiManager.startChat();
    }
}
