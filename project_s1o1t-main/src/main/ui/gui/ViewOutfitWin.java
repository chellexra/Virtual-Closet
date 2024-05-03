package ui.gui;

import model.Outfit;
import model.VirtualCloset;
import ui.FitInApp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class represents the graphical user interface for viewing outfits
// Resources for methods in this class: https://www.youtube.com/watch?v=Kmgo00avvEw&t=10163s
public class ViewOutfitWin implements ActionListener {
    JFrame viewOutfitFrame = new JFrame();
    FitInApp fitInApp;
    List<Outfit> outfits;
    List<JPanel> panels;
    JComboBox<String> comboBox;
    JPanel mainPanel;
    String[] seasons = {"All","Summer", "Fall", "Winter", "Spring"};

    //Modifies: this
    //Effects: This method constructs an addOutfitWin object
    public ViewOutfitWin(FitInApp fitInApp) {
        this.fitInApp = fitInApp;
        this.panels = new ArrayList<>();
        initFrame();

        comboBox = new JComboBox<String>(seasons);
        comboBox.addActionListener(this);
        topPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        outfits = fitInApp.getVirtualCloset().getAllOutfits();
        for (int i = 0; i < outfits.size(); i++) {
            initPanel(i);
        }

        JScrollPane scrPane = new JScrollPane(mainPanel);
        viewOutfitFrame.getContentPane().add(scrPane);
    }

    //Modifies: this
    //Effects: creates a frame
    public void initFrame() {
        viewOutfitFrame.getContentPane().setLayout(new BoxLayout(viewOutfitFrame.getContentPane(), BoxLayout.Y_AXIS));
        viewOutfitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewOutfitFrame.getContentPane().setBackground(new ColorUIResource(245, 218, 244));
        viewOutfitFrame.setPreferredSize(new Dimension(500, 700));

        viewOutfitFrame.pack();
        viewOutfitFrame.setVisible(true);
        viewOutfitFrame.setFocusable(true);
    }

    //Effects: Creates a panel with labels of user inputted outfits as a list of panels and a panel itself
    public void initPanel(int i) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 250));
        panel.setBackground(new ColorUIResource(221, 168, 227));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        Outfit outfit = outfits.get(i);
        label(panel, "Outfit " + Integer.toString(i + 1) + ":", 30);
        label(panel, outfit.getTop().getColor(), 20);
        label(panel, outfit.getTop().getType(), 20);
        label(panel, outfit.getBottom().getColor(), 20);
        label(panel, outfit.getBottom().getType(), 20);
        label(panel, outfit.getShoes().getColor(), 20);
        label(panel, outfit.getShoes().getType(), 20);
        label(panel, outfit.getSeason(), 20);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panels.add(panel);
        mainPanel.add(panel);
    }

    //Effects: Creates a panel that contains the header label and combobox
    public void topPanel() {
        JPanel topPanel = new JPanel();
        JLabel labelHeader = new JLabel();
        topPanel.setPreferredSize(new Dimension(500, 100));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));

        labelHeader.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        labelHeader.setVerticalAlignment(JLabel.TOP);
        labelHeader.setHorizontalAlignment(JLabel.CENTER);
        labelHeader.setText("View your Outfits!");
        labelHeader.setVisible(true);

        viewOutfitFrame.add(topPanel);
        topPanel.add(labelHeader);
        topPanel.add(comboBox);
    }

    //Effects: creates a label for the users inputted outfits adds label to a panel
    public void label(JPanel panel, String outfit,  int size) {
        JLabel label = new JLabel();
        label.setFont(new Font("Century Gothic", Font.PLAIN, size));
        label.setText(outfit);
        label.setVisible(true);
        panel.add(label);
    }

    //Effects: updates the panel based on user clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JPanel panel : panels) {
            mainPanel.remove(panel);
        }

        String selected = comboBox.getSelectedItem().toString();
        if (selected.equals("All")) {
            outfits = fitInApp.getVirtualCloset().getAllOutfits();
        } else {
            outfits = fitInApp.getVirtualCloset().getOutfitsBySeason(selected);
        }

        for (int i = 0; i < outfits.size(); i++) {
            initPanel(i);
        }

        mainPanel.revalidate();
    }
}


