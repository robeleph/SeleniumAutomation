package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();


        JsonArray postjson = new JsonArray();
        chromeDriver.get("http://www.addisadmassnews.com/index.php?option=com_k2&view=itemlist&layout=category&task=category&id=1&Itemid=180");
        List<WebElement> posts = chromeDriver.findElements(By.cssSelector(".catItemView.groupPrimary"));
        for(WebElement post: posts){
            JsonObject newPost = new JsonObject();
            newPost.addProperty("title", post.findElement(By.className("catItemTitle")).getText());
            newPost.addProperty("author", post.findElement(By.className("catItemAuthor")).getText());
            newPost.addProperty("body", post.findElement(By.className("catItemIntroText")).getText());
            postjson.add(newPost);
        }

        PrintWriter out;
        try {
            out = new PrintWriter("c:\\www\\expressapp\\addisadmas.json");
            out.println(postjson.toString());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
