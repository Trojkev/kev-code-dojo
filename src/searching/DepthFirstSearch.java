package searching;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static class Node {
        List<Node> children = new ArrayList<>();
        String name;

        Node(String name){
            this.name = name;
        }

        private List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (Node child: this.children) {
                child.depthFirstSearch(array);
            }
            return array;
        }

        private Node addChild(String name) {
            this.children.add(new Node(name));

            return this;
        }

        private void addChild(Node child){
            this.children.add(child);
        }
    }
    public static void main(String[] args) {
        List<String> values = new ArrayList<>();

        Node root = new Node("A");

        Node nodeF = new Node("F").addChild("I");
        nodeF.addChild("J");

        Node nodeB = new Node("B").addChild("E");
        nodeB.addChild(nodeF);

        root.addChild(nodeB);
        root.addChild("C");

        Node nodeD = new Node("D").addChild("G").addChild("K");
        nodeD.addChild("H");
        root.addChild(nodeD);

        List<String> results = root.depthFirstSearch(values);
        System.out.println("DFS values: " + results);
    }
}
