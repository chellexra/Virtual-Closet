package ui;

import ui.gui.LaunchPage;

import javax.swing.*;

// Main Class is the entry point for FitIn application
// This class initializes and starts the FitInApp class
public class Main {
    public static void main(String[] args) {
//        try {
//            FitInApp fitInApp = new FitInApp();
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }

        SwingUtilities.invokeLater(() -> {
            LaunchPage launchFrame = new LaunchPage();
        });
    }

}
