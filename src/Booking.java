import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
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

        ImageIcon logout = new ImageIcon("/home/erqyan/IdeaProjects/EO/logout.png");
        Image scaledLogout = logout.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        ImageIcon logoutFix = new ImageIcon(scaledLogout);

        JLabel imageIcon = new JLabel(iconFix);

        JLabel logoText = new JLabel("Selamat datang di Blue Spring");
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
        sidebarPanel.setLayout(new GridLayout(9, 1, 10, 10));
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

        JButton notaButton = createStyledButton("Cetak Nota");
        notaButton.addActionListener(e -> showPanel("Nota"));
        sidebarPanel.add(notaButton);

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
        contentPanel.add(createNotaPanel(), "Nota");

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

        JLabel welcomeLabel = new JLabel("Selamat Datang Di Blue Spring Event Organizer!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(30, 144, 255)); // Dodger Blue
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel servicesPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        servicesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Our Services", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        servicesPanel.setBackground(Color.WHITE);

        JLabel service1 = createServiceLabel("1. Pernikahan");
        JLabel service2 = createServiceLabel("2. Seminar");
        JLabel service3 = createServiceLabel("3. Ulang Tahun");
        JLabel service4 = createServiceLabel("4. Konser");

        servicesPanel.add(service1);
        servicesPanel.add(service2);
        servicesPanel.add(service3);
        servicesPanel.add(service4);

        panel.add(servicesPanel, BorderLayout.CENTER);

        JPanel upcomingEventsPanel = new JPanel();
        upcomingEventsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Upcoming Events", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        upcomingEventsPanel.setLayout(new BoxLayout(upcomingEventsPanel, BoxLayout.Y_AXIS));
        upcomingEventsPanel.setBackground(Color.WHITE);

        JLabel event1 = createEventLabel("1. Pernikahan Rama & Sinta - 2025-01-01");
        JLabel event2 = createEventLabel("2. Seminar Java Programming - 2024-02-10");
        JLabel event3 = createEventLabel("3. Ulang Tahun Regiana - 2025-21-21");

        upcomingEventsPanel.add(event1);
        upcomingEventsPanel.add(event2);
        upcomingEventsPanel.add(event3);

        panel.add(upcomingEventsPanel, BorderLayout.SOUTH);

        JPanel quickLinksPanel = new JPanel(new FlowLayout());
        quickLinksPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2), "Quick Links", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(30, 144, 255)));
        quickLinksPanel.setBackground(new Color(240, 248, 255));

        JButton newBookingButton = createStyledButton("Booking");
        newBookingButton.addActionListener(e -> showPanel("Wedding"));
        quickLinksPanel.add(newBookingButton);

        JButton viewHistoryButton = createStyledButton("Lihat Histori Booking");
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

                    int userId = Main.getIdUser();
                    int weddingId = namaPasangan.hashCode();
                    Main.addWeddingHistory(userId, weddingId);

                    List<Integer> history = mainApp.getWeddingHistory(userId);
                    if (!history.contains(weddingId)) {
                        JOptionPane.showMessageDialog(panel,
                                "Error: Wedding history not saved.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel,
                            "Input tidak valid. Coba lagi.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    System.err.println("Error: " + ex.getMessage());
                    ex.printStackTrace();
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

    private JPanel createSeminarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Book a Seminar", SwingConstants.CENTER);
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
        JLabel topicLabel = new JLabel("Seminar Topic:");
        topicLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(topicLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        JTextField topicField = new JTextField(20);
        topicField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(topicField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JLabel speakerLabel = new JLabel("Speaker Name:");
        speakerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(speakerLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JTextField speakerField = new JTextField(20);
        speakerField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(speakerField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        JLabel guestCountLabel = new JLabel("Number of Guests:");
        guestCountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        JTextField guestCountField = new JTextField(20); // Increase width
        guestCountField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(locationLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        JTextField locationField = new JTextField(20); // Increase width
        locationField.setFont(new Font("Arial", Font.PLAIN, 16)); // Increase font size
        formPanel.add(locationField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        JTextField dateField = new JTextField(20);
        dateField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateField, gbc);


        JButton submitButton = createStyledButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                String topic = topicField.getText();
                String pembicara = speakerField.getText();
                float jumlahTamu = Float.parseFloat(guestCountField.getText());
                String lokasi = locationField.getText();
                String tanggal = dateField.getText();

                mainApp.bookSeminar(topic, pembicara, jumlahTamu, lokasi, tanggal);

                JOptionPane.showMessageDialog(panel, "Seminar booking successful!", "Info", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            topicField.setText("");
            speakerField.setText("");
            guestCountField.setText("");
            locationField.setText("");
            dateField.setText("");

        });
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createBirthdayPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Book a Birthday", SwingConstants.CENTER);
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
        JLabel nameLabel = new JLabel("Name of Birthday Person:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(nameLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(ageLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JTextField ageField = new JTextField(20);
        ageField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(ageField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        JLabel guestCountLabel = new JLabel("Number of Guests:");
        guestCountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        JTextField guestCountField = new JTextField(20);
        guestCountField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(locationLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        JTextField locationField = new JTextField(20);
        locationField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(locationField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        JTextField dateField = new JTextField(20);
        dateField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateField, gbc);

        JButton submitButton = createStyledButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                String namaUltah = nameField.getText();
                int usia = Integer.parseInt(ageField.getText());
                float jumlahTamu = Float.parseFloat(guestCountField.getText());
                String lokasi = locationField.getText();
                String tanggal = dateField.getText();

                mainApp.bookBirthday(namaUltah, usia, jumlahTamu, lokasi, tanggal);

                JOptionPane.showMessageDialog(panel, "Birthday booking successful!", "Info", JOptionPane.INFORMATION_MESSAGE);

                nameField.setText("");
                ageField.setText("");
                guestCountField.setText("");
                locationField.setText("");
                dateField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createConcertPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Book a Concert", SwingConstants.CENTER);
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
        JLabel artistLabel = new JLabel("Artist Name:");
        artistLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(artistLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        JTextField artistField = new JTextField(20);
        artistField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(artistField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JLabel guestCountLabel = new JLabel("Number of Guests:");
        guestCountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JTextField guestCountField = new JTextField(20);
        guestCountField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(guestCountField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(locationLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        JTextField locationField = new JTextField(20);
        locationField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(locationField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        JTextField dateField = new JTextField(20);
        dateField.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(dateField, gbc);

        JButton submitButton = createStyledButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                String namaArtis = artistField.getText();
                float jumlahTamu = Float.parseFloat(guestCountField.getText());
                String lokasi = locationField.getText();
                String tanggal = dateField.getText();


                mainApp.bookConcert(namaArtis, (int) jumlahTamu, lokasi, tanggal);

                JOptionPane.showMessageDialog(panel, "Concert booking successful!", "Info", JOptionPane.INFORMATION_MESSAGE);


                artistField.setText("");
                guestCountField.setText("");
                locationField.setText("");
                dateField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        panel.add(formPanel, BorderLayout.CENTER);

        return panel;
    }

    public JPanel createPackagesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Packages List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255));
        panel.add(titleLabel, BorderLayout.NORTH);

        List<PaketLayanan> daftarPaketLayanan = mainApp.getDaftarPaketLayanan();
        if (daftarPaketLayanan == null || daftarPaketLayanan.isEmpty()) {
            JLabel noDataLabel = new JLabel("No packages available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (PaketLayanan paket : daftarPaketLayanan) {
            listModel.addElement(paket.getIdPaket() + " - " + paket.getNama());
        }

        JList<String> packageList = new JList<>(listModel);
        packageList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(packageList);


        JTextArea descriptionArea = new JTextArea(10, 20);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        packageList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = packageList.getSelectedIndex();
                if (selectedIndex != -1) {
                    PaketLayanan selectedPaket = daftarPaketLayanan.get(selectedIndex);
                    descriptionArea.setText(selectedPaket.deskripsiPaket());
                } else {
                    descriptionArea.setText("");
                }
            }
        });

        JPanel listAndDescriptionPanel = new JPanel();
        listAndDescriptionPanel.setLayout(new BorderLayout());
        listAndDescriptionPanel.add(scrollPane, BorderLayout.CENTER);
        listAndDescriptionPanel.add(descriptionScrollPane, BorderLayout.SOUTH);

        JButton pesanButton = new JButton("Pesan");
        pesanButton.setFont(new Font("Arial", Font.BOLD, 16));
        pesanButton.addActionListener(e -> {
            int selectedIndex = packageList.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(panel, "Silakan pilih paket terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JTextField namaField = new JTextField();
            JTextField alamatField = new JTextField();
            Object[] message = {
                    "Nama:", namaField,
                    "Alamat:", alamatField
            };

            int option = JOptionPane.showConfirmDialog(panel, message, "Input Biodata", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nama = namaField.getText().trim();
                String alamat = alamatField.getText().trim();

                if (nama.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Semua bidang harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    PaketLayanan selectedPaket = daftarPaketLayanan.get(selectedIndex);
                    JOptionPane.showMessageDialog(panel,
                            "Paket berhasil dipesan!\n\n" +
                                    "Nama: " + nama + "\n" +
                                    "Alamat: " + alamat + "\n" +
                                    "Paket: " + selectedPaket.getNama() + "\n" +
                                    "Harga: " + selectedPaket.getHarga(),
                            "Konfirmasi Pemesanan", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panel.add(listAndDescriptionPanel, BorderLayout.CENTER);
        panel.add(pesanButton, BorderLayout.SOUTH);

        return panel;
    }

    private List<Vendor> getSelectedVendorsFromPanelAsList(JPanel panel) {
        JSplitPane splitPane = (JSplitPane) panel.getComponent(0);
        JScrollPane scrollPane = (JScrollPane) splitPane.getLeftComponent();
        JList<Vendor> vendorList = (JList<Vendor>) scrollPane.getViewport().getView();

        return vendorList.getSelectedValuesList(); // Returns a list of selected vendors
    }


    private JPanel createTambahanPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Booking Layanan Tambahan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 144, 255));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        tabbedPane.addTab("Catering", createVendorPanelWithService("Catering", mainApp.getDaftarPemesananCatering()));
        tabbedPane.addTab("Fotografer", createVendorPanelWithService("Fotografer", mainApp.getDaftarPemesananFotografer()));
        tabbedPane.addTab("Hiburan", createVendorPanelWithService("Hiburan", mainApp.getDaftarPemesananHiburan()));
        tabbedPane.addTab("Decorator", createVendorPanelWithService("Decorator", mainApp.getDaftarPemesananDecorator()));

        panel.add(tabbedPane, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        actionPanel.setBackground(new Color(240, 248, 255));

        JButton bookButton = new JButton("Confirm Booking");
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.setBackground(new Color(30, 144, 255));
        bookButton.setForeground(Color.WHITE);
        bookButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                JPanel tab = (JPanel) tabbedPane.getComponentAt(i);
                String tabTitle = tabbedPane.getTitleAt(i);

                List<Vendor> selectedVendors = getSelectedVendorsFromPanelAsList(tab);
                if (selectedVendors.isEmpty()) continue;

                switch (tabTitle) {
                    case "Catering":
                        for (Vendor vendor : selectedVendors) {
                            mainApp.addCateringBooking(userId, (Catering) vendor);
                        }
                        break;
                    case "Fotografer":
                        for (Vendor vendor : selectedVendors) {
                            mainApp.addFotograferBooking(userId, (Fotografer) vendor);
                        }
                        break;
                    case "Hiburan":
                        for (Vendor vendor : selectedVendors) {
                            mainApp.addHiburanBooking(userId, (Hiburan) vendor);
                        }
                        break;
                    case "Decorator":
                        for (Vendor vendor : selectedVendors) {
                            mainApp.addDecoratorBooking(userId, (Decorator) vendor);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected tab: " + tabTitle);
                }
            }

            JOptionPane.showMessageDialog(panel, "Booking confirmed and saved!");
        });


        actionPanel.add(bookButton);
        panel.add(actionPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createVendorPanelWithService(String serviceType, List<? extends Vendor> vendors) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (vendors == null || vendors.isEmpty()) {
            JLabel noDataLabel = new JLabel("No vendors available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);
            return panel;
        }

        DefaultListModel<Vendor> listModel = new DefaultListModel<>();
        for (Vendor vendor : vendors) {
            listModel.addElement(vendor);
        }

        JList<Vendor> vendorList = new JList<>(listModel);
        vendorList.setFont(new Font("Arial", Font.PLAIN, 16));
        vendorList.setCellRenderer(new VendorCellRenderer());

        JScrollPane scrollPane = new JScrollPane(vendorList);

        JTextArea descriptionArea = new JTextArea(10, 20);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        vendorList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Vendor selectedVendor = vendorList.getSelectedValue();
                if (selectedVendor != null) {
                    descriptionArea.setText(selectedVendor.deskripsiEvent());
                }
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, descriptionScrollPane);
        splitPane.setResizeWeight(0.5);
        panel.add(splitPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createNotaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Nota Pembayaran", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 144, 255));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea notaTextArea = new JTextArea();
        notaTextArea.setEditable(false);
        notaTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        notaTextArea.setBackground(Color.WHITE);
        notaTextArea.setText(mainApp.cetakNotaEvent());

        JScrollPane scrollPane = new JScrollPane(notaTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton button1 = new JButton("Cetak Nota Layanan Utama");
        button1.addActionListener(e -> {
            String eventDetails = mainApp.cetakNotaEvent();
            notaTextArea.setText(eventDetails);
        });

        JButton button2 = new JButton("Cetak Nota Layanan Tambahan");
        button2.addActionListener(e -> {
            String paymentSummary = mainApp.cetakNotaVendor();
            notaTextArea.setText(paymentSummary);
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    class VendorCellRenderer extends JCheckBox implements ListCellRenderer<Vendor> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Vendor> list, Vendor value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.getIdVendor() + " - " + value.getNama());
            setSelected(list.isSelectedIndex(index));
            setBackground(isSelected ? new Color(173, 216, 230) : Color.WHITE);
            return this;
        }
    }

    private JPanel createVendorPanel(String serviceType, List<?> vendors) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (vendors == null || vendors.isEmpty()) {
            JLabel noDataLabel = new JLabel("No vendors available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Object vendor : vendors) {
            listModel.addElement(vendor.toString());
        }

        JList<String> vendorList = new JList<>(listModel);
        vendorList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(vendorList);


        JTextArea descriptionArea = new JTextArea(10, 20);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);


        vendorList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedVendor = vendorList.getSelectedValue();
                descriptionArea.setText("Details for " + selectedVendor);
            }
        });


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, descriptionScrollPane);
        splitPane.setResizeWeight(0.5);
        panel.add(splitPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createHistoryPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Order History", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 144, 255));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        JButton weddingButton = new JButton("Booking Wedding History");
        weddingButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            List<Pernikahan> weddingHistory = mainApp.getUserWeddingBookings(userId);
            contentPanel.removeAll();
            contentPanel.add(createUserWeddingHistoryPanel(weddingHistory), BorderLayout.CENTER); // Tambahkan panel baru
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        buttonPanel.add(weddingButton);

        JButton seminarButton = new JButton("Booking Seminar History");
        seminarButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            List<Seminar> seminarHistory = mainApp.getUserSeminarBookings(userId);
            contentPanel.removeAll();
            contentPanel.add(createUserSeminarHistoryPanel(seminarHistory), BorderLayout.CENTER); // Tambahkan panel baru
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        buttonPanel.add(seminarButton);

        JButton ultahButton = new JButton("Booking Ultah History");
        ultahButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            List<Ultah> ultahHistory = mainApp.getUserUltahBookings(userId);
            contentPanel.removeAll();
            contentPanel.add(createUserUltahHistoryPanel(ultahHistory), BorderLayout.CENTER); // Tambahkan panel baru
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        buttonPanel.add(ultahButton);

        JButton konserButton = new JButton("Booking Konser History");
        konserButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            List<Konser> konserHistory = mainApp.getUserKonserBookings(userId);
            contentPanel.removeAll();
            contentPanel.add(createUserKonserHistoryPanel(konserHistory), BorderLayout.CENTER); // Tambahkan panel baru
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        buttonPanel.add(konserButton);

        JButton vendorButton = new JButton("Booking Vendor History");
        vendorButton.addActionListener(e -> {
            int userId = Main.getIdUser();
            List<Fotografer> fotograferHistory = mainApp.getUserFotograferBookings(userId);
            List<Catering> cateringHistory = mainApp.getUserCateringBookings(userId);
            List<Decorator> decoratorHistory = mainApp.getUserDecoratorBookings(userId);
            List<Hiburan> hiburanHistory = mainApp.getUserHiburanBookings(userId);

            contentPanel.removeAll();
            contentPanel.add(createUserVendorHistoryPanel(fotograferHistory, cateringHistory, decoratorHistory, hiburanHistory), BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        buttonPanel.add(vendorButton);


        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createUserVendorHistoryPanel(List<Fotografer> fotograferEvents, List<Catering> cateringEvens, List<Decorator> decoratorEvens, List<Hiburan> hiburanEvens) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if ((fotograferEvents == null || fotograferEvents.isEmpty()) && (cateringEvens == null || cateringEvens.isEmpty()) && (decoratorEvens == null || decoratorEvens.isEmpty()) && (hiburanEvens == null || hiburanEvens.isEmpty())){
            JLabel noDataLabel = new JLabel("No Vendor history available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null,
                    "No Vendor history found for the current user.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Info: No Vendor history available for current user.");
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Fotografer fotografer : fotograferEvents) {
            String orderText = "Fotografer Name: " + fotografer.getNama() + "\n " +
                                "Harga: " + fotografer.getHarga() + "\n ";
            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText);
            mainApp.setLayananVendor(orderText);
            mainApp.setTotalHargaVendor(fotografer.getHarga());
        }

        for (Catering catering : cateringEvens) {
            String orderText = "Catering Name : " + catering.getNama() + "\n " +
                                "Jenis makanan : " + catering.getJenisMakanan() + "\n " +
                                "Harga: " + catering.getHarga() + "\n ";
            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText);
            mainApp.setLayananVendor(orderText);
            mainApp.setTotalHargaVendor(catering.getHarga());
        }

        for (Decorator decorator : decoratorEvens) {
            String orderText = "Decorator Name : " + decorator.getNama() + "\n " +
                    "Jenis decorator : " + decorator.getJenisDecorator() + "\n " +
                    "Harga: " + decorator.getHarga() + "\n ";
            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText);
            mainApp.setLayananVendor(orderText);
            mainApp.setTotalHargaVendor(decorator.getHarga());
        }

        for (Hiburan hiburan : hiburanEvens) {
            String orderText = "Hiburan Name : " + hiburan.getNama() + "\n " +
                    "Jenis hiburan : " + hiburan.getJenisHiburan() + "\n " +
                    "Harga: " + hiburan.getHarga() + "\n ";
            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText);
            mainApp.setLayananVendor(orderText);
            mainApp.setTotalHargaVendor(hiburan.getHarga());
        }

        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        System.out.println("JList created with " + listModel.size() + " elements.");

        JScrollPane scrollPane = new JScrollPane(historyList);
        panel.add(scrollPane, BorderLayout.CENTER);
        System.out.println("JScrollPane with historyList added to panel.");

        panel.revalidate();
        panel.repaint();

        return panel;
    }

    private JPanel createUserWeddingHistoryPanel(List<Pernikahan> weddingEvents) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (weddingEvents == null || weddingEvents.isEmpty()) {
            JLabel noDataLabel = new JLabel("No wedding history available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null,
                    "No wedding history found for the current user.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Info: No wedding history available for current user.");
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Pernikahan pernikahan : weddingEvents) {
            String orderText = "Pernikahan Pasangan: " + pernikahan.getNamaPasangan() + "\n " +
                    "Tanggal Pernikahan: " + pernikahan.getTanggal() + "\n " +
                    "Total Harga : " + pernikahan.getTotalHarga() + "\n "+
                    "Harga Layanan : " + pernikahan.getHargaLayanan() + "\n " +
                    "Lokasi : " + pernikahan.getLokasi() + "\n " +
                    "Jumlah Tamu : " + pernikahan.getJumlahTamu() + "\n " +
                    "Staff yang bertugas : " + pernikahan.getKepalaStaff();

            mainApp.setTotalHargaEvent(pernikahan.getTotalHarga());
            mainApp.setLayananEvent(orderText);


            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText); // Debug log
        }

        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        System.out.println("JList created with " + listModel.size() + " elements."); // Debug log

        JScrollPane scrollPane = new JScrollPane(historyList);
        panel.add(scrollPane, BorderLayout.CENTER);
        System.out.println("JScrollPane with historyList added to panel."); // Debug log

        panel.revalidate();
        panel.repaint();

        return panel;
    }

    private JPanel createUserSeminarHistoryPanel(List<Seminar> seminarEvents) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (seminarEvents == null || seminarEvents.isEmpty()) {
            JLabel noDataLabel = new JLabel("No seminar history available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null,
                    "No seminar history found for the current user.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Info: No seminar history available for current user.");
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Seminar seminar : seminarEvents) {
            String orderText ="Pembicara : " + seminar.getPembicara() + "\n " +
                    "Topik : " + seminar.getTopic() + "\n" +
                    "Tanggal Seminar: " + seminar.getTanggal() + "\n " +
                    "Total Harga : " + seminar.getTotalHarga() + "\n "+
                    "Harga Layanan : " + seminar.getHargaLayanan() + "\n " +
                    "Lokasi : " + seminar.getLokasi() + "\n " +
                    "Jumlah Tamu : " + seminar.getJumlahTamu() + "\n " +
                    "Staff yang bertugas : " + seminar.getKepalaStaff();

            mainApp.setTotalHargaEvent(seminar.getTotalHarga());
            mainApp.setLayananEvent(orderText);

            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText); // Debug log
        }

        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        System.out.println("JList created with " + listModel.size() + " elements."); // Debug log

        JScrollPane scrollPane = new JScrollPane(historyList);
        panel.add(scrollPane, BorderLayout.CENTER);
        System.out.println("JScrollPane with historyList added to panel."); // Debug log

        panel.revalidate();
        panel.repaint();

        return panel;
    }

    private JPanel createUserUltahHistoryPanel(List<Ultah> ultahEvents) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (ultahEvents == null || ultahEvents.isEmpty()) {
            JLabel noDataLabel = new JLabel("No ultah history available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null,
                    "No ultah history found for the current user.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Info: No ultah history available for current user.");
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Ultah ultah : ultahEvents) {
            String orderText = "Nama yang ulang tahun : " + ultah.getNama() + "\n " +
                    "Tanggal Ultah: " + ultah.getTanggal()+ "\n " +
                    "Total Harga : " + ultah.getTotalHarga() + "\n "+
                    "Harga Layanan : " + ultah.getHargaLayanan() + "\n " +
                    "Lokasi : " + ultah.getLokasi() + "\n " +
                    "Jumlah Tamu : " + ultah.getJumlahTamu() + "\n " +
                    "Staff yang bertugas : " + ultah.getKepalaStaff();

            mainApp.setTotalHargaEvent(ultah.getTotalHarga());
            mainApp.setLayananEvent(orderText);

            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText); // Debug log
        }

        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        System.out.println("JList created with " + listModel.size() + " elements."); // Debug log

        JScrollPane scrollPane = new JScrollPane(historyList);
        panel.add(scrollPane, BorderLayout.CENTER);
        System.out.println("JScrollPane with historyList added to panel."); // Debug log

        panel.revalidate();
        panel.repaint();

        return panel;
    }

    private JPanel createUserKonserHistoryPanel(List<Konser> konserEvents) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        if (konserEvents == null || konserEvents.isEmpty()) {
            JLabel noDataLabel = new JLabel("No konsser history available", SwingConstants.CENTER);
            noDataLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            panel.add(noDataLabel, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null,
                    "No konser history found for the current user.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("Info: No konser history available for current user.");
            return panel;
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Konser konser : konserEvents) {
            String orderText = "Artis : " + konser.getArtis() + " \n " +
                    "Tanggal Konser: " + konser.getTanggal()+ " \n " +
                    "Total Harga : " + konser.getTotalHarga() + " \n "+
                    "Harga Layanan : " + konser.getHargaLayanan() + " \n " +
                    "Lokasi : " + konser.getLokasi() + " \n " +
                    "Jumlah Tamu : " + konser.getJumlahTamu() + " \n " +
                    "Staff yang bertugas : " + konser.getKepalaStaff();

            mainApp.setTotalHargaEvent(konser.getTotalHarga());
            mainApp.setLayananEvent(orderText);

            listModel.addElement(orderText);
            System.out.println("Added to listModel: " + orderText); // Debug log
        }

        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        System.out.println("JList created with " + listModel.size() + " elements."); // Debug log

        JScrollPane scrollPane = new JScrollPane(historyList);
        panel.add(scrollPane, BorderLayout.CENTER);
        System.out.println("JScrollPane with historyList added to panel."); // Debug log

        panel.revalidate();
        panel.repaint();

        return panel;
    }





}
