public class BirthdayCake {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int count = 0;
        int max = ar[0];
        //determine the largest number
        for(int i = 1; i < ar.length;i++)
        {
            if(ar[i] > max)
            {
                max = ar[i];
            }
        }
        //count how many times the largest number occurs
        for(int i = 0;i<ar.length;i++){
            if(ar[i] == max){
                count++;
            }
        }

        return count;
    }
}
