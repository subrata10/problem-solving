package medium;

public class AddTwoNumbersByLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(8);
        ListNode h1n1 = new ListNode(3);
        ListNode h1n2 = new ListNode(2);
//        ListNode h1n3 = new ListNode(9);
//        ListNode h1n4 = new ListNode(9);
//        ListNode h1n5 = new ListNode(9);
//        ListNode h1n6 = new ListNode(9);
        head1.next = h1n1;
        h1n1.next = h1n2;
//        h1n2.next = h1n3;
//        h1n3.next = h1n4;
//        h1n4.next = h1n5;
//        h1n5.next = h1n6;

        ListNode head2 = new ListNode(9);
        ListNode h2n1 = new ListNode(2);
        ListNode h2n2 = new ListNode(1);
//        ListNode h2n3 = new ListNode(9);
        head2.next = h2n1;
        h2n1.next = h2n2;
//        h2n2.next = h2n3;

        AddTwoNumbersByLinkedList obj = new AddTwoNumbersByLinkedList();
        int list1Len = obj.findLength(head1);
        int list2Len = obj.findLength(head2);

//        ListNode list1Reverse = obj.reverseList(head1);
//        ListNode list2Reverse = obj.reverseList(head2);

        ListNode ans = obj.addTwoNumbers(head1, head2);
        obj.print(ans);
    }

    public void print(ListNode l1) {
        ListNode temp = l1;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        int divide = 0;
        ListNode node = null;

        while(l1 != null && l2 !=  null) {

            int sum = l1.data + l2.data + divide;


            if (String.valueOf(sum).length() > 1) {
                 divide = sum / 10;
                int remainder = sum % 10;
                node = new ListNode(remainder);
            }
            else {
                divide = 0;
                node = new ListNode(sum);
            }

            if (root != null) {
                node.next = root;
            }
            root = node;

            l1 = l1.next;
            l2 = l2.next;

            if (divide != 0 && l2 == null && l1 == null) {
                node = new ListNode(divide);
                node.next = root;
                root = node;
            }
        }

        // when size of first list is greater than second list
        while (l1 != null) {

            int sum = l1.data + divide;

            if (String.valueOf(sum).length() > 1) {
                divide = sum / 10;
                int remainder = sum % 10;
                node = new ListNode(remainder);
            }
            else {
                node = new ListNode(sum);
            }

            if (root != null) {
                node.next = root;
            }
            root = node;

            l1 = l1.next;

            if (divide != 0 && l1 == null) {
                node = new ListNode(divide);
                node.next = root;
                root = node;
            }

        }

        while (l2 != null) {

            int sum = l2.data + divide;

            if (String.valueOf(sum).length() > 1) {
                divide = sum / 10;
                int remainder = sum % 10;
                node = new ListNode(remainder);
            }
            else {
                node = new ListNode(sum);
            }

            if (root != null) {
                node.next = root;
            }
            root = node;

            l2 = l2.next;

            if (divide != 0 && l2 == null) {
                node = new ListNode(divide);
                node.next = root;
                root = node;
            }

        }

        return reverseList(root);
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode org = head;
        while (head != null) {
            ListNode previous = head.next;
            head.next = temp;
            temp = head;
            head = previous;
        }

        head = org;
        return temp;
    }

    protected int findLength(ListNode node) {
        int length = 0;

        while (node != null) {
            length = length + 1;
            node = node.next;
        }
        return length;
    }

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
}
