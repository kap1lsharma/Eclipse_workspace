package com.qa.opencart.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBrokenLinks {

    public static void main(String[] args) {
        
    	
    
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Run Chrome in headless mode
        options.addArguments("--disable-gpu");  // Optional: speeds up performance in headless mode on some machines
        options.addArguments("--no-sandbox");  // Optional: recommended for CI/CD environments

        // Initialize WebDriver with headless Chrome
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/"); // Replace with your target URL

        // Get all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Iterate through each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    // Check if the link is broken
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();

                    if (responseCode >= 400) {
                        System.out.println("Broken Link: " + url + " (Status: " + responseCode + ")");
                    } else {
                        System.out.println("Valid Link: " + url + " (Status: " + responseCode + ")");
                    }
                } catch (IOException e) {
                    System.out.println("Exception while checking link: " + url);
                }
            } else {
                System.out.println("Empty or Missing URL for element: " + link.getText());
            }
        }

        // Close the browser
        driver.quit();
    }
}