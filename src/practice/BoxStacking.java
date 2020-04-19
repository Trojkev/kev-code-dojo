package practice;

import java.util.Arrays;

public class BoxStacking {
    /**
     * Returns the tallest stack that can be achieved using the provided boxes
     *
     * @param boxes an array of the boxes to be stacked
     * @param n the number of boxes to be stacked
     * @return the maximum height achievable
     */
    private static int maxStackHeight(Box[] boxes, int n) {
        /*
        Create a new array of boxes to store all three possible rotations for each box
        provided. The width should be equal or less that the height
         */
        Box[] rot = new Box[n * 3];
        for (int i = 0; i < n; i++) {
            Box box = boxes[i];
            // original box
            rot[3 * i] = new Box(box.height, Math.max(box.width, box.length), Math.min(box.width, box.length));
            // first rotation
            rot[3 * i + 1] = new Box(box.width, Math.max(box.length, box.height), Math.min(box.length, box.height));
            // second rotation
            rot[3 * i + 2] = new Box(box.length, Math.max(box.width, box.height), Math.min(box.width, box.height));
        }

        // now let's calculate the base area for all the rotations
        for (Box box : rot)
            box.area = box.length * box.width;

        // now let's sort all the boxes based on their base area in a decreasing order
        Arrays.sort(rot);

        for (Box box : rot) {
            System.out.println(box.dimensions());
        }

        /*
        Initialize the msh values -> maximum stack height for all indexes
        where msh[i] is the maximum stack height with box i on top
         */
        int count = rot.length;
        int[] msh = new int[count];

        for (int i = 0; i < count; i++)
            msh[i] = rot[i].height;

        /*
        Now we compute the optimized msh[] values in a bottom up matter
         */
        for (int i = 0; i < count; i++) {
            Box box = rot[i];
            msh[i] = 0;
            int val = 0;

            for (int j = 0; j < i; j++) {
                Box prevBox = rot[j];
                if (box.width < prevBox.width && box.length < prevBox.length)
                    val = Math.max(val, msh[j]);
            }
            msh[i] = val + box.height;
        }

        // now let's find the highest possible stack
        int maxHeight = -1;
        for (int i = 0; i < count; i++)
            maxHeight = Math.max(maxHeight, msh[i]);

        return maxHeight;
    }

    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(6, 4, 7);
        arr[1] = new Box(2, 1, 3);
        arr[2] = new Box(5, 4, 6);
        arr[3] = new Box(12, 10, 32);
        System.out.println("Max Stack Height: " + maxStackHeight(arr, arr.length));
    }
}

class Box implements Comparable<Box> {
    int length, width, height, area;

    Box(int h, int w, int l) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    /*
    Sort the boxes on basis of area in decreasing order
     */
    @Override
    public int compareTo(Box o) {
        return o.area - this.area;
    }

    String dimensions() {
        return "{" + this.length + ", " + this.width + ", " + this.height + "}";
    }
}
