//21. mâjasdarbs - Elîna Mûrniece

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

	
public class Md_21 extends JFrame {
	
	 public Md_21() {
			setTitle("Md_21 - Swing");
			setSize(600,400);		 
			setLocation(50,250); 
			
			addWindowListener(new WindowAdapter() {
			  	public void windowClosing(WindowEvent e) {
				   System.exit(0);
			  	} 
			} );
			
	        String msg = "";
	        JLabel m = new JLabel(msg);
	        
			
		    //JLabel klase
		      JLabel l1 = new JLabel("Label - paraugs Nr.1");
		      JLabel l2 = new JLabel("Label - paraugs Nr.2");
		      add (l1);
		      add (l2);
			
			//JButton klase
			JButton b1 = new JButton(" Nospied pogu! ");   
			JButton b2 = new JButton(" Bet nespied ðo pogu! ");
			add(b1);               
	        add(b2); 
	        
	        b1.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        	            m.setText(" Tu nospiedi pogu! ");  
	        	        }  
	        	    });  
	        
	        b2.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        	            m.setText(" Kâpçc tu nospiedi ðo pogu?!! ");  
	        	        }  
	        	    }); 

	    	//JCheckbox klase
	        JCheckBox ch = new JCheckBox("Checkbox paraugs", true);
		      add (ch);
		      
		      ch.addItemListener(new ItemListener() {    
		             public void itemStateChanged(ItemEvent e) {                 
		                m.setText("Checkbox: "     
		                + (e.getStateChange()==1?"checked":"unchecked"));    
		             }    
		          });    

		      //JComboBox klase
		      String colors[]={"Dzeltens","Zils","Sarkans","Violets","Balts"};
		      JComboBox cb=new JComboBox(colors);
		      add(cb); 
		      
		      cb.addActionListener(new ActionListener() {  
		          public void actionPerformed(ActionEvent e) {   
		        	  m.setText("Izvçlçtâ krâsa: " + colors[cb.getSelectedIndex()]); 
		          }  
		      });           

		  	//JList klase
		      String seasons[]={"Vasara","Rudens","Ziema","Pavasaris"};
		      JList lt=new JList(seasons);
		      add(lt); 
		      
		      //JScrollBar klase
		      JScrollBar s=new JScrollBar();  
		      add(s);
		      s.addAdjustmentListener(new AdjustmentListener() {  
		    	    public void adjustmentValueChanged(AdjustmentEvent e) {  
		    	       m.setText("Vertical Scrollbar value is:"+ s.getValue());  
		    	    }  
		    	 });  
		      
		  	//JTextField un JPasswordField klase
		      JTextField name = new JTextField("lietotâjvârds",15);
		      JPasswordField password = new JPasswordField ("parole",10);
		      add(name);
		      add(password);
		      
		      name.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        	            m.setText("Teksts teksta laukâ: "+ name.getText());  
		        	        }  
		        	    });
		      
		      password.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        	            m.setText("Parole: "+ password.getPassword());  
		        	        }  
		        	    });
		      
		      //JTextArea klase	
		      JTextArea comment = new JTextArea ("komentâri", 11, 33);
		      add(comment);
		      
			  JButton b3 = new JButton(" Text area vçrtîba ");
			  add(b3); 
		      
		      b3.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		        		String text=comment.getText(); 
		        	    m.setText("Characters: "+text.length());  
		        	        }  
		        	    });
		      
	    	//FlowLayout klase	
	        setLayout(new FlowLayout(FlowLayout.LEFT));
	        
	         
	        
	    	//JFileChooser klase	      

			JButton b4 = new JButton(" Izvçlçties failu ");
			add(b4); 
	                 
		      b4.addActionListener(new ActionListener(){  
		        	public void actionPerformed(ActionEvent e){  
		    	        JFileChooser fc=new JFileChooser(); 
		    	        int returnValue = fc.showOpenDialog(null);
		        	        }  
		        	    });  
		      
		      //JOptionPane
		      String n=JOptionPane.showInputDialog("Enter Name"); 
		      
		      add(m); 
		 
	 
	 		//JMenu	 
	 		JMenuBar mb=new JMenuBar();  
	 		JMenu sn=new JMenu(" Gadalaiki ");  
	 		JMenu cl=new JMenu(" Krâsas ");
	 		
	 		JMenuItem i1=new JMenuItem(" Vasara ");
	 		JMenuItem i2=new JMenuItem(" Rudens ");
	 		JMenuItem i3=new JMenuItem(" Ziema ");
	 		JMenuItem i4=new JMenuItem(" Pavasaris ");
	 		sn.add(i1);
	 		sn.add(i2);
	 		sn.add(i3);
	 		sn.add(i4);
	 		
	 		JMenu cl1=new JMenu(" Papildkrâsas ");
	 		JMenu cl2=new JMenu(" Pamatkrâsas ");
	 		
	 		JMenuItem i5=new JMenuItem(" Balts ");
	 		cl1.add(i5);
	 		JMenu cl3=new JMenu(" Violets ");
	 		
	 		JMenuItem i6=new JMenuItem(" Gaiði violets ");
	 		JMenuItem i7=new JMenuItem(" Tumði violets ");
	 		cl3.add(i6);
	 		cl3.add(i7);
	 		
	 		JMenuItem i8=new JMenuItem(" Dzeltens ");
	 		JMenuItem i9=new JMenuItem(" Sarkans ");
	 		JMenuItem i10=new JMenuItem(" Zils ");
	 		cl2.add(i8);
	 		cl2.add(i9);
	 		cl2.add(i10);
	 			 		
	 		mb.add(sn);
	 		mb.add(cl);
	 		cl.add(cl1);
	 		cl.add(cl2);
	 		cl1.add(cl3);
	        setJMenuBar(mb); 
	 }
	 
	  public static void main(String[] args) {
		    JFrame f = new Md_21();
		    f.setVisible (true);	
		  }
}


