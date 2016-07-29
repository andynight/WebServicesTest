package clasesDeUtilidad;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class ConectarMongo {

	public ConectarMongo() {

		try {
			MongoClient mongo = new MongoClient();
			mongo.getAddress();
			printDatabases(mongo);
		} catch (UnknownHostException UKHe) {

			System.out.println("Error: Base de datos desconocida");
		} catch (MongoException Me) {
			System.out.println("Error: No se puede tener acceso a la base de datos");
		}catch (NullPointerException e) {
			System.out.println("Error: No se pudo mostrar todas las bases de datos");
		}
				

	}

	/**
	 * Clase que imprime por pantalla todas las bases de datos MongoDB.
	 * 
	 * @param mongo
	 *            conexión a MongoDB
	 */
	private static void printDatabases(MongoClient mongo) {
		List<String> dbs = mongo.getDatabaseNames();
		for (String db : dbs) {
			System.out.println(" - " + db);
		}
	}

}
