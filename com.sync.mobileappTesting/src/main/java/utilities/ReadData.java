package utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadData extends Driver{

	/**
	 * @param args
	 */
	public static double MonthAmmountbyCalc; // get values from Calculation
	public static int TotalAmountpayble;
	public static int TotalInterestpayble;
	public static JSONObject jsonObject;
	public static String FolderName;
	public static void main(String[] args) {
		try {
			readProperties();
			System.out.println(getDatafromprop("url"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//read data from proprties file Based on inpur parameter
	public static void readProperties() throws IOException {

		prop = new Properties(); // rea

		FileInputStream fis = null;

		fis = new FileInputStream(ProjectPath+"\\src\\main\\resources\\inputs\\Properties.prop"); //input path of Properties file 
		prop.load(fis);
		fis.close();

	}

	public static String getDatafromprop(String getData) {
		//logger.info("Read data from Properties file for :: "+getData);
		String dataValue = prop.getProperty(getData); // get value from Properties file
		//logger.info(getData + " value fetch from prop file is - "+ dataValue);
		return dataValue;

	}

	//Read Values from Input Json
	public static void readConfigValues() {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(ProjectPath+"\\src\\main\\resources\\inputs\\config.json"));
			jsonObject = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static String getDatafromJson(String Value) {
		String inputValue = null;
		//get Values from Json File
		inputValue = (String)jsonObject.get(Value); // get Values form Json file based on input Value
		System.out.println("Value from Input file :: "+Value+"-----"+inputValue);
		System.out.println("==============================");
		return inputValue;

	}
}
