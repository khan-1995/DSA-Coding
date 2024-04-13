/*
https://leetcode.com/discuss/interview-question/5008707/Salesforce-ATMS-Online-Assessment-April-2024
Question :

You are given the coordinates of a set of points in X and Y axis as an array of pair of integers. You need to find the densest rectangle that can be created from these points.

The density of a rectangle is defined as the number of points inside the rectangle divided by the area of the rectangle. Once you have found out the densest rectangle, return the density of the rectangle.

If it is not possible to create any rectangle from the given set of points, return -1.0

Input:

1.  A list of points N where 0 <N<1000. Each point will have two integer values (x, y) denoting X and Y coordinates of the point. -MAXINT <= x <= MAXINT and - MAXINT <y<< MAXINT.  

Output:

1. The density of the densest rectangle, as

a floating point number.

Example:

1. [[0,1] [0, 10], [10,1], [10,10], [2. 3]]

In this case, the first four points can forma rectangle with area of 90. The fifth point lies inside this rectangle. So, the highest density that can be obtained is 1/90 =0.011

2. ([0.1] [0, 101 (10,11 [10,10) 1

In this case, the four points can form arectangle, but there are no points insidethis rectangle. So, the highest density is0.0

3. [[0,1], [0, 101 [10,1], [2. 3])

in this case, no rectangle can be created with the given numbers. So, return -1.0

*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] points1 = {{0, 1}, {0, 10}, {10, 1}, {10, 10}, {2, 3}};
        System.out.println(densestRectangle(points1)); // Output: 0.011
        
        int[][] points2 = {{0, 1}, {0, 10}, {10, 1}, {10, 10}};
        System.out.println(densestRectangle(points2)); // Output: 0.0
        
        int[][] points3 = {{0, 1}, {0, 10}, {10, 1}, {2, 3}};
        System.out.println(densestRectangle(points3)); // Output: -1.0
    }

    public static double densestRectangle(int[][] points) {
        double maxDensity = -1.0;
        
        // Compress x and y coordinates
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        int index = 1;
        for (int[] point : points) {
            xMap.put(point[0], index);
            yMap.put(point[1], index);
            index++;
        }
        
        // Sort the compressed x and y coordinates
        List<Integer> xList = new ArrayList<>(xMap.values());
        Collections.sort(xList);
        List<Integer> yList = new ArrayList<>(yMap.values());
        Collections.sort(yList);
        
        // Iterate over all pairs of points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                // Calculate area of the rectangle
                int area = Math.abs((xMap.get(p2[0]) - xMap.get(p1[0])) * (yMap.get(p2[1]) - yMap.get(p1[1])));

                // Calculate density
                double density = calculateDensity(points, xList, yList, xMap.get(p1[0]), yMap.get(p1[1]), xMap.get(p2[0]), yMap.get(p2[1]));

                // Update max density if found
                maxDensity = Math.max(maxDensity, density);
            }
        }

        return maxDensity == -1.0 ? -1.0 : maxDensity;
    }
    
    private static double calculateDensity(int[][] points, List<Integer> xList, List<Integer> yList, int x1, int y1, int x2, int y2) {
        double area = Math.abs((x2 - x1) * (y2 - y1));
        int count = 0;
        
        // Iterate over all points
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            
            // Check if the point lies inside the rectangle
            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                count++;
            }
        }
        
        // Calculate density
        return count == 0 || area == 0 ? -1 : count / area;
    }
}


