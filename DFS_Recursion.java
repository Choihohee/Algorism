package Algorism;

public class DFS_Recursion {
	//방문할 때 사용하는 배열을 선언
	static boolean[] visited = new boolean[9];
	// 그래프의 연결상태를 2차원 배열로 표현
	static int[][]graph = {{}, {2,3,8}, {1,6,8,}, 
			{1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	static void dfs(int nodeIndex) {
		visited[nodeIndex] = true;	//방문처리
		System.out.print(nodeIndex + "->");//방문 노드 출력
		
		//방문한 노드에 인접한 노드 찾기
		for(int node : graph[nodeIndex]) {
			//인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!visited[node])
				dfs(node);
		}	
	}
	
	public static void main(String[] args) {
		dfs(1);
	}
	
}
