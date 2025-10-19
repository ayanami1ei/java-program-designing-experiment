package experiment2;

public class Queue {
    private Node head, tail;
    private int size;

    public Queue() {
        size = 0;
        head = null;
        tail = null;
    }

    public float getHead() {
        return head.getVal();
    }

    public float getTail() {
        return tail.getVal();
    }

    public void push(float newNum) {
        if (size == 0) {
            head = new Node(newNum);
            tail = head;
            size = 1;
            return;
        }
        Node p = new Node(newNum);
        p.setPrior(tail);
        tail.setNext(p);
        tail = p;

        ++size;
    }

    public float pop() {
        float res = head.getVal();

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;

            return res;
        }
        head = head.getNext();
        head.setPrior(null);

        --size;

        return res;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head(");

        Node p = head;
        while (p != tail) {
            sb.append(p.getVal()).append(", ");
            p = p.getNext();
        }
        sb.append(p.getVal()).append(")tail, size = ").append(String.valueOf(size));

        return sb.toString();
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        for (int i = 1; i <= 12; ++i) {
            q.push(i);
        }

        System.out.println(q);

        while (true) {
            if (!q.empty()) {
                System.out.println(q.pop() + " " + (q.getSize()));
            } else {
                System.out.println("queue empty!");
                break;
            }
        }
    }
}

class Node {
    private float val;
    private Node next, prior;

    public Node(float n) {
        val = n;
        next = null;
        prior = null;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrior() {
        return prior;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }
}