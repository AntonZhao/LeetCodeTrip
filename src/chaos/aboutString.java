package chaos;

public class aboutString {
    public static void main(String[] args) {
        String s2 = new String("hello");
        s2 = s2.intern();
        String s1 = "hello";
        System.out.println(s1 == s2);

        String s3 = new String("hello ") + new String("world");
//        String s3 = new String("hello world");
//        s3 = s3.intern();
        s3.intern();
        String s4 = "hello world";
        System.out.println(s3 == s4);

        String s5 = "hello ";
        String s6 = "world";
        String s7 = s5 + s6;
        String s8 = "hello world";
        System.out.println(s7 == s8);
    }
}
