import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking extends JFrame {
    private Main mainApp;
    private CardLayout cardLayout;

    public Booking(Main mainApp) {
        this.mainApp = mainApp;
        setTitle("Booking EO Blue Spring");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("/home/erqyan/IdeaProjects/EO/logo.jpeg");
        Image scaledIcon = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconFix = new ImageIcon(scaledIcon);

        ImageIcon logout = new ImageIcon("/home/erqyan/Documents/KULIAH/SEMESTER3/Kelas/logout.png");
        Image scaledLogout = logout.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon logoutFix = new ImageIcon(scaledLogout);

        JLabel imageIcon = new JLabel(iconFix);

        JLabel logoText = new JLabel("Welcome to Blue Spring");
        logoText.setFont(new Font("Arial", Font.BOLD, 30));
        logoText.setBorder(new EmptyBorder(8, 20, 0, 0));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(imageIcon, BorderLayout.WEST);
        leftPanel.add(logoText, BorderLayout.CENTER);

        JLabel imageLogout = new JLabel(logoutFix);
        imageLogout.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel logoutText = new JLabel("Logout");
        logoutText.setHorizontalAlignment(SwingConstants.CENTER);
        logoutText.setFont(new Font("Arial", Font.BOLD, 15));
        logoutText.setBorder(new EmptyBorder(0, 0, 50, 0));

        JPanel logoutPanel = new JPanel(new BorderLayout());
        logoutPanel.add(imageLogout, BorderLayout.CENTER);
        logoutPanel.add(logoutText, BorderLayout.SOUTH);
        logoutPanel.setBorder(new EmptyBorder(0, 0, 0, 30));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(logoutPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(8, 1, 10, 10));
        sidebarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton homeButton = createStyledButton("Home");
        homeButton.addActionListener(e -> showPanel("Home"));
        sidebarPanel.add(homeButton);

        JButton weddingButton = createStyledButton("Pesan Pernikahan");
        weddingButton.addActionListener(e -> showPanel("Wedding"));
        sidebarPanel.add(weddingButton);

        JButton seminarButton = createStyledButton("Pesan Seminar");
        seminarButton.addActionListener(e -> showPanel("Seminar"));
        sidebarPanel.add(seminarButton);

        JButton birthdayButton = createStyledButton("Pesan Ulang Tahun");
        birthdayButton.addActionListener(e -> showPanel("Birthday"));
        sidebarPanel.add(birthdayButton);

        JButton concertButton = createStyledButton("Pesan Konser");
        concertButton.addActionListener(e -> showPanel("Concert"));
        sidebarPanel.add(concertButton);

        JButton packagesButton = createStyledButton("Paket Layanan");
        packagesButton.addActionListener(e -> showPanel("Packages"));
        sidebarPanel.add(packagesButton);

        JButton tambahanButton = createStyledButton("Layanan Tambahan");
        tambahanButton.addActionListener(e -> showPanel("Tambahan"));
        sidebarPanel.add(tambahanButton);

        JButton historyButton = createStyledButton("Riwayat Pemesanan");
        historyButton.addActionListener(e -> showPanel("History"));
        sidebarPanel.add(historyButton);

        JPanel contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        contentPanel.add(createHomePanel(), "Home");
        contentPanel.add(createWeddingPanel(), "Wedding");
        contentPanel.add(createSeminarPanel(), "Seminar");
        contentPanel.add(createBirthdayPanel(), "Birthday");
        contentPanel.add(createConcertPanel(), "Concert");
        contentPanel.add(createPackagesPanel(), "Packages");
        contentPanel.add(createTambahanPanel(), "Tambahan");
        contentPanel.add(createHistoryPanel(), "History");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void showPanel(String panelName) {
        cardLayout.show((Container) ((JPanel) getContentPane().getComponent(1)).getComponent(1), panelName);
    }
    
    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel welcomeLabel = new JLabel("Welcome to Blue Spring Event Organizer!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(30, 144, 255)); // Dodger Blue
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel servicesPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        servicesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Our Services", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        servicesPanel.setBackground(Color.WHITE);

        JLabel service1 = createServiceLabel("1. Wedding Planning");
        JLabel service2 = createServiceLabel("2. Seminar and Workshop Organization");
        JLabel service3 = createServiceLabel("3. Birthday Parties");
        JLabel service4 = createServiceLabel("4. Concert and Performance Management");

        servicesPanel.add(service1);
        servicesPanel.add(service2);
        servicesPanel.add(service3);
        servicesPanel.add(service4);

        panel.add(servicesPanel, BorderLayout.CENTER);

        JPanel upcomingEventsPanel = new JPanel();
        upcomingEventsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Upcoming Events", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        upcomingEventsPanel.setLayout(new BoxLayout(upcomingEventsPanel, BoxLayout.Y_AXIS));
        upcomingEventsPanel.setBackground(Color.WHITE);

        JLabel event1 = createEventLabel("1. Wedding of John & Jane - 2024-01-15");
        JLabel event2 = createEventLabel("2. Seminar on Java Programming - 2024-02-10");
        JLabel event3 = createEventLabel("3. Birthday Party for Alex - 2024-03-05");

        upcomingEventsPanel.add(event1);
        upcomingEventsPanel.add(event2);
        upcomingEventsPanel.add(event3);

        panel.add(upcomingEventsPanel, BorderLayout.SOUTH);

        JPanel quickLinksPanel = new JPanel(new FlowLayout());
        quickLinksPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Quick Links", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        quickLinksPanel.setBackground(new Color(240, 248, 255));

        JButton newBookingButton = createStyledButton("New Booking");
        newBookingButton.addActionListener(e -> showPanel("Wedding"));
        quickLinksPanel.add(newBookingButton);

        JButton viewHistoryButton = createStyledButton("View Booking History");
        viewHistoryButton.addActionListener(e -> showPanel("History"));
        quickLinksPanel.add(viewHistoryButton);

        panel.add(quickLinksPanel, BorderLayout.EAST);

        return panel;
    }

    private JLabel createServiceLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setOpaque(true);
        label.setBackground(new Color(173, 216, 230));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JLabel createEventLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setOpaque(true);
        label.setBackground(new Color(255, 228, 196));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 40));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 102, 204));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255));
            }
        });

        return button;
    }

    private JPanel createWeddingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Book Your Wedding", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        gbc.gridx = 0; gbc.gridy = 0;
        JLabel pasanganLabel = new JLabel("Nama Pasangan:");
        pasanganLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(pasanganLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        JTextField pasanganField = new JTextField(20);
        pasanganField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(pasanganField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JLabel tamuLabel = new JLabel("Jumlah Tamu:");
        tamuLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(tamuLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JTextField tamuField = new JTextField(20);
        tamuField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(tamuField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lokasiLabel = new JLabel("Lokasi:");
        lokasiLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(lokasiLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        JTextField lokasiField = new JTextField(20);
        lokasiField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(lokasiField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        JLabel tanggalLabel = new JLabel("Tanggal (YYYY-MM-DD):");
        tanggalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(tanggalLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        JTextField tanggalField = new JTextField(20);
        tanggalField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(tanggalField, gbc);

        JButton submitButton = createStyledButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                String namaPasangan = pasanganField.getText();
                float jumlahTamu = Float.parseFloat(tamuField.getText());
                String lokasi = lokasiField.getText();
                String tanggal = tanggalField.getText();
                mainApp.bookWedding(namaPasangan, jumlahTamu, lokasi, tanggal);
                JOptionPane.showMessageDialog(panel, "Pemesanan Wedding berhasil!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Input tidak valid. Coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pasanganField.setText("");
            tamuField.setText("");
            lokasiField.setText("");
            tanggalField.setText("");
        });

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        return panel;
    }
   
}
