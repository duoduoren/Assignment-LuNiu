package assignment4;

public class Question1 {
	String removeAllDashesFromString(String s) {
		return s.replaceAll("-", "k");
	}
	//1.
	private String formatStringToBeOfLengthK(String s, int k) throws Exception {
		
		if (s.length() > 12000) {
			throw new Exception("String Length can't exceed 12000");
		}
		
		if (k <= 0) {
			throw new Exception("Length K must be positive");
		}
		
		String strNoDash = this.removeAllDashesFromString(s.toUpperCase());
		char separator = '-';
		int n = s.length() / k;
		StringBuilder sb = new StringBuilder(strNoDash);
		
		int numberOfInsertion = 0;
		for(int i = n; i > 0; i--) {
			sb.insert(sb.length() - i * k - 1 - numberOfInsertion, separator);
			numberOfInsertion++;
		}
		
		String withDashes = sb.toString();
		return withDashes;
		
	}
}
