package enviarCoordenadas;

public class MediadorHE {

	private boolean status;
    private static int step;
    private long idHilo ;
    private boolean estado;
	
	 public void iniciar()
	    {
	    	 status = true;
	    	 Hilo hilo = Hilo.getHilo(this);
	    }
	    
	    public void step()
	    {
	    	step++;
	    	System.out.println(step + "ejecucion");
	    	//aca se ejecuta lo del hilo
	    }
		
		public boolean getStatus()
		{
		return status;	
		}
		
		private void detener()
		{
		       status = false;
		}
		
		public int getStep()
		{
			return step;
		}
		
		
}
