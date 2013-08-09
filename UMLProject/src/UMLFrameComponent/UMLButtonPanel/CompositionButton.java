package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.AssociationMode;
import UMLMode.CompositionMode;

public class CompositionButton extends JButton {
	
	private UMLCanvas umlCanvas;
	private UMLButtonPanel panel;
	
	public CompositionButton(UMLCanvas canvas, final UMLButtonPanel panel){
		this.panel = panel;
		umlCanvas = canvas;
	    Icon comIcon = new ImageIcon("icons/composition.gif");
	    CompositionButton.this.setIcon(comIcon);
	    CompositionButton.this.setText("Composistion");
	    CompositionButton.this.addActionListener(null);
	    CompositionButton.this.addActionListener(new ActionListener(){

	    	@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new CompositionMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
	    	}
	    	 
	     });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}
}
