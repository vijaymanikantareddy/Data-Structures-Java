import java.util.*;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int option, list_size;
        Node head = null;
        do {
            System.out.println("\n\n*** MAIN MENU ***");
            System.out.println("Enter 1: To Create List");
            System.out.println("Enter 2: To Display List");
            System.out.println("Enter 3: To Insert At Beginning of List");
            System.out.println("Enter 4: To Insert At Middle of List");
            System.out.println("Enter 5: To Insert At Ending of List");
            System.out.println("Enter 6: To Delete From Beginning of List");
            System.out.println("Enter 7: To Delete From Middle of List");
            System.out.println("Enter 8: To Delete From End of List");
            System.out.println("Enter 9: To Reverse The List");
            System.out.println("Enter 10: To Exit");
            System.out.print("Enter Your Option: ");
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
                    head = insert_mid(head);
                    break;
                case 5:
                    head = insert_end(head);
                    break;
                case 6:
                    head = delete_beg(head);
                    break;
                case 7:
                    head = delete_val(head);
                    break;
                case 8:
                    head = delete_end(head);
                    break;
                case 9:
                    head = reversell(head);
                    break;
                default:
                    System.out.println("Program Exited");
            }
        } while (option <= 10);

    }

    public static Node createll(Node head, int list_size) {

        System.out.printf("\nEnter the %d elements : ", list_size);
        for (int i = 0; i < list_size; i++) {
            int num = sc.nextInt();
            Node newnode = new Node(num);
            if (head == null) {
                head = newnode;
            } else {
                Node ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = newnode;
            }
        }
        return head;

    }

    public static Node insert_beg(Node head) {
        System.out.print("\nEnter Value to insert at beginning: ");
        int num = sc.nextInt();
        Node newnode = new Node(num);
        newnode.next = head;
        head = newnode;
        return head;
    }

    public static Node insert_mid(Node head) {
        System.out.print("\nEnter Value to insert at Middle: ");
        int num = sc.nextInt();
        System.out.println("Enter the Position to insert: ");
        int cnt = sc.nextInt();
        Node newnode = new Node(num);
        Node pre = head;
        Node trav = head;
        while (cnt > 0) {
            pre = trav;
            trav = trav.next;
            cnt--;
        }
        pre.next = newnode;
        newnode.next = trav;
        return head;
    }

    public static Node insert_end(Node head) {
        System.out.print("\nEnter Value to insert at Ending: ");
        int num = sc.nextInt();
        Node newnode = new Node(num);
        Node trav = head;
        while (trav.next != null) {
            trav = trav.next;
        }
        trav.next = newnode;
        return head;
    }

    public static Node delete_val(Node head) {
        System.out.print("\nEnter Value to Delete: ");
        int num = sc.nextInt();
        if (head == null) {
            System.out.println("Nothing to Delete");
            return head;
        }
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
        System.out.println("Node with value " + num + " is Deleted");
        pre.next = trav.next;
        return head;
    }

    public static Node delete_beg(Node head) {
        if (head == null) {
            System.out.println("Nothing to Delete");
            return head;
        }
        head = head.next;
        System.out.println("First Node is Deleted");
        return head;
    }

    public static Node delete_end(Node head) {
        if (head == null) {
            System.out.println("Nothing to Delete");
            return head;
        }
        Node trav = head;
        Node pre = head;
        while (trav.next != null) {
            pre = trav;
            trav = trav.next;
        }
        pre.next = null;
        System.out.println("Last Node is Deleted");
        return head;
    }

    public static void display(Node head) {
        System.out.println("\n\nElements in LinkedList are: ");
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    public static Node reversell(Node head) {
        Node curr = head, pre = null;
        while (curr != null) {
            Node ne = curr.next;
            curr.next = pre;
            pre = curr;
            curr = ne;
        }
        head = pre;
        System.out.println("List is Reversed");
        return head;
    }
}
