public class FrameTest {

	public static void main(String[] args) 
		throws InterruptedException{
		
		MyFrame mf = new MyFrame();
		long counter = 0;
		
		/*
		while (true){
			mf.setBackgroundColorGreen();
			Thread.sleep(2000);
			mf.setBackgroundColorRed();
			Thread.sleep(2000);
		}
		*/
			
		while (!mf.isStopped()){
			mf.setCounterLabel(counter);
			counter++;
		}
		
		
	}

}




/*
public class FrameTest {


	public static void main(String[] args) {
		
		JFrame fr;
		JLabel lbInfo;
		JButton btOK, btNotOK;
		
		fr = new JFrame();
		
		fr.setTitle("Frame teszt");
		fr.setBounds(100,50,300,100);
		
		Container cp = fr.getContentPane();
		
		cp.setLayout(new FlowLayout());
		
		lbInfo = new JLabel("Döntsd el:");
		btOK = new JButton("OK");
		btNotOK = new JButton("Nem OK");
		
		cp.add(lbInfo);
		cp.add(btOK);
		cp.add(btNotOK);
		
		fr.setVisible(true);
		
		

	}

}
*/
