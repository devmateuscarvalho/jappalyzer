package com.vampbear.jappalyzer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Set;

// docker run -d -p 4444:4444 --shm-size=2g selenium/standalone-chrome
public class JappalyzerRunner {
    public static void main(String[] args) {
        try {
            ChromeOptions options = new ChromeOptions();
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

            driver.get("https://www.wappalyzer.com/apps/");
            Thread.sleep(5000);
            String renderedHtml = driver.getPageSource();
            Jappalyzer jappalyzer = Jappalyzer.create();
            Set<TechnologyMatch> result = jappalyzer.fromString(renderedHtml);
            System.out.println("Tecnologias detectadas:");
            for (TechnologyMatch tech : result) {
                System.out.println("- Tecnologia: " + tech.getTechnology().getName());
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}