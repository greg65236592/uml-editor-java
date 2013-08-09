package UMLFrameComponent.UMLMenuBar;

import generalObj.ShapeObj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import UMLFrameComponent.UMLCanvas;

public class UMLRenameMenuItem extends JMenuItem {
	private UMLCanvas umlCanvas;
	
	public UMLRenameMenuItem(UMLCanvas canvas){
		umlCanvas = canvas;
		this.setText("Rename");
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newName = JOptionPane.showInputDialog("Please type in new name");
				for(ShapeObj unit : umlCanvas.getShapeObjLis()){
					if(unit.getSelectMode() == 1 && newName != null){
						unit.setName(newName);
						
						//set the group's units name
						if(unit.getShapeObjLis() != null){
							for(ShapeObj members : unit.getShapeObjLis()){
								members.setName(newName);
							}
						}
					}
				}
				umlCanvas.repaint();	
			}
			
		});
	    
	}

}
