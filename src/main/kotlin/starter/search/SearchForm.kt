package starter.search

import net.serenitybdd.screenplay.targets.Target

object SearchForm {
    val SEARCH_FIELD: Target = Target.the("search field")
        .locatedBy("#searchInput")
    val ADVANCE_SEARCH_FIELD: Target = Target.the("advance search panel")
        .locatedBy("#search .mw-advancedSearch-container")
}