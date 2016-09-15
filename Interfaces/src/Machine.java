
public class Machine implements ICanGiveInfo {
	
	private int id;

	public Machine(int id) {
		this.id = id;
	}

	public void showInfo() {

		System.out.println(id);
		
	}

}
