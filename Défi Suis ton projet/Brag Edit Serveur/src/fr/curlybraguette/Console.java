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

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class Console extends ScrollPane{

	private VBox group;
	
	public Console(){
		
		group = new VBox();
		group.setPadding(new Insets(10,10,10,10));
		this.setContent(group);
				
		
	}

	public void afficher(String txt) {
		Label label = new Label(txt);
		
		this.setVvalue(this.getVvalue()+42);
		
		group.getChildren().add(label);
		
	}
}

