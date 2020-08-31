public class BaseConversion {
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static String convert(int num, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;


        /* Use the faster version */
        if (radix == 10) {
            return String.valueOf(num);
        }

        char buf[] = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;

        if (!negative) {
            num = -num;
        }

        while (num <= -radix) {
            buf[charPos] = digits[-(num % radix)];
            System.out.println("charPos: " + charPos + " -(num % radix): " + -(num % radix) + " digit: " + digits[-(num % radix)]);
            charPos--;
            num = num / radix;
        }
        buf[charPos] = digits[-num];

        if (negative) {
            buf[--charPos] = '-';
        }

         return new String(buf, charPos, (33 - charPos));
    }

    public static void main(String[] args) {
        System.out.println(convert(123, 3));
    }
}
