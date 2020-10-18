package vanHackCodingChallenge.kotlin.Question2

import java.util.*

class Turnstile {
    fun getTime(time: Array<Int>, direction: Array<Int>): Array<Int> {
        val n = time.size
        val result = Array(n) { 0 }
        val entry = LinkedList<Int>()
        val exit = LinkedList<Int>()
        for (i in 0 until n) {
            if (direction[i] == 0) {
                entry.add(i)
            } else {
                exit.add(i)
            }
        }
        var prev = -1
        var currentTime = 0
        while (!entry.isEmpty() && !exit.isEmpty()) {
            val currentEntry = entry.peek()
            val currentExit = exit.peek()
            val entryTime = Integer.max(time[currentEntry], currentTime)
            val exitTime = Integer.max(time[currentExit], currentTime)
            if (entryTime < exitTime) {
                entry.remove()
                result[currentEntry] = entryTime
                prev = setPrevious(true, currentTime, entryTime)
                currentTime = entryTime
            } else if (entryTime > exitTime) {
                exit.remove()
                currentTime = exitTime
                result[currentExit] = exitTime
                prev = setPrevious(false, currentTime, exitTime)
                currentTime = exitTime
            } else {
                if (prev == -1 || prev == 1) {
                    exit.remove()
                    result[currentExit] = exitTime
                    prev = setPrevious(false, currentTime, exitTime)
                    currentTime = exitTime
                } else {
                    entry.remove()
                    result[currentEntry] = entryTime
                    prev = setPrevious(true, currentTime, entryTime)
                    currentTime = entryTime
                }
            }
            currentTime += 1
        }
        while (!entry.isEmpty()) {
            val currEntry = entry.remove()
            currentTime = Math.max(currentTime, time[currEntry])
            result[currEntry] = currentTime
            currentTime += 1
        }
        while (!exit.isEmpty()) {
            val currExit = exit.remove()
            currentTime = Math.max(currentTime, time[currExit])
            result[currExit] = currentTime
            currentTime += 1
        }
        return result
    }

    private fun setPrevious(entry: Boolean, currTime: Int, time: Int): Int {
        return if (time > currTime) {
            -1
        } else {
            if (entry) 0 else 1
        }
    }
}