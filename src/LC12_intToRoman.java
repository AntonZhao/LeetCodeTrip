public class LC12_intToRoman {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                builder.append(symbols[i]);
                num -= values[i];
            }
        }
        return builder.toString();
    }


    public String intToRoman2(int num) {
        int QIAN = num / 1000;
        int BAI = (num % 1000) / 100;
        int SHI = (num % 100) / 10;
        int GE = num % 10;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < QIAN; i++) {
            builder.append("M");
        }

        if (BAI == 1) builder.append("C");
        else if (BAI == 2) builder.append("CC");
        else if (BAI == 3) builder.append("CCC");
        else if (BAI == 4) builder.append("CD");
        else if (BAI == 5) builder.append("D");
        else if (BAI == 6) builder.append("DC");
        else if (BAI == 7) builder.append("DCC");
        else if (BAI == 8) builder.append("DCCC");
        else if (BAI == 9) builder.append("CM");

        if (SHI == 1) builder.append("X");
        else if (SHI == 2) builder.append("XX");
        else if (SHI == 3) builder.append("XXX");
        else if (SHI == 4) builder.append("XL");
        else if (SHI == 5) builder.append("L");
        else if (SHI == 6) builder.append("LX");
        else if (SHI == 7) builder.append("LXX");
        else if (SHI == 8) builder.append("LXXX");
        else if (SHI == 9) builder.append("XC");

        if (GE == 1) builder.append("I");
        else if (GE == 2) builder.append("II");
        else if (GE == 3) builder.append("III");
        else if (GE == 4) builder.append("IV");
        else if (GE == 5) builder.append("V");
        else if (GE == 6) builder.append("VI");
        else if (GE == 7) builder.append("VII");
        else if (GE == 8) builder.append("VIII");
        else if (GE == 9) builder.append("IX");

        return builder.toString();
    }
}
