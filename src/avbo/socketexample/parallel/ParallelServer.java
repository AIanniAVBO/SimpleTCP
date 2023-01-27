package avbo.socketexample.parallel;

import java.io.*;
import java.net.*;

public class ParallelServer implements Runnable {
	private Socket client;

	public ParallelServer(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			// Ricava lo stream di output associate al socket
			// e definisce una classe wrapper di tipo
			// BufferedWriter per semplificare le operazioni
			// di scrittura
			OutputStream s1out = client.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out));

			// Il server invia la risposta al client
			bw.write("Benvenuto sul server!n");

			// Chiude lo stream di output e la connessione
			bw.close();
			client.close();
			System.out.println("Chiusura connessione effettuata");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}