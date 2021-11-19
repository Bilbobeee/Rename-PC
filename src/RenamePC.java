import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class RenamePC implements ActionListener{

    private boolean gun;
    private boolean mto;
    private boolean onOf;
    private JFrame viewForm;

        public RenamePC() {
            initComponents();
        }


        private void initComponents() {

// created Form, set size and location
            viewForm = new JFrame("Перейменувати Персональний Комп'ютер");
            viewForm.setSize(450, 200);
            viewForm.setVisible(true);
            viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            viewForm.setLocationRelativeTo(null);
            viewForm.setResizable(false);

// created Label, set size and set location and color for the Text
            JLabel label = new JLabel("Виберіть розділ який стосується Вас");
            label.setLocation(10,10);
            label.setSize(415,20);
            label.setVisible(true);
            label.setForeground(Color.white);

// created Button, set size and Location
            JButton button = new JButton("Далі");
            button.setVisible(true);
            button.setLocation(10, 120);
            button.setSize(415, 30);

// created Checkbox for GUNPU, set size and Location, set Background is Dark_Gray and set Color Text is White
            JCheckBox checkBoxGUNP = new JCheckBox("Головне управління національної поліції (ГУНП)");
            checkBoxGUNP.setVisible(true);
            checkBoxGUNP.setLocation(10,40);
            checkBoxGUNP.setSize(400,40);
            checkBoxGUNP.setBackground(Color.DARK_GRAY);
            checkBoxGUNP.setForeground(Color.white);

// created Checkbox for MTOU, set size and Location, set Background is Dark_Gray and set Color Text is White
            JCheckBox checkBoxMTO = new JCheckBox("Міжрегіональний територіальний орган (MTO)");
            checkBoxMTO.setVisible(true);
            checkBoxMTO.setLocation(10,70);
            checkBoxMTO.setSize(400,40);
            checkBoxMTO.setBackground(Color.DARK_GRAY);
            checkBoxMTO.setForeground(Color.white);

// Set Background color Dark-Gray for Form and added label, button, new JLabel, Checkbox for GUNPU and Checkbox for MTOU
            viewForm.getContentPane().setBackground(Color.darkGray);
            viewForm.getContentPane().add(label);
            viewForm.getContentPane().add(button);
            viewForm.getContentPane().add(new JLabel());
            viewForm.getContentPane().add(checkBoxGUNP);
            viewForm.getContentPane().add(checkBoxMTO);


            checkBoxGUNP.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

//  IF ELSE for boolean variable
                    if (checkBoxGUNP.isSelected()){
                        gun = true;
                        mto = false;

//  If this block is worked Checkbox from MTOU will be Disabled and Checkbox from GUNPU will be Enabled
                        checkBoxMTO.setSelected(false);

//  Test string for looking on the Checkbox GUNPU, and looking how it is switching if Checkbox is Selected, or does not select
//                        System.out.println("GUN " + gun + ": MTO " + mto);

                    } else if (!(checkBoxGUNP.isSelected()) && gun) {
                        gun = false;

//  Test string for looking on the Checkbox GUNPU, when variable is does not select
//                        System.out.println("GUN " + gun + ": MTO " + mto);
                    }
                }
            });

//
            checkBoxMTO.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (checkBoxMTO.isSelected()){
                        gun = false;
                        mto = true;
                        checkBoxGUNP.setSelected(false);

                        System.out.println("GUN " + gun + ": MTO " + mto);
                    } else if (!(checkBoxMTO.isSelected()) && mto){
                        mto = false;

                        System.out.println("GUN " + gun + ": MTO " + mto);
                    }
                }
            });

            button.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (gun){
                        new  GUNPU();
                    } else if (mto){
                        new MTOU();
                    }
                }
            });


        }

        public void actionPerformed(ActionEvent action) {
        }

        public static void main(String[] args) {

             new RenamePC();





        }





}




/*
public class RenamePC implements ActionListener{


        public RenamePC() {
            initComponents();
        }

        private JFrame viewForm;

        private void initComponents() {
            viewForm = new JFrame("Перейменувати Персональний Комп'ютер");
            viewForm.setSize(450, 200);
            viewForm.setVisible(true);
            viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            viewForm.setLocationRelativeTo(null);
            viewForm.setResizable(false);


            JLabel label = new JLabel("Введіть ім'я Персонального Комп'ютера");
            label.setLocation(10,10);
            label.setSize(415,20);
            label.setVisible(true);
            label.setForeground(Color.white);

            JButton button = new JButton("Перейменувати та Перезагрузити ПК");
            button.setVisible(true);
            button.setLocation(10, 120);
            button.setSize(415, 30);

            JCheckBox radioButton = new JCheckBox();
            radioButton.setVisible(true);
            radioButton.setLocation(10,10);

            button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(viewForm, "Don't touch me!",
                            "Warning", JOptionPane.WARNING_MESSAGE);

                }

            });

            viewForm.getContentPane().add(radioButton);
            viewForm.getContentPane().setBackground(Color.darkGray);
            viewForm.getContentPane().add(label);
            viewForm.getContentPane().add(button);
            viewForm.getContentPane().add(new JLabel());
        }

        public void actionPerformed(ActionEvent action) {
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new RenamePC();
                }
            });
        }





}*/