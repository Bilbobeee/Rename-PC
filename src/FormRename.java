import javax.swing.*;
import java.awt.*;

public class FormRename extends JFrame {

    public FormRename() {
        super("Підключення до НПУ");


        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("res/ICO.png"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
        setResizable(false);


        rename();
    }

    private void rename(){



    }
}
