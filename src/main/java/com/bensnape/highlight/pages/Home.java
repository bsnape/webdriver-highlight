package com.bensnape.highlight.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import com.bensnape.highlight.common.CommonPageMethods;

/**
 * The Amazon homepage
 *
 * @author Ben Snape
 */
public class Home extends CommonPageMethods {

    private static final String URL = "http://www.amazon.co.uk";

    private static final String SEARCH_FIELD = "//*[@id='twotabsearchtextbox']";

    private static final String SEARCH_BUTTON = "//*[@class='nav-submit-button nav-sprite']/input";

    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    /**
     * Navigate to this page
     */
    public void go() {
        get(URL);
    }

    /**
     * Perform a search.
     *
     * @param thing The thing you are searching for
     */
    public void search(String thing) {
        enterText(By.xpath(SEARCH_FIELD), thing);
        click(By.xpath(SEARCH_BUTTON));
    }

}
