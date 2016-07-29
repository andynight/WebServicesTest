package serviciosGET;

import clasesDeUtilidad.ConectarMongo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/Mongo")
public class Dbtest {

	ConectarMongo d ;
	@Path("/TestMG")
	@GET
	@Produces("application/json")
	public void probarMongo(){
		
		d = new ConectarMongo();		
	}
}
