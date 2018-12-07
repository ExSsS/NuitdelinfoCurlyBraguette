/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (C) 2018 Curly Braguette (ROMAINPC Killian Dieu Matoz)
 *  * 
 *  * This program is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  * 
 *  * This program is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  * 
 *  * You should have received a copy of the GNU General Public License
 *  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  ******************************************************************************/
package fr.curlybraguette;
	
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainS extends Application{
	
	private static ServerSocket ss;
	private static boolean socketCree = false;
	private static Socket connexion;
	private static Thread thread = null;
	private int clientCount = 0;
	private ChatServerThread clients[] = new ChatServerThread[50];
	
	private static boolean demandeEnCours = false;
	private static Console txtServ;
	
	
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			//Scene de login:
			BorderPane rootLogin = new BorderPane();
			VBox D = new VBox();
			D.setPadding(new Insets(0,0,0,50));
			Scene scene = new Scene(rootLogin, 1280, 720);
			
			txtServ = new Console();
			txtServ.prefWidthProperty().bind(scene.widthProperty().divide(2));
			
		
			rootLogin.setLeft(txtServ);
			rootLogin.setRight(D);
			rootLogin.setBackground(new Background(new BackgroundFill(Color.rgb(50,50,50), null, null)));

			D.prefWidthProperty().bind(scene.widthProperty().divide(2));
			
			//test
			//D.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			D.setSpacing(10);
			
			Button Cserv = new Button("Créer Serveur");
			D.getChildren().addAll(Cserv);
			D.setAlignment(Pos.CENTER_LEFT);
			
			Label noServ = new Label("ERREUR PAS DE SERVEUR");
			D.getChildren().addAll(noServ);
			noServ.setId("warning");
			noServ.setVisible(false);
			
			Label id = new Label("ID Serveur : XXXX.XXXX.XXXX.XXXX");
			D.getChildren().addAll(id);
			id.setId("indicator");
			id.setVisible(false);
			
			Label port = new Label("Port Serveur : XX");
			D.getChildren().addAll(port);
			port.setId("indicator");
			port.setVisible(false);
			
			Button dServ = new Button("Demande de connection");
			D.getChildren().addAll(dServ);
			dServ.setVisible(false);
			

			
			
			Cserv.setOnAction((ActionEvent e)-> {
				txtServ.afficher("Serveur créé");
				
				//thread = new Thread(this);
				//thread.start();
				
				
				try {
					
					ss = new ServerSocket(0);
					socketCree = true;
					Cserv.setVisible(false);
					id.setVisible(true);
					
					id.setText("ID Serveur : " + InetAddress.getLocalHost().getHostAddress());
					
					port.setVisible(true);
					port.setText("Port Serveur : " + ss.getLocalPort());
					
					dServ.setVisible(true);
					
					

					
				} catch (Exception e1) {
					noServ.setVisible(true);
					new Timeline (new KeyFrame(Duration.millis(1500), ae -> noServ.setVisible(false))).play();
					e1.printStackTrace();
					txtServ.afficher("problème de port");
				}
				
				
				
				
				
			});
			
			dServ.setOnAction(ae -> {
				txtServ.afficher("Demande de connexion");
				System.out.println("demande de co");
				
				try {
					ss.setSoTimeout(5000);
					
					try {
						
						
						new Handler(ss.accept()).start();
						txtServ.afficher("Connexion de : ");
						
					} catch (IOException e1) {
						System.out.println("pb");
						e1.printStackTrace();
						txtServ.afficher("timeout atteint");
					}
					
					
				} catch (SocketException e1) {
					System.out.println("pb2");
					e1.printStackTrace();
					
				}
				
				
			});
			
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Brag Edit");
			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> {
				if(socketCree) {
					try {
						ss.close();
						//connexion.close();
					} catch (IOException e1) {
						// TODO Bloc catch généré automatiquement
						e1.printStackTrace();
					}
				}
				//thread.stop();
				Platform.exit();
			    
			});
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
/*
	@Override
	public void run() {
		System.out.println("run");
		while (thread != null)
	      { //System.out.println("lalala");
			
			
			
			
			try
	         {  System.out.println("Waiting for a client ..."); 
	         
	         	if(demandeEnCours) {
	         		addThread(ss.accept());
	         		demandeEnCours = false;
	         		}
	            
	         
	         }
	         catch(IOException ioe)
	         {  System.out.println("Server accept error: " + ioe); try {
				stop();
			} catch (Exception e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			} }
			
	      }
		
		
	}
	private void addThread(Socket socket)
	   {  if (clientCount < clients.length)
	      {  System.out.println("Client accepted: " + socket);
	         clients[clientCount] = new ChatServerThread(this, socket);
	         try
	         {  clients[clientCount].open(); 
	            clients[clientCount].start();  
	            clientCount++; }
	         catch(IOException ioe)
	         {  System.out.println("Error opening thread: " + ioe); } }
	      else
	         System.out.println("Client refused: maximum " + clients.length + " reached.");
	   }
	public synchronized void remove(int ID)
	   {  int pos = findClient(ID);
	      if (pos >= 0)
	      {  ChatServerThread toTerminate = clients[pos];
	         System.out.println("Removing client thread " + ID + " at " + pos);
	         if (pos < clientCount-1)
	            for (int i = pos+1; i < clientCount; i++)
	               clients[i-1] = clients[i];
	         clientCount--;
	         try
	         {  toTerminate.close(); }
	         catch(IOException ioe)
	         {  System.out.println("Error closing thread: " + ioe); }
	         toTerminate.stop(); }
	   }
	private int findClient(int ID)
	   {  for (int i = 0; i < clientCount; i++)
	         if (clients[i].getID() == ID)
	            return i;
	      return -1;
	   }
	public synchronized void handle(int ID, String input)
	   {  
	      
	         for (int i = 0; i < clientCount; i++) {
	            clients[i].send(ID + ": " + input);   
	            txtServ.afficher(ID + ": " + input);
	         }
	   }*/
	public static Console getCons() {
		return txtServ;
	}
}
