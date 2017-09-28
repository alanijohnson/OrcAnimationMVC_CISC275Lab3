import java.util.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrcView extends JPanel{
	final int frameCount = 10;
	int picNum = 0;
	static int orcImageNum;
	BufferedImage[][] pics;
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	public static int xCoord;
	public static int yCoord;
	OrcController controller;
	
	/* animate() - shows animation window and loops through images
	 * 
	 */
	public void animate() {	
		JFrame frame = new JFrame();
		frame.getContentPane().add(new OrcView());
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		for (int i = 0; i < 1000; i++) {
			frame.repaint();
			controller.updateData();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* OrcView() - constructor
	 * 		
	 */
	public OrcView() {
		pics = new BufferedImage[8][10];
		//creates the image in each directions
		BufferedImage img1 = createImage("southeast");
		BufferedImage img2 = createImage("southwest");
		BufferedImage img3 = createImage("northeast");
		BufferedImage img4 = createImage("northwest");
		BufferedImage img5 = createImage("north");
		BufferedImage img6 = createImage("east");
		BufferedImage img7 = createImage("south");
		BufferedImage img8 = createImage("west");

		//assign each image to a position in the 2-d array "pics"
		//and the for loop is to get all the sub images from each direction
		for (int i = 0; i < frameCount; i++) {
			pics[0][i] = img1.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[1][i] = img2.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[2][i] = img3.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[3][i] = img4.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[4][i] = img5.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[5][i] = img6.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[6][i] = img7.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			pics[7][i] = img8.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
		}
	}
	
	/* createImage(String dir) - reads in the images into the class from file
	 * 
	 * parameters:
	 * 		String dir - the direction of the character in the image
	 * 
	 * return:
	 * 		Buffered Image - returns the png file
	 */
	private BufferedImage createImage(String dir) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_"+dir+".png"));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void paint(Graphics g) {
		//iterate the picture number so the animation uses different frames of the orcImage
		picNum = (picNum + 1) % frameCount;
		
		//draw the image
		g.drawImage(pics[orcImageNum][picNum], xCoord, yCoord, Color.gray, this);

	}
}
