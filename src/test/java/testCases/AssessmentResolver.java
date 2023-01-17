package testCases;



import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethod;


import java.util.List;

public class AssessmentResolver extends CommonMethod {

    @Test
    public static void Test1() {
/**
 * Navigate to the home page
 * Assert that both the email address and password inputs are present as well as the login button
 * Enter in an email address and password combination into the respective fields
 */
        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)
        boolean emailIsDisplayed = homePage.emailInput.isDisplayed();
        boolean passIsDisplayed = homePage.passwordInput.isDisplayed();
        boolean loginBtnIsDisplayed = homePage.loginBtn.isDisplayed();

        Assert.assertTrue(emailIsDisplayed);
        Assert.assertTrue(passIsDisplayed);
        Assert.assertTrue(loginBtnIsDisplayed);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendText(homePage.emailInput, "noreply@noemail.com");
        sendText(homePage.passwordInput, "123456qq");
        click(homePage.loginBtn);

    }


    @Test
    public static void Test2() {
/**
 * Navigate to the home page
 * In the test 2 div, assert that there are three values in the listgroup
 * Assert that the second list item's value is set to "List Item 2"
 * Assert that the second list item's badge value is 6
 */
        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)


        int size = homePage.ListGroup.size();
        Assert.assertEquals(size, 3);
        System.out.println("There are " + size + " values in the listgroup");

        System.out.println();

        for (WebElement option2 : homePage.ListGroup) {
            String entireList = option2.getText();
            if (entireList.contains("List Item 2")) {
                System.out.println("The second list item's value is set to " + entireList);
                break;
            }
        }

        String badgeValueText = homePage.badgeValue.getText();
        Assert.assertEquals(badgeValueText, "6");
        System.out.println("the second list item's badge value is " + badgeValueText);
    }


    @Test
    public static void Test3() {

        /**
         * Navigate to the home page
         * In the test 3 div, assert that "Option 1" is the default selected value
         * Select "Option 3" from the select list
         */

        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)

        getJSExecutor().executeScript("window.scrollBy(0,700)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String option1ButtonText = homePage.option1Button.getText();
        Assert.assertEquals(option1ButtonText, "Option 1");

        click(homePage.option1Button);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(homePage.option3);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public static void Test4() {
        /**
         * Navigate to the home page
         * In the test 4 div, assert that the first button is enabled and that the second button is disabled
         */
        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)
        getJSExecutor().executeScript("window.scrollBy(0,700)");

        boolean firstButtonIsEnabled = homePage.firstButton.isEnabled();
        Assert.assertTrue(firstButtonIsEnabled);

        boolean secondButtonIsDisabled = homePage.secondButton.isDisplayed();
        Assert.assertTrue(secondButtonIsDisabled);

    }


    @Test
    public static void Test5() throws InterruptedException {
        /**
         * Navigate to the home page
         * In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it
         * Once you've clicked the button, assert that a success message is displayed
         * Assert that the button is now disabled
         */
        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)
        getJSExecutor().executeScript("window.scrollBy(0,900)");
        waitToBeVisible(homePage.test5Button);
        click(homePage.test5Button);
        waitToBeVisible(homePage.messageAlert);
        String actualMessageAlert = homePage.messageAlert.getText();
        String expectedMessageAlert = "You clicked a button!";
        System.out.println(actualMessageAlert);
        Assert.assertEquals(actualMessageAlert, expectedMessageAlert);

        boolean buttonIsDiabled = homePage.disabledButton.isEnabled();
        Assert.assertFalse(buttonIsDiabled);
    }

    @Test
    public static void Test6() throws InterruptedException {
        /**
         * Navigate to the home page
         * Write a method that allows you to find the value of any cell on the grid
         * Use the method to find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner)
         * Assert that the value of the cell is "Ventosanzap"
         */
        //homepage is automatically opened through derived class which is CommonMethod class(avoiding redundant code)
        getJSExecutor().executeScript("window.scrollBy(0,1300)");

        List<WebElement> tableRows = homePage.table;
        for (int i = 0; i < tableRows.size(); i++) {
            String rowText = tableRows.get(i).getText();
            if (rowText.contains("Ventosanzap")) {
                Assert.assertEquals(rowText,"Ventosanzap");
                System.out.println("The value of the cell is "+rowText);
                break;
            }
        }
    }

}





