package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.AssociationMode;

public class AssociationButton extends JButton{
	
	private UMLCanvas umlCanvas;
	
	public AssociationButton(UMLCanvas canvas, final UMLButtonPanel panel){
		 umlCanvas = canvas;
	     Icon assIcon = new ImageIcon("icons/association.gif");
	     AssociationButton.this.setIcon(assIcon);
	     AssociationButton.this.setText("Association");
	     AssociationButton.this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new AssociationMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
				
			}
	    	 
	     });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}
}
