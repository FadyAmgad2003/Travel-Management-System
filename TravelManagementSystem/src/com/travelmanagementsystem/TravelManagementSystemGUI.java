package com.travelmanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TravelManagementSystemGUI {
    
    private JFrame frame;
    private JComboBox<String> packageTypeComboBox;
    private JComboBox<String> accommodationTypeComboBox;
    private JTextField usernameField;
    private JButton bookButton;

    public TravelManagementSystemGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Travel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create package type combo box
        String[] packageTypes = {"Luxury", "Adventure", "Cultural"};
        packageTypeComboBox = new JComboBox<>(packageTypes);

        // Create accommodation type combo box
        String[] accommodationTypes = {"Hotel", "Hostel", "Resort"};
        accommodationTypeComboBox = new JComboBox<>(accommodationTypes);

        // Create username field
        usernameField = new JTextField(10);

        // Create book button
        bookButton = new JButton("Book");
        bookButton.addActionListener(new BookButtonActionListener());

        // Create panel for package type and accommodation type
        JPanel packagePanel = new JPanel();
        packagePanel.add(new JLabel("Package Type:"));
        packagePanel.add(packageTypeComboBox);
        packagePanel.add(new JLabel("Accommodation Type:"));
        packagePanel.add(accommodationTypeComboBox);

        // Create panel for username and book button
        JPanel bookPanel = new JPanel();
        bookPanel.add(new JLabel("Username:"));
        bookPanel.add(usernameField);
        bookPanel.add(bookButton);

        // Add panels to frame
        frame.add(packagePanel, BorderLayout.NORTH);
        frame.add(bookPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private class BookButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get package type and accommodation type
            String packageType = (String) packageTypeComboBox.getSelectedItem();
            String accommodationType = (String) accommodationTypeComboBox.getSelectedItem();

            // Create travel package and accommodation
            TravelPackage travelPackage = TravelPackageFactory.createPackage(packageType);
            Accommodation accommodation = AccommodationFactory.createAccommodation(accommodationType);

            // Get username
            String username = usernameField.getText();

            // Create user profile
            UserProfile userProfile = new UserProfile(username);

            // Add user profile to user profile manager
            UserProfileManager.getInstance().addUserProfile(userProfile);

            // Create booking
            Booking booking = new Booking(travelPackage, accommodation, userProfile);

            // Add booking to booking manager
            BookingManager.getInstance().addBooking(booking);

            // Display booking details
            JOptionPane.showMessageDialog(frame, "Booking Details:\n" +
                    "Package Type: " + travelPackage.getPackageName() + "\n" +
                    "Accommodation Type: " + accommodation.getAccommodationName() + "\n" +
                    "Username: " + username);
        }
    }

}