package UMLFrameComponent.UMLMenuBar;

import javax.swing.JMenu;

import UMLFrameComponent.UMLCanvas;

public class UMLMenuEditButton extends JMenu {
	
	private UMLCanvas umlCanvas;
	
	private UMLUnGroupMenuItem umlUnGroupMenuItem;
	private UMLGroupMenuItem umlGroupMenuItem;
	private UMLRenameMenuItem umlRenameMenuItem;
	
	public UMLMenuEditButton(UMLCanvas canvas){
		umlCanvas = canvas;
		UMLMenuEditButton.this.setText("Edit");
		
		umlUnGroupMenuItem = new UMLUnGroupMenuItem(umlCanvas);
		umlGroupMenuItem = new UMLGroupMenuItem(umlCanvas);
		umlRenameMenuItem = new UMLRenameMenuItem(umlCanvas);
		this.add(umlGroupMenuItem);
		this.add(umlUnGroupMenuItem);
		this.add(umlRenameMenuItem);
	}
}
