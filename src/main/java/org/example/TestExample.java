package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.*;

import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.regex.Pattern;

@UsePlaywright
public class TestExample {
    @Test
    public void test() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();

        page.navigate("https://demoqa.com/", new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        page.locator("svg > path").first().click();
        page.getByText("Text Box").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Full Name")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Full Name")).fill("Привет!");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("name@example.com")).fill("SSS@SSS.ru");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Current Address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Current Address")).fill("DFDFD");
        page.locator("#permanentAddress").click(new Locator.ClickOptions()
                .setModifiers(Arrays.asList(KeyboardModifier.SHIFT)));
        page.locator("#permanentAddress").click(new Locator.ClickOptions()
                .setModifiers(Arrays.asList(KeyboardModifier.SHIFT)));
        page.locator("#permanentAddress").click();
        page.locator("#permanentAddress").fill("DFDF");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        System.out.println();

        browser.close();
    }
}
