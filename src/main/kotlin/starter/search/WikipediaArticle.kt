package starter.search

import net.serenitybdd.screenplay.targets.Target

object WikipediaArticle {
    val HEADING: Target = Target.the("article heading")
        .locatedBy("#firstHeading")
}