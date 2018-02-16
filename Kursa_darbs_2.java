//Kursa darbs - El�na M�rniece

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


class MansFrame extends JFrame {
			
	 public MansFrame() {
		 //uzst�dam Frame nosaukumu, lielumu u.c.parametrus
			setTitle("Apb�ves tehniskie r�d�t�ji");
			setSize(370,550);		 
			setLocation(50,250);			
			
			addWindowListener(new WindowAdapter() {
			  	public void windowClosing(WindowEvent e) {
				   System.exit(0);
			  	} 
			} );
			
			 JPanel p1=new JPanel(); 
			 p1.setLayout(new FlowLayout(FlowLayout.LEFT));
			 Color c = new Color (200, 204, 209);
			 p1.setBackground(c);	 
			 add(p1);  
			 			
		    //izveidojam JTextArea /JTextField laukus ar label elementiem
			 String stProjectName = " Projekta nosaukums: ";
		    JLabel lt1 = new JLabel(stProjectName);
		    p1.add (lt1);
		    JTextField projectName = new JTextField (25);
		    p1.add(projectName);
		    
		    String stProjectAddress = " Projekta adrese: ";
		    JLabel lt2 = new JLabel(stProjectAddress);
		    p1.add (lt2);
		    JTextField projectAddress = new JTextField (25);
		    p1.add(projectAddress);
		    
		    String stComment = " Koment�ri / P�d�jo izmai�u datums: ";
		    JLabel lt3 = new JLabel(stComment);
		    p1.add (lt3);
		    JTextArea comment = new JTextArea (5, 25);
		    p1.add(comment);		     		      

		      //izveidojam JComboBox klases elementus
		     String st []={"Ski�u stadija","Minim�lais b�vprojekts (MBP)","B�vprojekts (BP)"};
		     JComboBox cb=new JComboBox(st);
		     p1.add(cb); 
		               
		    //izveidojam JTextField ar label elementiem
		      String stl1 = " Zemesgabala plat�ba (m2) : ";
			  JLabel l1 = new JLabel(stl1);
			  p1.add (l1);  
		      JTextField t1 = new JTextField("0.00",10);		     
		      p1.add(t1);

		      String stl2 = " Apb�ves laukums (m2) : ";
			  JLabel l2 = new JLabel(stl2);
			  p1.add (l2);  
		      JTextField t2 = new JTextField("0.00",10);		     
		      p1.add(t2);
			    			    
		      String stl3 = " Ce�i un autost�vvietas (m2) : ";
			  JLabel l3 = new JLabel(stl3);
			  p1.add (l3);  
		      JTextField t3 = new JTextField("0.00",10);		     
		      p1.add(t3);
			  
		      String stl4 = " St�vu plat�ba (m2) : ";
			  JLabel l4 = new JLabel(stl4);
			  p1.add (l4);  
		      JTextField t4 = new JTextField("0.00",10);		     
		      p1.add(t4);
			    
		      String stl5 = " Apb�ves bl�vums (%) : ";
			  JLabel l5 = new JLabel(stl5);
			  p1.add (l5);  
		      JTextField t5 = new JTextField("0.00",10);		     
		      p1.add(t5);
			  t5.setEditable(false);   
			    
			  String stl6 = " Apb�ves intensit�te (%) : ";
			  JLabel l6 = new JLabel(stl6);
			  p1.add (l6);  
		      JTextField t6 = new JTextField("0.00",10);		     
		      p1.add(t6);
			  t6.setEditable(false); 
			    
			  String stl7 = " Br�v� teritorija (%) : ";
			  JLabel l7 = new JLabel(stl7);
			  p1.add (l7);  
		      JTextField t7 = new JTextField("0.00",10);		     
		      p1.add(t7);
			  t7.setEditable(false); 
		  	
			  String stl8 = " Ce�i un autost�vvietas (%) : ";
			  JLabel l8 = new JLabel(stl8);
			  p1.add (l8);  
		      JTextField t8 = new JTextField("0.00",10);		     
		      p1.add(t8);
			  t8.setEditable(false); 
			  
			  String stl9 = " Apza�umojums (%) : ";
			  JLabel l9 = new JLabel(stl9);
			  p1.add (l9);  
		      JTextField t9 = new JTextField("0.00",10);		     
		      p1.add(t9);
			  t9.setEditable(false); 
			  
			  
			  //izveidojam paneli ar pog�m
			  JPanel panelbtn=new JPanel(); 
			  p1.add(panelbtn);	
			  JButton b1 = new JButton(" Apr��in�t ");
			  JButton b2 = new JButton(" Nodz�st v�rt�bas "); 
			  JButton b3 = new JButton(" Saglab�t ");
			  panelbtn.add(b1);               
		      panelbtn.add(b2); 
		      panelbtn.add(b3);
		      panelbtn.setBackground(c);
		      
		      //uzst�dam kr�sas pog�m
			  Color c1 = new Color (165, 226, 161);
			  b1.setBackground(c1);
			  Color c2 = new Color (237, 97, 97);
			  b2.setBackground(c2);

		        
		        b1.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        		
	        	        try {
	        	        	//nolasam v�rt�bas no datu laukiem un p�rveidojam tos no String uz double form�tu
	        	        	 String s1=t1.getText();  
			        		 double a=Double.parseDouble(s1);
			        		 String s2=t2.getText();  
			        		 double b=Double.parseDouble(s2);
			        		 String s3=t3.getText();  
			        		 double c=Double.parseDouble(s3);
			        		 String s4=t4.getText();  
			        		 double d=Double.parseDouble(s4);
			        		 
			        		 //apr��inam nepiecie�amos r�d�t�jus
			        		 ApbuvesRaditaji A = new ApbuvesRaditaji (a, b, c, d);
			        		 double r = (double)Math.round(A.ApbBlivums()*10)/10;
			        		 double r1 = (double)Math.round(A.ApbIntens()*10)/10;
			        		 double r2 = (double)Math.round(A.BrivTerit()*10)/10;
			        		 double r3 = (double)Math.round(A.Celi()*10)/10;
			        		 double r4 = (double)Math.round(A.ZalTerit()*10)/10;
			        		 String result=String.valueOf(r); 
			        		 t5.setText(result);  
			        		 String result1=String.valueOf(r1); 
			        		 t6.setText(result1);  
			        		 String result2=String.valueOf(r2); 
			        		 t7.setText(result2);  
			        		 String result3=String.valueOf(r3); 
			        		 t8.setText(result3); 
			        		 String result4=String.valueOf(r4); 
			        		 t9.setText(result4); 
			        		 
	        	        } catch (Exception ex) {
	        	        	//dialoga logs, ja ievad�ti nere�li lielumi
	        	        	JDialog d = new JDialog();
	        	        	JLabel l4 = new JLabel("L�dzu ievadiet re�las plat�bas!");
	        	        	d.add(l4);
	        	            d.setSize(250,250);
	        				d.setLocation(50,250);
	        	        	d.setVisible(true);	        	        	
	        	        }
		        		
		        		
		        	        }  
		        	    });  
		        
		        b2.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        		//nodz��am v�rt�bas, ja nospiesta attiec�g� poga
		        		t1.setText("0.00");
		        		t2.setText("0.00");
		        		t3.setText("0.00");
		        		t4.setText("0.00");
		        		t5.setText("0.00");
		        		t6.setText("0.00");
		        		t7.setText("0.00");
		        		t8.setText("0.00");
		        		t9.setText("0.00");
		        	}		        	
		        });  	
		        
		        
		        b3.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  	
		        		//faila saglab��ana
		        	    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		        	    int retrival = chooser.showSaveDialog(null);
		        	    if (retrival == JFileChooser.APPROVE_OPTION) {
		        	        try {
		        		        String sb = stProjectName + projectName.getText() + stProjectAddress + projectAddress.getText() + stComment + comment.getText() + "Projekta stadija: " + st[cb.getSelectedIndex()] + 
		        		        		stl1 + t1.getText() + stl2 + t2.getText() + stl3 + t3.getText() + stl4 + t4.getText() + stl5 + t5.getText() + stl6 + t6.getText() + stl7 + t7.getText() + 
		        		        		stl8 + t8.getText() + stl9 + t9.getText();
		        	        	
		        	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
		        	            fw.write(sb.toString());
		        	            fw.close();
		        	        } catch (Exception ex) {
		        	            ex.printStackTrace();
		        	        }
		        	    }
		        	        } 
		        	    });		
	 }	 
}	 

class Zemesgabals {
	double Zemesgab_platiba; //Zemesgabala plat�ba
	final int i = 100; //konstante, kura tiek izmantota formul�s	
}

//klase, kas apr��ina apb�ves r�d�t�jus
class ApbuvesRaditaji extends Zemesgabals  {
	double Celu_lauk; //Ce�i un autost�vvietas - laukums
	double Apbuves_lauk; //�ku apb�ves laukums
	double Stavu_plat; //St�vu plat�ba

	ApbuvesRaditaji (double a, double b, double c, double d) {
		Zemesgab_platiba = a;
		Apbuves_lauk = b;
		Celu_lauk = c;
		Stavu_plat = d;
	}
	
	double ApbBlivums() {
	      return Apbuves_lauk * i / Zemesgab_platiba;  //Apr��ina Apb�ves bl�vumu zemesgabalam
	}
  
	double ApbIntens() {
	      return Stavu_plat * i / Zemesgab_platiba;  //Apr��ina Apb�ves intensit�ti zemesgabalam
	}
	
	double BrivTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk - Celu_lauk) * i / Stavu_plat ;  //Apr��ina zemesgabala br�vo teritoriju
	}
  
	double Celi() {
	      return Celu_lauk * i / Zemesgab_platiba ;  //Apr��ina %, ko aiz�em ce�i zemesgabal�
	}
  
	double ZalTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk -  Celu_lauk) * i / Zemesgab_platiba ;  //Apr��ina %, ko aiz�em apza�umojums zemesgabal�
	}   
}


public class Kursa_darbs {

	public static void main(String[] args) {
		//Creating the Frame
	    JFrame f = new MansFrame();
	    f.setVisible (true);	
	}
}


