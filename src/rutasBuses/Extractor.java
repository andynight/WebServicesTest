package rutasBuses;

import java.util.ArrayList;

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

	public Extractor(String stringToObject) {
		
		salida = new ArrayList<>();
		extraerCoordenadas(stringToObject);
	}

	/**
	 * Este método se encarga de extraer unicamente coordenadas en Json
	 * que han sido enviadas con un formato especifico en el que varia el 
	 * subíndice de la coordenada.
	 * ejemplo de formato : coordenada1 , coordenada2 , ... , coordenadan
	 * 
	 * 
	 * @param t
	 */
	public void extraerCoordenadas(String t) {
		JSONObject coordenada;
			
		jsonToObject = new JSONObject(t);
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

		

	}
    /**
     * Devuelve un arreglo de coordenadas obtenido mediante post.
     * @return salida Arreglo de coordenadas
     */
	public ArrayList<Coordenadas> getCoor() {
		return salida;
	}
}
