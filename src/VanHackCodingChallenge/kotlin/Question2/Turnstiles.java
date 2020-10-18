package vanHackCodingChallenge.kotlin.Question2;

import java.util.LinkedList;

import static java.lang.Integer.max;

public class Turnstiles {

    public static int[] getTime(int[] time, int[] direction) {
        int n = time.length;
        int[] result = new int[n];

        LinkedList<Integer> entry = new LinkedList<>();
        LinkedList<Integer> exit = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (direction[i] == 0) {
                entry.add(i);
            } else {
                exit.add(i);
            }
        }
        int prev = -1;
        int currentTime = 0;

        while (!entry.isEmpty() && !exit.isEmpty()) {
            int currentEntry = entry.peek();
            int currentExit = exit.peek();
            int entryTime = max(time[currentEntry], currentTime);
            int exitTime = max(time[currentExit], currentTime);

            if (entryTime < exitTime) {
                entry.remove();
                result[currentEntry] = entryTime;
                prev = setPrevious(true, currentTime, entryTime);
                currentTime = entryTime;
            } else if (entryTime > exitTime) {
                exit.remove();
                currentTime = exitTime;
                result[currentExit] = exitTime;
                prev = setPrevious(false, currentTime, exitTime);
                currentTime = exitTime;
            } else {
                if (prev == -1 || prev == 1) {
                    exit.remove();
                    result[currentExit] = exitTime;
                    prev = setPrevious(false, currentTime, exitTime);
                    currentTime = exitTime;
                } else {
                    entry.remove();
                    result[currentEntry] = entryTime;
                    prev = setPrevious(true, currentTime, entryTime);
                    currentTime = entryTime;
                }
            }
            currentTime = currentTime + 1;
        }

        while (!entry.isEmpty()) {
            int currEntry = entry.remove();
            currentTime = Math.max(currentTime, time[currEntry]);
            result[currEntry] = currentTime;
            currentTime += 1;
        }

        while (!exit.isEmpty()) {
            int currExit = exit.remove();
            currentTime = Math.max(currentTime, time[currExit]);
            result[currExit] = currentTime;
            currentTime += 1;
        }

        return result;
    }

    private static int setPrevious(boolean entry, int currTime, int time) {
        int prev;
        if (time > currTime) {
            prev = -1;
        } else {
            prev = entry ? 0 : 1;
        }
        return prev;
    }
}
