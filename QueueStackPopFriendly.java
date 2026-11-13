import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(n)
    public void push(int value) {

        // Move all elements to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Add new element to q1
        q1.add(value);

        // Move elements back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        System.out.println(value + " pushed into stack");
    }

    // Pop operation - O(1)
    public int pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return q1.remove();
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

        QueueStackPopFriendly stack =
                new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}

    

