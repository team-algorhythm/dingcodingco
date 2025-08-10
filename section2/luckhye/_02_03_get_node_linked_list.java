package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_03_get_node_linked_list {

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList(5);
    linkedList.append(12);
    linkedList.append(0); // 5를 들고 있는 노드를
  }


  public static class Node {

    int data;
    Node next;

    // 노드 생성자.
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }


  public static class LinkedList {

    Node head;

    // 생성자.
    public LinkedList(int value) {
      // this.head.data = value;
      this.head = new Node(value);
    }

    // 어팬드
    public void append(int value) {
      Node cur = this.head;
      // 리니어 저장방식이니 와일 루프.
      while (cur.next != null) {
        // 다음 저장.
        cur = cur.next;
      }
      // 마지막 노드에 다음 노드를 생성하여 저장.
      cur.next = new Node(value);
    }

    // 문제 : "index 번째 노드를 반환해보세요!"
    // 내답 : 답.
    // 5를 들고 있는 노드를 반환해야합니다.
    public Node getNode_dahye(int index) {
      //링크드 리스트는 해드를 관리하고, 노드는 넥스트를 관리함.
      // '기준'을 초기 노드로 시작.
      Node cur = this.head;
      for (int i = 1; i < 5; i++) {

        if(cur.next == null){
          throw new IllegalArgumentException("인덱스 만큼의 노드가 없는데요?");
        }
        cur = cur.next;
      }
      return cur;
    }


    public Node getNode(int index) {
      int cur_index = 0;
      Node cur = this.head;

      // 인덱스가 다르면
      while(cur_index != index){
        cur_index++;
        cur = cur.next;
      }

      return cur;
    }
    // 기준 차이점 : 나는 인덱스 2부터 시작. 2에 의존적임. 그러나 while문과 다르다 조건으로 초기값 2에서 벗어남.


    // 어팬드 방식
    // 0      1       2      3
    // [5] -> [12] -> [7] -> [8]

    // 1번째 인덱스에 7을 추가해줘. (어팬드와 다른 방식)
    // 0     1     2     3     4
    // [5] -> [7] -> [12] -> [7] -> [8]


    public Node addNode_dahye(int index, int value) {

      // ["자갈"] -> ["밀가루"] -> ["우편"]

      // ["흑연"]을 1번에 추가

      // 1. ["자갈"] 찾고 2. ["자갈"] ->["흑연"] 연결하고
      // 3. ["자갈"] ->["흑연"]    ["밀가루"] -> ["우편"]
      // 4. ["자갈"] ->["흑연"] ->["밀가루"] -> ["우편"]

      // 기준 노드 하나 만들고, 주로 현재 상태 들어감.
      int prev_index = index > 1 ? index - 1 : 0;
      Node cur = getNode(prev_index);


      // 노드가 요소를 가져왔을 뿐인데, 그 이후(넥스트들) 노드들이 딸려옴.
      // 기존 노드 기억.
      Node nextNode = cur.next;

      // 신규도드 설정.
      Node new_node = new Node(value);
      // 신규 다음 노드에 기존 노드 저장.
      new_node.next = nextNode;

      return this.head;
    }


    public void addNode(int index, int value) {
      // 신규도드 설정.
      Node new_node = new Node(value);


      // 해드 단위로 생존 중......
      if(index == 0){
        new_node.next = this.head;
        return;
      }

      Node prev_node = getNode( index - 1);
      Node next_node = prev_node.next;
      prev_node.next = new_node;
      new_node.next = next_node;
    }
    // 기준이 자료가 해드단위로 살아있다는 점. 링크드리스트는 해드 리니어 자체임...
    // 해드 단위로 CURD하면됨...




    // 흑연칸의 다음 노드가 우편이면 된다.
    // index -1 -> index -> index + 1
    // indec -1의 다음 노드를 index + 1로 저장하낟.


  }


  // 인덱스의 노드 찾기
  // 인덱스에 노드 추가
  // 인덱스에 노드 삭제 : 이전 노듸으 넥스트를 다음 노드의 해더



}