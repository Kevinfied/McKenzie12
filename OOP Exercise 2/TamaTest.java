/* TamaTest.java
 * This is the very basic interface program for the Tamagotchi class.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class TamaTest extends JFrame implements ActionListener {
	JButton feed = new JButton("Feed");
	JButton play = new JButton("Play");
	JButton scold = new JButton("Scold");
	Tamagotchi pet;

	    
    public static void delay (long len)
    {
		try
		{
		    Thread.sleep (len);
		}
		catch (InterruptedException ex)
		{
		    System.out.println("I hate when my sleep is interrupted");
		}
    }
    
    public TamaTest()
    {
		super("Tamagotchi Tester");
		setSize(600,200);
		GridLayout controls = new GridLayout(1, 3, 10, 10);
		setLayout(controls);
		add(feed);
		add(play);
		add(scold);
		feed.addActionListener(this);
		play.addActionListener(this);
		scold.addActionListener(this);
		
		pet = new Tamagotchi("Spike");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);    
		setVisible(true);               
    }
    
    public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource ();
		if (source == feed)
		{
			System.out.println("FEED");
		    pet.feed();
		}
		else if (source == play)
		{
			System.out.println("PLAY");
		    pet.play();
		}
		else if (source == scold)
		{
			System.out.println("SCOLD");
		    pet.scold();
		}
    }
   
       
    public static void main(String []a){
		TamaTest frame=new TamaTest();
		while(true){
		    frame.setTitle("Pet Status: "+ frame.pet);
		    frame.repaint();
			frame.pet.age();
			delay(200);
		}
    }
}