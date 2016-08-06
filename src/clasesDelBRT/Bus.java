package clasesDelBRT;

import clasesDeUtilidad.ConectarMongo;

import javax.json.Json;
import javax.json.JsonObject;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class Bus {
	// Datos del bus
	private String placa;
	private int capacidad;
	private String tipoBus;
	private boolean estado;
	private Coordenadas coor;
	// Conexion con la base de datos
	private ConectarMongo mongo;
	private DBObject datos;
	//Objetos de json
	private JsonObject JsonDatos;

	public Bus(String placa , Coordenadas coor){
		
		this.placa = placa;
		this.coor = coor;
		//valores default en caso de pedir el JSON sin la existencia del objeto en la BD
		this.tipoBus="";
		this.capacidad=0;
		this.estado=false;
		actualizarBusDesdeBD();
	}
	
	public void actualizarBusDesdeBD()
	{
		mongo = new ConectarMongo();
		datos = mongo.consultarMDB("GeneralBRT", "Bus", new BasicDBObject("Placa",placa));
		if (datos != null)
		{
			double castInt =(double) datos.get("Capacidad");
			capacidad = (int) castInt;
			tipoBus = (String) datos.get("TipoBus");
			estado = (boolean) datos.get("Estado");
		}
		else
		{
			System.out.println("No existe ese objeto"); //quedan valores por defecto
		}
		mongo.cerrarConexion();
	}
	
	public void actualizarJSON()
	{
		JsonDatos = Json.createObjectBuilder().add("Placa", this.placa)
				.add("Coordenada" , 
						Json.createObjectBuilder()
						.add("latitud", coor.getLatitud())
						.add("longitud", coor.getLongitud()))
				.add("Capacidad", capacidad)
				.add("TipoBus", tipoBus)
				.add("Estado", estado).build();
		System.out.println(JsonDatos.toString());
		//mongo.insertarMDB("GeneralBRT","Bus", );
	}
	
	/**
	 * Metodo que crea y devuelve el JSON del objeto Bus
	 * @return JsonObject representacion JSON del bus.
	 */
	public JsonObject getJsonBus(){
		actualizarJSON();
		return JsonDatos;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public Coordenadas getCoor() {
		return coor;
	}

	
	
	

}
