package GraduateAlgorithms_Udacity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    private static int increasingSubsequenceByDynamicProgramming(List<Integer> arr) {
        int i, j, max = 0;
        List<Integer> lis = new ArrayList<>();
        for (i = 0; i < arr.size(); i++) {

            /* Initialize LIS values for all indexes */
            for (i = 0; i < arr.size(); i++) {
                lis.add(1);
            }

           /* Compute optimized LIS values in
              bottom up manner */
            for (i = 1; i < arr.size(); i++) {
                for (j = 0; j < i; j++) {
                    if (arr.get(i) > arr.get(j) && lis.get(i) < lis.get(j) + 1) {
                        lis.set(i, lis.get(j) + 1);
                    }
                }
            }
        }
        /* Pick maximum of all LIS values */
        for (i = 0; i < arr.size(); i++)
            if (max < lis.get(i))
                max = lis.get(i);

        return max;

    }
    /**
     * just a container class that holds an integer value and a reference to the top card on the pile
     * immediately on the left
     */
    static class Card {
        final int i;
        final Card card; // could be null

        Card(int i, Card card) {
            this.i = i;
            this.card = card;
        }

        @Override
        public String toString() {
            return i + "";
        }
    }

    /**
     * we examine only the top most card of each pile, looking for a card that is greater or equal to the one at hand
     *
     * @param piles
     * @param i
     * @return -1 if no pile can host
     */
    static int binarySearchHostPileIdx(List<List<Card>> piles, int i) {
        int l = 0; // left
        int r = piles.size() - 1; // right
        int m = -1; // middle

        if (piles.isEmpty()) return -1;

        while (l <= r) {
            /*
             * Pick the middle. Same as (l + r) / 2 but does not run the risk of integer overflow
             */
            m =  l + (r - l) / 2;
            List<Card> pile = piles.get(m);
            Card c = pile.get(pile.size()-1); // get the top card from this pile
            if (c.i == i) return m; // exact match
            if (c.i < i) {
                l = m + 1; // ignore left half
            } else {
                r = m - 1; // ignore right half
            }
        }

        if (l >= piles.size()) return -1;

        List<Card> lPile = piles.get(l);
        return lPile.get(lPile.size()-1).i >= i ? l : -1;
    }

    /**
     * to retrieve the sub-sequence, start at the right most pile, pick a card (any one of those would do)
     * and follow the pointers, which will lead all the way to the left most pile.
     * @param piles
     * @return
     */
    private static int[] retrieveSeq(List<List<Card>> piles) {
        List<Card> rightPile = piles.get(piles.size()-1);
        Card c = rightPile.get(0);
        int[] seq = new int[piles.size()];
        int k = seq.length-1;

        while (c != null) {
            seq[k--] = c.i;
            c = c.card;
        }

        return seq;
    }

    public static int[] increasingSubsequenceByPatientSorting(Integer[] ar) {

        List<List<Card>> piles = new ArrayList<>();

        /**
         * "patience sort" each value into piles
         */
        for (int k = 0; k < ar.length; k++) {
            int hostPileIdx = binarySearchHostPileIdx(piles, ar[k]);

            List<Card> hostPile;
            if (hostPileIdx < 0) { // start a new pile
                hostPile = new ArrayList<>();
                piles.add(hostPile);
                hostPileIdx = piles.size()-1;
            } else {
                hostPile = piles.get(hostPileIdx); // found a host
            }

            Card leftCard = null;
            if (hostPileIdx > 0) {
                // except for left most pile, link the card to the top card of the pile immediately on the left
                List<Card> leftPile = piles.get(hostPileIdx-1);
                leftCard = leftPile.get(leftPile.size()-1); // top most card of the pile immediately on the left
            }

            hostPile.add(new Card(ar[k], leftCard));
        }

        return retrieveSeq(piles);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 7, 4, -3, 9, 1, 10, -4, 5, 8, 9, 3};
        //Integer[] arr = {0,8,4,12,2,10,6,14};
        //Integer[] arr = {2, 0, -1, 4, -2, 7, 9, 11, 3, -14, 8};
        //Integer arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        List<Integer> list = Arrays.asList(arr);
        System.out.println(increasingSubsequenceByDynamicProgramming(list));
        System.out.println(increasingSubsequenceByPatientSorting(arr).length);
    }
}
