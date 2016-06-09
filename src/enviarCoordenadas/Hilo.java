	package enviarCoordenadas;

public class Hilo extends Thread {

	private  MediadorHE m;
	private static  Hilo h;

	

	private Hilo(MediadorHE m) {
		super("Coor");
		this.m = m;
		this.start();

	}

	public static Hilo getHilo(MediadorHE m) {
		if(h == null){
			h = new Hilo(m);
		}
		return h;
		
	}

	public void run() {
		while (m.getStatus()) {
			m.step();
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
