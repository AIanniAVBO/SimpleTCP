package avbo.socketexample.parallel;

import java.io.*;
import java.net.*;
import avbo.socketexample.SimpleServer;

public class SimpleParallelServer extends SimpleServer {
	private Socket client;

	public SimpleParallelServer(int port) {
		super(port);
	}

	@Override
	public void runServer() {
		while (true) {
			try {
				// Il server resta in attesa di una richiesta
				System.out.println("Server in attesa di richieste...");
				client = getServer().accept();
				System.out.println("Un client si e' connesso...");
				ParallelServer pServer = new ParallelServer(client);
				Thread t = new Thread(pServer);
				t.start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		SimpleParallelServer ss = new SimpleParallelServer(7777);
		ss.runServer();
	}
}
