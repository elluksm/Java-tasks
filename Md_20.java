//20. mâjasdarbs - Elîna Mûrniece

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="Md_20" width=600 height=400>
</applet>
*/


public class Md_20 extends Applet implements ActionListener, ItemListener {
    String m = "";
    Button b1, b2;   
    Checkbox ch;
    Choice x;
    List y;
    TextField name, password;
    MyButton myButton;
    static int i = 0;
    
	   public void init() {
		   
    //Label klase
		      Label l1 = new Label("Label - paraugs Nr.1");
		      Label l2 = new Label("Label - paraugs Nr.2");

		      add (l1);
		      add (l2);
	
	//Button klase
		      b1 = new Button(" Nospied pogu! ");
		      b2 = new Button(" Bet nespied ðo pogu! ");

		      add(b1);
		      add(b2);
		      
		      b1.addActionListener(this);
		      b2.addActionListener(this);
		      
	//Checkbox klase
		      ch = new Checkbox("Checkbox paraugs", true);
		      add (ch);
		      ch.addItemListener(this);

	//Choice klase
		      x = new Choice();
		      x.add("Dzeltens");
		      x.add("Zils");
		      x.add("Sarkans");
		      x.add("Violets");
		      x.add("Balts");
		      add(x);
		      
	//List klase
		      y = new List (4, true);
		      y.add("Vasara");
		      y.add("Rudens");
		      y.add("Ziema");
		      y.add("Pavasaris");
		      add(y);
		      
	//TextField klase
		      name = new TextField("lietotâjvârds",15);
		      password = new TextField("parole",10);
		      password.setEchoChar('*');
		      add(name);
		      add(password);
		      
	//TextArea klase	
		      TextArea comment = new TextArea ("komentâri", 11, 33, TextArea.SCROLLBARS_VERTICAL_ONLY);
		      add(comment);
		      
	//FlowLayout klase	      
		      setLayout(new FlowLayout(FlowLayout.LEFT));
		      
	//Menu klases
		      Frame f;
		      f = new MenuFrame("Frame Menu");
		      f.setSize(250, 250);
		      f.setVisible(true);
		      
	//File Dialog klase	      
		      FileDialog w = new FileDialog(f, "File Dialog", FileDialog.LOAD);
		      w.setVisible(true);
		      
	//paplaðinâtâ Button klase
		      myButton = new MyButton("Cik reizes nospiedîsi pogu?");
		      add(myButton);		      
		   }

	   class MyButton extends Button {
	       public MyButton (String label) {
	         super(label);
	         enableEvents(AWTEvent.ACTION_EVENT_MASK);
	       }
	       protected void processActionEvent(ActionEvent ae) {
	         showStatus("Poga nospiesta: " + i++);
	         super.processActionEvent(ae);
	       }
	     }	      
	   	   
	   public void actionPerformed(ActionEvent ae) {
		      String str = ae.getActionCommand();
		      if (str.equals(" Nospied pogu! ")) {
		         m = " Tu nospiedi pogu! ";
		      }
		      else {
		         m  = "Kâpçc tu nospiedi ðo pogu?!!";
		      }
		      repaint();
		   }

	   public void itemStateChanged(ItemEvent ie) {
		   m = " Checkbox: " +ch.getState();
		      repaint();
		   }
	   
		   public void paint (Graphics g) {
		      g.drawString(m, 6, 300);
		   }
		  
}

//Menu klases
class MenuFrame extends Frame {
	   String msg = "";
	   CheckboxMenuItem debug, test;

	   MenuFrame(String title) {
	      super(title);

	      MenuBar mbar = new MenuBar();
	      setMenuBar(mbar);

	      Menu seasons = new Menu (" Gadalaiki ");
	      MenuItem item1, item2, item3, item4;
	      seasons.add(item1 = new MenuItem(" Vasara"));
	      seasons.add(item2 = new MenuItem(" Rudens "));
	      seasons.add(item3 = new MenuItem(" Ziema "));
	      seasons.add(item4 = new MenuItem(" Pavasaris "));
	      mbar.add(seasons);

	      Menu colors = new Menu (" Krâsas ");
	      Menu ck = new Menu (" Pamatkrâsas ");
	      MenuItem item5, item6, item7;
	      ck.add(item5 = new MenuItem(" Dzeltens "));
	      ck.add(item6 = new MenuItem(" Sarkans "));
	      ck.add(item7 = new MenuItem(" Zils "));
	      colors.add(ck);
	      MenuItem item8, item9;
	      colors.add(item8 = new MenuItem(" Violets "));
	      colors.add(item9 = new MenuItem(" Balts "));
	      mbar.add(colors);
	   }
}



