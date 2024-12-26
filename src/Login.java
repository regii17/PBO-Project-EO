import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login{
    public Login(Main mainApp) {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeComponents(panel, mainApp, loginFrame);

        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, Main mainApp, JFrame loginFrame) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 50, 165, 25);
        panel.add(userText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 80, 25);
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(50, 130, 300, 25);
        messageLabel.setForeground(Color.RED);
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = userText.getText();
                try {
                    int id = Integer.parseInt(inputId);
                    if (isValidUser(id, mainApp)) {
                        loginFrame.dispose();
                        mainApp.setIdUser(id);
                        new Booking(mainApp);
                    } else {
                        messageLabel.setText("Invalid User ID. Please try again.");
                    }
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Please enter a valid numeric User ID.");
                }
            }
        });
    }

    private static boolean isValidUser(int id, Main mainApp) {
        List<Klien> daftarUser = mainApp.getDaftarUser();
        for (Klien klien : daftarUser) {
            if (klien.getIdKlien() == id) {
                return true;
            }
        }
        return false;
    }
}