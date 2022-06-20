
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

// 2 Class Start Program

public class StartProgram implements ActionListener {
    private JFrame viewForm;
    private JLabel label;
    private JLabel backGround;
    private final JLabel INFO_ABOUT_CREATOR = new JLabel("Департамент Інформаційної Аналітичної Підтримки : розробник - К.Р.");
    private final JLabel INFO_ABOUT_CREATOR_TEL = new JLabel("телефони : Зовнішній - 00-00-00 : Внутрішній - 00-00");
    private JButton INFO;
    private JTextPane textPane;
    private JButton macAddress;
    private ImageIcon icon;
    private boolean onForINFO = true;

    public StartProgram() {
    runProgram();
    }

    private void runProgram(){

        // created FRAME, set size, set location, set NAME
        icon = new ImageIcon(getClass().getClassLoader().getResource("res/ICO.png"));
        viewForm = new JFrame("Підключення до НПУ");
        viewForm.setIconImage(icon.getImage());
        viewForm.setVisible(true);
        viewForm.setSize(450,175);
        viewForm.setLocationRelativeTo(null);
        viewForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewForm.setResizable(false);


        INFO = new JButton("Дод. Інформація");
        INFO.setSize(115,20);
        INFO.setLocation(310,110);
        INFO.setFont(new Font("Times new Roman", Font.BOLD, 10));
        INFO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (onForINFO){
                    INFO_ABOUT_CREATOR_TEL.setVisible(true);

                    for (int i=175; i < 190; i++ ){
                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        viewForm.setSize(450,i);
                        onForINFO = false;
                    }
                } else {
                    for (int i=190; i > 175; i-- ){
                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        viewForm.setSize(450,i);
                        onForINFO = true;
                        INFO_ABOUT_CREATOR_TEL.setVisible(false);

                    }
                }


            }
        });

        INFO_ABOUT_CREATOR.setLocation(10,120);
        INFO_ABOUT_CREATOR.setSize(500,45);
        INFO_ABOUT_CREATOR.setForeground(Color.WHITE);
        INFO_ABOUT_CREATOR.setFont(new Font("Times new Roman", Font.BOLD,10));

        INFO_ABOUT_CREATOR_TEL.setVisible(false);
        INFO_ABOUT_CREATOR_TEL.setLocation(10,105);
        INFO_ABOUT_CREATOR_TEL.setSize(500,40);
        INFO_ABOUT_CREATOR_TEL.setForeground(Color.WHITE);
        INFO_ABOUT_CREATOR_TEL.setFont(new Font("Times new Roman", Font.BOLD,11));

        String pathBackG = "res/backG(400).jpg";
        ImageIcon icon = new ImageIcon(this.getClass().getResource(pathBackG));
        backGround = new JLabel(icon);
        backGround.setSize(450,150);




// created an object to get the Windows version and checked for equality
        WinVersion windowsV = new WinVersion();


//  if this Operating System is Windows 10 we are created label with preferences
//  set size for Frame , and created button with preferences, and all is it added to Frame
//  an action listener is enabled for the button, when the button is clicked, a new object is created to validate the name

        if (windowsV.checkVersionWindows()){
            label = new JLabel("Windows 10");
            label.setLocation(165,10);
            label.setSize(415,30);
            label.setFont(new Font("Serif", Font.TYPE1_FONT, 20));
            label.setForeground(Color.white);

            textPane = new JTextPane();
            textPane.setText("                          Ваша версія ОС є задовільною, натисніть продовжити ...");
            textPane.setFont(new Font("Time New Roman",Font.BOLD,10));
            textPane.setVisible(true);
            textPane.setLocation(10,50);
            textPane.setSize(415,20);
            textPane.setEditable(false);


            JButton button = new JButton("Продовжити");
            button.setVisible(true);
            button.setLocation(10, 75);
            button.setSize(415, 30);

            viewForm.add(new JLabel());
            viewForm.add(button);
            viewForm.add(new JLabel());

            macAddress = new JButton("МАК Адреса");
            macAddress.setLocation(310,10);
            macAddress.setSize(115,20);
            macAddress.setVisible(true);

            macAddress.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewForm.setVisible(false);

                    new  MacAddress();
                }
            });


            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    viewForm.setVisible(false);

                    try {
                        new CheckName();
                    } catch (UnknownHostException ex) {
                        ex.printStackTrace();
                    }

                }
            });

//  else we are created label with preferences
//  set size for Frame , and created button with preferences, and all is it added to Frame
//  an action listener is enabled for the button, when the button is clicked system is closed
        } else if (!(windowsV.checkVersionWindows())) {
            label = new JLabel("Ваша версия Windows застаріла, Обновіть до Windows 10");
            label.setLocation(20,20);
            label.setSize(450,30);
            label.setFont(new Font("Serif", Font.TYPE1_FONT, 15));
            label.setForeground(Color.white);

            viewForm.setSize(450,175);
            viewForm.setLocationRelativeTo(null);
            viewForm.setResizable(false);

            JButton button = new JButton("Закрити");
            button.setVisible(true);
            button.setLocation(10, 70);
            button.setSize(415, 30);

            viewForm.add(new JLabel());
            viewForm.add(button);
            viewForm.add(new JLabel());
            viewForm.setVisible(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            });

        }


// added to frame JLabel for correctly job and added label and set color background
        viewForm.add(new JLabel());
        viewForm.add(INFO_ABOUT_CREATOR);
        viewForm.add(new JLabel());
        viewForm.add(INFO_ABOUT_CREATOR_TEL);
        viewForm.add(new JLabel());
        viewForm.add(INFO);
        viewForm.add(new JLabel());
        viewForm.add(textPane);
        viewForm.add(new JLabel());
        viewForm.setBackground(Color.darkGray);
        viewForm.add(new JLabel());
        viewForm.add(label);
        viewForm.add(new JLabel());
        viewForm.add(macAddress);
        viewForm.add(new JLabel());
        viewForm.add(backGround);
        viewForm.add(new JLabel());



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

