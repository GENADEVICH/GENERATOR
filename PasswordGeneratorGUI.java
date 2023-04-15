import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordGeneratorGUI {
    private JFrame frame;
    private JTextField lengthField;
    private JTextField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PasswordGeneratorGUI window = new PasswordGeneratorGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PasswordGeneratorGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Генератор паролей");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lengthLabel = new JLabel("Длина пароля:");
        lengthLabel.setBounds(10, 20, 100, 20);
        panel.add(lengthLabel);

        lengthField = new JTextField();
        lengthField.setBounds(120, 20, 100, 20);
        panel.add(lengthField);

        JButton generateButton = new JButton("Сгенерировать");
        generateButton.setBounds(240, 20, 120, 20);
        panel.add(generateButton);

        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(10, 50, 100, 20);
        panel.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(120, 50, 240, 20);
        passwordField.setEditable(false);
        panel.add(passwordField);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                passwordField.setText(generatePassword(length));
            }
        });
    }

    public String generatePassword(int length) {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String allChars = capitalLetters + lowerLetters + numbers + symbols;
        Random random = new Random();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }
        return new String(password);
    }
}
