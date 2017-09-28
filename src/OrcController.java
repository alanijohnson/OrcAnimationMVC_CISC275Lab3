import java.awt.Color;

public class OrcController {
	Orc orc;
	OrcView orcView;
	int orcImage;

	
	public OrcController(Orc orc, OrcView orcView) {
		this.orc = orc;
		this.orcView = orcView;
		
		//set the location in the view
		orcView.xCoord = orc.xloc;
		orcView.yCoord = orc.yloc;
		
		//sets the image number based on the direction traveling using flags
		if (orc.x_inc && orc.y_inc) {
			OrcView.orcImageNum = 0;
		} else if (!orc.x_inc && orc.y_inc) {
			OrcView.orcImageNum = 1;
		} else if (orc.x_inc && !orc.y_inc) {
			OrcView.orcImageNum = 2;
		} else {
			OrcView.orcImageNum = 3;
		}
	}
	
	/* animate() - call the view to animate
	 * parameters:
	 * 		none
	 * 
	 * return:
	 * 		none
	 
	 */
	public void animate(){
		orcView.animate();
	}

	public void updateData() {
		//updates all necessary data to move orc
		updateFlags();
		moveOrc();
		orcView.xCoord = orc.xloc;
		orcView.yCoord = orc.yloc;
	}
	

	//update the flags that indicate the direction the orc is traveling
	public void updateFlags() {
		if (orc.xloc >= (OrcView.frameWidth - 125)) {
			// the 125 is so the image does not completely go off the screen
			orc.x_inc = false;
		} else if (orc.xloc <= 0) {
			orc.x_inc = true;
		}

		if (orc.yloc >= (OrcView.frameHeight - 150)) {
			// the 150 is so the image does not completely go off the screen
			orc.y_inc = false;
		} else if (orc.yloc <= 0) {
			orc.y_inc = true;
		}
	}
	
	public void moveOrc() {
		//moves the orc and updates the integer representing the of the direction of the orc
		if (orc.x_inc && orc.y_inc) {
			OrcView.orcImageNum = 0;
			orc.xloc += orc.xIncr;
			orc.yloc += orc.yIncr;
		} else if (!orc.x_inc && orc.y_inc) {
			OrcView.orcImageNum = 1;
			orc.xloc -= orc.xIncr;
			orc.yloc += orc.yIncr;
		} else if (orc.x_inc && !orc.y_inc) {
			OrcView.orcImageNum = 2;
			orc.xloc += orc.xIncr;
			orc.yloc -= orc.yIncr;
		} else {
			OrcView.orcImageNum = 3;
			orc.xloc -= orc.xIncr;
			orc.yloc -= orc.yIncr;
		}
	}
	
	public int getxLoc(){
		return orc.xloc;
	}
	
	public int getyLoc(){
		return orc.yloc;
	}
	
	public String toString(){
		return "Orc: " + getxLoc() +","  + getyLoc();
	}
}
