package pl.edu.pjatk.tau.football;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestVerifyData {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(365, 600));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("test@test.com");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("test778@test.com");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='lastname'])[1]/following::li[1]")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("Janusz");
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("Typowy");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("Piwna");
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Gdansk");
        driver.findElement(By.id("id_state")).click();
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alabama");
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("11111");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alabama'])[1]/following::p[1]")).click();
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("11111111111");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Receive special offers from our partners!'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]")).click();
        driver.findElement(By.id("columns")).click();
        assertEquals("Sign out", driver.findElement(By.linkText("Sign out")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
