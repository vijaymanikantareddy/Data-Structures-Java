import java.util.*;

public class DoubleList {
    static class Node {
        int data;
        Node next, prev;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int option, list_size;
        Node head = null;
        do {
            System.out.println("\n\n*** MAIN MENU ***");
            System.out.println("Enter 1: To Create List");
            System.out.println("Enter 2: To Display List");
            System.out.println("Enter 3: To Insert At Beginning of List");
            System.out.println("Enter 4: To Insert At Ending of List");
            System.out.println("Enter 5: To Insert At after a Node");
            System.out.println("Enter 6: To Delete From Beginning");
            System.out.println("Enter 7: To Delete From Ending");
            System.out.println("Enter 8: To Delete a Node with value");
            System.out.println("Enter 9: To Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nEnter the Size of List: ");
                    list_size = sc.nextInt();
                    head = createll(head, list_size);
                    break;
                case 2:
                    display(head);
                    break;
                case 3:
                    head = insert_beg(head);
                    break;
                case 4:
                    head = insert_end(head);
                    break;
                case 5:
                    head = insert_after(head);
                    break;
                case 6:
                    head = delete_beg(head);
                    break;
                case 7:
                    head = delete_end(head);
                    break;
                case 8:
                    head = delete_after(head);
                    break;
            }
        } while (option <= 8);

    }

    public static Node createll(Node head, int list_size) {

        System.out.printf("\nEnter the %d elements : ", list_size);
        for (int i = 0; i < list_size; i++) {
            int num = sc.nextInt();
            Node newnode = new Node(num);
            if (head == null) {
                head = newnode;
                newnode.prev = null;
                newnode.next = null;
            } else {
                Node ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = newnode;
                newnode.prev = ptr;
                newnode.next = null;
            }
        }
        return head;

    }

    public static Node insert_beg(Node head) {
        System.out.print("\nEnter Value to insert at beginning: ");
        int num = sc.nextInt();
        Node newnode = new Node(num);
        newnode.next = head;
        newnode.prev = null;
        head = newnode;
        return head;
    }

    public static Node insert_end(Node head) {
        System.out.print("\nEnter Value to insert at Ending: ");
        int num = sc.nextInt();
        Node newnode = new Node(num);
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newnode;
        newnode.prev = ptr;
        newnode.next = null;
        return head;
    }

    public static Node insert_after(Node head) {
        System.out.print("\nEnter Value to insert at Middle: ");
        int num = sc.nextInt();
        System.out.print("\nEnter Node Value at which newnode adds   : ");
        int val = sc.nextInt();
        Node newnode = new Node(num);
        Node ptr = head;
        while (ptr.data != val) {
            ptr = ptr.next;
        }
        newnode.prev = ptr;
        newnode.next = ptr.next;
        ptr.next.prev = newnode;
        ptr.next = newnode;
        return head;
    }

    public static Node delete_beg(Node head) {
        head = head.next;
        head.prev = null;
        return head;
    }

    public static Node delete_after(Node head) {
        System.out.print("\nEnter Value to Delete: ");
        int num = sc.nextInt();

        if (head.data == num) {
            head = head.next;
            return head;
        }
        Node trav = head;
        Node pre = head;
        while (trav.data != num) {
            pre = trav;
            trav = trav.next;
        }
        pre.next = trav.next;
        return head;
    }

    public static Node delete_end(Node head) {
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.prev.next = null;
        return head;
    }

    public static Node delete_val(Node head) {
        System.out.print("\nEnter Value to Delete: ");
        int val = sc.nextInt();

        Node ptr = head;
        while (ptr.data != val) {
            ptr = ptr.next;
        }
        Node temp = ptr.next;
        ptr.next = temp.next;
        temp.next.prev = ptr;
        return head;
    }

    public static void display(Node head) {
        System.out.println("\n\nElements in Double LinkedList are: ");
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
