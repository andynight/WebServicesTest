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
public class Enviar {
	
    private boolean status;
    private static int step;
    private long idHilo ;
    private boolean estado;
    
    
    @Path("/posicion")
	@GET
	@Produces("application/json")
	public  Response asda() {
    	
    	iniciar();    	
    	int numero = step;
		String result = "{"
				+ "\"Ciclos\": \""+ numero +"\" }";
		return Response.status(200).entity(result).build();
	}
    

     public void iniciar()
    {
    	 status = true;
    	 Hilo hilo = Hilo.getHilo(this);
    	 
    	
    
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
	
	
    
  }
