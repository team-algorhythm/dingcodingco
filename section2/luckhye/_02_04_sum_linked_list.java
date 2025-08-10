package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_04_sum_linked_list {

  public static void main(String[] args) {
    /*
      Q.  다음과 같은 두 링크드 리스트를 입력받았을 때, 합산한 값을 반환하시오.

          예를 들어 아래와 같은 링크드 리스트를 입력받았다면,
          각각 678, 354 이므로 두개의 총합
          678 + 354 = 1032 를 반환해야 한다.

          단, 각 노드의 데이터는 한자리 수 숫자만 들어갈 수 있다.
    */

    //  [6] -> [7] -> [8]
    //  [3] -> [5] -> [4]

    // 처음 부터 노드 설계해서 작업해야함.
    LinkedList linkedList_1 = new LinkedList(6);
    linkedList_1.append(7);
    linkedList_1.append(8);

    System.out.println("기댓값 : 678 , 내답 : " + sum_linked_list_1_1(linkedList_1, null));

    LinkedList linkedList_2 = new LinkedList(3);
    linkedList_2.append(5);
    linkedList_2.append(4);
    System.out.println("기댓값 : 1032 , 내답 : " + sum_linked_list_1_2(linkedList_1, linkedList_2));
    System.out.println("기댓값 : 1032 ,리팩토링,  내답 : " + sum_linked_list_1_3(linkedList_1, linkedList_2));

  }


  private static class Node {

    int curValue;
    Node next;

    public Node(int value) {
      curValue = value;
    }
  }


  private static class LinkedList {

    Node head;

    public LinkedList(int value) {
      head = new Node(value);
    }

    public void append(int value) {
      Node cur = this.head;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = new Node(value);
    }

  }

  public static int sum_linked_list_1_1(LinkedList linkedList1, LinkedList LinkedList2) {

    // 1. 순차 리니어 : 현재 노드를 cur로 받고, cur을 이동시킨다.
    // 2. 이동할때의 자릿수를 10단위로 높히고, 기존과 함친다.
    // 3. curd을 모두 이동시켰음 종료한다.

    int sum_1 = 0;
    Node cur = linkedList1.head;
//    while (cur.next != null) { => 마지막 cur.value가 안나옴.
    while (cur != null) {
      // 맨 앞이 제일 높은 자리. 반복 횟수만큼 자리수가 증가한다.
      // 345
      // ((3 * 10) + 4) * 10
      sum_1 = (sum_1 + cur.curValue) * 10;
//      System.out.println("cur.curValue = " + cur.curValue + ", sum_1 = " + sum_1);
//      cur.curValue = 6, sum_1 = 60
//      cur.curValue = 7, sum_1 = 670
//      cur.curValue = 8, sum_1 = 6780
//      6780
      cur = cur.next;
    }

//      cur.curValue = 6, sum_1 = 6
//      cur.curValue = 7, sum_1 = 67
//      cur.curValue = 8, sum_1 = 678
    Node cur_1_1 = linkedList1.head;
    int sum_1_1 = 0;
    while (cur_1_1 != null) {
      sum_1_1 = sum_1_1 * 10 + cur_1_1.curValue;
      cur_1_1 = cur_1_1.next;
    }

    return sum_1_1;
  }


  public static int sum_linked_list_1_2(LinkedList linkedList1, LinkedList LinkedList2) {

    int sum_1 = 0;
    Node cur = linkedList1.head;
    while (cur != null) {
      sum_1 = (sum_1 * 10) + cur.curValue;
      cur = cur.next;
    }
    System.out.println("sum_1 = " + sum_1);

    int sum_2 = 0;
    Node cur_2 = LinkedList2.head;
    while (cur_2 != null) {
      sum_2 = sum_2 * 10 + cur_2.curValue;
      cur_2 = cur_2.next;
    }
    System.out.println("sum_2 = " + sum_2);

    return sum_1 + sum_2;
  }

  // 리팩토리
  // 중복된 코드는 인풋이 추가됨에 따라 관리할 코드량이 많아진다.\
  // ex. sum_linked_list_1_3(LinkedList linkedList1, LinkedList LinkedList2, ...)
  public static int sum_linked_list_1_3(LinkedList linkedList1, LinkedList LinkedList2) {

    // 변경이 필요한 데이터만 분리하면 된다.
    int sum_1 = getSum(linkedList1);
    System.out.println("sum_1 = " + sum_1);

    sum_1 += getSum(LinkedList2);
    System.out.println("sum_1 = " + sum_1);

    return sum_1;
  }

  private static int getSum(LinkedList linkedList) {
    int sum = 0;
    Node cur = linkedList.head;
    while (cur != null) {
      sum = (sum * 10) + cur.curValue;
      cur = cur.next;
    }
    return sum;
  }


  // head
  // cur : 현재 노드를 탐색하는 포인터를 cur이라는 변수에 담아두겠습니다.
  // cur이라는 변수가 현재 위치한 노드의 데이터를 뽑아서 sum_1을 더해줍니다.
  // cur이 한번 이동하게 된다 = 쳑


  // cur
  // 6 * 10 + 7 = 67

  // cur
  // 67 * 10 + 8 = 678

  // 기존값에 10을 곱한후 더해야 우리가 원하는 숫자가 된다.

}