package com.guru99.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	static WebDriver driver;
	static Properties prop;
	 
	public TestBase(){
		
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("C:\\Dev\\Workspace1\\Guru99Sitetest\\src\\main\\java\\com\\guru99\\qa\\config\\"
					+ "config.properties");
			prop.load(ip);
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
    String browserName = prop.getProperty("browser");
    if(browserName.equals("chrome")) {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jithendra\\Downloads\\chromedriver_win32");
    	 driver = new ChromeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    
    driver.get(prop.getProperty("url"));

	}

}
