package com.quangminh.swing1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {
    private JButton helloButton;
    private JButton goodbyeButton;
    private StringListener textListener;
    public ToolBar() {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(helloButton);
        add(goodbyeButton);
    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == helloButton) {
//            textPanel.appendText("hello\n");
            if(textListener != null){
                textListener.textEmitted("Hello\n");
            }
        } else if(clicked == goodbyeButton) {
//            textPanel.appendText("goodbye\n");
            if(textListener != null){
                textListener.textEmitted("Goodbye\n");
            }
        }
    }
}
