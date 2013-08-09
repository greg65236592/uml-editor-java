package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.AssociationMode;
import UMLMode.ClassObjMode;

public class ClassObjButton extends JButton{
	
	private UMLCanvas umlCanvas;
	private UMLButtonPanel panel;
	
	public ClassObjButton(UMLCanvas canvas, final UMLButtonPanel panel){
		 this.panel = panel;
		 umlCanvas = canvas;
	     Icon classIcon = new ImageIcon("icons/class.gif");
	     this.setIcon(classIcon);
	     this.setText("Class");
	     this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new ClassObjMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
			}
	    	 
	     });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}
}
