import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Image {
	static String rgb = new String();
	static String c;
	static String Red="Red";
	static String Black="Black";
	static String Yellow="Yellow";
	public static String ImageHex="";
	  private static final String imageDir = "Image/rect.ppm";
	    private final static String filename = "Germany.ppm";
	    private static byte bytes[]=null; 
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ImageCreator(100,100);
		writeImage(filename);

	}
	public static void ImageCreator(int width, int height){
		String[][]	Picture=new String [height][width];
		ImageHex +="P3\n" + width + "\n" + height + "\n255\n";
		for(int i = 0; i <= height-1; i++){
			for(int j = 0; j <= width-1; j++){ 
				int Rectangle=height/3;
				int Rectangle2=width/3;
				if(i<=Rectangle ) {
					ColorGenerator(Black);			
				}
				if(i>Rectangle && i<=(Rectangle*2)) {
					ColorGenerator(Red);
				}
				if(i>(Rectangle*2) && i<=(Rectangle*3)) {
					ColorGenerator(Yellow);
				}
				
				Picture[i][j]=""+rgb;
				System.out.println(Picture[i][j]);
			}
			ImageHex+=" "+rgb;
		}

	}
	public static void ColorGenerator(String c){
		if (c==Red) {
			rgb="255 0 0";


		}
		if (c==Black) {
			rgb="255 255 255";


		}
		if (c==Yellow) {
			rgb="255 225 0";


		}

	}
	public static void writeImage(String fn) throws FileNotFoundException, IOException {

               FileOutputStream fos = new FileOutputStream(fn);
                fos.write(new String(ImageHex).getBytes());

                fos.close();
       }
}