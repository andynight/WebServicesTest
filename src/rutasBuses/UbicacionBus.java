/**
 /**
 * Clase encargada de obtener la posicion promedio de un bus
 */

package rutasBuses;

import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import javax.json.*;


@Path("/ubicacion")
public class UbicacionBus {
	private static String Placa;
	private static String TipoBus;
	private static String promedio;
	private static JsonObject jsonProm;
    private static double sumaLat,sumaLong;
    private static int cantidad,incremento;
    private static String idBus;
	private LecturaJson leer;
	private Extractor coorExtractor;
	private Bus busObtenido;
    
	/**
	 * Servicio encargado de recibir los valores mediante post e ir llevando la sumatoria para calcular el
	 * promedio cada 10 valores
	 * @param incomingData Datos de entrada mediante post
	 * @return promedio posicion promedio
	 */
	@Path("/promedio10")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String promedio10(InputStream incomingData) {
		leer = new LecturaJson(incomingData);
		coorExtractor = new Extractor();
		busObtenido = coorExtractor.extractBus(leer.getLectura());
		incremento++;
		cantidad=10;
        sumaLat = busObtenido.getCoor().getLatitud()+sumaLat;
        sumaLong = busObtenido.getCoor().getLongitud()+sumaLong;
        idBus = busObtenido.getIdBus();
        System.out.println(idBus);
		if (incremento == 10) {
			double promLat;
			double promLong;

			
			promLat = sumaLat / cantidad;
			promLong = sumaLong / cantidad;


			System.out.println(promLat);
			System.out.println(promLong);

			jsonProm = Json.createObjectBuilder()
					.add("latitud", promLat)
					.add("longitud", promLong).build();
			promedio=jsonProm.toString();
			promLat = 0;
			promLong = 0;
			sumaLong=0;
			sumaLat=0;
			incremento=0;
			return promedio;
		}

		return null;
	}
	
	
    /**
     * Devuelve la posicion promedio actual
     * @return promedio
     */
	public static String getPromedio() {
		return promedio;
	}
}