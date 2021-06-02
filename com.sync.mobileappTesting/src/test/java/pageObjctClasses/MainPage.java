package pageObjctClasses;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.ReusabaleFunctions;

public class MainPage extends ReusabaleFunctions{

	@SuppressWarnings("unused")
	private static  AndroidDriver<AndroidElement> driver;


	public MainPage() {
	}

	@SuppressWarnings("static-access")
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	//MainOption filed using Id
	@AndroidFindBy(className = "android.widget.ImageButton")
	public static AndroidElement MainOption;

	//EmailDetails filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/nav_displayname")
	public static AndroidElement EmailDetails;

	//SizeDetails Button using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/nav_diskusage_text")
	public static AndroidElement SizeDetails;


	//Files in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[1]")
	public static AndroidElement FilesMenu;

	//Vault in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[2]")
	public static AndroidElement VaultMenu;

	//LinksMenu in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[3]")
	public static AndroidElement LinksMenu;

	//Recents in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[4]")
	public static AndroidElement RecentsMenu;

	//Rewards in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[5]")
	public static AndroidElement RewardsMenu;

	//Settings in MainMenu
	@AndroidFindBy(xpath = "(//*[@class = 'android.support.v7.widget.LinearLayoutCompat'])[6]")
	public static AndroidElement SettingsMenu;

	//EmptyFolder filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/filelist_empty_title")
	public static AndroidElement EmptyFolder;

	//AddFolder filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/fab")
	public static AndroidElement AddFolder;

	//UpLoad File filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/bottomsheetActionUpload")
	public static AndroidElement UploadFiles;

	//NewFolderCreation filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/bottomsheetActionMkdir")
	public static AndroidElement NewFolderCreation;


	//CeateFolderName filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/foldername")
	public static AndroidElement CeateFolderName;


	//CreateButton filed using Id
	@AndroidFindBy(id = "android:id/button1")
	public static AndroidElement CreateButton;


	//CancelButton filed using Id
	@AndroidFindBy(id = "android:id/button2")
	public static AndroidElement CancelButton;

	//FileDetails in the list filed using Id
	@AndroidFindBy(id = "com.sync.mobileapp:id/filename")
	public static AndroidElement FileDetails;


	//AllowButton in the popup using Id
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	public static AndroidElement AllowButton;

	//AllowButton in the popup using Id
	@AndroidFindBy(className = "android.widget.LinearLayout")
	public static AndroidElement SelectFile;









	public static void checkUserOnHomePage() {
		try {
			waitForVisible(EmailDetails);
			if(EmailDetails.getText().trim().equalsIgnoreCase(getDatafromprop("Email").trim())) {
				System.out.println("Logged in User is :: "+EmailDetails.getText());
				System.out.println("--and Allocated Size is  : "+SizeDetails.getText());
			}else {
				System.err.println("Logged in User is not matching :: "+EmailDetails.getText());
			}

		}catch(Exception e) {
			try {
				waitForVisible(MainOption);
				MainOption.isDisplayed();
				System.out.println("User on Main Page .. need to click on menu option");

			}catch(Exception loggedinIssue) {
				System.err.println("User not able to logged in properly");
			}
		}
	}

	public static void CheckFilesOption() {
		try {
			clickOnelement(FilesMenu);
			checkFolderEmpty();

		}catch(Exception e) {
			System.err.println("User Not of File menu ===============");
		}

	}

	public static void checkFolderEmpty() {
		try {
			waitForVisible(EmptyFolder);
			EmptyFolder.isDisplayed();
			System.err.println("Folder is Empty Need to add New Folder");

			AddNewFolder();

			SelectFolder();
			AddfilesinExistFolder();

		}catch(Exception emptyFolder) {
			System.out.println("Folder is not Empty, need to Select perticuler Folder");
			AddNewFolder();
		}

		SelectFolder();
		AddfilesinExistFolder();

	}

	public static void AddNewFolder() {
		try {
			waitForVisible(AddFolder);
			clickOnelement(AddFolder);
			clickOnelement(NewFolderCreation);
			EnterText(CeateFolderName, FolderName);
			clickOnelement(CreateButton);
			System.out.println("User Successfully Created New Folder");
		}catch(Exception AddFolder) {
			try {
				clickOnelement(CancelButton);
			}catch(Exception cancelButton) {
				System.err.println("Not abel to Create new Folder");
			}
		}
	}

	public static void SelectFolder() {
		try {
			waitForVisible(FileDetails);
			List<AndroidElement> ListOfFolders = driver.findElements(By.id("com.sync.mobileapp:id/filename"));
			for(AndroidElement Folder:ListOfFolders) {
				if(Folder.getText().equalsIgnoreCase(FolderName)) {
					System.out.println("Successfully Selected Folder");
					Folder.click();
					break;
				}

			}

		}catch(Exception e) {

			System.err.println("Folder was not selected");
		}
	}
	public static void AddfilesinExistFolder() {
		try {

			waitForVisible(EmptyFolder);
			EmptyFolder.isDisplayed();
			System.err.println("Folder is Empty Need to add Upload Files");
			clickOnelement(AddFolder);
			clickOnelement(UploadFiles);
			System.out.println("User Ready to Upload Files into Selected Folder :: "+FolderName);
			clickOnelement(AllowButton);
			clickOnelement(UploadFiles);
			waitForVisible(SelectFile);
			clickOnelement(SelectFile);
		}catch(Exception AddNewFiles) {

			System.err.println("Upload Page not present on the screen");
		}

	}

}
