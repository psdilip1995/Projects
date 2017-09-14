import java.io.*;
import java.awt.*;
import java.awt.event.*;
class convert extends Frame implements ActionListener,ItemListener
{
        File fp;
        FileWriter fw;
        BufferedReader br;
        Panel p,p1,pp1,ppp1,pp2,p2,p3;
        TextField t1,tt2,t2;
        Label l1,ll2,l2;
        Button b,b1,bb1,bb2,b2;
        CardLayout cdl=new CardLayout();
        int count;
		Checkbox cb1,cb2;
		TextArea ta;
        convert()
        {
                p=new Panel();
                p.setLayout(cdl);
                p1=new Panel();
                l1=new Label("Enter input file name:");
                t1=new TextField(20);
                b1=new Button("ok");
                b1.addActionListener(this);
                p1.add(l1);
                p1.add(t1);
                p1.add(b1);
                p1.setLayout(new FlowLayout());
				pp1=new Panel();
				cb1=new Checkbox("Genreate XSLT File											");
				bb1=new Button("ok");
				bb1.addActionListener(this);
				pp1.add(cb1);
				pp1.add(bb1);
				pp1.setLayout(new FlowLayout());
				ppp1=new Panel();
				ppp1.setLayout(new FlowLayout());
				pp2=new Panel();
				ll2=new Label("Enter the dtd file name(.dtd)			");
				tt2=new TextField(20);
				bb2=new Button("ok");
				bb2.addActionListener(this);
				cb2=new Checkbox("or type the dtd ");
				cb2.addItemListener(this);
				ta=new TextArea(25,55);
				ta.setEditable(false);
				pp2.add(ll2);
				pp2.add(tt2);
				pp2.add(bb2);
				pp2.add(cb2);
				pp2.add(ta);
				pp2.setLayout(new FlowLayout());
                p2=new Panel();
                t2=new TextField(20);
                l2=new Label("enter output file name(xml):");
                b2=new Button("ok");
                b2.addActionListener(this);
                p2.add(l2);
                p2.add(t2);
                p2.add(b2);
                p2.setLayout(new FlowLayout());
                p3=new Panel();
                p.add(p1);
				p.add(pp1);
				p.add(pp2);
                p.add(p2);
                p.add(p3);
                add(p);
                setLayout(new GridLayout(1,1));
                setSize(500,500);
                setVisible(true);
                setResizable(false);
        }
        public static void main(String args[])
        {
                convert c=new convert();
        }
        public void actionPerformed(ActionEvent ae)
        {
                b=(Button)ae.getSource();
                if(b==b1)
                {
						String str;
                        try{
                        br=new BufferedReader(new FileReader(t1.getText()));
                        while((str=br.readLine())!=null)
						{
								if(str.length()>0)
                                count++;
						}
                        System.out.println("your file has "+count+" number of lines");
						cdl.next(p);
                        }catch(IOException ioe){System.out.println("your file dose not exsist\n");t1.setText("");}
                        
                }
				if(b==bb1)
				{
						cdl.next(p);
				}
				if(b==bb2)
				{
						cdl.next(p);
				}
                if(b==b2)
                {
                        cdl.next(p);
                        fp=new File(t2.getText()+".xml");
                        try{
                        fw=new FileWriter(fp);
                        fp.createNewFile();
                        fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<note>\n<to>tove</to>\n</note>");
                        fw.flush();
                        fw.close();
                        }catch(Exception e){}
                }
        }
		public void itemStateChanged(ItemEvent ie)
		{
		 if(ta.isEditable())
		 ta.setEditable(false);
		 else
		 ta.setEditable(true);
		}
}
