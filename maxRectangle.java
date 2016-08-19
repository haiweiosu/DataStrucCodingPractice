public class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        //这道题有些难, 我参考了这个link的思路
        //其中的那个用柱形图, height[]的思路很巧妙
        
        //link: http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
    
        int m = matrix.length;
        int n = m == 0 ? 0: matrix[0].length;
        
        int[][] height = new int[m][n+1];
        
        int maxArea = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else{
                    if (i == 0){
                        height[i][j] = 1;
                    }else{
                        height[i][j] = height[i-1][j] + 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++){
            int area = maxAreaInHist(height[i]);
            if (area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
}

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0; 
        int maxArea = 0; 
        while (i < height.length){
            if (stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }
            else{
                int t = stack.pop();
                maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
          return maxArea;
    }
}