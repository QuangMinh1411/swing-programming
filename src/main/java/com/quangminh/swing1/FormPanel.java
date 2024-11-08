package com.quangminh.swing1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JLabel {
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();

        //Setup List Box
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"18 or under"));
        ageModel.addElement(new AgeCategory(1,"18 to 65"));
        ageModel.addElement(new AgeCategory(2,"65 or over"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110,72));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        //Set up combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);


        okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                FormEvent ev = new FormEvent(this,name,occupation,ageCat.getId());
                if(formListener!=null){
                    formListener.formEventOccurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //First row
        gc.gridy = 0;
        gc.weightx = 1.0;
        gc.weighty = 0.1;
        gc.gridx = 0;


        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField,gc);


        //Second row
        gc.gridy++;
        gc.weightx=1.0;
        gc.weighty=0.1;

        gc.gridx=0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridy=1;
        gc.gridx=1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        //Third row
        gc.gridy++;
        gc.weightx=1.0;
        gc.weighty=0.2;

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        //Fourth row
        gc.gridy++;
        gc.weightx = 1.0;
        gc.weighty = 0.2;

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 0);
        add(empCombo, gc);

        //Final row
        gc.gridy++;
        gc.weightx = 1.0;
        gc.weighty = 2.0;
        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
class AgeCategory {
    private  int id;
    private String text;
    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return text;
    }
}
