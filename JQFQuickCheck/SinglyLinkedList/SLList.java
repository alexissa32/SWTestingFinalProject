import java.util.HashSet;
import java.util.Set;

public class SLList {
    Node header;  // Head of the list.
    static class Node {
        boolean elem; // The data stored in the node.
        Node next;

    }
    boolean repOk() {
        Set<Node> visited = new HashSet<Node>();
        Node n = header;
        if(n == null || n.next == null) //If size is 0 or 1
            return false; //BUG
        while (n != null) {  // While the final node is not reached
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
