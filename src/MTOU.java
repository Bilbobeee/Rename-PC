import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

// 9 Class MTOU

public class MTOU extends FormRename implements ActionListener {
    private Library library;
    private JComboBox menuSPA;
    private JComboBox menuDistrict;
    private JComboBox menuGU;
    private JLabel infoChooseLabel;
    private JLabel infoChooseGULabel;
    private JLabel infoInputLabel;
    private JLabel infoInputDistrictLabel;
    private JButton buttonNext;
    private JButton buttonBack;
    private JTextField inventoryNumber;
    private JLabel err1;
    private JLabel errAbout;
    private JLabel backGround;

    private String depText;

    private String control ;
    private String controlAbbreviation ;
    private String districtString;
    private String districtStringAbbreviation;
    private int depIndex;
    private int invNumb;

    private String invNumbSixthNumber;

    private String nameForPC;


    public MTOU() {


        String pathBackG = "res/backG(800).jpg";
        ImageIcon icon = new ImageIcon(this.getClass().getResource(pathBackG));
        backGround = new JLabel(icon);
        backGround.setSize(550,390);

        nameMTOU();
    }

    private void nameMTOU(){

        setSize(550,370);
        setLocationRelativeTo(null);

        library = new Library();

        err1 = new JLabel();
        err1.setVisible(false);

        infoChooseGULabel = new JLabel("Виберіть Орган управління якому ви підпорядковуєтеся");
        infoChooseGULabel.setLocation(100,10);
        infoChooseGULabel.setSize(400,30);
        infoChooseGULabel.setFont(new Font("Times new Roman", Font.BOLD,14));
        infoChooseGULabel.setForeground(Color.white);

        menuGU = new JComboBox(library.getABBREVIATION_GUNPU().values().toArray(new String[0]));
        menuGU.setLocation(7,40);
        menuGU.setSize(520,30);
        menuGU.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,12));

        errAbout = new JLabel("В інвентаризаційному номері повинні бути тільки цифри");
        errAbout.setVisible(false);

        infoChooseLabel = new JLabel("Виберіть ваш Департамент/Відділ/Управління/ДУ");
        infoChooseLabel.setLocation(115,85);
        infoChooseLabel.setSize(350,30);
        infoChooseLabel.setFont(new Font("Times new Roman", Font.BOLD,14));
        infoChooseLabel.setForeground(Color.white);

        menuSPA = new JComboBox(library.getINDEX_SPA().values().toArray(new String[0]));
        menuSPA.setLocation(7,115);
        menuSPA.setSize(520,30);
        menuSPA.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,12));
        menuSPA.setEnabled(false);

        infoInputDistrictLabel = new JLabel("Виберіть ваш район");
        infoInputDistrictLabel.setLocation(220,150);
        infoInputDistrictLabel.setSize(300,30);
        infoInputDistrictLabel.setFont(new Font("Times new Roman", Font.BOLD,14));
        infoInputDistrictLabel.setForeground(Color.white);
        infoInputDistrictLabel.setVisible(true);

        menuDistrict = new JComboBox(library.getABBREVIATION_MTOU().values().toArray(new String[0]));
        menuDistrict.setLocation(7,180);
        menuDistrict.setSize(520,30);
        menuDistrict.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,12));
        menuDistrict.setEnabled(false);


        infoInputLabel = new JLabel("Введіть Інвентаризаційний номер ПК");
        infoInputLabel.setLocation(150,220);
        infoInputLabel.setSize(300,30);
        infoInputLabel.setFont(new Font("Times new Roman", Font.BOLD,14));
        infoInputLabel.setForeground(Color.white);
        infoInputLabel.setVisible(true);

        inventoryNumber = new JTextField();
        inventoryNumber.setLocation(120,250);
        inventoryNumber.setSize(320,30);
        inventoryNumber.setVisible(true);
        inventoryNumber.setFont(new Font("Times new Roman", Font.BOLD,25));
        inventoryNumber.setEnabled(false);

        buttonNext = new JButton("Далі");
        buttonNext.setSize(350,30);
        buttonNext.setLocation(105,290);
        buttonNext.setVisible(true);

        buttonBack = new JButton("Назад");
        buttonBack.setSize(80,30);
        buttonBack.setLocation(10,290);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChoiceTheControl();
                setVisible(false);
            }
        });



        menuGU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control = menuGU.getSelectedItem().toString();
                menuSPA.setEnabled(true);

                menuSPA.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        depText = menuSPA.getSelectedItem().toString();
                        menuDistrict.setEnabled(true);

                        for (Map.Entry<String,String> cell : library.getABBREVIATION_GUNPU().entrySet()){
                            if (control.equals(cell.getValue())){
                                controlAbbreviation = cell.getKey();
                                break;
                            }

                        }

                        menuDistrict.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                districtString = menuDistrict.getSelectedItem().toString();
                                inventoryNumber.setEnabled(true);

                                for (Map.Entry<String,String> cell : library.getABBREVIATION_MTOU().entrySet()){
                                    if (districtString.equals(cell.getValue())){
                                        districtStringAbbreviation = cell.getKey();
                                        break;
                                    }
                                }

                                Robot r = null;
                                try {
                                    r = new Robot();
                                } catch (AWTException ex) {
                                    ex.printStackTrace();
                                }
                                r.keyPress(KeyEvent.VK_UP);


                                buttonNext.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e1) {

                                        boolean lengthNumber = true;

                                        if (!inventoryNumber.getText().isEmpty()){

                                            try {
                                                invNumb = Integer.parseInt(inventoryNumber.getText().replaceAll(" ",""));


                                                if (String.valueOf(invNumb).length() <6){
                                                    lengthNumber = false;
                                                    throw new NumberFormatException();
                                                }


                                                invNumbSixthNumber = String.valueOf(invNumb).substring( String.valueOf(invNumb).length()-6);


                                                err1.setVisible(false);
                                                inventoryNumber.setBackground(Color.WHITE);
                                                errAbout.setVisible(false);
                                                buttonNext.setLocation(105,125);


                                                for (Map.Entry<Integer,String> cell : library.getINDEX_SPA().entrySet()){
                                                    if (depText.equals(cell.getValue())){
                                                        depIndex = cell.getKey();
                                                        break;
                                                    }
                                                }

                                                nameForPC = controlAbbreviation + "-" + depIndex + "-"+districtStringAbbreviation + "-" + invNumbSixthNumber;

                                                new StartComandRenamePC(nameForPC);
                                                setVisible(false);

                                            }catch (NumberFormatException e2){

                                                if (lengthNumber == false){
                                                    errAbout.setText("Повинно бути не менше як 6 символів");
                                                    errAbout.setLocation(140,290);

                                                } else {
                                                    errAbout.setText("В інвентаризаційному номері повинні бути тільки цифри");
                                                    errAbout.setLocation(80,290);
                                                }


                                                inventoryNumber.setBackground(Color.pink);

                                                errAbout.setVisible(true);
                                                errAbout.setSize(500,20);
                                                errAbout.setForeground(Color.red);
                                                errAbout.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));


                                                setSize(550,400);
                                                buttonNext.setLocation(105,320);

                                                err1.setVisible(true);
                                                err1.setLocation(118,248);
                                                err1.setSize(324,34);
                                                err1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
                                            }

                                        }

                                    }
                                });


                            }
                        });


                    }
                });



            }
        });






        add(new JLabel());
        add(menuSPA);
        add(new JLabel());
        add(menuGU);
        add(new JLabel());
        add(menuDistrict);
        add(new JLabel());
        add(infoInputDistrictLabel);
        add(new JLabel());
        add(infoChooseLabel);
        add(new JLabel());
        add(buttonNext);
        add(new JLabel());
        add(buttonBack);
        add(new JLabel());
        add(infoInputLabel);
        add(new JLabel());
        add(inventoryNumber);
        add(new JLabel());
        add(err1);
        add(new JLabel());
        add(errAbout);
        add(new JLabel());
        add(infoChooseGULabel);
        add(new JLabel());
        add(backGround);
        add(new JLabel());


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
