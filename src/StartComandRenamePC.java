import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StartComandRenamePC extends FormRename implements ActionListener {
    private JLabel paneInfo1;
    private JButton buttonReboot;
    private JButton buttonBack;

    private JLabel backGround;

    public StartComandRenamePC(String name) {

        buttonBack = new JButton("Назад");
        buttonBack.setSize(80,30);
        buttonBack.setLocation(10,120);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChoiceTheControl();
                setVisible(false);
            }
        });

        paneInfo1 = new JLabel();
        paneInfo1.setSize(400,50);
        paneInfo1.setLocation(100,20);
        paneInfo1.setText("<html>Ім'я вашого ПК буде змінено <br> Комп'ютер буде перезавантажено</html>");
        paneInfo1.setFont(new Font("Time New Roman",Font.BOLD,18));
        paneInfo1.setVisible(true);
        paneInfo1.setForeground(Color.WHITE);
        paneInfo1.setHorizontalAlignment(JTextField.CENTER);

        buttonReboot = new JButton("Перезавантажити");
        buttonReboot.setSize(370,30);
        buttonReboot.setLocation(145,120);


        String pathBackG = "res/backG(600).jpg";
        ImageIcon icon = new ImageIcon(this.getClass().getResource(pathBackG));
        backGround = new JLabel(icon);
        backGround.setSize(550,300);

        add(new JLabel());
        add(buttonReboot);
        add(new JLabel());
        add(buttonBack);
        add(new JLabel());
        add(paneInfo1);
        add(new JLabel());
        add(backGround);
        add(new JLabel());


        startProcessRename(name);

    }


    private void startProcessRename(String name) {


        buttonReboot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(name);

                String command = "start-process PowerShell -windowStyle hidden -verb runas -ArgumentList 'Rename-Computer -NewName "+ name +";Restart-Computer'";
                System.out.println(command);

                String[] commandList = {"powershell.exe" , command};

                ProcessBuilder processBuilder = new ProcessBuilder(commandList);
                try {
                    Process process = processBuilder.start();
                    System.exit(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });



//
//        String[] commandList = {"powershell.exe", "start-process PowerShell -verb runas" , "Rename-Computer -NewName CL2", "Restart-Computer"};
//
//        ProcessBuilder pb = new ProcessBuilder(commandList);




//        try {
//            Process p = pb.start();

            //String command = "powershell.exe  your command";
            //Getting the version
//            String command = "powershell.exe  $PSVersionTable.PSVersion";
//            String[] command = {"Get-Process ", "where {$_.Id -le 100}"};

//            // Executing the command
//            Process powerShellProcess = Runtime.getRuntime().exec(command);
//            // Getting the results
//            powerShellProcess.getOutputStream().close();
//            String line;
//            System.out.println("Standard Output:");
//            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
//            while ((line = stdout.readLine()) != null) {
//                System.out.println(line);
//            }
//            stdout.close();
//            System.out.println("Standard Error:");
//            BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream(),"cp1251"));
//            while ((line = stderr.readLine()) != null) {
//                System.out.println(line);
//            }
//            stderr.close();
//            System.out.println("Done");
//
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
