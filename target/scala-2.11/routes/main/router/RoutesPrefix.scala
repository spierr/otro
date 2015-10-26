
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/scvalencia606/Documents/University/SchoolWork/Teaching/ISIS2503/labs/lab02/mueblesdelosalpes/conf/routes
// @DATE:Mon Aug 10 08:21:39 COT 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
