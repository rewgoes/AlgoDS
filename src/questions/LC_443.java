package questions;

// https://leetcode.com/problems/string-compression/description/

public class LC_443 {

	public static int compress(char[] chars) {
        char cur = chars[0];
        int repeated = 1;
        int newSize = 0;
        
        for (int i = 1; i < chars.length; i++) {
            if (cur == chars[i]) {
                repeated++;
            } else {
                chars[newSize++] = cur;
                if (repeated >= 2) {
                    int powerTen = 10;
                    
                    while (repeated / powerTen > 0) {
                        powerTen *= 10;
                    }
                    powerTen /= 10;
                    
                    while (repeated > 10) {
                        chars[newSize++] = (char) ((repeated / powerTen) + '0');
                        repeated %= powerTen;
                        powerTen /= 10;
                    }                   
                    chars[newSize++] = (char) (repeated + '0');        
                }
                
                cur = chars[i];
                repeated = 1;
            }
        }
        
        if (repeated > 0) {
            chars[newSize++] = cur;
            if (repeated >= 2) {
                int powerTen = 10;
                    
                while (repeated / powerTen > 0) {
                    powerTen *= 10;
                }
                powerTen /= 10;
                    
                while (repeated > 10) {
                    chars[newSize++] = (char) ((repeated / powerTen) + '0');
                    repeated %= powerTen;
                    powerTen /= 10;
                }
                chars[newSize++] = (char) (repeated + '0');        
            }
        }
        
        return newSize;
    }
	
}
