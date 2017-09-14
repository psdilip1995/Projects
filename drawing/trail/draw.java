import java.awt.*;
import java.io.*;
class draw extends Frame
{
 int x,y,r,tx,ty,tr;
 Image img,img2,image;
 Graphics imgg,imgg2;
 String sx="",sy="",sr="";
 FileInputStream fx,fy,fr;
 draw()
 {
  //image = getImage(getCodeBase(),"pen.bmp");
  //image = Toolkit.getDefaultToolkit().getImage("penn.bmp");
  //imgg.setColor(Color.white);
  //imgg.fillRect(0,0,400,400);
  try{
  fx=new FileInputStream("x.txt");
  fy=new FileInputStream("y.txt");
  fr=new FileInputStream("r.txt");}catch(Exception e){}
  setSize(400,400);
  setVisible(true);
  drawing();
  //repaint();
 }
 public static void main(String args[])
 {
  draw d=new draw();
 }
 public void paint(Graphics g)
 {
     update(g);
 }
 public void update(Graphics g)
 {
  g.drawImage(img,0,0,this);
  g.setColor(Color.red);
  g.drawLine(tx,ty,tx+10,ty-10);
  //g.drawImage(image,0,0,this);
  //g.drawImage(img2,0,0,this);
  //try{
  //Thread.sleep(1);}catch(Exception e){System.out.println("1");}
 }
 public void drawing()
 {
  img=createImage(400,400);
  imgg=img.getGraphics();
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
    //Thread.sleep(1);
    }catch(Exception e){}
    //System.out.println(""+tx+" "+ty);
    imgg.setColor(new Color(tr,tr,tr));
    imgg.drawRect(tx,ty,0,0);
    //img2=createImage(400,400);
    //imgg2=img2.getGraphics();
	//imgg2.setColor(Color.red);
	//imgg2.drawRect(tx,ty,3,10);
	repaint();
	sx="";
	sy="";
	sr="";
	try{
	Thread.sleep(1);}catch(Exception eeee){}
   }
 }
}