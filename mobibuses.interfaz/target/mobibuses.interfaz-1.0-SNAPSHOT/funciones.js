/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//public/prueba.js
 function prueba()
    {
        
         var mapa="";
                
                $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                    verRutasTranvia(data);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
    }
    
   
   
     function crearMapaMobibusesBono(data,coor1,coor2)
    {
          var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 11    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                
      
   
    
                marcarMobibusesBon(map,data,coor1,coor2);
    }
   
    
    function crearMapaMobibuses(data)
    {
          var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 11    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                
      
   
    
                marcarMobibuses(map,data);
    }
    
    
    function verMobibusesMasCercanoUsuario(){
        
          if (navigator.geolocation) {
         //pongo en el parametro el nombre que quiera utilizar 
        navigator.geolocation.getCurrentPosition(ubicacion);
        
          }
        
    }
    
    
    function marcarMobibuses(map,data)
    {
        
        $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              
               var imagen="" ;
              var contenido="";
              
    
          
             contenido=value.nombre;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        

      zIndex: index
      
    });
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
        
        
    }
    
    
    
     
    function marcarMobibusesBon(map,data , coor1, coor2)
    {
                 
       var marker = new google.maps.Marker({
      position: {lat: coor1, lng: coor2},
      map: map,
    
      shape:shapes,
     
   
      
    });
    

  
        
        
        
        
        
        
        
        
        
        
        
        
        $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              
               var imagen="" ;
              var contenido="";
              
    
          
             contenido=value.nombre;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        

      zIndex: index
      
    });
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
        
        
    }
    
    
    function verMobibuses()
    {
        
        $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibuses',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    crearMapaMobibuses(data);
                    
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
        
        
        
        
    }
    
    function direccion( coo1,coo2 , coo3,coo4) {
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var directionsService = new google.maps.DirectionsService;
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 14,
       center: {lat: coo1, lng: coo2}
  });
  directionsDisplay.setMap(map);

  calculateAndDisplayRoute(directionsService, directionsDisplay,coo1,coo2,coo3,coo4);
  
}

function posicionActual()
{
    
     if (navigator.geolocation) {
         //pongo en el parametro el nombre que quiera utilizar 
        navigator.geolocation.getCurrentPosition(ubicacion);
    } 
    
}

function ubicacion(coordenadas)
{
   
     var latitud = coordenadas.coords.latitude;
     var longitud=coordenadas.coords.longitude;
     
     busquedaMasCercano(latitud,longitud);
     
     //llamar al metodo que quiera con estas variables 
    
}

    
    function verRutasTranvia(data) {
        
        
    
      
        
                var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 13    ,
                  center: {lat: 4.598889 , lng:  -74.080833}
                });
                
                var flightPlanCoordinates = [
    {lat: 4.43, lng: -74.068},
    {lat: 4.84, lng: -74.068}
    
  ];
  var flightPlanCoordinates2 = [
    {lat: 4.63, lng: -74.001},
    {lat: 4.63, lng: -74.214}
    
  ];
  var flightPlanCoordinates3 = [
    {lat: 4.69, lng: -74.001},
    {lat: 4.69, lng: -74.214}
    
  ];
  var flightPath = new google.maps.Polyline({
    path: flightPlanCoordinates,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });
    var flightPath3 = new google.maps.Polyline({
    path: flightPlanCoordinates3,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });
  var flightPath2 = new google.maps.Polyline({
    path: flightPlanCoordinates2,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });

  flightPath.setMap(map);
  flightPath2.setMap(map);
  flightPath3.setMap(map);
      
   
    
                setMarkers(map,data);
        
  
}

// Data for the markers consisting of a name, a LatLng and a zIndex for the
// order in which these markers should display on top of each other.
var beaches = null ;

var shapes = {
    coords: [1, 1, 1, 20, 18, 20, 18, 1],
    type: 'poly'
  };
  
  
  function busquedaMasCercanoBon(coordenada1,coordenada2)
  {
      $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibusesBon/'+coordenada1+"/"+coordenada2,
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                   crearMapaMobibusesBono(data,coordenada1,coordenada2);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
      
      
      
  }
  
  function busquedaMasCercano(coordenada1,coordenada2)
  {
      
      
      
       $.ajax({
                    url: '../mobibuses.servicios/webresources/mobibus/mobibuses/'+coordenada1+"/"+coordenada2,
                    type : "GET",
                    
                    
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                          
                          var latitud=data.posicionLatitud;
                          var longitud = data.posicionLongitud;
                          
                          direccion(coordenada1,coordenada2,latitud,longitud);
                          
                          
                      
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
      
      
      
  }
  function acercarEmergencia(coor1,coor2)
  {
     
                $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias',
                    type : "GET",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   
                    
                    acercarEmergencia2(coor1,coor2,data);
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
        
  }
  
  function acercarEmergencia2(coor1,coor2,data)
  {
     var map = new google.maps.Map(document.getElementById('map'), {
                  zoom: 15    ,
                  center: {lat: coor1 , lng:  coor2}
                });
                
                
      
   
    
                setMarkers(map,data);
  }
  
function setMarkers(map,data) {
 
  // Shapes define the clickable region of the icon. The type defines an HTML
  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
  // The final coordinate closes the poly by connecting to the first coordinate.
  
  
   document.getElementById('directionsPanel').innerHTML=" <h2><strong> <font color=\"white\">Tranvias en estado de emergencia </font>  </strong> </h2>";
    
  
   $.each(data, function(index,value){
          var latitud= value.posicionLatitud;
              var longitud=value.posicionLongitud;
              var nivelChoque=value.nivelChoque;
              var nivelPanico=value.nivelPanico;
              var nivelTemperatura=value.nivelTemparatura;
               var imagen="" ;
              var contenido="";
                
              
          if(nivelChoque>2 || nivelPanico>2 || nivelTemperatura>2)
          {
               imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=caution|#00FFBF";
               contenido="el vehiculo "+value.nombre+" se encuentra en estado de emergencia"+"<p>"+"<button name=\"busquedaMasCercano\" id=\"busquedaMasCercano\" onclick=\"busquedaMasCercano("+latitud+","+longitud+"); return false;\"> Buscar bus mas cercano </button>";
               contenido+="<p> <button name=\"busquedaMasCercanoBon\" id=\"busquedaMasCercanoBon\" onclick=\"busquedaMasCercanoBon("+latitud+","+longitud+"); return false;\"> Buscar 3 buses mas cercano </button>";
           document.getElementById('directionsPanel').innerHTML+="<input type=image src=\"images/lupa.png\" name=\"acercarEmergencia\" id=\"acercarEmergencia\" onclick=\"acercarEmergencia("+latitud+","+longitud+"); return false;\">  ";
          
           document.getElementById('directionsPanel').innerHTML+="<font color=\"white\" >" +  value.nombre  + "   </font> <p>" ;
               }
          else
          {
             contenido="Nombre Tranvia: "+value.nombre+"<p>";
             contenido+="Conducido por: " + value.nombreConductor;
             contenido+="Kilomatros desde ultima revicion: "+value.kilometraje;
             imagen="http://chart.apis.google.com/chart?chst=d_map_pin_icon&chld=bus|FFFF00";
          }
              
              
       var marker = new google.maps.Marker({
      position: {lat: latitud, lng: longitud},
      map: map,
      title: value.nombre,
      shape:shapes,
     
      icon:imagen,
        panel: document.getElementById('directionsPanel'),

      zIndex: index
      
    });
    
    
    
     
    
    var infowindow = new google.maps.InfoWindow({
    content:contenido 
        });
  
  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });
       
   });
  
 
}

function generarReporte()
{
    
    
       $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias/generarReportes',
                    type : "GET",
                    
                    
                  
                    dataType: 'text'
                }).done(function(data) {
                    
                   
                    
                          
                          var latitud=data;
                          var rta="<font color=\"white\"> <h2> Reporte </h2> </font> ";
                          rta+=data;
                  
                           document.getElementById("reporte").innerHTML=rta;
                         
                     
                          
                          
                          
                          
                      
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
    
    
    
    
}

function calculateAndDisplayRoute(directionsService, directionsDisplay , lat1,ing1,lat2,ing2) {
  var selectedMode = "DRIVING";
  var latitud1=lat1;
   var longitud1=ing1;
   var latitud2=lat2;
    var longitud2=ing2;
  directionsService.route({
    origin: {lat: lat1, lng: ing1},  // Haight.
    destination: {lat: lat2, lng: ing2},  // Ocean Beach.

    // Note that Javascript allows us to access the constant
    // using square brackets and a string value as its
    // "property."
    travelMode: google.maps.TravelMode[selectedMode]
  }, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    } else {
      window.alert('Directions request failed due to ' + status);
    }
  });
}

function cambiarEstadoTranvia()
{
    var identificador=document.getElementById('nombreTranvia').value;
    var emer=document.getElementById('emergenciaTranvia').value;
    var numero=document.getElementById('valorTranvia').value;
    
     $.ajax({
                    url: '../mobibuses.servicios/webresources/Tranvia/tranvias/cambiar/'+identificador+"/"+emer+"/"+numero,
                    type : "PUT",
                  
                    contentType: 'application/json',
                }).done(function(data) {
                    
                   var x =emer;
                    
                    verRutasTranvia();
                   
                 
                    
                
                    console.log(data);
                }, this).error(function(data) {
                    alert(data);
                }, this);
}


function handleLocationError(browserHasGeolocation, infoWindow, pos) {
  infoWindow.setPosition(pos);
  infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
}
    

   
    
   