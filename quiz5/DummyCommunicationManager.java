// quiz5/DummyCommunicationManager.java
package quiz5;

public class DummyCommunicationManager extends CommunicationManager {
    @Override
    public String sendMessage(String message, String history) {
        return "This is a dummy response for message: " + message;
    }
}