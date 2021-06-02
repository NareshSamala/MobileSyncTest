
import org.openqa.selenium.By;

import utilities.ReusabaleFunctions;



public class LoginPage extends ReusabaleFunctions{
	
	//Elements By
    By Email           = By.id("com.sync.mobileapp:id/input_email");
    By Password        = By.id("com.sync.mobileapp:id/input_password");
    
    By LoginBTN        = By.id("com.sync.mobileapp:id/btn_login");
	
	public static void login() {
		
		EnterText(Email,"myselfmono85@gmail.com");
		EnterText(Password,"zaq12wsx");
		
		clickOnelement(LoginBTN);
	}

}
