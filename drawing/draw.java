import java.awt.*;
import java.io.*;
class draw extends Frame
{
 int x,y,r,tx,ty,tr;
 String sx="",sy="",sr="";
 FileInputStream fx,fy,fr;
 draw()
 {
  try{
  fx=new FileInputStream("x.txt");
  fy=new FileInputStream("y.txt");
  fr=new FileInputStream("r.txt");}catch(Exception e){}
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
   try{
   x=fx.read();
   y=fy.read();
   r=fr.read();}catch(Exception e){}
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
    while((char)r!=',')
    {
     sr=sr+(char)r;
     r=fr.read();
    }
    x=fx.read();
    y=fy.read();
    r=fr.read();
    tx=Integer.parseInt(sx);
    ty=Integer.parseInt(sy);
    tr=Integer.parseInt(sr);
    Thread.sleep(1);
    }catch(Exception e){}
    //System.out.println(""+tx+" "+ty);
    g.setColor(new Color(tr,tr,tr));
    g.drawRect(tx,ty,1,1);
	sx="";
	sy="";
	sr="";
   }
   System.out.println("over");
 }
}