package t;

import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class T {

    ReadDataFromJson readDataFromJson;

    @Test
    public void t1() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().URL); //working fine
        System.out.println(readDataFromJson.readJsonFile().login.validCredentials.username);
        System.out.println(readDataFromJson.readJsonFile().login.validCredentials.password);
        System.out.println("****************************************");
    }

    @Test
    public void t2() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().login.invalidCredentials.invalidUserName.UserName);
        System.out.println(readDataFromJson.readJsonFile().login.invalidCredentials.invalidUserName.Password);
        System.out.println("****************************************");
    }

    @Test
    public void t3() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().login.invalidCredentials.invalidPassword.UserName);
        System.out.println(readDataFromJson.readJsonFile().login.invalidCredentials.invalidPassword.Password);
        System.out.println("****************************************");
    }

}
