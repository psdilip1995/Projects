import java.awt.*;
import java.io.*;
class draw extends Frame
{
 int x,y,tx,ty;
 String sx="",sy="";
 FileInputStream fx,fy;
 draw()
 {
  try{
  fx=new FileInputStream("x.txt");
  fy=new FileInputStream("y.txt");}catch(Exception e){}
  setSize(400,400);
  setVisible(true);
  //repaint();
 }
 public static void main(String args[])
 {
  draw d=new draw();
 }
 public void paint(Graphics g)
 {
   g.setColor(new Color(192,192,192));
   try{
   x=fx.read();
   y=fy.read();}catch(Exception e){}
   while((char)x!='}')
   {
   try{
    while((char)x!=',')
    {
     sx=sx+(char)x;
     x=fx.read();
    }
    while((char)y!=',')
    {
     sy=sy+(char)y;
     y=fy.read();
    }
    x=fx.read();
    y=fy.read();
    tx=Integer.parseInt(sx);
    ty=Integer.parseInt(sy);
    Thread.sleep(1);
    }catch(Exception e){}
    //System.out.println(""+tx+" "+ty);
    g.drawRect(tx,ty,1,1);
	sx="";
	sy="";
   }
   System.out.println("over");
 }
}