package practiseprograms.strings;

public class NewLineString {
    public static void main(String[] args)
    {
        // Calling the System.lineSeparator() function to
        // print newline in between some specified strings
        String newline = System.lineSeparator();

        // Printing new line
        System.out.println("GFG" + newline + "gfg");
        System.out.println("GFG" + '\n' + "gfg");

    }
}
