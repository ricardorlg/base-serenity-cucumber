package starter.stepdefinitions

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.EventualConsequence.eventually
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible
import net.serenitybdd.screenplay.questions.WebElementQuestion.the
import net.serenitybdd.screenplay.questions.page.TheWebPage
import net.serenitybdd.screenplay.questions.targets.TheTarget.textOf
import net.serenitybdd.screenplay.waits.WaitUntil
import org.hamcrest.CoreMatchers.endsWith
import org.hamcrest.CoreMatchers.equalTo
import starter.navigation.NavigateTo
import starter.search.LookForInformation
import starter.search.SearchForm
import starter.search.WikipediaArticle

class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    fun `actor is researching things`(actor: Actor) {
        actor.wasAbleTo(NavigateTo.theWikipediaHomePage())
    }

    @When("{actor} looks up {string}")
    fun `actor searches for`(actor: Actor, term: String) {
        actor.attemptsTo(
            WaitUntil.the(SearchForm.SEARCH_FIELD, isVisible())
                .forNoMoreThan(10)
                .seconds(),
            LookForInformation.about(term)
        )
    }

    @When("{actor} tries to search without typing any term")
    fun `actor tries to search with no typed term`(actor: Actor) {
        actor.attemptsTo(
            WaitUntil.the(SearchForm.SEARCH_FIELD, isVisible())
                .forNoMoreThan(10)
                .seconds(),
            LookForInformation.aboutNothing()
        )
    }

    @Then("{actor} should see information about {string}")
    fun ` actor should see information about`(actor: Actor, term: String) {
        actor.should(
            eventually(
                seeThat(
                    textOf(WikipediaArticle.HEADING),
                    equalTo(term)
                )
            ).waitingForNoLongerThan(5)
                .seconds()
        )
    }

    @Then("{actor} should see an advance search page")
    fun `actor should see an advance search page`(actor: Actor) {
        actor.should(
            eventually(
                seeThat(
                    the(SearchForm.ADVANCE_SEARCH_FIELD), isVisible()
                )
            ).waitingForNoLongerThan(10)
                .seconds(),
            seeThat(TheWebPage.currentUrl(), endsWith("Special:Search?search=&go=Go"))
        )
    }
}