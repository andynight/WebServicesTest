package enviarCoordenadas;

public class Hilo extends Thread {

	private  Enviar e;
	private static  Hilo h;

	

	private Hilo(Enviar e) {
		super("Coor");
		this.e = e;
		this.start();

	}

	public static Hilo getHilo(Enviar e) {
		if(h == null){
			h = new Hilo(e);
		}
		return h;
		
	}

	public void run() {
		while (e.getStatus()) {
			e.step();
			pause();
		}
	}

	private void pause() {
		try {
			Thread.sleep(1000); // pause for 300 milliseconds
		} catch (InterruptedException exc) {
		}
	}

}
