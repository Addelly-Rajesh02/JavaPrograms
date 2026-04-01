package practiseprograms.strings;

import java.util.Scanner;

public class RemoveSpaces {
    public static String removeSpaces(String str){
        return str.replaceAll("\\s","");
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println("String before removing spaces: "+str);
        System.out.println("String after removing spaces: "+removeSpaces(str));
    }
}
