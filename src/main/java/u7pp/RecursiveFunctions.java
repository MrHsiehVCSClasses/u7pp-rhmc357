package u7pp;

public class RecursiveFunctions {
    RecursiveFunctions(){
    }

    //Takes in an integer
    //returns a double that is the factorial of that integer
    //Precondition: the argument is non-negative
    public static double factorial(int input){
        if (input <= 1){
            return 1;
        }
        else {
            return input*factorial((input-1));
        }
    }

    //Takes in a base and a power
    //Returns a double that is base raised to the power
    //Precondition: power is a positive integer
    public static Double pow(double base, int exp) {
        if (exp == 0){
            return 1.0;
        }
        else{
            return base * pow(base, exp-1);
        }
    }

    //Takes in an integer digit 
    //returns the *digitth* term in the Fibonacci sequence
    //the 0th term is `0` and the 1st term is `1`
    //Precondition: `digit` is a non-negative integer
    public static Integer fibonacci(int digit) {
        if(digit == 1 || digit == 0){
            return digit;
        }
        else{
            return fibonacci(digit-1) + fibonacci(digit -2);
        }
    }

    //Takes in a string
    //returns true if the string is a palindrome, false otherwise.
    public static boolean isPalindrome(String string) {
        if (string.length() == 1 || string.length() == 0){
            return true;
        }
        else if (string.charAt(0) ==(string.charAt(string.length()-1))){
            return isPalindrome(string.substring(1,string.length()-1));
        }
        return false;
    }

    //Given an array, returns an `int` counting how many pairs of adjacent integers 
    //where the right integer is double the left one
    //Precondition: the given array has at least 1 element
    public static Integer nextIsDouble(int[] data, int i) {
        if (data.length == 0 || data.length == 1 || data[i] == data[i+1]){
            return 0;
        }
        if (i+1 >= data.length-1){
            return 1;
        }
        else if(data[i+1] / data[i] == 2){
            return 1 + nextIsDouble(data, i+1);
        }
        return nextIsDouble(data, i+1);
    }

    //Takes in an int 
    //returns a String of its binary representation
    //Precondition: the argument is a positive integer
    public static String getBinary(int num) {
        if (num == 0){
            return "0";
        }
        if (num == 1){
            return "1";
        }
        else {
            return getBinary(num/2) + getBinary(num%2);
        }
    }

    //Takes in an array and a value to search for
    //If the value is in the array, it returns the index of the value
    //Otherwise, return -1
    public static Integer binarySearch(int[] list, int num, int start, int end) {
        if (start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if (num == list[mid]){
            return mid; 
        }
        else if (num < list[mid]){
            return binarySearch(list, num, start, mid -1);
        }
        else { //if (num > list[mid])
            return binarySearch(list, num, mid + 1, end);
        }
    }

    //returns true if a drop of water starting at the location specified 
    //by row, column can reach the edge of the map, false otherwise
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        if (row + 1 >= map.length || row -1 < 0 || col + 1 >= map[0].length || col -1 < 0){
            return true;
        }
        //left
        else if (map[row][col - 1] < map [row][col] && canFlowOffMap(map, row, col-1)){
            return true;
        }
        //right
        else if (map[row][col + 1] < map [row][col] && canFlowOffMap(map, row, col+1)){
            return true;
        }
        //up
        else if (map[row - 1][col] < map [row][col] && canFlowOffMap(map, row -1, col)){
            return true;
        }
        //down
        else if (map[row + 1][col] < map [row][col] && canFlowOffMap(map, row +1, col)){
            return true;
        }
        //final
        else {
            return false;
        }
    }
}
