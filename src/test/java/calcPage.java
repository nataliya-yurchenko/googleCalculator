import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
//import ru.yandex.qatools.allure.annotations.Step;

public class calcPage {

    public static void calcResutlEqual(String expectedCalcResult) {
        $(By.cssSelector("#cwos")).shouldHave(text(expectedCalcResult));
    }

    public static void buttonCalcEqual() {
        $(By.cssSelector("#cwbt45")).click();
    }
    public static void buttonSum() {
        $(By.cssSelector("#cwbt46")).click();
    }
    public static void buttonMultiply() {
        $(By.cssSelector("#cwbt26")).click();
    }
    public static void buttonDivision() {
        $(By.cssSelector("#cwbt16")).click();
    }
    public static void buttonSubtraction() {
        $(By.cssSelector("#cwbt36")).click();
    }
    public static void buttonAC() {
        $(By.cssSelector("#cwclrbtnAC")).click();
    }

    public static void clickOnDigit1() {
        $(By.cssSelector("#cwbt33")).click();
    }
    public static void clickOnDigit2() {
        $(By.cssSelector("#cwbt34")).click();
    }
    public static void clickOnDigit3() {
        $(By.cssSelector("#cwbt35")).click();
    }
    public static void clickOnDigit4() {
        $(By.cssSelector("#cwbt23")).click();
    }
    public static void clickOnDigit5() {
        $(By.cssSelector("#cwbt24")).click();
    }
    public static void clickOnDigit6() {
        $(By.cssSelector("#cwbt25")).click();
    }
    public static void clickOnDigit7() {
        $(By.cssSelector("#cwbt13")).click();
    }
    public static void clickOnDigit8() {
        $(By.cssSelector("#cwbt14")).click();
    }
    public static void clickOnDigit9() { $(By.cssSelector("#cwbt15")).click(); }
    public static void clickOnDigit0() { $(By.cssSelector("#cwbt43")).click(); }
}
