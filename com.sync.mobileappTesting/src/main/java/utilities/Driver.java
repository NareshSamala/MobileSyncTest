package utilities;

import java.util.Properties;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;


/**
 * @author naresh
 *
 */
public class Driver {
	protected static String ProjectPath = System.getProperty("user.dir"); //--Project Directory path
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	public static WebDriverWait wait;
	public static  Properties prop; // for read properties 


}


