import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class tspmap extends Applet
{
 Image image;
 MediaTracker tr;
 public void init()
 {
  tr=new MediaTracker(this);
  image = getImage(getCodeBase(),"map2.jpg");
  setSize(700,600);
  setVisible(true);
 }
 public void start(){}
 public void run(){}
 public void stop(){}
 public void paint(Graphics g)
 {
  tr.addImage(image,0);
  g.drawImage(image,50,0,600,650,this);
 }
}