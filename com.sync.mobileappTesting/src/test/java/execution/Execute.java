package execution;

import org.testng.annotations.Test;

import funtionality.BaseClass;
import pageObjctClasses.LoginPage;
import pageObjctClasses.MainPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Execute  extends BaseClass  {
	
	
  @SuppressWarnings({ "unchecked", "static-access" })
@Test
  public void f() {
	  
	  try {
		launchApplication();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.login();
	  
	  MainPage mainPage = new MainPage(driver);
	  mainPage.checkUserOnHomePage();
	  mainPage.CheckFilesOption();
  }
  @BeforeTest
  public void beforeTest() {
	 
	  System.out.println("Execution tsarted ========");
	  createFolderName();
  }

  @AfterTest
  public void afterTest() {
	  stopServer();
	  System.out.println("Execution Ended ========");
  }

}
