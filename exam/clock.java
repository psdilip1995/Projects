import java.awt.*;
import java.util.*;
class clock extends Frame
{
 int coy[]={100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,390,380,370,360,350,340,330,320,310,300,290,280,270,260,250,240,230,220,210,200,190,180,170,160,150,140,130,120,110};
 int cox[]={250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,390,380,370,360,350,340,330,320,310,300,290,280,270,260,250,240,230,220,210,200,190,180,170,160,150,140,130,120,110,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240};
 String mon[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
 GregorianCalendar gc;
 clock()
 {
  setBackground(Color.yellow);
  setVisible(true);
  setSize(500,500);
  cshow();
 }
 public void cshow()
 {
  for(;;)
  {
   try
   {
    Thread.sleep(1000);
   }
   catch(Exception e)
   {}
   gc=new GregorianCalendar();
   repaint();
  }
 }
 public void paint(Graphics g)
 {
   g.drawString("12",245,85);
   g.drawString("3",410,250);
   g.drawString("6",245,420);
   g.drawString("9",80,250);
   g.drawLine(250,90,410,250);
   g.drawLine(410,250,250,410);
   g.drawLine(250,410,90,250);
   g.drawLine(90,250,250,90);
   g.setColor(Color.green);
   g.drawLine(250,250,cox[gc.get(Calendar.HOUR)*5+(gc.get(Calendar.MINUTE)/12)],coy[gc.get(Calendar.HOUR)*5+(gc.get(Calendar.MINUTE)/12)]);
   g.setColor(Color.red);
   g.drawLine(250,250,cox[gc.get(Calendar.SECOND)],coy[gc.get(Calendar.SECOND)]);
   g.setColor(Color.black);
   g.drawLine(250,250,cox[gc.get(Calendar.MINUTE)],coy[gc.get(Calendar.MINUTE)]);
   g.fillOval(300,150,5,5);
   g.fillOval(350,200,5,5);
   g.fillOval(400,250,5,5);
   g.fillOval(350,300,5,5);
   g.fillOval(300,350,5,5);
   g.fillOval(250,400,5,5);
   g.fillOval(200,350,5,5);
   g.fillOval(150,300,5,5);
   g.fillOval(100,250,5,5);
   g.fillOval(150,200,5,5);
   g.fillOval(200,150,5,5);
   g.fillOval(250,100,5,5);
   g.drawString(""+gc.get(Calendar.YEAR)+"  "+mon[gc.get(Calendar.MONTH)]+"  "+gc.get(Calendar.DATE),50,450);
   g.drawString(""+gc.get(Calendar.HOUR)+":"+gc.get(Calendar.MINUTE)+":"+gc.get(Calendar.SECOND),50,470);
  }
 public static void main(String args[])
 {
  clock c=new clock();
 }
}