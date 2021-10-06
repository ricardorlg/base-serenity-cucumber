package starter.stepdefinitions

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.EventualConsequence.eventually
import net.serenitybdd.screenplay.GivenWhenThen.seeThat
import net.serenitybdd.screenplay.questions.targets.TheTarget.textOf
import org.hamcrest.CoreMatchers.equalTo
import starter.navigation.NavigateTo
import starter.search.LookForInformation
import starter.search.WikipediaArticle

class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    fun `actor is researching things`(actor: Actor) {
        actor.wasAbleTo(NavigateTo.theWikipediaHomePage())
    }

    @When("{actor} looks up {string}")
    fun `actor searches for`(actor: Actor, term: String) {
        actor.attemptsTo(
            LookForInformation.about(term)
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
}