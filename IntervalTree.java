import java.util.*;
class Node {
    int start, end;
    Node left, right;
    List<Node> overlaps;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
        this.overlaps = new ArrayList<>();
    }
}

class IntervalTree {
    private Node root;

    public IntervalTree() {
        this.root = null;
    }

    public void insertInterval(int start, int end) {
        root = insertInterval(root, start, end);
    }

    private Node insertInterval(Node node, int start, int end) {
        if (node == null) {
            return new Node(start, end);
        }

        if (end < node.start) {
            node.left = insertInterval(node.left, start, end);
        } else if (start > node.end) {
            node.right = insertInterval(node.right, start, end);
        } else {
            node.overlaps.add(new Node(start, end));
        }

        return node;
    }

    public void deleteInterval(int start, int end) {
        root = deleteInterval(root, start, end);
        System.out.println("Deleted Successfully");
    }

    private Node deleteInterval(Node node, int start, int end) {
        if (node == null) {
            return null;
        }

        if (end < node.start) {
            node.left = deleteInterval(node.left, start, end);
        } else if (start > node.end) {
            node.right = deleteInterval(node.right, start, end);
        } else {
            node.overlaps.removeIf(interval -> interval.start == start && interval.end == end);
        }

        return node;
    }

    public List<Node> findOverlappingIntervals(int start, int end) {
        List<Node> result = new ArrayList<>();
        findOverlappingIntervals(root, start, end, result);
        return result;
    }

    private void findOverlappingIntervals(Node node, int start, int end, List<Node> result) {
        if (node == null) {
            return;
        }

        if (start <= node.end && end >= node.start) {
            result.addAll(node.overlaps);
        }

        if (node.left != null && node.left.end >= start) {
            findOverlappingIntervals(node.left, start, end, result);
        }

        if (node.right != null && node.right.start <= end) {
            findOverlappingIntervals(node.right, start, end, result);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        IntervalTree intervalTree = new IntervalTree();

        intervalTree.insertInterval(10, 30);
        intervalTree.insertInterval(17, 19);
        intervalTree.insertInterval(5, 20);
        intervalTree.insertInterval(12, 15);
        intervalTree.insertInterval(30, 40);

        List<Node> overlappingIntervals = intervalTree.findOverlappingIntervals(16, 18);
        for (Node interval : overlappingIntervals) {
            System.out.println("Overlapping interval: [" + interval.start + ", " + interval.end + "]");
        }

        intervalTree.deleteInterval(12, 15);

        overlappingIntervals = intervalTree.findOverlappingIntervals(16, 18);
        for (Node interval : overlappingIntervals) {
            System.out.println("Overlapping interval: [" + interval.start + ", " + interval.end + "]");
        }
    }
}
