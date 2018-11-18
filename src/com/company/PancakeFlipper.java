package com.company;

public class PancakeFlipper {

    public static void main(String[] args) {
        System.out.println(solve("---+-++- 3"));
        System.out.println(solve("+++++ 4"));
        System.out.println(solve("-+-+- 4"));
    }

    public static String solve(String data){
        String[] split = data.split(" ");

        char[] pancakepattern = split[0].toCharArray();
        int minflips = Integer.parseInt(split[1]);
        int totalk_flips = 0;
        int current_flips = 0;

        for (int i = 0; i < pancakepattern.length; i++) {
            if (pancakepattern[i] == '-') {
                totalk_flips++;
                if (i + minflips - 1 < pancakepattern.length){
                    current_flips = 0;
                    while(current_flips < minflips) {
                        if (pancakepattern[i + current_flips] == '-') {
                            pancakepattern[i + current_flips] = '+';
                        } else {
                            pancakepattern[i + current_flips] = '-';
                        }
                        current_flips++;
                    }
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return String.valueOf(totalk_flips);
    }
}
