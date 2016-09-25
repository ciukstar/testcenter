package bootstrap
package liftweb

import net.liftweb._
import http._
import sitemap._

class Boot {

  def boot {
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("Applicants") / "applicants",
      Menu.i("Question") / "question" submenus(
        Menu.i("Questions") / "questions",
        Menu.i("Categories") / "categories",
        Menu.i("Families") / "families"
      )
    )

    LiftRules.setSiteMapFunc(() => sitemap())
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))
    LiftRules.addToPackages("code")
  }
}
