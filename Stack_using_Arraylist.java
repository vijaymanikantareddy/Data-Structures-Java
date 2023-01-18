import java.util.*;

class Stack_Methods {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int top = 0, option;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        do {
            System.out.println("\n\n ***MAIN MENU ***");
            System.out.println("Enter 1: Push");
            System.out.println("Enter 2 : Pop");
            System.out.println("Enter 3 : Peek");
            System.out.println("Enter 4 : Display");
            System.out.println("Enter 5 : To Check the Stack is Empty");
            System.out.println("Enter 6 : Exit");
            System.out.println("Enter your option: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    top = push(stack, top);
                    break;
                case 2:
                    top = pop(stack, top);
                    break;
                case 3:
                    peek(stack, top);
                    break;
                case 4:
                    display(stack, top);
                    break;
                case 5:
                    isEmpty(stack, top);
                    break;
            }
        } while (option <= 6);
    }

    public static int push(ArrayList<Integer> stack, int top) {
        System.out.println("Enter Value to Push into Stack: ");
        int num = sc.nextInt();
        stack.add(num);
        top++;
        return top;
    }

    public static int pop(ArrayList<Integer> stack, int top) {
        if (top == 0) {
            System.out.println("Stack is Empty, Pop Operation is Not Possible");
            return -1;
        }
        System.out.println("Element removed : " + stack.get(top - 1));
        stack.remove(top - 1);
        top--;
        return top;
    }

    public static void peek(ArrayList<Integer> stack, int top) {
        if (top == 0) {
            System.out.println("Stack is Empty, There is no Peek element");
            return ;
        }
        System.out.println("Peek element is : " + stack.get(top-1));
        
    }

    public static void display(ArrayList<Integer> stack, int top) {
        if (top == 0) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Stack Elements are: ");
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
    }

    public static void isEmpty(ArrayList<Integer> stack, int top) {
        if (top == 0)
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack is Not Empty");
    }
}
