package pageObjctClasses;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.ReusabaleFunctions;



public class LoginPage extends ReusabaleFunctions{



	@SuppressWarnings("unused")
	private AndroidDriver<AndroidElement> driver;


	public LoginPage() {
	}

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	//Email filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/input_email")
	public static AndroidElement Email;

	//Password filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/input_password")
	public static AndroidElement Password;

	//Login Button using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/btn_login")
	public static AndroidElement LoginBTN;

	//ErrorOnLoginPage Button using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/error_message")
	public static AndroidElement ErrorOnLoginPage;
	//ErrorOnLoginPage text  using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/error_message_text")
	public static AndroidElement ErrorOnLoginPageText;





	public static void login() {
		try {
			EnterText(Email,getDatafromprop("Email"));
			EnterText(Password,getDatafromprop("Password"));
			clickOnelement(LoginBTN);
			try {
				ErrorOnLoginPage.isDisplayed();
				System.err.println(ErrorOnLoginPageText.getText());
			}catch(Exception e) {
				System.out.println("User Loged in Successfully");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
