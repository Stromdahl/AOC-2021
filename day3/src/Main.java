import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static void part1(){
        String[] data = helper.readFile("day3/src/inputData.txt");
        int bits = data[0].length();
        int gama = 0;
        for(int i = 0; i < bits; i++){
            int count = 0;
            for (String value: data) {
                char b = value.charAt(i);
                if(b == '1'){
                    count++;
                }
                System.out.println();
            }
            int gamaFlag = count > data.length / 2? 1 : 0;
            gama |= gamaFlag << bits - i;
        }
        gama = gama >> 1;

        int x = 0;
        for(int i = 0; i < bits; i++){
            x |= 1 << i;
        }

        int epsilon = gama ^ x;
        int result = gama * epsilon;
        System.out.println();
    }

    static void part2(){
        // 101011011101
        // 001110010111
        // 2530926
        // 2541942
        // 433992
        // 2555739
        String[] dataArray = helper.readFile("day3/src/inputData.txt");
        ArrayList<String> data = new ArrayList<>(Arrays.asList(dataArray));
        int bits = data.get(0).length();
        int oxygen = 0;

        int i = 0;
        while(data.size() > 1){
                int count1 = 0;
                int count0 = 0;
                for (String value: data) {
                    char b = value.charAt(i);
                    if(b == '1'){
                        count1++;
                    } else {
                        count0++;
                    }
                    System.out.println();
                }

                char flag = count1 >= count0 ? '0': '1';
                for (int j = data.size() - 1; j >= 0; j--) {
                    if(data.get(j).charAt(i) != flag){
                        data.remove(j);
                    }
                }
                i++;
                if(i > bits) i = 0;
        }
    }

    public static void main(String[] args) {
        part2();
    }
}
