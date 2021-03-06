package everis.carrinho.utilitarios;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSelenium {

	private static WebDriver driver = null;
	public static final String CHROME_DRIVER = "src/test/resources/chromedriver.exe";
	public static final boolean HEADLESS = false;
	public static final String LOJA = "http://automationpractice.com/index.php";

	@BeforeClass
	public static void inicializarSistema() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);

		if (HEADLESS) {

			driver = iniciarWebDriverEmModoHeadless();
		} else {

			driver = iniciarWebDriverEmModoDefault();
		}

		driver.manage().window().maximize();
		driver.get(LOJA);

	}

	@AfterClass
	public static void sairSistema() {
		driver.quit();
	}

	private static ChromeDriver iniciarWebDriverEmModoDefault() {
		return new ChromeDriver();
	}

	private static ChromeDriver iniciarWebDriverEmModoHeadless() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		return new ChromeDriver(options);
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
