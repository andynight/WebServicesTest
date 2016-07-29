/**
 /**
 * Clase encargada de obtener la posicion promedio de un bus
 */

package serviciosPOST;

//Import de paquetes de la aplicación
import clasesDeUtilidad.*;
import clasesDelBRT.*;

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
	
	private static String BusProm;
	private static JsonObject BusCoorProm;
    private static double sumaLat,sumaLong;
    private static int cantidad,incremento;
    private static String placa;
	private LecturaJson leer;
	private Extractor coorExtractor;
	private Bus BusObtenido;
    
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
		BusObtenido = coorExtractor.extractBus(leer.getLectura());
		incremento++;
		cantidad=10;
        sumaLat = BusObtenido.getCoor().getLatitud()+sumaLat;
        sumaLong = BusObtenido.getCoor().getLongitud()+sumaLong;
       
		if (incremento == 10) {
			double promLat;
			double promLong;

			
			promLat = sumaLat / cantidad;
			promLong = sumaLong / cantidad;


			System.out.println(promLat);
			System.out.println(promLong);
			BusObtenido.getCoor().setLatitud(promLat);
			BusObtenido.getCoor().setLongitud(promLong);
			BusObtenido.actualizarJsonBus();
			BusCoorProm = BusObtenido.getJsonBus();
			BusProm=BusCoorProm.toString();
			promLat = 0;
			promLong = 0;
			sumaLong=0;
			sumaLat=0;
			incremento=0;
			return BusProm;
		}

		return null;
	}
	
	
    /**
     * Devuelve la posicion promedio actual
     * @return promedio
     */
	public static String getBusProm() {
		return BusProm;
	}
}