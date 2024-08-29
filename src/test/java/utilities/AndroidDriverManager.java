package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverManager {

	public static AppiumDriver androidDriver;

	public static AppiumDriver getDriver() {
		if (androidDriver == null) {
			AppiumServerManager.startServer("android");
			try {
				androidDriver = new AndroidDriver(
						new URL("http://127.0.0.1:4723/wd/hub"), getOptions()
				);
				setupDriverTimeouts(5);
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		return (androidDriver);
	}

	public static void quitDriver() {
		if (androidDriver != null) {
			androidDriver.quit();
			AppiumServerManager.stopServer();
			androidDriver = null;
		}
	}

	public static UiAutomator2Options getOptions() {
		UiAutomator2Options options;

		options = new UiAutomator2Options();
		options.setPlatformName("Android").setAutomationName("UiAutomator2");
		//options.setApp("C:/Users/avsel/Downloads/querycart2006.apk");
		options.setAppPackage("com.wise.querycart");
		options.setAppActivity("com.wise.querycart.MainActivity");
		options.setUdid("emulator-5554");
		options.setNoReset(false);
		options.setNewCommandTimeout(Duration.ofMinutes(20));

		return (options);
	}

	public static void setupDriverTimeouts(int second) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
	}
}
