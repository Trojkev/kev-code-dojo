package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(1);
        nums.add(2);
        nums.add(5);
        nums.add(6);
        nums.add(3);
        nums.add(2);

        int toMove = 2;
        System.out.println("Input: "+nums);
        System.out.println("Output: "+moveElementToEnd(nums, toMove));
    }

    private static List<Integer> moveElementToEnd(List<Integer> array, int element){
        int counter = 0;
        Iterator<Integer> itr = array.iterator();
        while (itr.hasNext()){
            if (itr.next() == element){
                counter++;
                itr.remove();
            }
        }

        for (int i = 0; i < counter; i++) {
            array.add(element);
        }

        return array;
    }
}
