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
		
		// System.out.println("Szeretni fogod a Javát");
		
		/*
		JFrame ablak = new JFrame();
		String fejlec = "Ablak fejléc" + (2 + 2);
		
		ablak.setTitle(fejlec);
		ablak.setSize(300,200);
		ablak.setLocation(150,150);
		ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ablak.setVisible(true);
		*/
		
		/*
		Scanner keyboard = new Scanner(System.in);
		
		out.println("Írj be egy egészet 1 és 10 között");
		
		int inputNr = keyboard.nextInt();
		int randomNr = new Random().nextInt(10) + 1;
		
		if (inputNr == randomNr){
			out.println("***************");
			out.println("*** Nyertél ***");
			out.println("***************");
		} else {
			out.println("*****************************************");
			out.println("*** Vesztettél. A helyes szám " + randomNr + " volt. ***");
			out.println("*****************************************");
		}
		*/

		/*
		Scanner keyboard = new Scanner(System.in);
		
		out.println("Jelszó:");
		
		String inputPassword = keyboard.next();
		
		if (inputPassword.equals("kardhal")){
			out.println("******************");
			out.println("*** Beléphetsz ***");
			out.println("******************");
		} else {
			out.println("***********************");
			out.println("*** Nem léphetsz be ***");
			out.println("***********************");
		}
		*/
		
		/*
		String username = 
				JOptionPane.showInputDialog("Felhasználónév");
		String password =
				JOptionPane.showInputDialog("Jelszó");
		
		if (username != null &&
			password != null &&
			(
					(username.equals("füli") &&
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
			JOptionPane.showMessageDialog(null, "gyanús vagy");
		}
		
		*/
		/*
		File f = new File("c:\\xx.txt");
		Scanner keyboard = new Scanner(System.in);
		char valasz;
		
		do{
			out.println("Törli a fájlt?");
			valasz = keyboard.findWithinHorizon(".", 0).charAt(0); // az API-ban nincs nextChar
		} while (valasz != 'i' && valasz != 'n');
		
		if (valasz == 'i'){
			out.println("Oké gyerünk ...");
			f.delete();
			out.println("Törölve");
		} else {
			out.println("Megmarad");
		}
		*/
		
		
		/* JavaBeans: meglévõ GUI-khoz kapcsolódáshoz módszer*/
		
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
