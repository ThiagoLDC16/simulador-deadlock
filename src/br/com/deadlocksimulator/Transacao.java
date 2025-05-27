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
		this.id = ++Transacao.CURRENT_ID;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		try {
			System.out.println("[T" + this.id + "] Iniciando...");
			if (!x.lock(this)) {
				abortAndRestart();
				return;
			}
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

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void abortAndRestart() {
		System.out.println("[T" + this.id + "] Abortando...");
		new Transacao(this.id, x, y).start();
	}

}
