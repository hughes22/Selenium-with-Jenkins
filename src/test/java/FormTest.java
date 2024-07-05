import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Forms;

public class FormTest {
    WebDriver driver;
    private ConfigManager config;
    @BeforeTest
    public void beforeTest(){
        config = new ConfigManager();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        //options.addArguments("--window-size=1920,1080");
        String baseURL = config.getProperty("baseURL1");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
    @Test
    public void field(){
        Forms myforms = new Forms(driver);
        String username = config.getProperty("username");
        myforms.enterFirstName(username);
        myforms.selectFavoriteDrink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        myforms.selectAnySiblings();
        myforms.selectFastAnimals();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        String email = config.getProperty("email");
        myforms.enterEmail(email);
        String messages = config.getProperty("messages");
        myforms.enterMessage(messages);
    }
    @AfterTest
    public void exit(){
        driver.quit();
    }
}
