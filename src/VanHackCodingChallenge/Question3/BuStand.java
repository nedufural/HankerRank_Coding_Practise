package VanHackCodingChallenge.Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuStand {
    public static Comparator<Element> compareByValue = new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            return o1.getValue() - o2.getValue();
        }
    };
    public static Comparator<Element> compareByIndex = new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            return o1.getIndex() - o2.getIndex();
        }
    };

    public static void main(String[] args) {

    }

    public static int target(int targetValue, List<Element> persons) {
        int res = -1;
        int s = 0;
        int e = persons.size() - 1;
        int m;
        while (s <= e) {
            m = (s + e) / 2;
            if (persons.get(m).getValue() < targetValue) {
                s = m + 1;
            } else {
                res = m;
                e = m - 1;
            }
        }
        return res;
    }

    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {

        List<Element> persons = new ArrayList<>();
        int targetIndex;
        List<Integer> queryRes = new ArrayList<>(Collections.nCopies(q.size(), 0));

        for (int j = 0; j < p.size(); j++) {
            Element person = new Element(j, p.get(j));
            persons.add(person);
        }

        persons.sort(compareByValue);

        for (int j = 0; j < q.size(); j++) {
            targetIndex = target(q.get(j), persons);
            if (targetIndex == -1) {
                continue;
            }

            if (persons.size() - targetIndex >= k) {
                List<Element> targetPersons = new ArrayList(persons.subList(targetIndex, persons.size()));
                targetPersons.sort(compareByIndex);
                queryRes.set(j, targetPersons.get(k - 1).getIndex() + 1);
            }
        }
        return queryRes;
    }

    static class Element {
        private final int index;
        private final int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return this.index;
        }

        public int getValue() {
            return this.value;
        }
    }
}
