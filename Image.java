import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Image
{
    static String Image_Hex = new String();
    static String File_Name = "Germany.ppm";
    static int width = 100;
    static int height = 100;
    public static byte data[];
    
    static int Counter = 0;
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Image Image_Object = new Image(100, 100);
        Image_Hex += "P3\n" + width + "\n" + height + "\n255\n";
        int Rectangle = height / 3;
        int Color;
        int R = 0;
        int G = 0;
        int B = 0;
        
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if (i <= Rectangle)
                {
                    R = 0;
                    G = 0;
                    B = 0;
                }
                else if (i > Rectangle && i <= (Rectangle * 2))
                {
                    R = 255;
                    G = 0;
                    B = 0;
                }
                else if (i > (Rectangle * 2) && i <= (Rectangle * 3))
                {
                    R = 255;
                    G = 225;
                    B = 0;
                }
                Color = new Color(R, G, B).getRGB();//This Line Is From Stack Overflow
                Image_Object.set(i, j, Color);
                Counter++;
            }
        }
        write(File_Name);
    }

    public Image(int height, int width)
    {
        this.height = height;
        this.width = width;
        data = new byte[height * width * 3];
    }
    
    public static void write(String File_Name) throws FileNotFoundException, IOException
    {
        FileOutputStream File_Output_Stream_Object = new FileOutputStream(File_Name);
        File_Output_Stream_Object.write(Image_Hex.getBytes());
        File_Output_Stream_Object.close();
    }

    public static void set(int x, int y, int val)
    {
        Color Color2 = new Color(val);
        String RGB_Hex = "0x" + Integer.toHexString(val);
        
        data[Counter] = (byte) Integer.parseInt(RGB_Hex.substring(2, 4), 16);
        Counter++;
        data[Counter] = (byte) Integer.parseInt(RGB_Hex.substring(4, 6), 16);
        Counter++;
	data[Counter] = (byte) Integer.parseInt(RGB_Hex.substring(6, 8), 16);
        
        Image_Hex += Integer.toString(Color2.getRed()) + " " + Integer.toString(Color2.getGreen()) + " " + Integer.toString(Color2.getBlue()) + " ";
    }
}