package UMLFrameComponent.UMLMenuBar;

import generalObj.GroupUnit;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.lineObj.LineObj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;



import UMLFrameComponent.UMLCanvas;

	public class UMLUnGroupMenuItem extends JMenuItem {

	private UMLCanvas umlCanvas;
	
	public UMLUnGroupMenuItem(UMLCanvas canvas){
		umlCanvas = canvas;
		this.setText("Ungroup");
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectNum = 0; //count how many selected units
				for(ShapeObj unit : umlCanvas.getShapeObjLis()){
					if(unit.getSelectMode() == 1){
						selectNum++;
					}
				}
				
				//decompose
				if(selectNum == 1){
					ShapeObj removeBasicObj = null;
					for(ShapeObj basicObj : umlCanvas.getShapeObjLis()){
						if( basicObj.getShapeObjLis()!=null && basicObj.getSelectMode() == 1){ //exam whether unit is a GroupUnit
							removeBasicObj = basicObj; //using this wired remove solution because there is a concurrentModificationException
						}
					}
					//remove related line
					List<ShapeObj> removeLineList = new ArrayList<ShapeObj>();
					for(ShapeObj lineObj : umlCanvas.getShapeObjLis()){
						if(lineObj.getPortSrc() == removeBasicObj.getPortDown() ||
								lineObj.getPortSrc() == removeBasicObj.getPortLeft() ||
								lineObj.getPortSrc() == removeBasicObj.getPortRight() ||
								lineObj.getPortSrc() == removeBasicObj.getPortUp() ||
								lineObj.getPortTar() == removeBasicObj.getPortDown() ||
								lineObj.getPortTar() == removeBasicObj.getPortLeft() ||
								lineObj.getPortTar() == removeBasicObj.getPortRight() ||
								lineObj.getPortTar() == removeBasicObj.getPortUp() ){
							
							removeLineList.add(lineObj);
						}
					}
					for(ShapeObj lineObj : removeLineList){
						for(int i = 0; i < umlCanvas.getShapeObjLis().size(); i++){
							if(umlCanvas.getShapeObjLis().get(i) == lineObj){
								umlCanvas.getShapeObjLis().remove(umlCanvas.getShapeObjLis().get(i));
							}
						}
					}

					umlCanvas.getShapeObjLis().remove(removeBasicObj); //remove the group
					umlCanvas.repaint();
				}
			}
	    	 
	     });

	}
	
}
