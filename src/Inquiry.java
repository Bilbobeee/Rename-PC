import java.io.FileWriter;
import java.io.IOException;

public class Inquiry  {

    private String macAddress;
    private String OS;

    private String GUNPU;
    private String department;
    private String city;
    private Integer invNumber;
    private String nameOfPC;

    private String userLastName;
    private String userName;
    private String surname;
    private String position;
    private String militaryRank;

    public Inquiry(String macAddress, String OS){

        this.macAddress = macAddress;
        this.OS = OS;

        writeMacAndWin(macAddress,OS);
    }

    public Inquiry(String GUNPU, String department, String city, Integer invNumber, String nameOfPC){
        this.GUNPU = GUNPU;
        this.department = department;
        this.city = city;
        this.invNumber = invNumber;
        this.nameOfPC = nameOfPC;

        writeDepartmentAndNamePC(GUNPU, department, city, invNumber, nameOfPC);
    }

    public Inquiry(String userLastName, String userName, String surname, String position, String militaryRank){
        this.userLastName = userLastName;
        this.userName = userName;
        this.surname = surname;
        this.position = position;
        this.militaryRank = militaryRank;

        writeUserInfo(userLastName, userName, surname, position, militaryRank);
    }


    private void writeMacAndWin(String macAddress, String OS){}

    private void writeDepartmentAndNamePC(String GUNPU, String department, String city, Integer invNumber, String nameOfPC){}

    private void writeUserInfo(String userLastName, String userName, String surname, String position, String militaryRank){}

}
