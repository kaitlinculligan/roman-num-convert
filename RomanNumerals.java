/**
 * A basic convertor between the decimal number and roman numeral systems
 * @version 1.0
 * @since 1.0
 * @author Kaitlin Culligan <a href="mailto:kaitlinculligan@gmail.com">kaitlinculligan@gmail.com</a>
 */
public class RomanNumerals {
    
    public static void main(String[] args){
        //use args to determine number to convert, and select mode
        RomanNumerals r = new RomanNumerals();
        String answer;
        if(args[0].equals("0")){
            answer = r.decimalToRoman(Integer.parseInt(args[1]), 1000, " ");
        }else{
            answer = String.valueOf(r.romanToDecimal(args[1]));
        }
        System.out.println("The input converts to:" + answer);
    }


    /**
     * converts a given roman numeral to its decimal equivalent
     * @param toConvert the roman numeral to convert
     * @return roman numeral as a decimal number
     */
    public int romanToDecimal(String toConvert){
        int answer = 0;
        for(int i =0; i < toConvert.length(); i++){
            if(toConvert.charAt(i)=='I'&&(toConvert.charAt(i+1)!='I'&& i+1!=toConvert.length())){
                answer+=convertNotNice(toConvert.substring(i, i+1));
                i++;
            }else{
                answer += charToNum(toConvert.charAt(i));
            }
        }
        return answer;
    }

    /**
     *  converts a number to a roman numeral recursively
     * @param toConvert the number to convert
     * @param startingNum the closest number that translates to a roman numeral
     * that is bigger than toConvert
     * @param answer the roman numeral in its current state
     * @return roman numeral
     */
    public String decimalToRoman(int toConvert, int startingNum, String answer){
       if(toConvert == 0){
           return answer;
       }
       if(!checkIfGood(toConvert)){
            answer = answer + convertNotNice(toConvert);
            return answer;
       }

       if(toConvert < startingNum){
        return decimalToRoman(toConvert, nextDown(startingNum), answer);
       }else if(toConvert == startingNum){
        return decimalToRoman(toConvert - startingNum, nextDown(startingNum), answer+numToChar(startingNum));
       }else{
        return decimalToRoman(toConvert - startingNum, startingNum, answer+numToChar(startingNum));
       }

    }

    /**
     * convertor from number to numeral
     * @param num number to convert
     * @return equivalent numeral
     */
    private String numToChar(int num){
        if(num==1000){
            return "M";
        }
        else if(num == 500){
            return "D";
        }
        else if(num == 100){
            return "C";
        }
        else if(num == 50){
            return "L";
        }
        else if(num == 10){
            return "X";
        }
        else if(num == 5){
            return "V";
        }
        else{
            return "I";
        }
        
    }

    /**
     * convertor from numeral to number
     * @param c numeral to convert
     * @return equivalent number
     */
    private int charToNum(char c){
        if(c == 'M'){
            return 1000;
        }
        else if(c == 'D'){
            return 500;
        }
        else if(c == 'C'){
            return 100;
        }
        else if(c == 'L'){
            return 50;
        }
        else if(c == 'X'){
            return 10;
        }
        else if(c == 'V'){
            return 5;
        }
        else{
            return 1;
        }
    }

    /**
     * finds the next number that translates to a numeral in decreasing order
     * @param num number to decrement down
     * @return next number that can be a numeral down
     */
    private int nextDown(int num){
        if(num==1000){
            return 500;
        }
        else if(num == 500){
            return 100;
        }
        else if(num == 100){
            return 50;
        }
        else if(num == 50){
            return 10;
        }
        else if(num == 10){
            return 5;
        }
        else{
            return 1;
        }
    }

    /**
     * converts numerals representing 4's and 9's
     * @param s numeral to convert
     * @return numeral as a number
     */
    private int convertNotNice(String s){
        if(s.equals("IM")){
            return 999;
        }
        else if(s.equals("ID")){
            return 499;
        }
        else if(s.equals("IC")){
            return 99;
        }
        else if(s.equals("IL")){
            return 49;
        }
        else if(s.equals("IX")){
            return 9;
        }
        else{
            return 4;
        }
    }

    /**
     * converts 4's and 9's to numerals
     * @param s number to convert
     * @return number as a numeral
     */
    private String convertNotNice(int s){
        if(s == 999){
            return "IM";
        }
        else if(s == 499){
            return "ID";
        }
        else if(s == 99){
            return "IC";
        }
        else if(s == 49){
            return "IL";
        }
        else if(s == 9){
            return "IX";
        }
        else{
            return "IV";
        }
    }

    /**
     * checks if a number is a 4 or 9 ending
     * @param s number to check
     * @return true if it is not 4 or 9 ending, false if it is
     */
    private boolean checkIfGood(int s){
        if( s==999|s==499||s==99||s==49||s==9||s==4){
            return false;
        }
        return true;
    }
}
