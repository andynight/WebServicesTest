package clasesDelBRT;

import clasesDeUtilidad.ConectarMongo;

import javax.json.Json;
import javax.json.JsonObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class Bus {
	// Datos del bus
	private String placa;
	private int capacidad;
	private String tipoBus;
	private boolean estado;
	private Coordenadas coor;
	// Conexion con la base de datos
	private ConectarMongo mongo;
	private DBCursor datos;
	//Objetos de json
	private JsonObject JsonDatos;

	public Bus(String placa , Coordenadas coor){
		
		this.placa = placa;
		this.coor = coor;
		actualizarJsonBus();
		
		
					
	}
	public void actualizarJsonBus()
	{
		mongo = new ConectarMongo();
		datos = mongo.consultarMDB("GeneralBRT", "Bus", new BasicDBObject("Placa",placa));
		double castInt =(double) datos.next().get("Capacidad");
		capacidad = (int) castInt;
		tipoBus =(String) datos.curr().get("TipoBus");
		estado = (boolean) datos.curr().get("Estado");
		JsonDatos = Json.createObjectBuilder().add("Placa", this.placa)
				.add("Coordenada" , 
						Json.createObjectBuilder()
						.add("latitud", coor.getLatitud())
						.add("longitud", coor.getLongitud()))
				.add("Capacidad", capacidad)
				.add("TipoBus", tipoBus)
				.add("Estado", estado).build();
		mongo.cerrarConexion();
	}
	
	public JsonObject getJsonBus(){
		
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
