// import javax.swing.JFrame;
/*
import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;
*/

// import javax.swing.JOptionPane;

/*
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;
*/

import static java.lang.System.out;


public class Display {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.out.println("Szeretni fogod a Jav�t");
		
		/*
		JFrame ablak = new JFrame();
		String fejlec = "Ablak fejl�c" + (2 + 2);
		
		ablak.setTitle(fejlec);
		ablak.setSize(300,200);
		ablak.setLocation(150,150);
		ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ablak.setVisible(true);
		*/
		
		/*
		Scanner keyboard = new Scanner(System.in);
		
		out.println("�rj be egy eg�szet 1 �s 10 k�z�tt");
		
		int inputNr = keyboard.nextInt();
		int randomNr = new Random().nextInt(10) + 1;
		
		if (inputNr == randomNr){
			out.println("***************");
			out.println("*** Nyert�l ***");
			out.println("***************");
		} else {
			out.println("*****************************************");
			out.println("*** Vesztett�l. A helyes sz�m " + randomNr + " volt. ***");
			out.println("*****************************************");
		}
		*/

		/*
		Scanner keyboard = new Scanner(System.in);
		
		out.println("Jelsz�:");
		
		String inputPassword = keyboard.next();
		
		if (inputPassword.equals("kardhal")){
			out.println("******************");
			out.println("*** Bel�phetsz ***");
			out.println("******************");
		} else {
			out.println("***********************");
			out.println("*** Nem l�phetsz be ***");
			out.println("***********************");
		}
		*/
		
		/*
		String username = 
				JOptionPane.showInputDialog("Felhaszn�l�n�v");
		String password =
				JOptionPane.showInputDialog("Jelsz�");
		
		if (username != null &&
			password != null &&
			(
					(username.equals("f�li") &&
					 password.equals("kardhal")
					) ||
					(username.equals("laci") &&
					 password.equals("pajzs")
					)
					
			)
			)
		{
			JOptionPane.showMessageDialog(null, "bent vagy");
		} else {
			JOptionPane.showMessageDialog(null, "gyan�s vagy");
		}
		
		*/
		/*
		File f = new File("c:\\xx.txt");
		Scanner keyboard = new Scanner(System.in);
		char valasz;
		
		do{
			out.println("T�rli a f�jlt?");
			valasz = keyboard.findWithinHorizon(".", 0).charAt(0); // az API-ban nincs nextChar
		} while (valasz != 'i' && valasz != 'n');
		
		if (valasz == 'i'){
			out.println("Ok� gyer�nk ...");
			f.delete();
			out.println("T�r�lve");
		} else {
			out.println("Megmarad");
		}
		*/
		
		
		/* JavaBeans: megl�v� GUI-khoz kapcsol�d�shoz m�dszer*/
		
		BankAccount myAccount   = new BankAccount();

		myAccount.setOwnerAddress("addr: ogjksdfogj");
		myAccount.setOwnerName("AF");
		myAccount.setBalance(50);
		
		out.println("my account:");
		out.println(myAccount.getOwnerAddress());
		out.println(myAccount.getOwnerName());
		out.printf("%4.2f \r\n", myAccount.getBalance());	
		out.printf("%4.2f \r\n", myAccount.calculateInterest(20));

		
	}
	
}
