package tnr.junitmetalink;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.squashtest.ta.galaxia.squash.tf.galaxia.annotations.TFMetadata;
import java.util.concurrent.TimeUnit;

public class AnimatedMenuTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://codepen.io/knyttneve/pen/LKrGBy");
    }

    @TFMetadata(key = "linked-TC", value = "zzz")
    @DisplayName("sameName")
    @Test
    public void testMenuTestimonials(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='result']")));
        driver.findElement(By.xpath("//a[contains(text(),'Testimonials')]")).click();
        String style = driver.findElement(By.xpath("//a[contains(text(),'Testimonials')]")).getAttribute("class");
        Assertions.assertTrue(style.contains("is-active"), "Le bouton n'a pas été activé");
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        style = driver.findElement(By.xpath("//a[contains(text(),'Testimonials')]")).getAttribute("class");
        Assertions.assertTrue(style.contains("is-active"), "Le bouton n'a pas été désactivé");
    }
    
    @TFMetadata(key = "linked-TC", value = "17932783-7d4a-4e68-a52e-e54b3116e3e7")
    @DisplayName("sameName")
    @Test
    public void testMenuBlog(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='result']")));
        driver.findElement(By.xpath("//a[contains(text(),'Blog')]")).click();
        String style = driver.findElement(By.xpath("//a[contains(text(),'Blog')]")).getAttribute("class");
        Assertions.assertTrue(style.contains("is-active"), "Le bouton n'a pas été activé");
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        style = driver.findElement(By.xpath("//a[contains(text(),'Blog')]")).getAttribute("class");
        Assertions.assertTrue(!style.contains("is-active"), "Le bouton n'a pas été désactivé");
    }


	
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
