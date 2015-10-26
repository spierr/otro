
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/scvalencia606/Documents/University/SchoolWork/Teaching/ISIS2503/labs/lab02/mueblesdelosalpes/conf/routes
// @DATE:Mon Aug 10 08:21:39 COT 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMuebleController MuebleController = new controllers.ReverseMuebleController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCiudadController CiudadController = new controllers.ReverseCiudadController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseExperienciaVendedorController ExperienciaVendedorController = new controllers.ReverseExperienciaVendedorController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMuebleController MuebleController = new controllers.javascript.ReverseMuebleController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCiudadController CiudadController = new controllers.javascript.ReverseCiudadController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseExperienciaVendedorController ExperienciaVendedorController = new controllers.javascript.ReverseExperienciaVendedorController(RoutesPrefix.byNamePrefix());
  }

}
