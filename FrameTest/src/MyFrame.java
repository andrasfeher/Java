import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame
	implements ActionListener{
	
	protected JLabel lbCounter = new JLabel();
	protected boolean isStopped = false;

	public MyFrame() {
		JButton btStop;

		setTitle("Frame teszt");
		setBounds(100,50,300,125);
		lbCounter.setFont(new Font("Dialog", Font.PLAIN,40));

		btStop = new JButton("Stop");
		btStop.addActionListener(this);
		
		
		Container cp = getContentPane();
		
		// cp.setLayout(new FlowLayout());
		// cp.setLayout(new GridLayout(2,1));
		cp.setLayout(new BorderLayout(2,1));

		cp.add(lbCounter, "North");
		cp.add(btStop, "South");
		
		
		/*
		// cp.add(btStart);
		lbInfo = new JLabel("Döntsd el:");
		*/
		
		// cp.setBackground(Color.RED);	
		/*

		cp.add(btNotOK);
		*/
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// pack();
			
		
		setVisible(true);
	}
	
	public void setBackgroundColorRed(){
		this.getContentPane().setBackground(Color.RED);
	}

	public void setBackgroundColorGreen(){
		
		this.getContentPane().setBackground(Color.GREEN);
	}
	
	public void setCounterLabel(Long counter){
		lbCounter.setText(counter.toString());
		lbCounter.paintImmediately(lbCounter.getVisibleRect());
	}
	
	public boolean isStopped(){
		return isStopped;
	}
	
	public void actionPerformed(ActionEvent ev){
		isStopped = true;
	}
	
	
}
