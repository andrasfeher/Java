import java.util.Random;

public class Maze {

	private Random rand = new Random();
	
	private int[][] maze;
	private int width;
	private int height;

	
	
	public Maze(int width, int height){
		
		this.width = width;
		this.height = height;
		
		generate();
	}
	
	protected void generate(){

		maze = new int[height][width];
		
		int counter = 1;
		
		do {

			int side = rand.nextInt(2) + 1; 

			if (counter % Math.round(width/height) == 0){
			
				if (side == 1){
					wallLeftRight();
				} else {
					wallRightLeft();
				}				
				
			} else {
				
				if (side == 1){
					wallUpDown();
				} else {
					wallDownUp();
				}
								
			}
			
			counter++;
			
			// is true when the number of walls = number of positions / 2	
		} while(!isMazeReady());
		
		// wallLeftRight();
		// wallRightLeft();
		// wallUpDown();
		// wallDownUp();
		
	}

	protected int getNextStartingVerticalPos(){

		// make sure that position is always uneven and within range
		return rand.nextInt((height - 1) / 2) * 2 + 1;
		
	}

	protected int getNextStartingHorizontalPos(){

		// make sure that position is always uneven and within range
		return rand.nextInt((width - 1) / 2) * 2 + 1;
		
	}
	
	
	protected void wallLeftRight(){
		
		int verticalStartPos = getNextStartingVerticalPos();
		
		for (int i = 0; i < width - 1; i++){
			
			if (maze[verticalStartPos][i] == 0 && maze[verticalStartPos][i + 1] == 0){
				maze[verticalStartPos][i] = 1;
			}
		}
	}
	
	
	protected void wallRightLeft(){

		int verticalStartPos = getNextStartingVerticalPos();
		
		for (int i = width - 1; i > 0; i--){
			
			if (maze[verticalStartPos][i] == 0 && maze[verticalStartPos][i - 1] == 0){
				maze[verticalStartPos][i] = 1;
			}
		}
		
	}
	
	protected void wallUpDown(){

		int horizontalStartPos = getNextStartingHorizontalPos();
		
		for (int i = 0; i < height - 1; i++){
			
			if (maze[i][horizontalStartPos] == 0 && maze[i + 1][horizontalStartPos] == 0){
				maze[i][horizontalStartPos] = 1;
			}
		}
		
	}
	
	protected void wallDownUp(){

		int horizontalStartPos = getNextStartingHorizontalPos();
		
		for (int i = height - 1; i > 0; i--){
			
			if (maze[i][horizontalStartPos] == 0 && maze[i - 1][horizontalStartPos] == 0){
				maze[i][horizontalStartPos] = 1;
			}
		}
		
	}
	
	protected boolean isMazeReady(){
		
		return (!isPossibleWallLeftRight()
				&& !isPossibleWallRightLeft()
				&& !isPossibleWallUpDown()
				&& !isPossibleWallDownUp()
		);
	}
	
	protected boolean isPossibleWallLeftRight(){

		boolean result = false;
		int verticalStartPos = 1;
		
		while (verticalStartPos < height - 1){
			
			if (result){break;}			
			
			int i = 0;
			
			while (i < width - 1){
				if (maze[verticalStartPos][i] == 0 && maze[verticalStartPos][i + 1] == 0){
					result = true;
					break;
				}
				
				i++;
			}
			
			verticalStartPos += 2;
		}

		return result;
		
	}
	
	protected boolean isPossibleWallRightLeft(){
		
		boolean result = false;
		int verticalStartPos = 1;
		
		while (verticalStartPos < height - 1){
			
			if (result){break;}			
			
			int i = width - 1;
			
			while (i > 0){
				if (maze[verticalStartPos][i] == 0 && maze[verticalStartPos][i - 1] == 0){
					result = true;
					break;
				}
				
				i--;
			}

			verticalStartPos += 2;
		}
		
		return result;		
		
	}
	
	protected boolean isPossibleWallUpDown(){
		
		boolean result = false;
		int horizontalStartPos = 1;
		
		while (horizontalStartPos < width - 1){
			
			if (result){break;}			
			
			int i = 0;
			
			while (i < height - 1){
				if (maze[i][horizontalStartPos] == 0 && maze[i + 1][horizontalStartPos] == 0){
					result = true;
					break;
				}
				
				i++;
			}
			
			horizontalStartPos += 2;
		}
		
		return result;			
		
	}
	
	
	protected boolean isPossibleWallDownUp(){
		
		boolean result = false;
		int horizontalStartPos = 1;
		
		while (horizontalStartPos < width - 1){
			
			if (result){break;}			
			
			int i = height - 1;
			
			while (i > 0){
				if (maze[i][horizontalStartPos] == 0 && maze[i - 1][horizontalStartPos] == 0){
					result = true;
					break;
				}
				
				i--;
			}

			horizontalStartPos += 2;
		}
		
		return result;			
	}
	
	
	public void draw(){
		
		drawHorizontalEdge();
		
		for (int i = 0; i < height; i++){
			drawRow(maze[i]);
		}
		
		drawHorizontalEdge();
		
	}
	
	protected void drawHorizontalEdge(){
		
		for (int i = 0; i < width + 2; i++){
			System.out.print("-");
		}
		
		System.out.println();
		
	}
	
	protected void drawRow(int[] row){
		
		System.out.print("|");

		for (int place: row){
			if (place == 0){
				System.out.print(" ");
			} else {
				System.out.print("*");	
			}
		}

		System.out.println("|");
		
	}

}
