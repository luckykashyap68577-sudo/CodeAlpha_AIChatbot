import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AIChatbotGUI extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AIChatbotGUI() {

        setTitle("CodeAlpha AI Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        chatArea.append("Bot: Welcome to CodeAlpha AI Chatbot!\n\n");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty())
            return;

        chatArea.append("You: " + userInput + "\n");

        String message = userInput.toLowerCase();
        String response;

        if (message.equals("hi") || message.equals("hello")) {
            response = "Hello! How can I help you?";
        }
        else if (message.contains("java")) {
            response = "Java is an object-oriented programming language.";
        }
        else if (message.contains("internship")) {
            response = "CodeAlpha provides internship opportunities in various domains.";
        }
        else if (message.contains("project")) {
            response = "You can work on Java, AI, Web Development and other projects.";
        }
        else if (message.contains("name")) {
            response = "My name is CodeAlpha AI Chatbot.";
        }
        else if (message.contains("bye")) {
            response = "Goodbye! Have a great day.";
        }
        else if (message.contains("help")) {
            response = "I can answer questions about Java, internships and projects.";
        }
        else {
            response = "Sorry, I don't understand. Please try another question.";
        }

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AIChatbotGUI::new);
    }
}
