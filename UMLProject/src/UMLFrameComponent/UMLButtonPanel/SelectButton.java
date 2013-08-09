package UMLFrameComponent.UMLButtonPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UMLFrameComponent.UMLCanvas;
import UMLMode.GeneralizationMode;
import UMLMode.SelectionMode;

public class SelectButton extends JButton{
	
	private UMLCanvas umlCanvas;
	private UMLButtonPanel panel;
	
	public SelectButton(UMLCanvas canvas, final UMLButtonPanel panel){
		this.panel = panel;
		umlCanvas = canvas;
		Icon selectIcon = new ImageIcon("icons/select.gif");	
		SelectButton.this.setIcon(selectIcon);
		SelectButton.this.setText("Select");
	    SelectButton.this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				umlCanvas.setCurrentMode(new SelectionMode(umlCanvas));
				panel.setAllButtonColorToWhite();
				setSelfToBlack();
			}
	    	 
	    });
	}
	
	private void setSelfToBlack(){
		this.setBackground(Color.GRAY);
	}

}
