package UMLFrameComponent.UMLMenuBar;

import generalObj.GroupUnit;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


import UMLFrameComponent.UMLCanvas;

public class UMLGroupMenuItem extends JMenuItem {
	
	private UMLCanvas umlCanvas;
	
	public UMLGroupMenuItem(UMLCanvas canvas){
		umlCanvas = canvas;
		this.setText("Group");
		
		this.addActionListener(new ActionListener(){
	    	 @Override
			public void actionPerformed(ActionEvent e) {
				int selectNum = 0; //count how many selected units
				for(ShapeObj unit : umlCanvas.getShapeObjLis()){
					if(unit.getSelectMode() == 1){
						selectNum++;
					}
				}
				//compose
				if(selectNum > 1){
					GroupUnit groupUnit = new GroupUnit(umlCanvas);
					for(ShapeObj basicObj : umlCanvas.getShapeObjLis()){
						if(basicObj.getSelectMode() == 1){
							groupUnit.addInGroup(basicObj);
						}	
					}
					groupUnit.setPort();
					groupUnit.setInitPos();
					umlCanvas.getShapeObjLis().add(groupUnit);
					umlCanvas.repaint();
				}
			}		
		});
	}
}
