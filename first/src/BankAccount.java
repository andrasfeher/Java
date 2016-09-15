public class BankAccount {
	private String ownerName;
	private String ownerAddress;
	private double balance;

	public void setOwnerName(String value){
		ownerName = value;
	}
	
	public void setOwnerAddress(String value){
		ownerAddress = value;
	}
	
	public void setBalance(double value){
		balance = value;
	}
	
	public String getOwnerName(){
		return ownerName;
	}
	
	public String getOwnerAddress(){
		return ownerAddress;
	}
	
	public double getBalance(){
		return balance;
	}

	
	/* pénzműveletknél jobb a BigDecimal API osztályt használni*/
	public double calculateInterest(double rate){
		return balance * rate / 100;
	}
	
}
