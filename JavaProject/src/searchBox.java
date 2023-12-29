import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class searchBox extends JFrame implements ActionListener {
    JLabel L1, L2, L3, L4, L5, L6;
    JTextField T1, T2, T3, T4, T5, T6;
    JButton B1,B2;

    public searchBox() {
        setSize(680,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        L1 = new JLabel("Brand");
        L1.setFont(new Font("verdana", Font.BOLD,13));
        L1.setBounds(30,15,100,30);
        L2 = new JLabel("GearBox");
        L2.setFont(new Font("verdana", Font.BOLD,13));
        L2.setBounds(130,15,100,30);
        L3 = new JLabel("Model");
        L3.setFont(new Font("verdana", Font.BOLD,13));
        L3.setBounds(250,15,100,30);
        L4 = new JLabel("Year");
        L4.setFont(new Font("verdana", Font.BOLD,13));
        L4.setBounds(365,15,100,30);
        L5 = new JLabel("Max Speed");
        L5.setFont(new Font("verdana", Font.BOLD,13));
        L5.setBounds(455,15,100,30);
        L6 = new JLabel("Color");
        L6.setFont(new Font("verdana", Font.BOLD,13));
        L6.setBounds(580,15,100,30);

        T1 = new JTextField(13);
        T1.setBounds(10,55,90,30);
        T2 = new JTextField(13);
        T2.setBounds(120,55,90,30);
        T3 = new JTextField(13);
        T3.setBounds(230,55,90,30);
        T4 = new JTextField(13);
        T4.setBounds(340,55,90,30);
        T5 = new JTextField(13);
        T5.setBounds(450,55,90,30);
        T6 = new JTextField(13);
        T6.setBounds(560,55,90,30);

        B1 = new JButton("Find the Fastest Car");
        B1.setBounds(10,90,530,30);
        B1.addActionListener(this);
        B1.setBackground(Color.decode("#90EE90"));
        B1.setForeground(Color.decode("#8b0000"));
        B2 = new JButton("Clear");
        B2.setBounds(560,90,90,30);
        B2.addActionListener(this);
        B2.setBackground(Color.decode("#90EE90"));
        B2.setForeground(Color.decode("#8b0000"));

        add(L1); add(L2); add(L3); add(L4); add(L5); add(L6);
        add(T1); add(T2); add(T3); add(T4); add(T5); add(T6);
        add(B1); add(B2);
        B1.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B1) {
            try {
                double fSpeed = 0;
                Scanner reader = new Scanner(new File("c:\\car_info.txt"));

                while (reader.hasNext()) {
                    String brand = reader.next();
                    String gearbox = reader.next();
                    String model = reader.next();
                    String year = reader.next();
                    String speed = reader.next();
                    String color = reader.next();

                    T1.setText(brand);
                    T2.setText(gearbox);
                    T3.setText(model);
                    T4.setText(year);
                    T5.setText(speed);
                    T6.setText(color);

                    double currentSpeed = Double.parseDouble(speed);
                    if (currentSpeed > fSpeed) {
                        fSpeed = currentSpeed;
                    }
                }
                reader.close();

                Scanner reader2 = new Scanner(new File("c:\\car_info.txt"));
                while (reader2.hasNext()) {
                    String brand = reader2.next();
                    String gearbox = reader2.next();
                    String model = reader2.next();
                    String year = reader2.next();
                    String speed = reader2.next();
                    String color = reader2.next();

                    T1.setText(brand);
                    T2.setText(gearbox);
                    T3.setText(model);
                    T4.setText(year);
                    T5.setText(speed);
                    T6.setText(color);

                    double currentSpeed = Double.parseDouble(speed);
                    if (currentSpeed == fSpeed) {
                        break;
                    }
                }

                reader2.close();

                if (fSpeed == 0) {
                    JOptionPane.showMessageDialog(null, "Car file is empty.");
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error: File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Fastest car Imported!", "Done", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == B2) {
            T1.setText("");
            T2.setText("");
            T3.setText("");
            T4.setText("");
            T5.setText("");
            T6.setText("");
        }

    }
}
