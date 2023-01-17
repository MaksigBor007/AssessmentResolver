package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethod;

import java.util.List;

public class HomePage extends CommonMethod {
    @FindBy(xpath = "//*[@id='inputEmail']")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id='inputPassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@class='list-group']/li")
    public List<WebElement> ListGroup;

    @FindBy(xpath = "//*[text()='6']")
    public WebElement badgeValue;

    @FindBy(id = "dropdownMenuButton")
    public WebElement option1Button;

    @FindBy(xpath = "//*[@class='dropdown-menu show']")
    public List<WebElement> ddManu;

    @FindBy(xpath = "//*[text()='Option 3']")
    public WebElement option3;

    @FindBy(xpath = "//*[@id='test-4-div']/button[1]")
    public WebElement firstButton;

    @FindBy(xpath ="//*[@id='test-4-div']/button[2]")
    public WebElement secondButton;

    @FindBy(xpath = "//*[@id='test5-button']")
    public WebElement test5Button;

    @FindBy(xpath = "//*[@id='test5-alert']")
    public WebElement messageAlert;

    @FindBy(xpath = "//*[@id='test5-button']")
    public WebElement disabledButton;

    @FindBy(xpath = "//*[@id='test-6-div']/div/table/tbody/tr/td")
    public List<WebElement> table;

    public HomePage() {
        PageFactory.initElements(driver,this);

    }
}
