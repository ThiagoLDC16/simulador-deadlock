package br.com.deadlocksimulator;

public class Recurso {

	public final String nome;
	public int valor;
	private Transacao lockTransaction = null;

	public Recurso(String nome, int valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public boolean lock(Transacao t) throws InterruptedException {
		if (lockTransaction == null) {
			lockTransaction = t;
			System.out.println("[T" + t.id + "] Bloqueou o recurso " + nome);
			return true;
		}
		if (t.timestamp < lockTransaction.timestamp) {

		}
		System.out.println("[T" + t.id + "] Aguardando recurso " + nome);
		while (lockTransaction != null) {
			Thread.sleep(10);
		}
		lockTransaction = t;
		System.out.println("[T" + t.id + "] Bloqueou o recurso " + nome);
		return true;
	}

	public boolean unlock(Transacao t) {
		if (this.lockTransaction == t) {
			System.out.println("[T" + t.id + "] Desbloqueou o recurso " + nome);
			this.lockTransaction = null;
			return true;
		}
		return false;
	}

	public int read() {
		return this.valor;
	}

	public void write(int valor) {
		this.valor = valor;
	}
}
