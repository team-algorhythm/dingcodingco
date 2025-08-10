package dingCoDingCo.chapter2.arrayAndLlinkedList;

import dingCoDingCo.chapter2.arrayAndLlinkedList._02_03_get_node_linked_list.LinkedList;
import dingCoDingCo.chapter2.arrayAndLlinkedList._02_03_get_node_linked_list.Node;

public class _02_Q_1_find_n_for_linked_list {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList(6);
    linkedList.append(7);
    linkedList.append(8);
    System.out.println(linkedList); // [6, 7, 8]

    System.out.println(find_n_for_linked_list(linkedList, 1)); // [6, 7, 8]
    System.out.println(find_n_for_linked_list(linkedList, 2)); // [6, 7, 8]
    System.out.println(find_n_for_linked_list(linkedList, 3)); // [6, 7, 8]

//    System.out.println(find_n_for_linked_list_ref(linkedList, 1));
//    System.out.println(find_n_for_linked_list_ref(linkedList, 2));
//    System.out.println(find_n_for_linked_list_ref(linkedList, 3));
  }

  public static int find_n_for_linked_list(LinkedList linkedList, int k) {

    // 6 7 8
    // k =1 => 8; 끝에서 첫번째
    // k =2 => 7; 끝에서 두번째
    // k =3 => 6; 끝에서 세번째
    //            끝(상수)에서 세번째(상수) => int first_value_from_edn = 사이즈 - index;

    // 수를 담고 있는게 노드니까, 노드를 돌려야함.
    Node curr = linkedList.head;
    // 길이.
    int size = 0;
    while (curr != null) {
      size++;
      curr = curr.next;
    }

    int first_value_from_edn = size - k;
    int i = 0;
    Node curr2 = linkedList.head;

    // 한단계씩 접근 -> 접근한 객체의 속성
    while (i <= first_value_from_edn) {
      if (i == first_value_from_edn) {
        return curr2.data;
      }
      curr2 = curr2.next;
      i++;
    }

    return curr2.data;
  }


  public static int find_n_for_linked_list_ref(LinkedList linkedList, int k) {

    // 6 7 8
    // k =1 => 8; 끝에서 첫번째
    // k =2 => 7; 끝에서 두번째
    // k =3 => 6; 끝에서 세번째
    //            끝(상수)에서 세번째(상수) => int first_value_from_edn = 사이즈 - index;

    // 수를 담고 있는게 노드니까, 노드를 돌려야함.
    Node curr = linkedList.head;
    // 길이.
    int size = 0;
    while (curr != null) {
      size++;
      curr = curr.next;
    }

    int first_value_from_edn = size - k;
    int i = 0;
    Node curr2 = linkedList.head;

    // 한단계씩 접근 -> 접근한 객체의 속성
//    while (i <= first_value_from_edn) {
//      if (i == first_value_from_edn) {
//        return curr2.data;
//      }
//      curr2 = curr2.next;
//      i++;
//    }
//
//    return curr2.data;
    return recrusion(first_value_from_edn, curr2, i);
  }

  // 재귀문은 while에 해당하는 객체와 다음 객체의 연산(행위)를 정해주면 됨. => while 제거, 요소는 인자로
  private static int recrusion(int first_value_from_edn, Node curr2, int count) {
      if (count == first_value_from_edn) {
        return curr2.data;
      }
      curr2 = curr2.next;
      count++;

      return recrusion(first_value_from_edn, curr2, count);
  }

}