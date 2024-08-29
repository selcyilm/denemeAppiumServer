package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Test;

public class Test01 {
	/*@Test
	public void test01() {
		AndroidDriverManager.getDriver();
		ReusableMethods.wait(5);
		AndroidDriverManager.quitDriver();
	}*/

	@Before
	public void setup(){
		//AppiumServerManager.startServer("android");
	}

	/*@After(order = 1)
	public void teardown1(Scenario scenario) {
		if (scenario.isFailed()) {
			AndroidDriverManager.quitDriver();
			AppiumServerManager.stopServer();
		}
	}
	@After(order = 2)
	public void teardown() {
		AppiumServerManager.stopServer();
	}*/

	@After
	public void teardown() {
		AndroidDriverManager.quitDriver();
	}
}
