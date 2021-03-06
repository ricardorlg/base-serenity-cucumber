package starter.search

import net.serenitybdd.screenplay.Performable
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.actions.Enter
import org.openqa.selenium.Keys

object LookForInformation {
    fun about(searchTerm: String): Performable {
        return Task.where(
            "{0} searches for '$searchTerm'",
            Enter.theValue(searchTerm)
                .into(SearchForm.SEARCH_FIELD)
                .thenHit(Keys.ENTER)
        )
    }

    fun aboutNothing(): Performable {
        return Task.where(
            "{0} searches without typing any search term",
            Enter.theValue("")
                .into(SearchForm.SEARCH_FIELD)
                .thenHit(Keys.ENTER)
        )
    }
}