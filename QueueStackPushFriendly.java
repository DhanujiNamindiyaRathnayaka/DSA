import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(1)
    public void push(int value) {
        q1.add(value);
        System.out.println(value + " pushed into stack");
    }

    // Pop operation - O(n)
    public int pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int removed = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return removed;
    }

    // Display stack
    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("Stack elements: " + q1);
    }

    public static void main(String[] args) {

        QueueStackPushFriendly stack =
                new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}