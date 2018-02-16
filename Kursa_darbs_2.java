//Kursa darbs - Elîna Mûrniece

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


class MansFrame extends JFrame {
			
	 public MansFrame() {
		 //uzstâdam Frame nosaukumu, lielumu u.c.parametrus
			setTitle("Apbûves tehniskie râdîtâji");
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
		    
		    String stComment = " Komentâri / Pçdçjo izmaiòu datums: ";
		    JLabel lt3 = new JLabel(stComment);
		    p1.add (lt3);
		    JTextArea comment = new JTextArea (5, 25);
		    p1.add(comment);		     		      

		      //izveidojam JComboBox klases elementus
		     String st []={"Skièu stadija","Minimâlais bûvprojekts (MBP)","Bûvprojekts (BP)"};
		     JComboBox cb=new JComboBox(st);
		     p1.add(cb); 
		               
		    //izveidojam JTextField ar label elementiem
		      String stl1 = " Zemesgabala platîba (m2) : ";
			  JLabel l1 = new JLabel(stl1);
			  p1.add (l1);  
		      JTextField t1 = new JTextField("0.00",10);		     
		      p1.add(t1);

		      String stl2 = " Apbûves laukums (m2) : ";
			  JLabel l2 = new JLabel(stl2);
			  p1.add (l2);  
		      JTextField t2 = new JTextField("0.00",10);		     
		      p1.add(t2);
			    			    
		      String stl3 = " Ceïi un autostâvvietas (m2) : ";
			  JLabel l3 = new JLabel(stl3);
			  p1.add (l3);  
		      JTextField t3 = new JTextField("0.00",10);		     
		      p1.add(t3);
			  
		      String stl4 = " Stâvu platîba (m2) : ";
			  JLabel l4 = new JLabel(stl4);
			  p1.add (l4);  
		      JTextField t4 = new JTextField("0.00",10);		     
		      p1.add(t4);
			    
		      String stl5 = " Apbûves blîvums (%) : ";
			  JLabel l5 = new JLabel(stl5);
			  p1.add (l5);  
		      JTextField t5 = new JTextField("0.00",10);		     
		      p1.add(t5);
			  t5.setEditable(false);   
			    
			  String stl6 = " Apbûves intensitâte (%) : ";
			  JLabel l6 = new JLabel(stl6);
			  p1.add (l6);  
		      JTextField t6 = new JTextField("0.00",10);		     
		      p1.add(t6);
			  t6.setEditable(false); 
			    
			  String stl7 = " Brîvâ teritorija (%) : ";
			  JLabel l7 = new JLabel(stl7);
			  p1.add (l7);  
		      JTextField t7 = new JTextField("0.00",10);		     
		      p1.add(t7);
			  t7.setEditable(false); 
		  	
			  String stl8 = " Ceïi un autostâvvietas (%) : ";
			  JLabel l8 = new JLabel(stl8);
			  p1.add (l8);  
		      JTextField t8 = new JTextField("0.00",10);		     
		      p1.add(t8);
			  t8.setEditable(false); 
			  
			  String stl9 = " Apzaïumojums (%) : ";
			  JLabel l9 = new JLabel(stl9);
			  p1.add (l9);  
		      JTextField t9 = new JTextField("0.00",10);		     
		      p1.add(t9);
			  t9.setEditable(false); 
			  
			  
			  //izveidojam paneli ar pogâm
			  JPanel panelbtn=new JPanel(); 
			  p1.add(panelbtn);	
			  JButton b1 = new JButton(" Aprçíinât ");
			  JButton b2 = new JButton(" Nodzçst vçrtîbas "); 
			  JButton b3 = new JButton(" Saglabât ");
			  panelbtn.add(b1);               
		      panelbtn.add(b2); 
		      panelbtn.add(b3);
		      panelbtn.setBackground(c);
		      
		      //uzstâdam krâsas pogâm
			  Color c1 = new Color (165, 226, 161);
			  b1.setBackground(c1);
			  Color c2 = new Color (237, 97, 97);
			  b2.setBackground(c2);

		        
		        b1.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        		
	        	        try {
	        	        	//nolasam vçrtîbas no datu laukiem un pârveidojam tos no String uz double formâtu
	        	        	 String s1=t1.getText();  
			        		 double a=Double.parseDouble(s1);
			        		 String s2=t2.getText();  
			        		 double b=Double.parseDouble(s2);
			        		 String s3=t3.getText();  
			        		 double c=Double.parseDouble(s3);
			        		 String s4=t4.getText();  
			        		 double d=Double.parseDouble(s4);
			        		 
			        		 //aprçíinam nepiecieðamos râdîtâjus
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
	        	        	//dialoga logs, ja ievadîti nereâli lielumi
	        	        	JDialog d = new JDialog();
	        	        	JLabel l4 = new JLabel("Lûdzu ievadiet reâlas platîbas!");
	        	        	d.add(l4);
	        	            d.setSize(250,250);
	        				d.setLocation(50,250);
	        	        	d.setVisible(true);	        	        	
	        	        }
		        		
		        		
		        	        }  
		        	    });  
		        
		        b2.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        		//nodzçðam vçrtîbas, ja nospiesta attiecîgâ poga
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
		        		//faila saglabâðana
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
	double Zemesgab_platiba; //Zemesgabala platîba
	final int i = 100; //konstante, kura tiek izmantota formulâs	
}

//klase, kas aprçíina apbûves râdîtâjus
class ApbuvesRaditaji extends Zemesgabals  {
	double Celu_lauk; //Ceïi un autostâvvietas - laukums
	double Apbuves_lauk; //Çku apbûves laukums
	double Stavu_plat; //Stâvu platîba

	ApbuvesRaditaji (double a, double b, double c, double d) {
		Zemesgab_platiba = a;
		Apbuves_lauk = b;
		Celu_lauk = c;
		Stavu_plat = d;
	}
	
	double ApbBlivums() {
	      return Apbuves_lauk * i / Zemesgab_platiba;  //Aprçíina Apbûves blîvumu zemesgabalam
	}
  
	double ApbIntens() {
	      return Stavu_plat * i / Zemesgab_platiba;  //Aprçíina Apbûves intensitâti zemesgabalam
	}
	
	double BrivTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk - Celu_lauk) * i / Stavu_plat ;  //Aprçíina zemesgabala brîvo teritoriju
	}
  
	double Celi() {
	      return Celu_lauk * i / Zemesgab_platiba ;  //Aprçíina %, ko aizòem ceïi zemesgabalâ
	}
  
	double ZalTerit() {
	      return (Zemesgab_platiba - Apbuves_lauk -  Celu_lauk) * i / Zemesgab_platiba ;  //Aprçíina %, ko aizòem apzaïumojums zemesgabalâ
	}   
}


public class Kursa_darbs {

	public static void main(String[] args) {
		//Creating the Frame
	    JFrame f = new MansFrame();
	    f.setVisible (true);	
	}
}


