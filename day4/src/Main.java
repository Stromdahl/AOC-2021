import java.util.ArrayList;
import java.util.stream.Stream;



public class Main {

    static class Board{

        private final int[] boardNumbers;

        private Board(int[] boardNumbers){
            this.boardNumbers = boardNumbers;
        }
    }

    static int[] readDrawNumbers(String[] data){
        String[] drawNumbersString = data[0].split(",");
        int[] drawNumbers = new int[drawNumbersString.length];
        for (int i = 0, drawNumbersStringLength = drawNumbersString.length; i < drawNumbersStringLength; i++) {
            String drawNumber = drawNumbersString[i];
            drawNumbers[i] = Integer.parseInt(drawNumbersString[i]);
        }
        return drawNumbers;
    }

    static int[] convertStringArr2IntArr(String[] stringNumbers){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < stringNumbers.length; i++) {
            if(stringNumbers[i] == "")
                continue;
            numbers.add(Integer.parseInt(stringNumbers[i]));
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    static Board[] readBoards(String[] data){
        ArrayList<Board> boards = new ArrayList<>();
        int pointer = 2;
        while(true){
            int[] boardNumbers = new int[5*5];
            for (int i = 0; i < 5; i++) {
                int[] boardRow = convertStringArr2IntArr(data[pointer].split(" "));
                for (int j = 0; j < 5; j++) {
                    boardNumbers[i*5+j] = boardRow[j];
                }
                pointer++;

            }
            boards.add(new Board(boardNumbers));
            pointer++;
            if(pointer >= data.length)
                break;
        }
        return boards.toArray(new Board[0]);
    }

    static void part1(){
        String[] data = helper.readFile("day4/src/inputData.txt");
        Board[] boards = readBoards(data);
        readDrawNumbers(data);

    }


    public static void main(String[] args) {
        part1();
    }
}
