package com.quangminh.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private JButton btn;
    private ToolBar toolBar;
    public MainFrame() {
        super("Hello World");
        setLayout(new BorderLayout());
        toolBar = new ToolBar();
        textPanel = new TextPanel();

        toolBar.setStringListener((text)->{
            textPanel.appendText(text);
        });


        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
