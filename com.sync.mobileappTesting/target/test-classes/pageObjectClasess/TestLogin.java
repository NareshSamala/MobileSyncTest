package pageObjectClasess;

import org.openqa.selenium.By;

import utilities.ReusabaleFunctions;

public class TestLogin extends ReusabaleFunctions{
	static //Elements By
    By Email           = By.id("com.sync.mobileapp:id/input_email");
    By Password        = By.id("com.sync.mobileapp:id/input_password");
    
    By LoginBTN        = By.id("com.sync.mobileapp:id/btn_login");
    
    public static void login() {
    	EnterText(Email, ProjectPath);
    }

}
