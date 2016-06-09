package rutasBuses;

import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("/ubicacion")
public class UbicacionBus {

	private static String promedio;

	private LecturaJson leer;
	private Extractor coorExtractor;

	@Path("/promedio10")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String promedio10(InputStream incomingData) {

		leer = new LecturaJson(incomingData);
		coorExtractor = new Extractor(leer.getLectura());
		CapturaCoor Guardar = CapturaCoor.getCapturaCoor();
		Guardar.addToColeccion(coorExtractor.getCoor().get(0));
		int cantidad;
		cantidad = Guardar.getCoorToAverage().size();

		if (cantidad == 10) {
			double sumaLat = 0;
			double sumaLong = 0;
			double promLat;
			double promLong;

			for (Coordenadas t : Guardar.getCoorToAverage()) {
				sumaLat = sumaLat + t.getLatitud();
				sumaLong = sumaLong + t.getLongitud();
			}
			promLat = sumaLat / cantidad;
			promLong = sumaLong / cantidad;

			CapturaCoor.resetColeccion();

			System.out.println(promLat);
			System.out.println(promLong);

			promedio = "{ \"coordenada1\":{" + " \"latitud\": \"" + promLat + "\"," + " \"longitud\":\"" + promLong
					+ "\"" + "}}";

			promLat = 0;
			promLong = 0;
		}

		return promedio;
	}

	public static String getPromedio() {
		return promedio;
	}
}
