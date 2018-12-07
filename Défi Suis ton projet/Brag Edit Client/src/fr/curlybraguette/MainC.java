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
	
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainC extends Application /*implements Runnable*/{
	
	
	private static Socket socket;
	private static boolean socketCree = false;
	
	private Thread thread              = null;
	   private DataInputStream  console   = null;
	   private DataOutputStream streamOut = null;
	  //private ChatClientThread client    = null;
	   
	  
	 private Interface gui; 
	 
	 
	 
	 
	 
	 BufferedReader in;
	    PrintWriter out;

	 
	 
	 
	 
	 
	 
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//scene principale:
			gui = new Interface(1280, 720);
			gui.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Scene de login:
			StackPane rootLogin = new StackPane();
			rootLogin.setBackground(new Background(new BackgroundFill(Color.rgb(50,50,50), null, null)));
			Scene scene = new Scene(rootLogin, 1280, 720);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			VBox loginBox = new VBox();
			//loginBox.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
			loginBox.setSpacing(10);
			
			loginBox.maxHeightProperty().bind(scene.heightProperty().divide(3));
			loginBox.maxWidthProperty().bind(scene.widthProperty().divide(3));
			loginBox.setMinHeight(200);
			loginBox.setMinWidth(500);
			
			
			
			Label indicationsLogin = new Label("Entrez votre pseudo (pas d'espace):");
			TextField entreeLogin = new TextField();
			entreeLogin.prefWidthProperty().bind(loginBox.widthProperty());
			loginBox.getChildren().addAll(indicationsLogin, entreeLogin);
			
			
			Label indicationsIP = new Label("Entrez l'IPv4 du serveur :");
			TextField entreeIP = new TextField();
			entreeIP.prefWidthProperty().bind(loginBox.widthProperty());
			loginBox.getChildren().addAll(indicationsIP, entreeIP);
			
			Label indicationsPort = new Label("Entrez le port du serveur :");
			TextField entreePort = new TextField();
			entreeIP.prefWidthProperty().bind(loginBox.widthProperty());
			loginBox.getChildren().addAll(indicationsPort, entreePort);
			
			
			Button boutonOK = new Button("Connexion");
			loginBox.getChildren().addAll(boutonOK);
			
			loginBox.setAlignment(Pos.CENTER);
			
			
			
			Label saisie = new Label("!!! Problème saisie ou serveur !!!");
			saisie.setId("saisieBMC");
			loginBox.getChildren().add(saisie);
			saisie.setVisible(false);
			
			
			rootLogin.getChildren().addAll(loginBox);
			
			boutonOK.setOnAction((ActionEvent e) -> {
				
				String login = entreeLogin.getText();
				String ip = entreeIP.getText();
				String port = entreePort.getText();
				
				
				
				if(!isLoginValid(login) || !convert2int(port)) {
					
					saisie.setVisible(true);
					new Timeline (new KeyFrame(Duration.millis(1500), ae -> saisie.setVisible(false))).play();
				}else{
					
					
					try {
						socket = new Socket(ip, Integer.parseInt(port));
						socketCree = true;
						
						
						System.out.println("yeeeeeeeeeeeeeeees ! ! ! ! ! !");
						primaryStage.setScene(gui);
						
					} catch (IOException e1) {
						saisie.setVisible(true);
						socketCree =false;
						new Timeline (new KeyFrame(Duration.millis(1500), ae -> saisie.setVisible(false))).play();
						e1.printStackTrace();
						System.out.println("problème ! ! !!  !");
						
					}
					
					try {
						run();
					} catch (IOException e1) {
						// TODO Bloc catch généré automatiquement
						e1.printStackTrace();
					}
					
					
					
				}
				
				
				
				
			});
			
			
			Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			    @Override
			    public void handle(ActionEvent event) {
			        //System.out.println("this is called every 1 seconds on UI thread");
			    	System.out.println("fred");
			        out.println(gui.getEditor().getHtmlText());
			        System.out.println("et jamy");
			        
					try {
						String line = in.readLine();
						gui.setEditorContent(line);
					} catch (IOException e) {
						// TODO Bloc catch généré automatiquement
						e.printStackTrace();
					}
		            
			        
			    }
			}));
			fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
			fiveSecondsWonder.play();
			
			
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Brag Edit");
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(event -> {
				if(socketCree) {
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Bloc catch généré automatiquement
						e1.printStackTrace();
					}
				}
				Platform.exit();
			    
			});
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static boolean isLoginValid(String login) {
		
		
		if(login.equals("")) {
			return false;
		}
		
		int index = 0;
		while(index < login.length()) {
			
			if(login.charAt(index) == ' ') {
				return false;
			}
			
			index++;
		}
		
		return true;
	}
	
	
	private boolean convert2int(String nb) {
		try{
			Integer.parseInt(nb);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
}
	
	
	private void run() throws IOException {

        // Make connection and initialize streams
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Process all messages from server, according to the protocol.
        /*
        while (true) {
            String line = in.readLine();
            gui.setEditorContent(line);
            
        }*/
    }

	
	
/*
	public void run()
	   {  while (thread != null)
	      {  try
	         {  streamOut.writeUTF(console.readLine());
	            streamOut.flush();
	         }
	         catch(IOException ioe)
	         {  System.out.println("Sending error: " + ioe.getMessage());
	            stop();
	         }
	      }
	   }
	
	
	public void stop()
	   {  if (thread != null)
	      {  thread.stop();  
	         thread = null;
	      }
	      try
	      {  if (console   != null)  console.close();
	         if (streamOut != null)  streamOut.close();
	         if (socket    != null)  socket.close();
	      }
	      catch(IOException ioe)
	      {  System.out.println("Error closing ..."); }
	      client.close();  
	      client.stop();
	   }
		
	public void start() throws IOException
	   {  console   = new DataInputStream(System.in);
	      streamOut = new DataOutputStream(socket.getOutputStream());
	      if (thread == null)
	      {  client = new ChatClientThread(this, socket);
	         thread = new Thread(this);                   
	         thread.start();
	      }
	   }
	
	public void handle(String msg)
	   {  
	         
		gui.setEditorContent(msg);
	   }*/
	
	
}
