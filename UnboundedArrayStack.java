public class UnboundedArrayStack {

    private int[] array;
    private int top;
    private int capacity;

    // Constructor
    public UnboundedArrayStack() {
        capacity = 2;
        array = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int value) {

        // Increase capacity when array is full
        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        array[++top] = value;

        System.out.println(value + " pushed into stack");
    }

    // Pop operation
    public int pop() {

        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }

        int removed = array[top];
        top--;

        // Reduce capacity when necessary
        if (capacity > 2 && top + 1 <= capacity / 4) {
            resize(capacity / 2);
        }

        return removed;
    }

    // Resize array
    private void resize(int newCapacity) {

        int[] newArray = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;

        System.out.println("Array resized to: " + capacity);
    }

    // Display stack
    public void display() {

        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements: ");

        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("Current capacity: " + capacity);
    }

    // Main method
    public static void main(String[] args) {

        UnboundedArrayStack stack =
                new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}
