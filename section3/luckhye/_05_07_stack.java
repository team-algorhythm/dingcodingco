package luckhye;

import java.sql.SQLOutput;
import java.util.Arrays;

public class _05_07_stack {

  public static void main(String[] args) {

    Stack stack = new Stack();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);
//
//    stack.peek();
//    stack.peek();
//    stack.peek();
//
//    stack.pop();
//    stack.pop();
  }

  public static class Stack {

    Node head;

    public void push(int value) {
      Node valueWrapper = new Node(value); // [2]
      valueWrapper.next = head; // [2] -> [3]
      head = valueWrapper; // stack -> [2] -> [3]
      // 값을 만들어 준다음, 설정한 거.
    }

    public class Node {

      int value;
      Node next;

      public Node(int value) {
        this.value = value;
        this.next = null;
      }
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      while (head != null) {
        sb.append(head.value);
        sb.append("\n");
        head = head.next;
      }
      return sb.toString();
    }

  }


}