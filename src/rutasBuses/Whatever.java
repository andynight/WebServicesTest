package rutasBuses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.json.JSONObject; 
import javax.ws.rs.core.Response;

@Path("/patricio")
public class Whatever {
	
	public Whatever(){}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	public String g()
	{
		return "{"
				+ "nombre: \" Carlos Andrés \","
				+ "apellido: \"Pereira\""
				+ "}";
	}
	

}
