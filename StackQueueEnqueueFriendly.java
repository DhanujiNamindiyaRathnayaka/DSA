
import java.util.Stack;

public class StackQueueEnqueueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation - O(1)
    public void enqueue(int value) {

        s1.push(value);

        System.out.println(value + " added to queue");
    }

    // Dequeue operation - O(n)
    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        // Move elements to second stack
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        // Remove the oldest element
        int removed = s1.pop();

        // Move elements back
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return removed;
    }

    // Display queue
    public void display() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue elements: " + s1);
    }

    // Main method
    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();
    }
}

