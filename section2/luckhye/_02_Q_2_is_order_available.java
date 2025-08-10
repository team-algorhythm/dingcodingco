package dingCoDingCo.chapter2.arrayAndLlinkedList;

import java.util.ArrayList;
import java.util.Objects;

public class _02_Q_2_is_order_available {

  public static void main(String[] args) {
    ArrayList<String> menus = new ArrayList<>();
    menus.add("떡볶이");
    menus.add("만두");
    menus.add("오뎅");
    menus.add("사이다");
    menus.add("콜라");
    System.out.println(menus); // [떡볶이, 만두, 오뎅, 사이다, 콜라]

    ArrayList<String> orders = new ArrayList<>();
    orders.add("오뎅");
    orders.add("콜라");
    orders.add("만두");
    orders.add("김밥");
    System.out.println(orders); // [오뎅, 콜라, 만두]

    System.out.println(is_order_available_dh(menus, orders));
    System.out.println(is_order_available(menus, orders));
  }

  public static boolean is_order_available_dh(ArrayList<String> menus, ArrayList<String> orders) {
    // 다 돈다.
    // 범위를 줄이며 돈다.
    int success_count = 0;

    for (String menu : menus) {
      for (String order : orders) {
        if (Objects.equals(menu, order)) {
          success_count++;
          break;
        }
      }
    }
    System.out.println(success_count);

    return success_count == orders.size();
  }


  public static boolean is_order_available(ArrayList<String> menus, ArrayList<String> orders) {
    // 다 돈다.
    // 범위를 줄이며 돈다.
    int success_count = 0;

    for (String menu : menus) {
      for (String order : orders) {
        if (Objects.equals(menu, order)) {
          success_count++;
          break;
        }
      }
    }
    System.out.println(success_count);

    return success_count == orders.size();
  }

  // 접근한 얘들 가지고 작업.
//  public boolean recrusion(String menu, String order, int success_count) {
  // 접근할 얘들 가지고는 다음상태로 연산이 불가..... => 접근전 객체 가져오기.
}