package com.quangminh.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private TextPanel textPanel;
    private ToolBar toolBar;
    private  FormPanel formPanel;
    public MainFrame() {
        super("Hello World");
        setLayout(new BorderLayout());
        toolBar = new ToolBar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        toolBar.setStringListener((text)->{
            textPanel.appendText(text);
        });

        formPanel.setFormListener(e -> {
            String name = e.getName();
            String occupation = e.getOccupation();
            int id = e.getId();
            String empCat = e.getEmpCat();
            textPanel.appendText(name+":"+occupation+":"+id+":"+empCat+  "\n");

        });

        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
