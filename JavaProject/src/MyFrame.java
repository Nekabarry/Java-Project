import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener{
    JLabel title, l1, l2, l3, l4, l5, l6;
    JRadioButton rb1, rb2;
    JTextField t1, t2, t3, t4;
    JButton b1,b2;
    JComboBox carComboBox;

    public MyFrame() {
        setTitle("Car Info");
        setSize(430, 430);
        setLayout(null); // Use absolute positioning
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new JLabel("Enter the Car's Information");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(110, 10, 380, 30); // Set bounds for title

        l1 = new JLabel("Choose the Brand:");
        String[] carBrands = {"Choose","Mercedes", "BMW", "Honda", "Mazda", "Suzuki", "Hyundai"};
        carComboBox = new JComboBox<>(carBrands);
        l1.setBounds(15, 50, 150, 15); // Set bounds for l1
        carComboBox.setBounds(160, 50, 250, 20); // Set bounds for carComboBox

        l2 = new JLabel("Choose the GearBox:");
        rb1 = new JRadioButton("Manual");
        rb2 = new JRadioButton("Automatic");
        l2.setBounds(15, 90, 150, 15); // Set bounds for l2
        rb1.setBounds(160, 90, 100, 15); // Set bounds for rb1
        rb2.setBounds(290, 90, 100, 20); // Set bounds for rb2

        l3 = new JLabel("Enter a Model:");
        t1 = new JTextField(30);
        l3.setBounds(15, 130, 120, 15); // Set bounds for l3
        t1.setBounds(160, 130, 250, 30); // Set bounds for t1

        l4 = new JLabel("Enter the Year:");
        t2 = new JTextField(20);
        l4.setBounds(15, 170, 120, 15); // Set bounds for l4
        t2.setBounds(160, 170, 250, 30); // Set bounds for t2

        l5 = new JLabel("Enter the Max Speed:");
        t3 = new JTextField(30);
        l5.setBounds(15, 210, 150, 15); // Set bounds for l5
        t3.setBounds(160, 210, 250, 30); // Set bounds for t3

        l6 = new JLabel("Enter The Color:");
        t4 = new JTextField(30);
        l6.setBounds(15, 250, 120, 15); // Set bounds for l6
        t4.setBounds(160, 250, 250, 30); // Set bounds for t4

        b1 = new JButton("Add car to the File");
        b1.setBounds(15, 290, 390, 30); // Set bounds for b1

        b2 = new JButton("Open the search form");
        b1.setBackground(Color.decode("#90EE90"));
        b1.setForeground(Color.decode("#8b0000"));
        b2.setBounds(15, 330, 390, 30); // Set bounds for b2
        b2.setBackground(Color.decode("#90EE90"));
        b2.setForeground(Color.decode("#8b0000"));

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(title);
        add(l1);
        add(carComboBox);
        add(l2);
        add(rb1);
        add(rb2);
        add(l3);
        add(t1);
        add(l4);
        add(t2);
        add(l5);
        add(t3);
        add(l6);
        add(t4);
        add(b1);
        add(b2);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String brand = (String) carComboBox.getSelectedItem();
            if(brand.equals("Choose"))
            {
                JOptionPane.showMessageDialog(null, "Please select a car brand.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!rb1.isSelected() && !rb2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please select a gearbox type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String gearbox = rb1.isSelected() ? "Manual" : "Automatic";
            String model = t1.getText();
            String year = t2.getText();
            String maxSpeed = t3.getText();
            String color = t4.getText();

            // Validate numeric input for year and maxSpeed
            try {
                int yearValue = Integer.parseInt(year);
                int maxSpeedValue = Integer.parseInt(maxSpeed);

                // Create a formatted string with the car information
                String carInfo = "";
                carInfo += brand + "\t\t" + gearbox + "\t\t" + model + "\t\t" + year + "\t\t" + maxSpeed + "\t\t" + color + "\n";

                // Write the car information to a file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\car_info.txt", true))) {
                    writer.write(carInfo);
                    writer.newLine();
                    writer.flush();
                    JOptionPane.showMessageDialog(null, "Car information added to file.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error writing to file.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input for year or max speed. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == b2)
        {
            new searchBox();
        }
    }

}
