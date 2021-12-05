import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;



public class Main {

    static class Board{

        private final int[] boardNumbers;
        public boolean hasWon = false;

        private Board(int[] boardNumbers){
            this.boardNumbers = boardNumbers;
        }

        public boolean checkDrawnNumbers(ArrayList<Integer> drawnNumbers){
            //rows
            for (int i = 0; i < 5; i++) {
                boolean flag = true;
                for (int j = 0; j < 5; j++) {
                    if(!drawnNumbers.contains(boardNumbers[i*5 + j])){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }

            //cols
            for (int i = 0; i < 5; i++) {
                boolean flag = true;
                for (int j = 0; j < 5; j++) {
                    if(!drawnNumbers.contains(boardNumbers[i + j*5])){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
            return false;
        }

        int calcScore(ArrayList<Integer> drawnNumbers){
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : boardNumbers) {
                if(!drawnNumbers.contains(n)){
                    list.add(n);
                }
            }

            int sum = 0;
            for (int n : list) {
                sum += n;
            }

            return sum;
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

    static void addAll(ArrayList<Integer> list, int[] items){
        for (int item :
                items) {
            list.add(item);
        }
    }

    static ArrayList<Integer> part1(){
        ArrayList<Integer> result = new ArrayList<>();
        String[] data = helper.readFile("day4/src/inputData.txt");
        Board[] boards = readBoards(data);
        int[] numbers = readDrawNumbers(data);
        ArrayList<Integer> drawnNumbers = new ArrayList<>();

        for (int number : numbers) {
            drawnNumbers.add(number);
            for (Board board : boards) {
                if(board.checkDrawnNumbers(drawnNumbers) && !board.hasWon){
                    board.hasWon = true;
                    result.add(board.calcScore(drawnNumbers) * number);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        part1();
        System.out.println();
    }
}
