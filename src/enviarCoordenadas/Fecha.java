package enviarCoordenadas;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Fecha {

	private String fecha;
	
	public Fecha()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
		fecha=dateFormat.format(date);
	}
	
	public String getFecha()
	{
		return fecha;
	}
}