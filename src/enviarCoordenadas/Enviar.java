package enviarCoordenadas;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/Enviar")
public class Enviar {
	
    private boolean status;
    private Hilo hilo;
    private int step;
    
    

     public void iniciar()
    {
    	step=0;
    	status = true;
    	hilo = new Hilo(this);
    	hilo.start();
    }
    
    public void step()
    {
    	step++;
    	System.out.println(step + "ejecucion");
    	//aca se ejecuta lo del hilo
    }
	
	public boolean getStatus()
	{
	return status;	
	}
	
	private void detener()
	   {
	       status = false;
	   }
	
	@Path("/posicion")
	@GET
	@Produces("application/json")
	public Response asda() {
		iniciar();
		String result = "{"
				+ "\"Ciclos\": \""+ step +"\" }";
		return Response.status(200).entity(result).build();
	}
    
  }
