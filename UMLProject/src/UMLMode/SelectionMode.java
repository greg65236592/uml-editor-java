package UMLMode;

import generalObj.ShapeObj;
import java.awt.event.MouseEvent;
import UMLFrameComponent.UMLCanvas;

public class SelectionMode extends UMLMode {
	
	public SelectionMode(UMLCanvas canvas){
		super(canvas);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		// (left click mouse)
		if (e.getButton() == MouseEvent.BUTTON1) {
			//select an unit while in select mode
			chosenObj = getInRangeObj(e.getX(), e.getY());
			//click position has a unit
			if(chosenObj != null){
				//change unit select mode
			}	
		}
		umlCanvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//select a BasicObj while in select mode
		chosenObj = getInRangeObj(e.getX(), e.getY());
		//click position has a BasicObj
		if(chosenObj != null){
			//clean other selection first
			for(ShapeObj unSelectedObj : umlCanvas.getShapeObjLis()){
				unSelectedObj.setSelectMode(0);
			}
			//change unit select mode
			if(chosenObj.getSelectMode() == 0){
				//cancel other selection
				int i = 0; 
				for(ShapeObj unSelectedObj : umlCanvas.getShapeObjLis()){
					unSelectedObj.setSelectMode(0);
					i++;
				}
				//select current unit
				ShapeObj currentObj = chosenObj;
				currentObj.setSelectMode(1);
			}

		}
		//click position has no unit -> cancel all selection
		else if(chosenObj == null){ 
			for(ShapeObj unSelectedObj : umlCanvas.getShapeObjLis()){
				unSelectedObj.setSelectMode(0);
			}
		}
		
		//multiple selection if in-range Index == -1
    	if(getInRangeObj(e.getX(), e.getY()) == null){
    		//unselect others first
			for(ShapeObj unit : umlCanvas.getShapeObjLis()){
				unit.setSelectMode(0);
			}
			
    		multiSelectRangeX1 = e.getX();
    		multiSelectRangeY1 = e.getY();
    		//turn on multi-select mode
    		isMultiSelect = true;
    	}
    	umlCanvas.repaint();
    	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//reset index
		chosenObj = null;
		
		//if mutiSelectMode is on
		if(isMultiSelect == true){
    		multiSelectRangeX2 = e.getX();
    		multiSelectRangeY2 = e.getY();
    		for(ShapeObj unit : umlCanvas.getShapeObjLis()){
    			//left-up to right-down mouse drag
    			if(unit.getPosX() >= multiSelectRangeX1 && unit.getPosY() >= multiSelectRangeY1
    					&& unit.getPosX() + unit.getWidth() <= multiSelectRangeX2 && unit.getPosY() + unit.getHeight() <= multiSelectRangeY2){
    				unit.setSelectMode(1);
    				
    			}
    			//right-down to left-up mouse drag
    			else if(unit.getPosX() >= multiSelectRangeX2 && unit.getPosY() >= multiSelectRangeY2
    					&& unit.getPosX() + unit.getWidth() <= multiSelectRangeX1 && unit.getPosY() + unit.getHeight() <= multiSelectRangeY1){
    				unit.setSelectMode(1);
    			}
    			//left-down to right-up mouse drag
    			else if(unit.getPosX() >= multiSelectRangeX1 && unit.getPosY() >= multiSelectRangeY2
    					&& unit.getPosX() + unit.getWidth() <= multiSelectRangeX2 && unit.getPosY() + unit.getHeight() <= multiSelectRangeY1){
    				unit.setSelectMode(1);
    			}
    			//right-up to left-down mouse drag
    			if(unit.getPosX() >= multiSelectRangeX2 && unit.getPosY() >= multiSelectRangeY1
    					&& unit.getPosX() + unit.getWidth() <= multiSelectRangeX1 && unit.getPosY() + unit.getHeight() <= multiSelectRangeY2){
    				unit.setSelectMode(1);
    				
    			}
    			//forbid group partial selection
    			if(unit.getSelectMode() == 0){
    				unit.unSelectGroupMember();
    			}
    			
    		}
		}
		else if (isMultiSelect == false){
			//unselect the units under the "non-selected" group
			for(ShapeObj unit : umlCanvas.getShapeObjLis()){
				unit.unSelectGroupMember();
			}	
		}
		isMultiSelect = false;
		umlCanvas.repaint();
	}
	
    public void mouseDragged(MouseEvent e) {
    	if(chosenObj != null){
			
    		ShapeObj shapeObj = chosenObj;
    		
			shapeObj.resetGroupMember(e);

			shapeObj.setPosX(e.getX() - shapeObj.getWidth()/2);
    		shapeObj.setPosY(e.getY() - shapeObj.getHeight()/2);
    		shapeObj.setPortToNewPos();
			umlCanvas.repaint();	
    	} 	
	
    }	

}
