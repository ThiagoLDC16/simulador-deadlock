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
			Print.colored("[T" + t.id + "] Bloqueou o recurso " + nome, "CYAN");
			return true;
		}
		if (t.timestamp > lockTransaction.timestamp) {
			Print.colored("[T" + t.id + "] Abortando transação", "RED");
			return false;
		}
		Print.colored("[T" + t.id + "] Aguardando recurso " + nome, "YELLOW");
		while (lockTransaction != null) {
			Thread.sleep(10);
		}
		lockTransaction = t;
		Print.colored("[T" + t.id + "] Bloqueou o recurso " + nome, "CYAN");
		return true;
	}

	public boolean unlock(Transacao t) {
		if (this.lockTransaction == t) {
			Print.colored("[T" + t.id + "] Desbloqueou o recurso " + nome, "GREEN");
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
