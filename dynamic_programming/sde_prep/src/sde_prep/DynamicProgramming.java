package sde_prep;

public class DynamicProgramming {
	
	int count=0;
	
	public int get_possible_ways_count(int no_of_steps)
	{
		//one step at once, two steps at once or three steps at once
		//take n and then n-1, n-2 and n-3 and search each path to get to zero
		
		//no more steps left to walk over.
		if(no_of_steps<0)
			return 0;
		if(no_of_steps==0)
			return 1;
		return (get_possible_ways_count(no_of_steps-1) + 
				get_possible_ways_count(no_of_steps-2) + 
				get_possible_ways_count(no_of_steps-3));
	}
	
	public void robot_path(int[][] grid, int x, int y)
	{
		//find path for a robot walking on a grid with some banned squares
		if(grid == null)
			return;
		if(x<0 || y<0 || grid[x][y]<0)
			return;
		System.out.println("step=(x="+x+",y="+y+")");
		robot_path(grid, x-1, y);
		robot_path(grid, x, y-1);
	}
	
	public int finid_magic_index(int[] array, int start_index, int end_index)
	{
		//find an array magic index A[i]==i
		if(array==null)
			return 0;
		if(start_index>=end_index)
			return 0;
		int mid = (start_index+end_index)/2;
		if(array[mid]==mid)
			return mid;
		if(array[mid]>mid)
			finid_magic_index(array, 0, mid-1);
		else
			finid_magic_index(array, mid, end_index);
		return 0;
	}

	public static void main(String[] args) 
	{
		DynamicProgramming DP = new DynamicProgramming();	
		System.out.println("possible ways to go up the stairs="+DP.get_possible_ways_count(4));
		System.out.println("===================");
		int[][] gr = {{0,0,0,0},{0,-1,0,0},{0,-1,0,0},{-1,0,-1,0}};
		DP.robot_path(gr, 3, 3);
		System.out.println("===================");
		int[] array = {0,1,2,3,4,15,17,20,88};
		int magic = DP.finid_magic_index(array, 0, array.length-1);
		System.out.println(magic);
		
	}
}