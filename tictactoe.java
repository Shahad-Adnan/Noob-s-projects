import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    static void gameboard(char[][] board){
        for(char[] row : board){
            for(char sign : row){
                System.out.print(sign);
            }
            System.out.println(); //newline
        }
        System.out.println("\n");
    }

    static void placement(char[][] board,int position,String player) {
        char symbol;
        if(player.equals("Player")){
            symbol = 'X';
            playerpos.add(position); // To store the positions (declared below) :)
        }
        else {
            symbol = 'O';
            cpupos.add(position);
        }
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                System.out.println("Stay within the limit!!");
                break;
        }
        gameboard(board);
    }

    static ArrayList <Integer> playerpos = new ArrayList<Integer>();
    static ArrayList <Integer> cpupos = new ArrayList<Integer>();
    
    public static String judgement(){
        List <Integer> top = Arrays.asList(1, 2, 3);
        List <Integer> mid = Arrays.asList(4, 5, 6);
        List <Integer> bottom = Arrays.asList(7, 8, 9);
        List <Integer> col1 = Arrays.asList(1, 4, 7);
        List <Integer> col2 = Arrays.asList(2, 5, 8);
        List <Integer> col3 = Arrays.asList(3, 6, 9);
        List <Integer> horizontal = Arrays.asList(1, 5, 9);
        List <Integer> diagonal = Arrays.asList(3, 5, 7);

        List <List <Integer>> check = new ArrayList<>();
        check.add(top);
        check.add(mid);
        check.add(bottom);
        check.add(col1);
        check.add(col2);
        check.add(col3);
        check.add(horizontal);
        check.add(diagonal);

        for(List <Integer> l : check){
            if(playerpos.containsAll(l)) return "Booyah! You won";
            else if(cpupos.containsAll(l)) return "You lost idiot!";
            else if(playerpos.size() + cpupos.size() == 9) return "Draw! :(";
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', '|', ' ', '|', ' '},
                           {'-','-','-','-','-'},
                           {' ', '|', ' ', '|', ' '},
                           {'-','-','-','-','-'},
                           {' ', '|', ' ', '|', ' '}};

        char[][] temp = {{'1', '|', '2', '|', '3'},
                           {'-','-','-','-','-'},
                           {'4', '|', '5', '|', '6'},
                           {'-','-','-','-','-'},
                           {'7', '|', '8', '|', '9'}};

        System.out.println("Memrise the number to place peace carefully, we won't show it everytime :\\");
        for(char[] a : temp){
            for(char b : a){
                System.out.print(b);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        
        gameboard(board);
        while(true){
            System.out.print("Enter your placement (1-9): ");
            int player = scanner.nextInt();
            while(playerpos.contains(player) || cpupos.contains(player)){
                System.out.println("Position already got taken idiot!");
                player = scanner.nextInt();
            }
            placement(board, player, "Player");
            
            String result = judgement();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
            
            Random ran = new Random();
            int cpu = ran.nextInt(9) + 1;
            while(playerpos.contains(cpu) || cpupos.contains(cpu)){
                cpu = ran.nextInt(9) + 1;
            }
            placement(board, cpu, "Cpu");

            result = judgement();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}