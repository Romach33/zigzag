package com.company;

import javax.swing.*;
import java.awt.event.*;

public class Settings extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField xT1;
    private JTextField yT1;
    private JTextField xT2;
    private JTextField yT2;
    private JTextField wT;
    private JTextField nT;

    int x1;
    int x2;
    int y1;
    int y2;
    int n;
    int w;

    public Settings() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        x1 = Integer.parseInt(xT1.getText());
        y1 = Integer.parseInt(yT1.getText());

        x2 = Integer.parseInt(xT2.getText());
        y2 = Integer.parseInt(yT2.getText());


        n = Integer.parseInt(nT.getText());
        w = Integer.parseInt(wT.getText());
        DrawPanel.doIt(x1, y1, x2, y2, w, n);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Settings dialog = new Settings();
        dialog.setBounds(0,0, 300, 300);
        dialog.setVisible(true);
    }
}
