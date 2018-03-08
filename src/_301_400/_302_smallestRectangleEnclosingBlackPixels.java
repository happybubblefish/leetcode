package _301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _302_smallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		char[][] image = {
				{ '0', '0', '1', '0' },
				{ '0', '1', '1', '0' },
				{ '0', '1', '0', '0' }
		};
		
		System.out.println(minArea(image, 0, 2));
	}

	/*
	An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

			For example, given the following image:

			[
			  "0010",
			  "0110",
			  "0100"
			]
			and x = 0, y = 2,
			Return 6.
	*/

	
	public static int minArea(char[][] image, int x, int y) {
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		
		int rows = image.length;
		int cols = image[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(image[i][j] == '1') {
					row.add(i);
					col.add(j);
				}
			}
		}
		
		Collections.sort(row);
		Collections.sort(col);
		
		return (row.get(row.size() - 1) - row.get(0) + 1) * (col.get(col.size() - 1) - col.get(0) + 1);
	}
}
