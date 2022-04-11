package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChatClientCLI {

	private SimpleChatClient client;
	private boolean isRunning;
	private static final String SHELL_STRING = "Enter message (or exit to quit)> ";
	private Thread loopThread;

	public ChatClientCLI(SimpleChatClient client) {
		this.client = client;
		this.isRunning = false;
	}

	public void loop() throws IOException {
		loopThread = new Thread(new Runnable() {

			@Override
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String message;
				while (client.isConnected()) {
					System.out.print(SHELL_STRING);
					try {
						message = reader.readLine();
						if (message.isBlank())
							continue;
						if (message.equalsIgnoreCase("#exit")) {
							System.out.println("Closing connection.");
							client.closeConnection();
						}
						else if(message.equals("#sendSubmitters")){
							System.out.println("Abed, Sgier");
						}
						else if(message.equals("#sendSubmittersID")){
							System.out.println("206529836, 209114859");
						}
						else if(message.equals("#echoHello")){
							System.out.println("Hello World!");
						}
						else {
							client.sendToServer(message);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		loopThread.start();
		this.isRunning = true;

	}

	public void displayMessage(Object message) {

		if (isRunning) {
			System.out.print("(Interrupted)\n");
		}
		System.out.println("Received message from server: " + message.toString());

		String[] help = message.toString().split(" ");
		if (isRunning) {
			System.out.print("(Interrupted)\n");
		}
		System.out.print("Received message from server: ");
		for(int i = 1; i < help.length - 1; i++) {
			System.out.print(help[i] + " ");
		}
		System.out.println(help[help.length-1]);

		if (isRunning)
			System.out.print(SHELL_STRING);
	}

	public void closeConnection() {
		System.out.println("Connection closed.");
		System.exit(0);
	}
}
