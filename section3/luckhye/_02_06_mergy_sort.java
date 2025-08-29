package luckhye;

import java.util.Arrays;

public class _02_06_mergy_sort {

  public static void main(String[] args) {
   // --------- 수들 ----------- << 값의 타입을 써야겠다! (데이터 특성이 생각되네)
   // (5, 2, 4, 6) -> (5,2), (4,6)
   // (5,2) -> (5), (2) -> 교환 -> (2,5)

   // --------- 알고리즘 --------
   // 리스트 -> 리스트 절반 -> ... -> 원소 하나 -> 교환해서 순서대로 저장

    // -------- gpt 수들 ------------
    //3️⃣ 예시
    //배열: [2,5] 와 [1,4,6] 합치기
    //비교: 2 > 1 → temp = [1]
    //비교: 2 > 4? no → temp = [1,2]
    //왼쪽 배열 끝 → 남은 원소 없음
    //오른쪽 배열 남은 원소 → temp = [1,2,4,6]

    int[] arr = {5, 2, 4, 6, 1, 3};
    mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6]
  }

  public static void mergeSort(int[] arr, int left, int right ) {
    if (left >= right) return; // ✅ 재귀 종료 조건

    int mid = (left + right) / 2; // ✅ left/right 기준 mid 계산

    mergeSort(arr, left, mid);

    mergeSort(arr, mid + 1, right);

    merge(arr, left, mid, right);
  }

  public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right-left+1]; // [left, right] 배열구간, 인덱스 구간은 닫힌집합이므로, 닫힌집합끼리 뺀 후 일을 더해줘야함.
    int ls = left, rs = mid + 1, k = 0;


    // 왼쪽과 오른쪽 배열 모두 원소가 남아 있을 때만 서로 비교
    while (ls <= mid && rs <= right) {
      if (arr[ls] <= arr[rs]) {
        temp[k++] = arr[ls++];
      }else  {
        temp[k++] = arr[rs++];
      }
    }

    // 아 변수에 저장되기 전이 후전. 후가 후위
    // 후위(postfix, i++) → 변수에 저장되기 전에 기존 값 먼저 사용 → 그 후 1 증가
    // 전위(prefix, ++i) → 변수에 저장되기 전에 먼저 1 증가 → 증가된 값 사용

    // 남은 원소 추가
    while (ls <= mid) temp[k++] = arr[ls++]; // 엘에스를 초기화했기때문에 가능
    while (rs <= right) temp[k++] = arr[rs++];

    // 정렬된 temp를 원래 배열에 복사
    for (int t = 0; t < temp.length; t++) {
      arr[left + t] = temp[t];
    }

  }

//🔹 구조 설명
//
//  분할(Divide)
//
//  배열을 leftmid와 mid+1right로 나눔
//
//  재귀 호출로 더 작은 배열까지 분할
//
//  합치기(Merge)
//
//  두 정렬된 부분을 비교하며 작은 값부터 임시 배열 temp에 넣음
//
//  남은 값도 모두 넣고, array에 다시 복사
//
//  시간복잡도
//
//  배열 n개 → log₂(n)번 분할
//
//  합치기 과정에서 n번 비교
//
//  최종 O(n log n)


}