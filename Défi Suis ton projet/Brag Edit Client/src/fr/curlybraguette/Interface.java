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

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Interface extends Scene{
	
	private static Group root = new Group();
	private static Editeur editeur;

	public Interface(double width, double height) {
		
		
		super(root, width, height);
		
		Tab t1 = new Tab();
		t1.setText("Editeur de Texte");
		editeur = new Editeur();
		editeur.prefWidthProperty().bind(this.widthProperty());
		t1.setContent(editeur);
		
		Tab t2 = new Tab();
		t2.setText("Dessins");
		
		Tab t3 = new Tab();
		t3.setText("Taches");
		
		
		
		
		
		
		
		TabPane tp = new TabPane();
		tp.getTabs().addAll(t1,t2,t3);
		
		root.getChildren().add(tp);
		}


	public synchronized void setEditorContent(String msg) {
		
		editeur.setHtmlText(msg);
		
	}
	
	public Editeur getEditor() {
		return editeur;
	}
	

}
