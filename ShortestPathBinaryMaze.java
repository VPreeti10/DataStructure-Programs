// Find the shortest path in a binary maze from (0,0) to (m,n) 

public class ShortestPathBinaryMaze {
	int N=4;
	public boolean solveMaze(int[][] maze) {
		int solMaze[][]= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		if(solveMazeUtil(maze, 0, 0, solMaze)==false) {
			System.out.println("No solution to  maze!");
			return false;
		}
		printSolution(solMaze);
		return true;
	}
	public boolean solveMazeUtil(int[][] maze,int x,int y,int[][] sol) {
		if(x==N-1 && y==N-1) {
			sol[x][y]=1;
			return true;
		}
	
		if(x>=0 && x<N && y>=0 &&y<N && maze[x][y]==1) {
				sol[x][y]=1;
				if(solveMazeUtil(maze, x+1, y, sol))
					return true;
				if(solveMazeUtil(maze, x, y+1, sol))
					return true;
				
				sol[x][y]=0;
				return false;
			}
			return false;	
		
	}
	public void printSolution(int[][] solMaze) {
		for(int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(solMaze[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void  main(String[] args) {
		ShortestPathBinaryMaze sbm=new ShortestPathBinaryMaze();
		int[][] maze= {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
		sbm.solveMaze(maze);
	}
}