package enviarCoordenadas;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.catalina.ant.StopTask;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/Enviar")
public class EnvioCoor {
	
    private MediadorHE r;
    
    
    @Path("/posicion")
	@GET
	@Produces("application/json")
	public  Response asda() {
    	r = new MediadorHE();
    	r.iniciar(); 
    	int numero = r.getStep();
		String result = "{"
				+ "\"Ciclos\": \""+ numero +"\" }";
		return Response.status(200).entity(result).build();
	}
    

    
  }
