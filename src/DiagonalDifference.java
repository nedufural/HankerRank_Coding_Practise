import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rightD = 0;
        int leftD = 0;

        for (int i = 0;i<arr.size();i++) {

            rightD += arr.get(i).get(i);
            leftD += arr.get(i).get(arr.size() - (i+1));
        }
        return Math.abs(rightD - leftD);
    }

}
