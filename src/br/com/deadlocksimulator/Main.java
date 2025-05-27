package br.com.deadlocksimulator;

public class Main {

	public static void main(String[] args) {
		int N_THREADS = 20;
		Recurso x = new Recurso("X", 0);
		Recurso y = new Recurso("Y", 0);
		
		for(int i = 0; i < N_THREADS; i++) {
			new Transacao(x, y).start();
		}
	}
}
