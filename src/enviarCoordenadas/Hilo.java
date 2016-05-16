package enviarCoordenadas;

public class Hilo extends Thread {

	private Enviar e;
	public Hilo(Enviar e)
	{
		super();
		this.e=e;
	}
	
	public void run()
    {
        while (e.getStatus()) {
            e.step();
            pause();
        }
    }
    
    private void pause()
    {
        try {
            Thread.sleep(1000);   // pause for 300 milliseconds
        }
        catch (InterruptedException exc) {
        }
    }
	
  
}
