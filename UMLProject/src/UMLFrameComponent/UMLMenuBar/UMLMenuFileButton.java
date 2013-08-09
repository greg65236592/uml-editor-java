package UMLFrameComponent.UMLMenuBar;

import javax.swing.JMenu;

import UMLFrameComponent.UMLCanvas;

public class UMLMenuFileButton extends JMenu {

	private UMLCanvas umlCanvas;
	
	public UMLMenuFileButton(UMLCanvas canvas){
		umlCanvas = canvas;
		UMLMenuFileButton.this.setText("File");
	}
}
