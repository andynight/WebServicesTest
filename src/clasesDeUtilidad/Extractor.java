package clasesDeUtilidad;

import java.util.ArrayList;

//Import de paquetes de la aplicaci�n
import clasesDelBRT.*;


import org.json.JSONObject;

/**
 * Esta clase se encarga de convertir las lecturas de Json en objetos de Java.
 * 
 * @author Carlos Pereira
 *
 */
public class Extractor {

	private JSONObject jsonToObject;
	private String[] nombres;
	private ArrayList<Coordenadas> salida;

	public Extractor() {
	}

	/**
	 * Este m�todo se encarga de extraer unicamente coordenadas en Json que han
	 * sido enviadas con un formato especifico en el que varia el sub�ndice de
	 * la coordenada. ejemplo de formato : coordenada1 , coordenada2 , ... ,
	 * coordenadan
	 * 
	 * 
	 * @param stringToObject
	 */
	public ArrayList<Coordenadas> extraerCoordenadas(String stringToObject) {
		salida = new ArrayList<>();

		JSONObject coordenada;

		jsonToObject = new JSONObject(stringToObject);
		nombres = JSONObject.getNames(jsonToObject);
		int size = nombres.length;
		int temp = 1;
		while (temp <= size) {

			coordenada = jsonToObject.getJSONObject("coordenada" + temp);
			Coordenadas C1 = new Coordenadas();
			C1.setLatitud(coordenada.getDouble("latitud"));
			C1.setLongitud(coordenada.getDouble("longitud"));

			salida.add(C1);
			temp++;

		}

		return salida;

	}

	public Recorrido extractRecorrido(String stringToObject) {

		JSONObject coordenada;
		jsonToObject = new JSONObject(stringToObject);
		nombres = JSONObject.getNames(jsonToObject);
		String idRec = jsonToObject.getString("idBus");
		coordenada = jsonToObject.getJSONObject("coordenada");
		Coordenadas C1 = new Coordenadas();
		C1.setLatitud(coordenada.getDouble("latitud"));
		C1.setLongitud(coordenada.getDouble("longitud"));
		Tiempo hEnvio = new Tiempo(jsonToObject.getLong("hora"));
		Recorrido extractRec = new Recorrido(idRec, C1, hEnvio );
		return extractRec;

	}

}