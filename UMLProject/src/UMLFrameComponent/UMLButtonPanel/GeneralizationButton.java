package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.AssociationMode;
import UMLMode.GeneralizationMode;
import UMLMode.UMLMode;

public class GeneralizationButton extends JButton {
	
	private UMLCanvas umlCanvas; 
	private UMLButtonPanel panel;
	
	public GeneralizationButton(UMLCanvas canvas, final UMLButtonPanel panel){
		 this.panel = panel;
		 umlCanvas = canvas;
	     Icon genIcon = new ImageIcon("icons/generalization.gif");
	     GeneralizationButton.this.setIcon(genIcon);
	     GeneralizationButton.this.setText("Generalization");
	     GeneralizationButton.this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new GeneralizationMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
			}
	    	 
	     });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}
}
