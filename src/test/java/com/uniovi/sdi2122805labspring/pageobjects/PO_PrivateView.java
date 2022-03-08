package com.uniovi.sdi2122805labspring.pageobjects;

import com.uniovi.sdi2122805labspring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.uniovi.sdi2122805labspring.pageobjects.PO_View.getTimeout;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);

        //Seleccionamos el alumno userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);

        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    public static void goLoginAndFill(WebDriver driver, String user, String password,String text) {
        //Ir a login
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");

        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, user, password);

        //Comprobamos que entramos en la pagina privada de Alumno
        List<WebElement> result = PO_View.checkElementBy(driver, "text", text);
    }

    public static void goLogout(WebDriver driver) {
        //Ir a logout
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    static public void showEnlacesAndGotToLastPage(WebDriver driver, String type, String text) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        elements.get(3).click();
    }
}