package com.uniovi.sdi2122805labspring.pageobjects;

import com.uniovi.sdi2122805labspring.util.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.uniovi.sdi2122805labspring.pageobjects.PO_View.getTimeout;
import static com.uniovi.sdi2122805labspring.pageobjects.PO_View.p;

public class PO_HomeView extends PO_NavView{

    //comprobar el mensaje de bienvenida, pero podría generalizarse para buscar cualquier clave del archivo de propiedades
    static public void checkWelcomeToPage(WebDriver driver, int language) {
        //Esperamos a que se cargue el saludo de bienvenida en Español
        SeleniumUtils.waitLoadElementsBy(driver, "text", p.getString("welcome.message", language), getTimeout());
    }

    static public List<WebElement> getWelcomeMessageText(WebDriver driver, int language) {
        //Esperamos a que se cargue el saludo de bienvenida en Español
        return SeleniumUtils.waitLoadElementsBy(driver, "text", p.getString("welcome.message", language), getTimeout());
    }

    static public void checkChangeLanguage(WebDriver driver, String textLanguage1, String textLanguage, int locale1, int locale2) {
        //Esperamos a que se cargue el saludo de bienvenida en Español
        PO_HomeView.checkWelcomeToPage(driver, locale1);
        //Cambiamos a segundo idioma
        PO_HomeView.changeLanguage(driver, textLanguage);
        // Comprobamos que el texto de bienvenida haya cambiado a segundo idioma
        PO_HomeView.checkWelcomeToPage(driver, locale2);
        //Volvemos a Español.
        PO_HomeView.changeLanguage(driver, textLanguage1);
        // Esperamos a que se cargue el saludo de bienvenida en Español
        PO_HomeView.checkWelcomeToPage(driver, locale1); }
    }
