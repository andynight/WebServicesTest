package clasesDelBRT;

public class Bus {
	
	private String placa;
	private Conductor conductor;
	private int capacidad;
	private String tipoBus;

	public Bus(String placa){
		
		this.placa = placa;
				
					
	}
	
	

	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getPlaca() {
		return placa;
	}



	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}




}
