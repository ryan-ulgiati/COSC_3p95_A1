public class Main {

    public static String results(String input) { //this function is the delta debugging

        if (input.length() == 1) { //if input is only 1 digit long and cannot be split anymore
            boolean i_r = processString(input);
            if (i_r) {
                return input;
            }
            else return "";
        }

        //here it splits the input in half
        String pt1 = input.substring(0,input.length()/2);
        String pt2 = input.substring(input.length()/2);

        //checks to see if there are bugs in each half
        boolean pt1_r = processString(pt1);
        boolean pt2_r = processString(pt2);


        if (pt1_r || pt2_r) { //if a bug is detected
            return results(pt1) + results(pt2); //adds both sides, recursively splitting and checking for bugs to find the minimum case that causes the error
        }

        else return ""; //returns empty if there are no bugs
    }

    public static boolean processString(String input) { //the code from the assignment, returns a boolean instead of the string because we already know that the error is caused if there is a number.
        // If we instead take the string value, splitting the result in delta debugging becomes an issue because the string becomes longer
        String output = "";
        for (int i = 0; i <input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                output += Character.toLowerCase(input.charAt(i));
            }
            else if (Character.isDigit(input.charAt(i))) {
                int x = (int)(input.charAt(i) - '0');
                x = x*2;
                output += x;
                return true; //error detected
            }
            else {
                output += Character.toUpperCase(input.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] s = {"abcdefG1","CCDDEExy","1234567b", "8665"};
        for (int z = 0; z < s.length; z++) {
            System.out.println("Input: "+s[z]+", Ouput: "+results(s[z]));
        }
    }
}