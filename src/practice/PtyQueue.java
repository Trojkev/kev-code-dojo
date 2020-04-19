package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PtyQueue {
    public static void main(String[] args) {
        PriorityQueue<House> pQueue = new PriorityQueue<>(5, new HouseComparator());
        // create new house instances
        var house1 = new House(15000, 244);
        var house2 = new House(12500, 172);
        var house3 = new House(35000, 265);
        var house4 = new House(78500, 415);
        var house5 = new House(11000, 112);
        var house6 = new House(12500, 148);

        // add the house instances to the priority queue
        pQueue.add(house1);
        pQueue.add(house2);
        pQueue.add(house3);
        pQueue.add(house4);
        pQueue.add(house5);
        pQueue.add(house6);

        // now print out the houses in the queue in the order of their priority
        while (!pQueue.isEmpty()) {
            var h = pQueue.poll();
            System.out.println(h.rent + " => " + h.area);
        }
    }
}

class HouseComparator implements Comparator<House> {
    public int compare(House h1, House h2) {
        if (h1.rent > h2.rent)
            return 1;
        else if (h1.rent < h2.rent)
            return -1;
        return 0;
    }
}

class House {
    double rent;
    double area;

    House(double rent, double area) {
        this.rent = rent;
        this.area = area;
    }
}
