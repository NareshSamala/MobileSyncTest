package funtionality;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utilities.ReusabaleFunctions;

public class BaseClass extends ReusabaleFunctions{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
//			String[] command = {"cmd.exe", "/C", "Start", "C:\\Users\\naresh\\Desktop\\AppiumStart.bat"};
//            Process p =  Runtime.getRuntime().exec(command);    
			//startServer();
			startAppiumServer();
//			launchApplication();
//			login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("rawtypes")
	public static void launchApplication() throws Exception{
		
		readConfigValues();
		readProperties();
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", getDatafromJson("deviceName"));
        caps.setCapability("device", getDatafromJson("device")); //DeviceId from "adb devices" command
        caps.setCapability("platformName", getDatafromJson("platformName"));
        caps.setCapability("platformVersion", getDatafromJson("platformVersion"));
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", getDatafromJson("appPackage"));
        caps.setCapability("appActivity", getDatafromJson("appActivity"));
        caps.setCapability("noReset", getDatafromJson("noReset"));
        caps.setCapability("app", getDatafromJson("app"));
        caps.setCapability("noSign",getDatafromJson("noSign"));
         
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver = new Androiddiver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 20);
		
	}
	
	public static void login() {
		driver.findElement(By.id("com.sync.mobileapp:id/input_email")).sendKeys("myselfmono85@gmail.vom");	
		driver.findElement(By.id("com.sync.mobileapp:id/input_password")).sendKeys("zaq12wsx");
		driver.findElement(By.id("com.sync.mobileapp:id/btn_login")).click();	
	}
	
	public static void startServer() throws Exception {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	    	Process proc= runtime.exec("cmd /c cd /d C:\\Users\\naresh && start cmd.exe /K  \"  appium -a 127.0.0.1 -p 4723 --session-override\"");
	        Thread.sleep(20000);
	        BufferedReader stdInput = new BufferedReader(new 
	        	     InputStreamReader(proc.getInputStream()));

	        	BufferedReader stdError = new BufferedReader(new 
	        	     InputStreamReader(proc.getErrorStream()));

	        	// Read the output from the command
	        	System.out.println("Here is the standard output of the command:\n");
	        	String s = null;
	        	while ((s = stdInput.readLine()) != null) {
	        	    System.out.println(s);
	        	}

	        	// Read any errors from the attempted command
	        	System.out.println("Here is the standard error of the command (if any):\n");
	        	while ((s = stdError.readLine()) != null) {
	        	    System.out.println(s);
	        	}
	    } catch (InterruptedException  e) {
	        e.printStackTrace();
	    }
	}

	public void stopServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void startAppiumServer() {
	    //Set Capabilities
//		DesiredCapabilities  cap = new DesiredCapabilities();
//	    cap.setCapability("noReset", "false");

	    //Build the Appium service
	    AppiumServiceBuilder   builder = new AppiumServiceBuilder();
	    builder.withAppiumJS(new File("C:\\Users\\naresh\\node_modules\\appium"));
	    builder.withIPAddress("127.0.0.1");
	    builder.usingPort(4721);
	   // builder.withCapabilities(cap);
	    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

	    //Start the server with the builder
	    AppiumDriverLocalService   service = AppiumDriverLocalService.buildService(builder);
	    service.start();
	}
	
	
	public void startAppiumServer_new() throws IOException, InterruptedException { 
		 
//		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
//		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		//command.addArgument("--no-reset", false);
		command.addArgument("--log-level", true);
		command.addArgument("error");
		command.addArgument("--log");
		command.addArgument("/Users/aparna/Documents/sys113.log");

		
//		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//		DefaultExecutor executor = new DefaultExecutor();
//		executor.setExitValue(1);
//		executor.execute(command, resultHandler);
		
		
		Thread.sleep(20000);
      
    }  
      
    public  void stopAppiumServer() throws IOException {  
        String[] command ={"/usr/bin/killall","-KILL","node"};  
        Runtime.getRuntime().exec(command);  
        //System.out.println("Appium server stop");  
    }  
}
