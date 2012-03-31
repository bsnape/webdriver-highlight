package com.bensnape.examples.highlight.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.bensnape.examples.highlight.pages.Home;
import com.bensnape.examples.highlight.pages.PageFactory;
import com.bensnape.examples.highlight.pages.SearchResults;

public class Steps {

  private Home home;
  private SearchResults searchresults;

  public Steps(PageFactory pageFactory) {
    home = pageFactory.newHome();
    searchresults = pageFactory.newSearchResults();
  }

  @Given("I am on amazon.co.uk")
  public void homepageOnAmazon() {
    home.go();
  }

  @When("I search for product: <product>")
  public void searchForProduct(@Named("product") String product) {
    home.search(product);
  }

  @Then("I can see a product image and rating")
  public void verifyProductImageAndRating() {
    searchresults.isFirstResultImagePresent();
    searchresults.isFirstResultRatingPresent();
  }

}
