package clasesDeUtilidad;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class BusDB {
	
	private BasicDBObject placa;
	private int capacidad;
	private String tipoBus;
	private boolean estado;
	private String nombreBaseDatos;
	private String nombreColeccion;
	private ConectarMongo mongo;
	private DBObject datos;
	
	public BusDB(String nombreBaseDatos,String nombreColeccion,BasicDBObject placa)
	{
		this.nombreBaseDatos=nombreBaseDatos;
		this.nombreColeccion=nombreColeccion;
		this.placa = placa;
	}

	public void consulta()
	{
		mongo = new ConectarMongo();
		datos = mongo.consultarMDB(nombreBaseDatos,nombreColeccion,placa);
		double castInt =(double) datos.get("Capacidad");
		capacidad = (int) castInt;
		tipoBus = (String) datos.get("TipoBus");
		estado = (boolean) datos.get("Estado");
	}
}
