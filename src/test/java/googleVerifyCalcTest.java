//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class googleVerifyCalcTest {

    private String GooglePage = "http://google.ca/#";
    private String Calculator = "#cwmcwd";
    private String GoogleSearch = "//button[@type='submit' and @aria-label='Google Search']";
    private String GoogleSearchField = "#lst-ib";
    private String GoogleCalculator = "#cwmcwd";
    private String CancelButton = "#cwbt06";
    private String ButtonSeven = "#cwbt13";
    private String ButtonPlus = "#cwbt46";
    private String InputCalculator = "#cwos";


    @Before
    public void openGoogleAndSearchCalculator()throws IOException {
        open(GooglePage);
        $(By.xpath(GoogleSearch)).exists();
        $(By.cssSelector(GoogleSearchField)).sendKeys("google calculator");
        $(By.cssSelector(Calculator)).should(exist);
    }

    @Test
    public void testSearchForGoogleCalculator() throws IOException {
        $(By.cssSelector(GoogleCalculator)).isDisplayed();
        $(By.cssSelector(ButtonSeven)).shouldHave(text("7"));
        $(By.cssSelector(ButtonPlus)).shouldHave(text("+"));
        $(By.cssSelector(CancelButton)).shouldHave(text("AC"));
        calcPage.buttonAC();
        $(By.cssSelector(CancelButton)).shouldHave(text("CE")); //AC button is changed to CE
    }

    @Test
    public void testVerifySumCalculation() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit1();
        calcPage.buttonSum();
        calcPage.clickOnDigit5();
        calcPage.calcResutlEqual("1 + 5");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("6");
        calcPage.buttonSum();
        calcPage.clickOnDigit7();
        calcPage.calcResutlEqual("6 + 7");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("13");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
        $(By.cssSelector("#cwles")).shouldHave(text("Ans = 1"));
    }

    @Test
    public void testVerifySubtractionCalculation() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit1();
        calcPage.clickOnDigit8();
        calcPage.buttonSubtraction();
        calcPage.clickOnDigit5();
        calcPage.clickOnDigit3();
        calcPage.calcResutlEqual("18 - 53");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("-35");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyMultiplyCalculation() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit2();
        calcPage.buttonMultiply();
        calcPage.clickOnDigit8();
        calcPage.calcResutlEqual("2 × 8");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("16");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyMultiplyCalculationOfHugeDigits() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();

        calcPage.buttonMultiply();

        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();
        calcPage.clickOnDigit9();

        calcPage.calcResutlEqual("9999999999 × 9999999999");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("1e+20");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyDivisionCalculation() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit2();
        calcPage.buttonDivision();
        calcPage.clickOnDigit3();
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("0.66666666666");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyDivisionByZero() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit4();
        calcPage.clickOnDigit6();
        calcPage.buttonDivision();
        calcPage.clickOnDigit0();
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("Infinity");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyDivisionZeroByZero() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit0();
        calcPage.buttonDivision();
        calcPage.clickOnDigit0();
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("Error");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testVerifyDifferentCalculations() throws IOException {
        calcPage.calcResutlEqual("0");
        calcPage.clickOnDigit4();
        calcPage.buttonSum();
        calcPage.clickOnDigit5();
        calcPage.buttonSubtraction();
        calcPage.clickOnDigit9();
        calcPage.buttonDivision();
        calcPage.clickOnDigit2();
        calcPage.calcResutlEqual("4 + 5 - 9 ÷ 2");
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("4.5");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }

    @Test
    public void testNotPossibleSetLetters() throws IOException {
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(InputCalculator)).sendKeys("zx");
        calcPage.buttonSum();
        calcPage.clickOnDigit5();
        calcPage.buttonCalcEqual();
        calcPage.calcResutlEqual("5");
        calcPage.buttonAC();
        calcPage.calcResutlEqual("0");
        $(By.cssSelector(CancelButton)).shouldHave(text("CE"));
    }
}
