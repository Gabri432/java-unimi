package chatbot;

public class ChatBot {
    private void start() {
        System.out.println("Hi! I'm Bob! I'm here to talk about NBA related content.");
        System.out.println("Let's chat!");
        System.out.println("What is your favorite player or team?");
        System.out.println("Do you play basketball or any other sport?");
    }
    

    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot();
        chatBot.start();
    }
}
