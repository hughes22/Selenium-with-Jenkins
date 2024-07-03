package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Forms {
    WebDriver driver;
    private final WebDriverWait wait;

    public  Forms(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    By Name = By.id("name");
    By Drink = By.id("drink1");
    By Color = By.id("color");
    By Blue = By.xpath("//input[@id='color2']");
    By Siblings = By.id("siblings");
    By Animals = By.xpath("//li[contains(text(),'Eagle')]");
    By Email = By.id("email");
    By Message = By.id("message");
    By Submit = By.xpath("//button[@id='submit-btn']");

    public void enterFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        WebElement firstNameInput = driver.findElement(Name);
        firstNameInput.sendKeys(firstname);
    }
    public void selectFavoriteDrink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Drink));
        driver.findElement(Drink).click();
    }
    public void selectFavoriteColor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Color));
        WebElement target = driver.findElement(Color);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
        wait.until(ExpectedConditions.elementToBeClickable(target));
        target.click();
    }
    public  void selectAnySiblings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Siblings));
        Select dropdown = new Select(driver.findElement(Siblings));

        dropdown.selectByVisibleText("Yes");
    }

    public void selectFastAnimals(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Animals));
        WebElement element = driver.findElement(Animals);
        System.out.println(element.getText());
    }
    public void enterEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public void enterMessage(String message){driver.findElement(Message).sendKeys(message);
    }
    public void clickSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(Submit));
        driver.findElement(Submit).click();
        ///Alert alert = driver.switchTo().alert();
        //alert.accept();

    }
}
