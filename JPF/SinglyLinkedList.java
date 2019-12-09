// Name: Rabia Khan
// UTEID: rk23823
import java.util.HashSet;
import java.util.Set;
import gov.nasa.jpf.vm.Verify;

public class HomeworkOne {
    Node header;
    static class Node {
        boolean elem;
        Node next;
    }

    boolean repOk() {
        // postcondition: returns true iff <this> is an acyclic list, i.e.,
        //                         there is no path from a node to itself
        Set<Node> visited = new HashSet<Node>();
        Node n = header;
        while (n.next != null) {        //introduced a bug here, correct = 'n != null'
            if (!visited.add(n)) {
                return false;
            }
            n = n.next; }
        return true;
    }

    void add(boolean e) {
        // precondition: this.repOk()
        // postcondition: adds <e> in a new node at the beginning of the
        //                list; the rest of the list is unmodified

        Node n = new Node();
        n.elem = e;
        n.next = header;
        header = n;
    }

    public static void main(String[] args){
        HomeworkOne l = new HomeworkOne();
        l.add(Verify.getBoolean());
        l.header.elem = Verify.getBoolean();
        
        int numElements = Verify.getInt(0,3);
        for (int i = 0; i < numElements; i++){
            l.add(Verify.getBoolean());
        }

        if(Verify.getBoolean()) l.header = null;

        l.repOk();
    }
}

