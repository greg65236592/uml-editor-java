package UMLMode;

import generalObj.Port;
import generalObj.ShapeObj;
import generalObj.basicObj.BasicObj;
import generalObj.basicObj.ClassObj;
import generalObj.basicObj.UseCaseObj;
import generalObj.lineObj.LineObj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;


import UMLFrameComponent.UMLCanvas;

public class UMLMode extends MouseMotionAdapter implements MouseListener {
	
	UMLCanvas umlCanvas;
	
	
	ShapeObj chosenObj; //the chosen BasicObj
	
	//For multiple selection
	protected Boolean isMultiSelect;
//	int mutiSelectFirstIndex; //if mutiSelectFirstIndex==-1, then when released the mouse there'll be multiple selection
	int multiSelectRangeX1, multiSelectRangeY1, multiSelectRangeX2, multiSelectRangeY2;
	
	Port lineSrcPort; //record the src port
	Port lineTarPort; //record the tar port
	
	String srcPortPos, tarPortPos; //for association port's position in string form
	
	public UMLMode(UMLCanvas canvas){
		umlCanvas = canvas;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//remove unit listener (right click mouse)
		if (e.getButton() == MouseEvent.BUTTON3) { 
			chosenObj = getInRangeObj(e.getX(), e.getY());
			if(chosenObj != null){
				umlCanvas.getShapeObjLis().remove(chosenObj);
				//remove the related relation
				List<ShapeObj> removeLineList = new ArrayList<ShapeObj>();
				for(ShapeObj rel : umlCanvas.getShapeObjLis()){
					if(rel.getPortSrc() == chosenObj.getPortDown() ||
							rel.getPortSrc() == chosenObj.getPortLeft() ||
							rel.getPortSrc() == chosenObj.getPortRight() ||
							rel.getPortSrc() == chosenObj.getPortUp() ||
							rel.getPortTar() == chosenObj.getPortDown() ||
							rel.getPortTar() == chosenObj.getPortLeft() ||
							rel.getPortTar() == chosenObj.getPortRight() ||
							rel.getPortTar() == chosenObj.getPortUp() ){
						removeLineList.add(rel);
					}
				}
				for(ShapeObj lineObj : removeLineList){
					for(int i = 0; i < umlCanvas.getShapeObjLis().size(); i++){
						if(umlCanvas.getShapeObjLis().get(i) == lineObj){
							umlCanvas.getShapeObjLis().remove(umlCanvas.getShapeObjLis().get(i));
						}
					}
				}
			}
			umlCanvas.repaint();
		}
		System.out.println(umlCanvas.getCurrentMode()+"++++");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    //choose the most closed BasicObj
    public ShapeObj getInRangeObj(int mousePosX, int mousePosY){
    	ShapeObj retObj = null;
    	for(ShapeObj basicObj : umlCanvas.getShapeObjLis()){
    		if(basicObj.getPosX() < mousePosX && mousePosX < basicObj.getPosX() + basicObj.getWidth()
    				&& basicObj.getPosY() < mousePosY && mousePosY < basicObj.getPosY() + basicObj.getHeight()){
    			retObj = basicObj;
    		}
    	}
    	return retObj;
    }
	
 	//choose the most closed port and get it's position
  	public Port getMostClosedPort(ShapeObj shapeObj, int mouseInX, int mouseInY){
  		getInRangeObj(mouseInX, mouseInY);
  		
  		int downX = 0; int downY = 0;
  		int leftX = 0; int leftY = 0;
  		int rightX = 0; int rightY = 0;
  		int upX = 0; int upY = 0;
  		
  		ShapeObj currentUnit = shapeObj;
  		downX = ((Port) currentUnit.getPortDown()).getPosX(); downY = currentUnit.getPortDown().getPosY();
  	  	leftX = ((Port) currentUnit.getPortLeft()).getPosX(); leftY = currentUnit.getPortLeft().getPosY();
  	  	rightX = ((Port) currentUnit.getPortRight()).getPosX(); rightY = currentUnit.getPortRight().getPosY();
  	  	upX = ((Port) currentUnit.getPortUp()).getPosX(); upY = currentUnit.getPortUp().getPosY();

  		
  		int minDis;
  		Port retPort;
  		
  		minDis = (mouseInX - downX)*(mouseInX - downX) + (mouseInY - downY)*(mouseInY - downY);
  		retPort = currentUnit.getPortDown();
  		
  		if(((mouseInX - leftX)*(mouseInX - leftX) + (mouseInY - leftY)*(mouseInY - leftY)) < minDis){
  			minDis = (mouseInX - leftX)*(mouseInX - leftX) + (mouseInY - leftY)*(mouseInY - leftY);
  			retPort = currentUnit.getPortLeft();
  		}
  		
  		if(((mouseInX - rightX)*(mouseInX - rightX) + (mouseInY - rightY)*(mouseInY - rightY)) < minDis){
  			minDis = (mouseInX - rightX)*(mouseInX - rightX) + (mouseInY - rightY)*(mouseInY - rightY);
  			retPort = currentUnit.getPortRight();
  		}
  		
  		if(((mouseInX - upX)*(mouseInX - upX) + (mouseInY - upY)*(mouseInY - upY)) < minDis){
  			minDis = (mouseInX - upX)*(mouseInX - upX) + (mouseInY - upY)*(mouseInY - upY);
  			retPort = currentUnit.getPortUp();
  		}
  		
  		return retPort;
  	}
  	
	//add new UseCaseUnit while "clicking" mouse
	public void addNewUseCaseObj(int newPosX, int newPosY){
		UseCaseObj useCaseObj = new UseCaseObj(umlCanvas);
		useCaseObj.setPosX(newPosX);
		useCaseObj.setPosY(newPosY);
		useCaseObj.setPort();
		umlCanvas.getShapeObjLis().add(useCaseObj);
		umlCanvas.repaint();
	}
	
	//add new classUnit while "clicking" mouse
	public void addNewClsObj(int newPosX, int newPosY){
		ClassObj clsObj = new ClassObj(umlCanvas);
		clsObj.setPosX(newPosX);
		clsObj.setPosY(newPosY);
		clsObj.setPort();
		umlCanvas.getShapeObjLis().add(clsObj);
		umlCanvas.repaint();
	}

}
