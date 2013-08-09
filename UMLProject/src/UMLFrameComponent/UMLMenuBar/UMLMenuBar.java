package UMLFrameComponent.UMLMenuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import UMLFrameComponent.UMLCanvas;

public class UMLMenuBar extends JMenuBar {
	
	private UMLCanvas umlCanvas;
	
    JMenu menuF;
    JMenu menuE;
	
	public UMLMenuBar(UMLCanvas canvas){
		umlCanvas = canvas;
	    menuF = new UMLMenuFileButton(umlCanvas);
	    menuE = new UMLMenuEditButton(umlCanvas);
	    this.add(menuF);
	    this.add(menuE);
	}
}
