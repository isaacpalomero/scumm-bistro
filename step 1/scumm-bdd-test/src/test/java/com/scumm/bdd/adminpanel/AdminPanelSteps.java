package com.scumm.bdd.adminpanel;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminPanelSteps {

    private WebDriver driver;

    @Given("Un navegador")
    public void un_navegador(){
        driver = new ChromeDriver();
    }

    @When("Entro en el panel de administracion")
    public void abro_el_admin_panel(){
        driver.get("http://localhost:8081");
    }

    @Then("Se abre el dashboard")
    public void se_abre_el_dashboard() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/nav/div/a"));
        Assert.assertNotNull(element);
        Assert.assertEquals("DASHBOARD", element.getText());

        WebElement linkTypography = driver.findElement(By.xpath("//*[@id=\"style-3\"]/ul[2]/li[4]/a"));
        Assert.assertNotNull(linkTypography);
        linkTypography.click();
    }

    @After
    public void cerrar_browser(){
        driver.close();
    }
}
