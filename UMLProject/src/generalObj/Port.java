package generalObj;

public class Port {
	int posX, posY;
	
	public Port(){
		//default constructor
	}
	
	public Port(int x, int y){
		posX = x;
		posY = y;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void setPosX(int newPosX){
		posX = newPosX;
	}
	
	public void setPosY(int newPosY){
		posY = newPosY;
	}

}
