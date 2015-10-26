
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/scvalencia606/Documents/University/SchoolWork/Teaching/ISIS2503/labs/lab02/mueblesdelosalpes/conf/routes
// @DATE:Mon Aug 10 08:21:39 COT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_4: controllers.Application,
  // @LINE:21
  CiudadController_3: controllers.CiudadController,
  // @LINE:25
  ExperienciaVendedorController_0: controllers.ExperienciaVendedorController,
  // @LINE:33
  MuebleController_1: controllers.MuebleController,
  // @LINE:39
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_4: controllers.Application,
    // @LINE:21
    CiudadController_3: controllers.CiudadController,
    // @LINE:25
    ExperienciaVendedorController_0: controllers.ExperienciaVendedorController,
    // @LINE:33
    MuebleController_1: controllers.MuebleController,
    // @LINE:39
    Assets_2: controllers.Assets
  ) = this(errorHandler, Application_4, CiudadController_3, ExperienciaVendedorController_0, MuebleController_1, Assets_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_4, CiudadController_3, ExperienciaVendedorController_0, MuebleController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ciudad""", """controllers.CiudadController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ciudad""", """controllers.CiudadController.read()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """experiencia""", """controllers.ExperienciaVendedorController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """experiencia""", """controllers.ExperienciaVendedorController.read()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """experiencia/$id<[^/]+>""", """controllers.ExperienciaVendedorController.get(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """experiencia/$id<[^/]+>""", """controllers.ExperienciaVendedorController.update(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mueble""", """controllers.MuebleController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mueble""", """controllers.MuebleController.read()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_4.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CiudadController_create1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ciudad")))
  )
  private[this] lazy val controllers_CiudadController_create1_invoker = createInvoker(
    CiudadController_3.create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CiudadController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """ciudad"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_CiudadController_read2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ciudad")))
  )
  private[this] lazy val controllers_CiudadController_read2_invoker = createInvoker(
    CiudadController_3.read(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CiudadController",
      "read",
      Nil,
      "GET",
      """""",
      this.prefix + """ciudad"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ExperienciaVendedorController_create3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("experiencia")))
  )
  private[this] lazy val controllers_ExperienciaVendedorController_create3_invoker = createInvoker(
    ExperienciaVendedorController_0.create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ExperienciaVendedorController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """experiencia"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ExperienciaVendedorController_read4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("experiencia")))
  )
  private[this] lazy val controllers_ExperienciaVendedorController_read4_invoker = createInvoker(
    ExperienciaVendedorController_0.read(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ExperienciaVendedorController",
      "read",
      Nil,
      "GET",
      """""",
      this.prefix + """experiencia"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ExperienciaVendedorController_get5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("experiencia/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ExperienciaVendedorController_get5_invoker = createInvoker(
    ExperienciaVendedorController_0.get(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ExperienciaVendedorController",
      "get",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """experiencia/$id<[^/]+>"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_ExperienciaVendedorController_update6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("experiencia/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ExperienciaVendedorController_update6_invoker = createInvoker(
    ExperienciaVendedorController_0.update(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ExperienciaVendedorController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      """""",
      this.prefix + """experiencia/$id<[^/]+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_MuebleController_create7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mueble")))
  )
  private[this] lazy val controllers_MuebleController_create7_invoker = createInvoker(
    MuebleController_1.create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MuebleController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """mueble"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_MuebleController_read8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mueble")))
  )
  private[this] lazy val controllers_MuebleController_read8_invoker = createInvoker(
    MuebleController_1.read(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MuebleController",
      "read",
      Nil,
      "GET",
      """""",
      this.prefix + """mueble"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_4.index())
      }
  
    // @LINE:21
    case controllers_CiudadController_create1_route(params) =>
      call { 
        controllers_CiudadController_create1_invoker.call(CiudadController_3.create())
      }
  
    // @LINE:23
    case controllers_CiudadController_read2_route(params) =>
      call { 
        controllers_CiudadController_read2_invoker.call(CiudadController_3.read())
      }
  
    // @LINE:25
    case controllers_ExperienciaVendedorController_create3_route(params) =>
      call { 
        controllers_ExperienciaVendedorController_create3_invoker.call(ExperienciaVendedorController_0.create())
      }
  
    // @LINE:27
    case controllers_ExperienciaVendedorController_read4_route(params) =>
      call { 
        controllers_ExperienciaVendedorController_read4_invoker.call(ExperienciaVendedorController_0.read())
      }
  
    // @LINE:29
    case controllers_ExperienciaVendedorController_get5_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ExperienciaVendedorController_get5_invoker.call(ExperienciaVendedorController_0.get(id))
      }
  
    // @LINE:31
    case controllers_ExperienciaVendedorController_update6_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ExperienciaVendedorController_update6_invoker.call(ExperienciaVendedorController_0.update(id))
      }
  
    // @LINE:33
    case controllers_MuebleController_create7_route(params) =>
      call { 
        controllers_MuebleController_create7_invoker.call(MuebleController_1.create())
      }
  
    // @LINE:35
    case controllers_MuebleController_read8_route(params) =>
      call { 
        controllers_MuebleController_read8_invoker.call(MuebleController_1.read())
      }
  
    // @LINE:39
    case controllers_Assets_versioned9_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_2.versioned(path, file))
      }
  }
}