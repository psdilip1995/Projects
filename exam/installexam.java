import java.io.*;
import java.util.*;
class installexam
{
 public static void main(String args[])throws Exception
 {
  new File("C:\\config86").mkdir();
  new File("C:\\config86\\network").mkdir();
  new File("C:\\config86\\system").mkdir();
  new File("C:\\config86\\security").mkdir();
  new File("C:\\config86\\A3C5F3").mkdir();
  new File("C:\\config86\\S5F8I2B9").mkdir();
  new File("exam\\details").mkdirs();
  File fakefile=new File("exam\\details","details.txt");
  File fakefile2=new File("exam\\details","questions.txt");
  FileOutputStream fake=new FileOutputStream(fakefile);
  FileOutputStream fake2=new FileOutputStream(fakefile2);
  String fakestr2="this program is created by dilip";
  String fakestr="this program is created by dilip";
  for(int i=0;i<fakestr.length();i++)
	fake.write(fakestr.charAt(i));
  for(int i=0;i<fakestr2.length();i++)
	fake2.write(fakestr2.charAt(i));
  fake.close();
  fake2.close();
  File f=new File("C:\\config86\\S5F8I2B9","conf.dil");
  String s=String.valueOf(new Random().nextInt(20000));
  FileOutputStream f1=new FileOutputStream(f);
  for(int i=0;i<s.length();i++)
	f1.write(s.charAt(i));
  f1.close();
  FileOutputStream f2=new FileOutputStream("key.txt");
  for(int i=0;i<s.length();i++)
	f2.write(s.charAt(i));
  f2.close();
  File fc=new File("C:\\config86\\system","count.dil");
  FileOutputStream fcs=new FileOutputStream(fc);
  fcs.write('0');
  fcs.close();
  File fu=new File("C:\\config86\\security","user.dil");
  fu.createNewFile();
  System.out.println("please delete installexam.class file to avoid any errors or data loss\nexam file is successfully installed");
 }
}