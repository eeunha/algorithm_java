/*
I: int[] scoville, int k
O: int 섞어야 하는 최소 횟수
C: scoville의 길이는 2 이상 1,000,000 이하
    K는 0 이상 1,000,000,000 이하
    scoville의 원소는 각각 0 이상 1,000,000 이하
    scoville의 원소는 각각 0 이상 1,000,000 이하
E:

스코빌 지수를 K 이상으로 만들고 싶다.
-> 스코빌 지수가 가장 낮은 두 개의 음식을 섞는다.
=> 섞은 음식의 스코빌 지수 = 가장 안매운 음식의 스코빌 지수 + (두 번째로 안매운 음식의 스코빌 지수 * 2)

모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다.


scoville에는 정렬되지 않았다.

최소 힙을 만들어서 루트 + 루트의 왼쪽 자식을 섞어 새로운 음식으로 만든다.

최소 힙의 루트가 k이상일 때까지 반복한다.

ds: min heap
algorithm:

1. scoville을 min heap으로 만들기
2.

time:
solution:
*/
class Solution {
    public int[] heap;
    public int size;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        buildHeap(scoville);
        printHeapArray();
        
        return answer;
    }
    
    public void buildHeap(int[] arr){
        this.size = arr.length;
        this.heap = new int[size + 1];
        System.arraycopy(arr, 0, heap, 1, size);
        
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }
    
    public void minHeapify(int i){
        int left = 2 * i;
        int right = 2 * i + 1;
        int smallest;
        
        smallest = (left <= size && heap[left] < heap[i]) ? left : i;
        
        if (right <= size && heap[right] < heap[i]) {
            smallest = right;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    
    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void printHeapArray() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}