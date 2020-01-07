package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver driver;


	public WebDriver getDriver(String browser, String environment) {

		if (environment.equals("remoteHub")) {
			createDriverGrid();
		} else {
			createDriver(browser);

		}
		return driver;
	}

	private void createDriver(String browser) {
		try {
			switch (browser) {

			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					ChromeOptions options = new ChromeOptions();
					options.addArguments("window-size=1920x1080");
					driver = new ChromeDriver(options);
				}
				break;
			case "chrome-headless":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					ChromeOptions options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1920x1080");
					driver = new ChromeDriver(options);
				}
				break;
			case "ie":
				if (null == driver) {
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					driver = new InternetExplorerDriver();
				}
				break;
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		}

	}

	private WebDriver createDriverGrid() {
		if (null == driver) {
			URL url = null;
			try {
				url = new URL("http://34.98.89.28/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			System.out.println("! Using remote Webdirver: " + url);
			ChromeOptions opts = new ChromeOptions();
			driver = new RemoteWebDriver(url, opts);
		}

		return driver;
	}
	
	
}
