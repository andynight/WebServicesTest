package clientes;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.mongodb.util.JSON;
import com.sun.jersey.api.JResponseAsResponse;



public class HTTPClient{
	
	//campo que contendra el string del json que se lee
private String respuesta;

/**
 * Obtiene la respuesta del servicio a la solicitud de la URL
 * @return String
 */
public String getRespuesta() {
	return respuesta;
}


public void traer()
{
	JsonObject jo;
	JsonReader jr;
	try {
		/**
		 * Url del servicio que desea utilizar
		 */
		URL url = new URL(
				"http://localhost:8080/rutasBuses/apirutas/ubicacion/envioWilson");
		String input =""; 			
		
		
		 /**
		  * Json que se construye para enviar
		  */
	     JsonObject Entrada = Json.createObjectBuilder()
	    		 
	    		         .add("placa", "ZOE 101")	
	    		         .add("coordenada",Json.createObjectBuilder()
	    		         
			    		 .add("latitud", 7.3431231443)
					     .add("longitud", 67.4567864324))
	    	     
	    	     .build();
	     
	     
			input= Entrada.toString();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
					if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

	 BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	 jr = Json.createReader(conn.getInputStream());
	 jo = jr.readObject();
	 
	 /*
	  * String de la respuesta del servidor
	  */
	    respuesta=jo.toString();
		String output1;
		System.out.println("Output from Server .... \n");
		System.out.println(respuesta);
		conn.disconnect();

	} catch (MalformedURLException e) {

		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();

	}
	
}
	
}
