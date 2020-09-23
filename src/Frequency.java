public class Frequency {

    public static void main(String[] args) {

        //Initialize array
        int [] arr = new int [] {4,5,5,4,5};
        //Array fr will store frequencies of element
        System.out.println( solution(arr));
    }
    public static int solution(int[] arr){
        int sum = 0;
        int [] fr = new int [arr.length];
        int visited = -1;

        for(int i = 0; i < arr.length; i++){
            int count = 1;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                    //To avoid counting same element again
                    fr[j] = visited;
                }
            }
            if(fr[i] != visited)
                fr[i] = count;
        }

        //Displays the frequency of each element present in array
        for(int i = 0; i < fr.length; i++){

            if(fr[i] != visited && fr[i] > 1)
            sum = sum + fr[i];

        }


        return sum;
    }
}