package methods;

public class Methods
{

    public static void method()
    {
        System.out.println("Iam from method");
    }
    private static int method2(){
        return 1;
    }
    protected static String method3(){
        return "Iam method 3";
    }
    static void method4(){
        System.out.println("Iam method 4");
    }
    public void method5(){
        System.out.println("Iam non static method");
    }
    public static void main(String[] args)
    {
        method();
        System.out.println("Iam from method2 return value: "+method2());
        System.out.println(method3());
        method4();
        Methods methods=new Methods();
        methods.method5();

    }
}
