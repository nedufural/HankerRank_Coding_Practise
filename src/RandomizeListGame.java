import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomizeListGame {
    static ArrayList<Integer> playedList = new ArrayList<>();
    static ArrayList<String> playerName = new ArrayList<>();
    static ArrayList<Player> playersList = new ArrayList<>();
    static int count = 0;

    public static ArrayList<Integer> generateRandomNumbers() {
        int min = 0;
        int max = 100;
        ArrayList<Integer> numberList = new ArrayList<>();
        int[] arr = IntStream.range(1, 101).toArray();

        for (int j : arr) {
            numberList.add(j);
        }
        int randomSeed = (int) (Math.random() * (max - min + 1) + min);
        Collections.shuffle(numberList, new Random(randomSeed));
        return numberList;
    }

    public static boolean checkPlayedNumbers(int numberPlayed) {
        count++;

        playedList.add(numberPlayed);
        if (playedList.get(0) != 1) {
            System.out.println("Please pick numbers in incremental order from 1");
            return false;
        } else if (playedList.get(0) == 1) {
            if (!isValidIncrement(count, numberPlayed)) {
                playedList.remove(count - 1);
                System.out.println("Play number in increment");
                count--;
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static boolean isValidIncrement(int count, int numberPlayed) {
        return count == numberPlayed;
    }

    public static void whoPlayed(Player player) {
        if (checkPlayedNumbers(player.score)) {
            playerName.add(player.player);
            playersList.add(player);
            //  System.out.println(playersList);
        }
    }

    //Todo  make possible for multiple player score
    public static void findWinner(ArrayList<Player> players, int numberOfPlayers) {
        int p1 = 0, p2 = 1, p3 = 2;
        if (numberOfPlayers == 3) {
            if(p1 == checkWinnerAmong3Players()){
                System.out.println("The winner is [ P1 ]");
            }
            else if(p2 == checkWinnerAmong3Players()){
                System.out.println("The winner is [ P2 ]");
            }
            else if(p3 == checkWinnerAmong3Players()){
                System.out.println("The winner is [ P3 ]");
            }
        }
        else if(numberOfPlayers == 2){
            if(p1 == checkWinnerAmong2Players()){
                System.out.println("The winner is [ P1 ]");
            }
            else if(p2 == checkWinnerAmong2Players()){
                System.out.println("The winner is [ P2 ]");
            }
        }


    }

    private static int checkWinnerAmong3Players() {
        ArrayList<Integer> plays = new ArrayList<>();
        int p1 = Collections.frequency(playerName, "P1");
        int p2 = Collections.frequency(playerName, "P2");
        int p3 = Collections.frequency(playerName, "P3");
        plays.add(p1);
        plays.add(p2);
        plays.add(p3);
        return IntStream.range(0, plays.size()).boxed()
                .max(Comparator.comparing(plays::get)).orElse(-1);
    }

    private static int checkWinnerAmong2Players() {
        ArrayList<Integer> plays = new ArrayList<>();
        int p1 = Collections.frequency(playerName, "P1");
        int p2 = Collections.frequency(playerName, "P2");
        plays.add(p1);
        plays.add(p2);
        return IntStream.range(0, plays.size()).boxed()
                .max(Comparator.comparing(plays::get)).orElse(-1);
    }


    public static int endGame(int gameSize) {
        return playedList.size() == gameSize ? 1 : 0;
    }

    public static String checkTheEnd(int gameStatus) {
        if (gameStatus == 0) {
            return "On going";
        } else {
            return "Finshed";
        }
    }

    public static void main(String[] args) {

        Player player1 = new Player("P1", 1);
        System.out.println(checkTheEnd(endGame(100)));
        Player player2 = new Player("P2", 2);
        System.out.println(checkTheEnd(endGame(100)));
        Player player3 = new Player("P1", 3);
        System.out.println(checkTheEnd(endGame(100)));
        Player player4 = new Player("P2", 5);
        System.out.println(checkTheEnd(endGame(100)));
        Player player5 = new Player("P1", 4);
        System.out.println(checkTheEnd(endGame(100)));
        Player player6 = new Player("P2", 5);
        System.out.println(checkTheEnd(endGame(100)));
        Player player7 = new Player("P1", 6);
        System.out.println(checkTheEnd(endGame(100)));
        Player player8 = new Player("P3", 6);
        System.out.println(checkTheEnd(endGame(100)));
        whoPlayed(player1);
        whoPlayed(player2);
        whoPlayed(player3);
        whoPlayed(player4);
        whoPlayed(player5);
        whoPlayed(player6);
        whoPlayed(player7);
        whoPlayed(player8);
        findWinner(playersList, 3);

    }

    static class Player {
        String player;
        int score;

        public Player(String player, int score) {
            this.player = player;
            this.score = score;
        }

        public String getPlayer() {
            return player;
        }

        public void setPlayer(String player) {
            this.player = player;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "player='" + player + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
