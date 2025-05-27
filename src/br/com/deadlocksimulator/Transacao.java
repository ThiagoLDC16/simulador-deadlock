package br.com.deadlocksimulator;

public class Transacao extends Thread {

	protected static int CURRENT_ID = 0;

	public final int id;
	public final long timestamp = System.currentTimeMillis();

	public Recurso x;
	public Recurso y;

	public Transacao(Recurso x, Recurso y) {
		this.id = ++Transacao.CURRENT_ID;
		this.x = x;
		this.y = y;
	}

	public Transacao(int id, Recurso x, Recurso y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		try {
			Print.colored("[T" + this.id + "] Iniciando...", "WHITE");
			this.randomSleep();
			if (!x.lock(this)) {
				abortAndRestart();
				return;
			}
			this.randomSleep();
			int read_x = x.read();
			if (!y.lock(this)) {
				abortAndRestart();
				return;
			}
			int read_y = y.read();
			x.write(read_x + 6);
			y.write(read_y + 5);
			x.unlock(this);
			y.unlock(this);
			Print.colored("[T" + this.id + "] Finalizou", "PURPLE");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void abortAndRestart() {
		new Transacao(this.id, x, y).start();
	}
	
	private void randomSleep() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
	}

}
