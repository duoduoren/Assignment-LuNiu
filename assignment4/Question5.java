package assignment4;


class Question5 { // score 2
	
    String intToRoman(int num) {
        String[] dict= new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
        StringBuilder res = new StringBuilder();
        for(int i=0; i<13; i++) {
            if(num>=val[i]) {
                int count = num/val[i];
                num %= val[i];
                for(int j=0; j<count; j++) {
                    res.append(dict[i]);
                }
            }
        }
        
        return res.toString();
    }
}
