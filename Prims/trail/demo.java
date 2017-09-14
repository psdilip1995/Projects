import java.awt.geom.Line2D;
import java.awt.*;
import java.awt.event.*;
class demo extends Frame implements MouseListener,MouseMotionListener,ActionListener
{
 int x=0,y=0,x1=0,y1=0;
 demo()
 {
  addMouseListener(this);
  addMouseMotionListener(this);
  setSize(500,500);
  setVisible(true);
 }
 public static void main(String args[])
 {
  demo d=new demo();
 }
 public void actionPerformed(ActionEvent e)
 {
 }
 public void mousePressed(MouseEvent e)
 {
  x=e.getX();
  y=e.getY();
 }
 public void mouseReleased(MouseEvent e)
 {
  x1=e.getX();
  y1=e.getY();
  repaint();
 }
 public void mouseClicked(MouseEvent e)
 {
 }
 public void mouseEntered(MouseEvent e)
 {
 }
 public void mouseExited(MouseEvent e)
 {
 }
 public void mouseDragged(MouseEvent e)
 {
 }
 public void mouseMoved(MouseEvent e)
 {
 }
 public void paint(Graphics g)
 {
  //g.drawLine(x,y,x1,y1);
   Graphics2D g2 = (Graphics2D) g;
    			g2.setColor(Color.red);
                g2.setStroke(new BasicStroke(5));
                g2.draw(new Line2D.Float(x,y,x1,y1));
 }
}