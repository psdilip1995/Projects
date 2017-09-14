import java.awt.*;
import javax.swing.*;
public class ShowImage extends JPanel
{
 Image image;
 public ShowImage()
 {
  super();
  image = Toolkit.getDefaultToolkit().getImage("picccc.jpg");
 }
 public void paintComponent(Graphics g)
 {
  g.drawImage(image,50,10,300,200, this);
 }
 public static void main(String arg[])
 {
  JFrame frame = new JFrame("ShowImage");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(600,400);
  ShowImage panel = new ShowImage();
  frame.setContentPane(panel); 
  frame.setVisible(true); 
 }
}