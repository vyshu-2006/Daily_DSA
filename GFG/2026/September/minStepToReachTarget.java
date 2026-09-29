class Solution {
	
	class Pair {
		int r;
		int c;
		int step;
		
		Pair(int r, int c, int step) {
			this.r = r;
			this.c = c;
			this.step = step;
		}
	}
	
	int directions[][] = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};
	
	public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
		// code here
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(knightPos[0] - 1, knightPos[1] - 1, 0));
		boolean isVis[][] = new boolean[n][n];
		int min = Integer.MAX_VALUE;
		
		while (!q.isEmpty()) {
			Pair curr = q.remove();
			int r = curr.r;
			int c = curr.c;
			int steps = curr.step;
			
			if (r == (targetPos[0] - 1) && c == (targetPos[1] - 1)) {
				min = Math.min(min, steps);
				continue;
			}
			
			for (int dir[] : directions) {
				int nr = r + dir[0];
				int nc = c + dir[1];
				
				if (nr < 0 || nc < 0 || nr >= n || nc >= n || isVis[nr][nc]) {
					continue;
				}
				isVis[nr][nc] = true;
				
				q.add(new Pair(nr, nc, steps+1));
			}
		}
		
		return min;
	}
}
