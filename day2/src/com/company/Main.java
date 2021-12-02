package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{

    static String[] readFile(String filename) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            return null;
        }

        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    static void part1(){
        int h = 0;
        int d = 0;
        int aim = 0;
        String[] data = readFile("C:/Users/Mattias/code/AOC-2021/day2/inputData.txt");
        for (String dir : data) {
            String[] arrofString = dir.split(" ", 2);
            int units = Integer.parseInt(arrofString[1]);
            switch (arrofString[0]){
                case "forward":
                    h+=units;
                    d+=aim*units;
                    break;
                case "down":
                    aim+=units;
                    break;
                case "up":
                    aim-=units;
                    break;
            }
        }
        int result = h * d;
        System.out.print("");
    }

    public static void main(String[] args) {
        part1();
    }
}