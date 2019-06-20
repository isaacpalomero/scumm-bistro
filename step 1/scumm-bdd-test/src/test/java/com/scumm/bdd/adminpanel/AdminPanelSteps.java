package com.scumm.bdd.adminpanel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdminPanelSteps {

    private WebDriver driver;

    @Given("Un navegador")
    public void un_navegador(){
        driver = new FirefoxDriver();
    }

    @When("Entro en el panel de administracion")
    public void abro_el_admin_panel(){
        driver.get("http://localhost:8081");
    }

    @Then("Se abre el dashboard")
    public void se_abre_el_dashboard(){
        //driver.findElement(By.id(""))
    }
}
