package HW1;

import java.util.HashSet;
import java.util.Set;

public class SLList {
    Node header;  // Head of the list.
    static class Node {
        boolean elem; // The data stored in the node.
        Node next;
    }

    boolean repOk() {
        Node n = header;
        Set<Node> visited = new HashSet<Node>();
        while (n.next != null) {  // Introduced a bug here, correct "n != null"
            if (!visited.add(n)) {
                return false;
            }
            n = n.next;
        }
        return true;
    }

    void add(boolean e) {
        Node newNode = new Node();  // Declare the new node
        newNode.elem = e;
        newNode.next = header;  // Make the new node point to the old header
        header = newNode;  // Make the new node the new header now

    }

}
