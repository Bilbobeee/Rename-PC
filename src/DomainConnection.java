import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

public class DomainConnection extends FormRename implements ActionListener {
    private JLabel backGround;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JButton reboot;
    private JButton back;

    private final String IP_ADDRESS_ACTIVE_DIRECTORY = "0.0.0.0";
    private final String IP_ADDRESS_GOOGLE = "8.8.8.8";
    private final String IP_ADDRESS_GOOGLE_ALTERNATIVE = "8.8.4.4";
    private final String DOMAIN_NAME = "\"test.gov.ua\"";
    private final String LOGIN = "''администратор''";
    private final String PASSWORD = "''password''";

    public DomainConnection() {

        String pathBackG = "res/backG(600).jpg";
        ImageIcon icon = new ImageIcon(this.getClass().getResource(pathBackG));
        backGround = new JLabel(icon);
        backGround.setSize(550,250);
        setSize(550,200);
        setLocationRelativeTo(null);

        setVisible(true);


        startConnect();
    }

    private void startConnect(){

        info1 = new JLabel("УВАГА!");
        info1.setSize(400,30);
        info1.setLocation(150,10);
        info1.setForeground(Color.WHITE);
        info1.setFont(new Font("Times new Roman", Font.BOLD,24));
        info1.setVisible(true);

        info2 = new JLabel("після перезавантаження ваш ПК буде підключено:");
        info2.setSize(400,30);
        info2.setLocation(150,40);
        info2.setForeground(Color.WHITE);
        info2.setFont(new Font("Times new Roman", Font.BOLD,14));
        info2.setVisible(true);

        info3 = new JLabel("до Національної Поліції України");
        info3.setSize(400,30);
        info3.setLocation(150,70);
        info3.setForeground(Color.WHITE);
        info3.setFont(new Font("Times new Roman", Font.BOLD,18));
        info3.setVisible(true);



        reboot = new JButton("Перезавантажити");
        reboot.setSize(400,30);
        reboot.setLocation(120,120);
        reboot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String command = "start-process PowerShell -windowStyle hidden -verb runas -ArgumentList 'Get-NetAdapter | Set-DnsClientServerAddress -ServerAddresses "+
                        IP_ADDRESS_ACTIVE_DIRECTORY +","+IP_ADDRESS_GOOGLE+","+IP_ADDRESS_GOOGLE_ALTERNATIVE+
                        ";Set-ItemProperty -Path \"HKLM:\\Software\\Microsoft\\PowerShell\\1\\ShellIds\" -Name ConsolePrompting -Value True;$Username = "
                        +LOGIN+";$Password = "+PASSWORD+
                        ";[SecureString]$Securepassword = $Password | ConvertTo-SecureString -AsPlainText -Force;" +
                        "$credential = New-Object System.Management.Automation.PSCredential -ArgumentList $Username, $Securepassword;" +
                        "Add-Computer –domainname "+DOMAIN_NAME+" -Credential $credential;Restart-Computer'";

//                System.out.println(command);

                String[] commandList = {"powershell.exe" , command};

                ProcessBuilder processBuilder = new ProcessBuilder(commandList);
                try {
                    Process process = processBuilder.start();

                } catch (IOException ex) {

                    ex.printStackTrace();
                }


            }
        });

        back = new JButton("Назад");
        back.setSize(100,30);
        back.setLocation(10,120);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    new CheckName();

                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
            setVisible(false);
            }
        });

        add(new JLabel());
        add(info3);
        add(new JLabel());
        add(info2);
        add(new JLabel());
        add(info1);
        add(new JLabel());
        add(reboot);
        add(new JLabel());
        add(back);
        add(new JLabel());
        add(backGround);
        add(new JLabel());


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
