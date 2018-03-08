package _101_200;

public class _158_readNCharactersGivenRead4II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];
	
	public int read(char[] buf, int n) {
		int ptr = 0;
		while(ptr < n) {
			if(buffPtr == 0) {
				buffCnt = read4(buff);
			}
			
			if(buffCnt == 0) {
				break;
			}
			
			while(ptr < n && buffPtr < buffCnt) {
				buf[ptr++] = buff[buffPtr++];
			}
			
			if(buffPtr >= buffCnt) {
				buffPtr = 0;
			}
		}
		
		return ptr;
	}
	
	public int read4(char[] buf) {
		return 0;
	}
}
