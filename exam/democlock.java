import java.awt.*;
import java.util.*;
class democlock extends Frame
{
 String mon[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
 GregorianCalendar gc;
 int x=250,y=100,f=1,flag=0,sec=0,min=0,x1=250,y1=100,f1=1,flag1=0,hr=0,f2=0,flag2=0,x2=250,y2=160;
 democlock()
 {
  setBackground(Color.yellow);
  setVisible(true);
  setSize(500,500);
  show1();
 }
 public void show1()
 {
  for(;;)
  {
   gc=new GregorianCalendar();
   try
   {
    Thread.sleep(1000);
   }
   catch(Exception e)
   {}
   if(f==1)
   {
    x+=10;
    y+=10;
    flag++;
    if(flag==15)
    {
     flag=0;
     f=2;
    }
   }
   else if(f==2)
   {
    x-=10;
    y+=10;
    flag++;
    if(flag==15)
    {
     flag=0;
     f=3;
    }
   }
   else if(f==3)
   {
    x-=10;
    y-=10;
    flag++;
    if(flag==15)
    {
     flag=0;
     f=4;
    }
   }
   else if(f==4)
   {
    x+=10;
    y-=10;
    flag++;
    if(flag==15)
    {
     flag=0;
     f=1;
    }
   }
   sec++;
   if(sec==60)
   {
    sec=0;
    min++;
    if(f1==1)
    {
     x1+=10;
     y1+=10;
     flag1++;
     if(flag1==15)
     {
      flag1=0;
      f1=2;
     }
    }
    else if(f1==2)
    {
     x1-=10;
     y1+=10;
     flag1++;
     if(flag1==15)
     {
      flag1=0;
      f1=3;
     }
    }
    else if(f1==3)
    {
     x1-=10;
     y1-=10;
     flag1++;
     if(flag1==15)
     {
      flag1=0;
      f1=4;
     }
    }
    else if(f1==4)
    {
     x1+=10;
     y1-=10;
     flag1++;
     if(flag1==15)
     {
      flag1=0;
      f1=1;
     }
    }
   }
   if(min==60)
   {
    min=0;
    hr++;
    if(f2==1)
    {
     x2+=10;
     y2+=10;
     flag2++;
     if(flag2==15)
     {
      flag2=0;
      f2=2;
     }
    }
    else if(f2==2)
    {
     x2-=10;
     y2+=10;
     flag2++;
     if(flag2==15)
     {
      flag2=0;
      f2=3;
     }
    }
    else if(f2==3)
    {
     x2-=10;
     y2-=10;
     flag2++;
     if(flag2==15)
     {
      flag2=0;
      f2=4;
     }
    }
    else if(f2==4)
    {
     x2+=10;
     y2-=10;
     flag2++;
     if(flag2==15)
     {
      flag2=0;
      f2=1;
     }
    }
   }
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
  g.drawLine(250,250,x2,y2);
  g.drawLine(252,250,x2+2,y2);
  g.setColor(Color.red);
  g.drawLine(250,250,x,y);
  g.setColor(Color.black);
  g.drawLine(250,250,x1,y1);
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
  g.drawString(""+min+":"+sec,400,400);
  g.drawString(""+gc.get(Calendar.YEAR)+"  "+mon[gc.get(Calendar.MONTH)]+"  "+gc.get(Calendar.DATE),50,450);
  g.drawString(""+gc.get(Calendar.HOUR)+":"+gc.get(Calendar.MINUTE)+":"+gc.get(Calendar.SECOND),50,470);
 }
 public static void main(String args[])
 {
  democlock c=new democlock();
 }
}