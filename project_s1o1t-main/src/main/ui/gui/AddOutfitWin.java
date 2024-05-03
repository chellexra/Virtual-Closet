package ui.gui;

import model.Bottoms;
import model.Outfit;
import model.Shoes;
import model.Tops;
import ui.FitInApp;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class represents the graphical user interface for adding outfits
// Resources for methods in this class: https://www.youtube.com/watch?v=Kmgo00avvEw&t=10163s
public class AddOutfitWin implements ActionListener {
    JFrame addOutfitFrame = new JFrame();
    JPanel panel = new JPanel();
    JButton submitButton = new JButton("Submit");
    JTextField textFieldTopColor = new JTextField(10);
    JTextField textFieldTopStyle = new JTextField(10);
    JTextField textFieldBottomColor = new JTextField(10);
    JTextField textFieldBottomStyle = new JTextField(10);
    JTextField textFieldShoesColor = new JTextField(10);
    JTextField textFieldShoesStyle = new JTextField(10);
    JComboBox comboBoxSeason = new JComboBox();
    FitInApp fitInApp;
    String[] seasons = {"Spring","Summer", "Fall", "Winter"};

    //Effects: This method constructs an addOutfitWin object
    public AddOutfitWin(FitInApp fitInApp) {
        this.fitInApp = fitInApp;
        addOutfitFrame.getContentPane().setLayout(new BoxLayout(addOutfitFrame.getContentPane(), BoxLayout.Y_AXIS));
        addOutfitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addOutfitFrame.getContentPane().setBackground(new ColorUIResource(245, 218, 244));
        addOutfitFrame.setPreferredSize(new Dimension(450, 900));

        submitButton.addActionListener(this);
        submitButton.setBounds(200, 100, 100, 50);
        label("What will you wear today?", 30);
        addTopTextFields();
        addBottomTextFields();
        addShoeTextFields();
        addComboBox();
        panel.setBounds(0, 0, 500, 100);
        panel.setBackground(new Color(195, 229, 229));

        panel.setLayout(new FlowLayout());
        panel.add(submitButton);
        addOutfitFrame.add(panel);
        addOutfitFrame.pack();
        addOutfitFrame.setVisible(true);
        addOutfitFrame.setFocusable(true);
    }

    //Effects: constructs textfields for users to input their top, is added to panel
    public void addTopTextFields() {
        textFieldTopColor.setPreferredSize(new Dimension(200, 40));
        textFieldTopColor.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldTopColor.setForeground(Color.BLACK);
        textFieldTopColor.setBackground(new Color(232, 209, 234));
        textFieldTopColor.setCaretColor(Color.pink);

        textFieldTopStyle.setPreferredSize(new Dimension(200, 40));
        textFieldTopStyle.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldTopStyle.setForeground(Color.BLACK);
        textFieldTopStyle.setBackground(Color.WHITE);
        textFieldTopStyle.setCaretColor(Color.pink);

        label("Enter Top Color", 20);
        panel.add(textFieldTopColor);
        label("Enter Top Style", 20);
        panel.add(textFieldTopStyle);
    }

    //Effects: constructs textfields for users to input their bottoms, is added to panel
    public void addBottomTextFields() {
        textFieldBottomColor.setPreferredSize(new Dimension(200, 40));
        textFieldBottomColor.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldBottomColor.setForeground(Color.BLACK);
        textFieldBottomColor.setBackground(new Color(232, 209, 234));
        textFieldBottomColor.setCaretColor(Color.pink);

        textFieldBottomStyle.setPreferredSize(new Dimension(200, 40));
        textFieldBottomStyle.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldBottomStyle.setForeground(Color.BLACK);
        textFieldBottomStyle.setBackground(Color.WHITE);
        textFieldBottomStyle.setCaretColor(Color.pink);

        label("Enter Bottom Color", 20);
        panel.add(textFieldBottomColor);
        label("Enter Bottom Style", 20);
        panel.add(textFieldBottomStyle);
    }

    // Resources for methods in this class: https://www.youtube.com/watch?v=Kmgo00avvEw&t=10163s
    //Effects: constructs textfields for users to input their shoes, is added to panel
    public void addShoeTextFields() {
        textFieldShoesColor.setPreferredSize(new Dimension(200, 40));
        textFieldShoesColor.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldShoesColor.setForeground(Color.BLACK);
        textFieldShoesColor.setBackground(new Color(232, 209, 234));
        textFieldShoesColor.setCaretColor(Color.pink);

        textFieldShoesStyle.setPreferredSize(new Dimension(200, 40));
        textFieldShoesStyle.setFont(new Font("Century Gothic", Font.PLAIN,20));
        textFieldShoesStyle.setForeground(Color.BLACK);
        textFieldShoesStyle.setBackground(Color.WHITE);
        textFieldShoesStyle.setCaretColor(Color.pink);

        label("Enter Shoes Color", 20);
        panel.add(textFieldShoesColor);
        label("Enter Shoes Style", 20);
        panel.add(textFieldShoesStyle);
    }

    //Modifies: this
    //Effects: Creates a comboBox to be added to a panel for user selection of Season
    public void addComboBox() {
        comboBoxSeason = new JComboBox(seasons);
        comboBoxSeason.addActionListener(this);
        panel.add(comboBoxSeason);
    }

    //modifies: this
    //Effects: Creates a label to be added to a panel
    public void label(String str, int size) {
        JLabel label = new JLabel();
        label.setFont(new Font("Century Gothic", Font.PLAIN, size));
        label.setText(str);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVisible(true);
        panel.add(label);
    }

    //Effects: creates a window to alert user that their outfit has been created
    void alert() {
        JOptionPane.showMessageDialog(null, "Your outfit has been created!",
                "Saved outfit", JOptionPane.INFORMATION_MESSAGE);
    }

    // Resources for methods in this class: https://www.youtube.com/watch?v=Kmgo00avvEw&t=10163s
    //Effects: controls the behaviour of submitButton and comboBoxSeason drop down
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String topColor = textFieldTopColor.getText();
            String topStyle = textFieldTopStyle.getText();
            Tops top = new Tops(topColor, topStyle);
            String bottomColor = textFieldBottomColor.getText();
            String bottomStyle = textFieldBottomStyle.getText();
            Bottoms bottom = new Bottoms(bottomColor, bottomStyle);
            String shoeColor = textFieldShoesColor.getText();
            String shoeStyle = textFieldShoesStyle.getText();
            Shoes shoes = new Shoes(shoeColor, shoeStyle);
            String season = comboBoxSeason.getSelectedItem().toString();
            Outfit outfit = new Outfit(top, bottom, shoes, season);
            fitInApp.addOutfit(outfit);
            alert();
        }
    }
}