package enviarCoordenadas;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.catalina.ant.StopTask;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import rutasBuses.Coordenadas;
import rutasBuses.UbicacionBus;
@Path("/Enviar")
public class EnvioCoor {
	
    private MediadorHE r;
    private Coordenadas c;
    
    @Path("/posicion")
	@GET
	@Produces("application/json")
	public  Response asda() {
    	r = new MediadorHE();
        c = new Coordenadas();
        double longpartida=-73.1049097579193;
        double latpartida=7.0704193901191745;
    	r.iniciar(); 
    	Fecha f = new Fecha();
    	double numero = ((double)r.getStep())/1000;
    	c.setLatitud(latpartida+numero);
    	c.setLongitud(longpartida+numero);
    	
    	JSONObject coordenada = new JSONObject();
    	coordenada.put("latitud", c.getLatitud());
    	coordenada.put("longitud",c.getLongitud());
    	JSONObject main = new JSONObject();
    	main.put("Ruta", "Ruta1");
    	main.put("Buses", "2");
    	main.put("Tiempo", f.getFecha());
    	main.put("id", "P10XYZ325");
    	main.put("Coordenada",coordenada);
	    /*String result = "{"
					+" \"Ruta\":\"Ruta1\", "
					+" \"Buses\":\"2\", "
					+" \"Tiempo\":\""+f.getFecha()+"\","
					+" \"id\":\"P10XYZ325\","
					+" \"Coordenada\":{\"latitud\":"+"\""+c.getLatitud()+"\",\"longitud\":"+"\""+c.getLongitud()+"\"}"
					+ "}";*/
		return Response.status(200).entity(main.toString()).build();
	}
    
    @Path("/WilsonPosi")
   	@GET
   	@Produces("application/json")
   	public  Response wilson() {
       	       
   		String result = UbicacionBus.getPromedio();
   		return Response.status(200).entity(result).build();
   	}

    
  }