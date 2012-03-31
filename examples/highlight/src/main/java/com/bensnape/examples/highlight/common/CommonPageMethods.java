package com.bensnape.examples.highlight.common;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * A class containing common WebDriver methods to act as a single point of
 * interaction with the browser.
 * 
 * @author Ben Snape
 * 
 */
public class CommonPageMethods extends WebDriverPage {

  public CommonPageMethods(WebDriverProvider webDriverProvider) {
    super(webDriverProvider);
  }

  /**
   * Wait for an element.
   * 
   * @param by
   *          The locating mechanism
   */
  public void waitForElement(By by) {
    waitUntilVisible(by);
  }

  /**
   * Get the text of an element.
   * 
   * @param by
   *          The locating mechanism
   * @return The text contained in the element
   */
  public String getText(By by) {
    WebElement element = waitUntilVisible(by);
    return element.getText();
  }

  /**
   * Enter text into a field.
   * 
   * @param by
   *          The locating mechanism
   * @param text
   *          The text to enter
   */
  public void enterText(By by, String text) {
    WebElement element = waitUntilVisible(by);
    element.sendKeys(text);
  }

  /**
   * Click on an element.
   * 
   * @param by
   *          The locating mechanism
   */
  public void click(By by) {
    WebElement element = waitUntilVisible(by);
    element.click();
  }

  /**
   * Wait for an element to be visible in the UI.
   * 
   * <p>
   * A method commonly used inside other public methods.
   * 
   * @param by
   *          The locating mechanism
   * @return The found WebElement
   */
  private WebElement waitUntilVisible(By by) {
    try {
      WebElement element = findElement(by);
      highlight(element);
      return element;
    } catch (NoSuchElementException e) {
      throw new NoSuchElementException(
          "Failed to find the element specified by: "
              + by
              + " to become visible and clickable in the UI. Check your selection method!");
    }
  }

  /**
   * Set an attribute in the HTML of a page.
   * 
   * @param element
   *          The WebElement to modify
   * @param attributeName
   *          The attribute to modify
   * @param value
   *          The value to set
   */
  private void setAttribute(WebElement element, String attributeName,
      String value) {
    executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
        element, attributeName, value);
  }

  /**
   * Highlight an element in the UI.
   * 
   * @param element
   *          The WebElement to highlight
   */
  private void highlight(WebElement element) {
    final int wait = 75;
    String originalStyle = element.getAttribute("style");
    try {
      setAttribute(element, "style",
          "color: yellow; border: 5px solid yellow; background-color: black;");
      Thread.sleep(wait);
      setAttribute(element, "style",
          "color: black; border: 5px solid black; background-color: yellow;");
      Thread.sleep(wait);
      setAttribute(element, "style",
          "color: yellow; border: 5px solid yellow; background-color: black;");
      Thread.sleep(wait);
      setAttribute(element, "style",
          "color: black; border: 5px solid black; background-color: yellow;");
      Thread.sleep(wait);
      setAttribute(element, "style", originalStyle);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
