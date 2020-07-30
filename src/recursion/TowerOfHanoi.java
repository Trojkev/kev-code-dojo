package recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int disks = 3;
        char from = 'A';
        char to = 'C';
        char inter = 'B';

        move(disks, from, to, inter);
    }

    private static void move(int noOfDisks, char from, char to, char inter){
        if (noOfDisks == 1)
            System.out.println("Moving disk 1 from "+ from +" to "+ to);
        else {
            move(noOfDisks - 1, from, inter, to);
            System.out.println("Moving disk " + noOfDisks + " from " + from + " to " + to);
            move(noOfDisks - 1, inter, to, from);
        }
    }
}
