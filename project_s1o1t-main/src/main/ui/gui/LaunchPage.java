package ui.gui;

import model.Event;
import model.EventLog;
import ui.FitInApp;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

//Class that represents the main launchpage of the application
// Resources for methods in this class: https://www.youtube.com/watch?v=Kmgo00avvEw&t=10163s
public class LaunchPage extends JFrame implements ActionListener, WindowListener {

    FitInApp fitInApp;
    JButton addOutfitButton = new JButton("Add Outfit");
    JButton viewButton = new JButton("View Outfits");
    String image = "./src/main/ui/gui/closedcloset.png";
    ImageIcon closedClosetImg = new ImageIcon(image);

    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem loadItem = new JMenuItem("Load");
    JMenuItem saveItem = new JMenuItem("Save");

    //Constructs launchPage as the main window when application is opened
    public LaunchPage() {
        try {
            fitInApp = new FitInApp();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        initMenuBar();
        initLabel();
        initFrame();
        initPanel();
        Image image = closedClosetImg.getImage();
        Image closetImg = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        closedClosetImg = new ImageIcon(closetImg);

        addOutfitButton.setBounds(100, 160, 200, 40);
        addOutfitButton.setFocusable(false);
        addOutfitButton.addActionListener(this);

        viewButton.setBounds(0, 0, 200, 40);
        viewButton.setFocusable(false);
        viewButton.addActionListener(this);

        add(panel);
        add(label);
        addWindowListener(this);
        setVisible(true);
    }

    //Modifies: this
    //Effects: creates a label that can be added to the launchpage frame
    public void initLabel() {
        label.setIcon(closedClosetImg);
        label.setHorizontalTextPosition(JLabel.CENTER); //options: set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP);//set text TOP CENTER OR BOTTOM OF imageicon
        label.setForeground(Color.black); //OPTION: set rgb values by saying new Color(r: g: b:) or HEX
        label.setFont(new Font("Century Gothic", Font.PLAIN, 50)); //sets the font name, style and size
        label.setText("Your Virtual Closet awaits"); //set text of label
        label.setIconTextGap(25); //set gap of text to image
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        label.setBounds(100, 100, 200, 200); //set x, y position within frame as well as dimensions
    }

    //Modifies: this
    //Effects: creates a frame for the application GUI
    public void initFrame() {
        setTitle("FitIn Application"); //sets title of the frame
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits out of application
        setSize(1000, 1000); //sets the x-dimension, and y-dimension of frame
        getContentPane().setBackground(new ColorUIResource(245, 218, 244)); //change color of background
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
    }

    //Modifies: this
    //Effects: creates a panel to be added to the frame
    public void initPanel() {
        panel.setPreferredSize(new Dimension(600, 40));
        panel.setBackground(new ColorUIResource(245, 218, 244));
        panel.add(addOutfitButton);  // JButton = a button that performs an action when clicked on
        panel.add(viewButton);
        panel.setLayout(new FlowLayout());
    }

    //Modifies: this
    //Effects: allows users to save and load their outfits
    public void initMenuBar() {
        setJMenuBar(menuBar);
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (Event ev : EventLog.getInstance()) {
            System.out.println(ev.toString());
        }
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    //Effects: actions that are performed when user interacts with
    // addOutfitBuitton, viewButton, loadItem and saveItem in menubar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addOutfitButton) {
            AddOutfitWin addOutfitWin = new AddOutfitWin(fitInApp);
        }

        if (e.getSource() == viewButton) {
            ViewOutfitWin viewOutfitWin = new ViewOutfitWin(fitInApp);
        }

        if (e.getSource() == loadItem) {
            fitInApp.loadVirtualCloset();
        }

        if (e.getSource() == saveItem) {
            fitInApp.saveVirtualCloset();
        }
    }
}