package labs.lab9;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

public class RideApp {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 700;

    private JFrame frame;

    private JTextField nameField;

    private JTextField pickupStreetField;
    private JTextField pickupCityField;
    private JComboBox<String> pickupStateBox;
    private JTextField pickupZipField;

    private JTextField dropStreetField;
    private JTextField dropCityField;
    private JComboBox<String> dropStateBox;
    private JTextField dropZipField;

    private JCheckBox expressCheck;
    private JRadioButton oneTwoRadio;
    private JRadioButton threeFourRadio;
    private JRadioButton fiveToSevenRadio;

    private DefaultListModel<String> rideListModel;
    private JList<String> rideList;
    private ArrayList<Ride> rideQueue = new ArrayList<>();
    private JButton assignButton;

    // 10 drivers
    private Driver[] Drivers = {
            new Driver("Alex"), new Driver("Bob"), new Driver("Cayden"), new Driver("David"),
            new Driver("Ethan"), new Driver("Felix"), new Driver("Gabriel"), new Driver("Henry"),
            new Driver("Jose"), new Driver("Kevin")
    };

    public RideApp() {
        frame = new JFrame();
        frame.setTitle("Ride App - Jimmy Jiang - 68381722");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setJMenuBar(createExitMenuBar());

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(createRiderPanel());
        frame.add(createPickupPanel());
        frame.add(createDropoffPanel());
        frame.add(createRideInfoPanel());
        frame.add(createRideQueuePanel());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RideApp();
    }

    // MENU BAR
    private JMenuBar createExitMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        return menuBar;
    }

    // RIDER NAME PANEL
    private JPanel createRiderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Rider name: ");
        nameField = new JTextField(10);
        panel.add(nameLabel);
        panel.add(nameField);
        return panel;
    }

    // PICKUP PANEL
    private JPanel createPickupPanel() {
        JPanel pickupPanel = new JPanel();
        pickupPanel.setBorder(new TitledBorder("Pickup Address"));
        pickupPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pickupPanel.add(new JLabel("Street address:"), gbc);

        gbc.gridx = 1;
        pickupStreetField = new JTextField(20);
        pickupPanel.add(pickupStreetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pickupPanel.add(new JLabel("City:"), gbc);

        gbc.gridx = 1;
        pickupCityField = new JTextField(12);
        pickupPanel.add(pickupCityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pickupPanel.add(new JLabel("State:"), gbc);

        String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };

        gbc.gridx = 1;
        pickupStateBox = new JComboBox<>(states);
        pickupPanel.add(pickupStateBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pickupPanel.add(new JLabel("Zip code:"), gbc);

        gbc.gridx = 1;
        pickupZipField = new JTextField(8);
        pickupPanel.add(pickupZipField, gbc);

        return pickupPanel;
    }

    // DROPOFF PANEL
    private JPanel createDropoffPanel() {
        JPanel dropoffPanel = new JPanel();
        dropoffPanel.setBorder(new TitledBorder("Dropoff Address"));
        dropoffPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        dropoffPanel.add(new JLabel("Street address:"), gbc);

        gbc.gridx = 1;
        dropStreetField = new JTextField(20);
        dropoffPanel.add(dropStreetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        dropoffPanel.add(new JLabel("City:"), gbc);

        gbc.gridx = 1;
        dropCityField = new JTextField(12);
        dropoffPanel.add(dropCityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        dropoffPanel.add(new JLabel("State:"), gbc);

        String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };

        gbc.gridx = 1;
        dropStateBox = new JComboBox<>(states);
        dropoffPanel.add(dropStateBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        dropoffPanel.add(new JLabel("Zip code:"), gbc);

        gbc.gridx = 1;
        dropZipField = new JTextField(8);
        dropoffPanel.add(dropZipField, gbc);

        return dropoffPanel;
    }

    // RIDE INFO
    private JPanel createRideInfoPanel() {
        JPanel info = new JPanel();
        info.setBorder(new TitledBorder("Ride Info"));
        info.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        expressCheck = new JCheckBox("Express?");
        info.add(expressCheck, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        info.add(new JLabel("# of passengers:"), gbc);

        oneTwoRadio = new JRadioButton("1–2");
        threeFourRadio = new JRadioButton("3–4");
        fiveToSevenRadio = new JRadioButton("5–7");

        oneTwoRadio.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(oneTwoRadio);
        group.add(threeFourRadio);
        group.add(fiveToSevenRadio);

        gbc.gridx = 1;
        info.add(oneTwoRadio, gbc);

        gbc.gridx = 2;
        info.add(threeFourRadio, gbc);

        gbc.gridx = 3;
        info.add(fiveToSevenRadio, gbc);

        JButton requestButton = new JButton("Request ride");
        JButton clearButton   = new JButton("Clear");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(requestButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        info.add(buttonPanel, gbc);

        requestButton.addActionListener(e -> handleRequestRide());
        clearButton.addActionListener(e -> clearForm());

        return info;
    }

    private JPanel createRideQueuePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Ride Queue:"), gbc);

        rideListModel = new DefaultListModel<>();
        rideList = new JList<>(rideListModel);
        JScrollPane scroll = new JScrollPane(rideList);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(scroll, gbc);

        assignButton = new JButton("Assign Ride");
        assignButton.setEnabled(false);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(assignButton, gbc);

        assignButton.addActionListener(e -> assignRide());

        return panel;
    }

    private void handleRequestRide() {
        if (!inputsAreValid()) {
            JOptionPane.showMessageDialog(frame, "Invalid input");
            return;
        }

        String name = nameField.getText().trim();
        String pCity = pickupCityField.getText().trim();
        String dCity = dropCityField.getText().trim();

        int pZip = Integer.parseInt(pickupZipField.getText().trim());
        int dZip = Integer.parseInt(dropZipField.getText().trim());

        int passengers;
        if (oneTwoRadio.isSelected()) {
            passengers = 2;
        } else if (threeFourRadio.isSelected()) {
            passengers = 4;
        } else {
            passengers = 7;
        }

        boolean express = expressCheck.isSelected();

        Ride r = new Ride(name, pCity, dCity, pZip, dZip, passengers, express);

        rideQueue.add(r);
        rideListModel.addElement(r.queueSummary());

        assignButton.setEnabled(true);
    }

    private boolean inputsAreValid() {
        if (nameField.getText().trim().isEmpty()|| pickupStreetField.getText().trim().isEmpty() || dropStreetField.getText().trim().isEmpty()
                || pickupCityField.getText().trim().isEmpty()
                || dropCityField.getText().trim().isEmpty()
                || pickupZipField.getText().trim().isEmpty()
                || dropZipField.getText().trim().isEmpty()) {
            return false;
        }

        try {
            int pickupZip = Integer.parseInt(pickupZipField.getText().trim());
            int dropZip = Integer.parseInt(dropZipField.getText().trim());
            if (pickupZip <= 0 || dropZip <= 0) return false;
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    private void clearForm() {
        nameField.setText("");
        pickupStreetField.setText("");
        pickupCityField.setText("");
        pickupZipField.setText("");
        dropStreetField.setText("");
        dropCityField.setText("");
        dropZipField.setText("");

        expressCheck.setSelected(false);
        oneTwoRadio.setSelected(true);
    }

    private void assignRide() {
        ArrayList<Ride> unassignedRide = new ArrayList<>();
        for (Ride r : rideQueue) {
            if (r.getAssignedDriver() == null) {
                unassignedRide.add(r);
            }
        }

        if (unassignedRide.isEmpty()) {
            assignButton.setEnabled(false);
            return;
        }

        Ride[] unassignedArray = unassignedRide.toArray(new Ride[0]);
        JComboBox<Driver> driverBox = new JComboBox<>(Drivers);
        JComboBox<Ride> rideBox = new JComboBox<>(unassignedArray);

        rideBox.setRenderer(new DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
        Ride r = (Ride) value;
        return super.getListCellRendererComponent(
             list, r.queueSummary(), index, isSelected, cellHasFocus
                );
            }
        });

        Object[] message = {
                "Driver:", driverBox,
                "Ride:", rideBox
        };

        int option = JOptionPane.showConfirmDialog(
                frame,
                message,
                "Assign Ride",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            Driver chosenDriver = (Driver) driverBox.getSelectedItem();
            Ride chosenRide = (Ride) rideBox.getSelectedItem();

            if (chosenDriver != null && chosenRide != null) {
                chosenRide.setAssignedDriver(chosenDriver.toString());

                int index = rideQueue.indexOf(chosenRide);
                if (index >= 0) {
                    rideListModel.set(index, chosenRide.queueSummary());
                }
            }
        }

        boolean stillHasUnassigned = false;
        for (Ride r : rideQueue) {
            if (r.getAssignedDriver() == null) {
                stillHasUnassigned = true;
                break;
            }
        }
        assignButton.setEnabled(stillHasUnassigned);
    }
}
