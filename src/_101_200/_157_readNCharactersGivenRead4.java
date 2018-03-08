package _101_200;

public class _157_readNCharactersGivenRead4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int read(char[] buf, int n) {
		char[] buffer = new char[4];
		boolean endOfFile = false;
		int readBytes = 0;
		
		while(readBytes < n && !endOfFile) {
			int currReadBytes = read4(buffer);
			if(currReadBytes != 4) {
				endOfFile = true;
			}
			
			int length = Math.min(n - readBytes, currReadBytes);
			for(int i = 0; i < length; i++) {
				buf[readBytes + i] = buffer[i];
			}
			
			readBytes += length;
		}
		
		return readBytes;
	}
	
	
	public static int read4(char[] buf) {
		return 0;
	}
}
