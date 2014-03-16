import java.io.*;

public class KnightsTour{

    private String[][]board = new String[5][5];
    private boolean solved = false;

    private void fillBoard(){
	for(int i = 0; i < 5; i++){
	    for(int j = 0; j < 5; j++){
	        board[i][j] = "0";
	    }
	}
    }
    public String toString(){
	String board = "";
	for(int i = 0; i < 5; i++){
	    for(int j = 0; j < 5; j++){
		board += (String)(this.board[i][j]);
		board += " ";
	    }
	    board += "\n";
	}
	return board;
    }

    public int getCur(){
	int cur = 0;
    	for(int i = 0; i < 5; i++){
	    for(int j = 0; j < 5; j++){
		try{
		    int n = Integer.parseInt(board[i][j]);
			if (n > cur){
			    cur = n;
			}
		}catch(Exception e){
		}
	    }
	}
	return cur;
    }

    public Boolean solve(int x, int y, int z){
	if ((x < 0) || (x >= 5) || (y < 0) || (y >= 5)){
	    return false;
	}
	if (visited(x,y) == true){
	    return false;
	}
	if (z == 25){
	    System.out.println("Solving complete");
	    visited(x,y) = true;
	    return true;
	}else{
	    try{
		Thread.sleep(50);
	    }catch(InterruptedException e){
		System.exit(0);
	    }
	    if (getCur() >= 25) {
		solved = true;
		System.out.println(toString());
		return;
	    }else if (board[x][y] == "0") {
		boolean result = false;
		board[x][y] = ((getCur() + 1) + "");
		System.out.println(toString()); 
		result = result || solve(x + 2, y + 1, z + 1);
		result = result || solve(x + 2, y - 1, z + 1);
		result = result || solve(x - 2, y + 1, z + 1);
		result = result || solve(x - 2, y - 1, z + 1);
		result = result || solve(x + 1, y + 2, z + 1);
		result = result || solve(x + 1, y - 2, z + 1);
		result = result || solve(x - 1, y + 2, z + 1);
		result = result || solve(x - 1, y - 2, z + 1);
		if (result){
		    return true;
		    System.out.println("" + x + "," + y);
		}
		
	    }
	}
	System.out.println(toString());
	
	
    }

    public static void main(String[]args) throws InterruptedException{
	KnightsTour k = new KnightsTour();
        k.fillBoard();

	System.out.println( "\r" + k.toString());
	k.solve(1,1,0);  

	
    }

}
