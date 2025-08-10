package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_02_append_linked_list {

  public static void main(String[] args) {
    // 무엇을 만들고자 하는가, 무엇을 어디까지 표현했는가?

    // ["기관실"] -> ["시멘트"] -> ["자갈"] -> ["밀가루"] -> ["우편"]

    Node node = new Node("3");
    System.out.println("node.data = " + node.data +", node.next = " + node.next);

    LinkedList linkedList = new LinkedList("5");
    System.out.println("linkedList.head.data = " + linkedList.head.data);

    // [5] -> [3]
    Node first_node = new Node("5");
    Node next_node = new Node("3");
    first_node.next = next_node; // node.next는 노드임. 스트링이 아님.

    // 이 과정이 귀찮아서, 링크드리스트에서 head 뒤에 붙여주는것

    // 현재 상태                목표상태
    // head
    //                        여기(next)
    // [3] → [5] → [6] → [8]
    // [3] → [5] → [6] → [8] -> None


    // next : curr -> curr -> curr -> curr
    //        [3] → [5] → [6] → [8] -> None

    // 링크드리스트에 가장 끝에 있는 노드에 새로운 노드를 연결해줘.
    LinkedList linkedList2 = new LinkedList("3");
    linkedList2.append("5");
    linkedList2.append("12");

    // head
    // [3] -> [5]
    // 링크드리스트에 저장한 해드를 따라가면서 현재 있는 노드들을 전부 출력하는 함수.
    // 내가 가진 정보:해드 (링크드리스트에서 맨 앞에 있는 노드)
    linkedList2.print_all();
  }
  public static class Node {

    String data;
    Node next; // 이거 스트링 아니고 노드임.

    public Node(String data) {
      this.data = data;
      this.next = null;
    }
  }


  private static class LinkedList {

    Node head;

    private LinkedList(String value) {
      head = new Node(value);
    }

    private void append(String value){

      // 노드
      Node cur = head;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = new Node(value); // 마지막 노드에 새로운 노드를 추가
    }


    private void print_all() {
      System.out.println("print_all() 호출됨");
      Node curr = head;
      while (curr != null){ // 노드들을 따라간다! 따라가기 위한 방법으로 커런트에 낵스트를 넣으면서 따라간다.
        System.out.println("curr.data = " + curr.data);
        curr = curr.next; // 다음 노드로 이동
      }

      // 노드가 존재하면 출력.
    }

  }

}