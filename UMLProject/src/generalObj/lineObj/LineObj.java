package generalObj.lineObj;

import generalObj.Port;
import generalObj.ShapeObj;

public interface LineObj extends ShapeObj {
	
		
		public Port getPortSrc();
		
		public Port getPortTar();

		public void setPortSrc(Port port);
		
		public void setPortTar(Port port);

}
