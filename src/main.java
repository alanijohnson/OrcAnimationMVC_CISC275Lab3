import java.awt.Color;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		Orc orc1 = new Orc();
		OrcView view1 = new OrcView();
		OrcController control = new OrcController(orc1,view1);
		view1.controller = control;
		//System.out.println(view1.controller);

		control.animate();

	}
}
