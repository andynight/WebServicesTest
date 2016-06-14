package rutasBuses;

public class Bus {
	
	private String idBus;
	private Coordenadas coor;

	public Bus(String idBus , Coordenadas coor){
		
		this.idBus = idBus;
		this.coor = coor;
			
	}

	public String getIdBus() {
		return idBus;
	}

	public Coordenadas getCoor() {
		return coor;
	}
	
}
