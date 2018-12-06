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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainS extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			//Scene de login:
			BorderPane rootLogin = new BorderPane();
			VBox D = new VBox();
			
			
			
			//a changer
			VBox G = new VBox();
			
			rootLogin.setRight(D);
			rootLogin.setBackground(new Background(new BackgroundFill(Color.rgb(50,50,50), null, null)));
			Scene scene = new Scene(rootLogin, 1280, 720);
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
			
			Label id = new Label("ID Serveur : XXXX.XXXX.XXXX.XXXX");
			D.getChildren().addAll(id);
			id.setId("indicator");
			
			Label port = new Label("Port Serveur : XX");
			D.getChildren().addAll(port);
			port.setId("indicator");
			
			Button dServ = new Button("Demande de connection");
			D.getChildren().addAll(dServ);
			
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
