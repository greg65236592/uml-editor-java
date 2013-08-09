package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.GeneralizationMode;
import UMLMode.UseCaseMode;

public class UseCaseButton extends JButton {
	
	private UMLCanvas umlCanvas;
	private UMLButtonPanel panel;
	
	public UseCaseButton(UMLCanvas canvas, final UMLButtonPanel panel){
		 this.panel = panel;
		 umlCanvas = canvas;
	     Icon useCaseIcon = new ImageIcon("icons/use case.gif");
	     UseCaseButton.this.setIcon(useCaseIcon);
	     UseCaseButton.this.setText("Use Case");
	     UseCaseButton.this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new UseCaseMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
			}
	    	 
	     });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}
}
