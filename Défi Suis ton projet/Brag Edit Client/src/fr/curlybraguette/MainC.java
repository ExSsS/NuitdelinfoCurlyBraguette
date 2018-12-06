/*******************************************************************************
 * Copyright (C) 2018 Curly Braguette (ROMAINPC Killian Dieu Matoz)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package fr.curlybraguette;
	
import javafx.application.Application;
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


public class MainC extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
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
			
			
			
			Label indicationsLogin = new Label("Entrez votre pseudo :");
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
			rootLogin.getChildren().addAll(loginBox);
			
			
			
			
			
			
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Brag Edit");
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
