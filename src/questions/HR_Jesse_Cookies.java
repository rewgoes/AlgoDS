package questions;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem

public class HR_Jesse_Cookies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] heap = new int[N];
        int heapSize = 0;
             
        int i;
        
        for (i = 0; i < N; i++) {
            add(heap, heapSize, sc.nextInt());
            heapSize++;
        }
        
        int steps = 0;
        
        while (heapSize >= 2 && top(heap, heapSize) < K) {
        	int val1 = pop(heap, heapSize--);
        	int val2 = pop(heap, heapSize--);
        	add(heap, heapSize++, val1 + (2 * val2));
        	steps++;
        }
        
        if (top(heap, heapSize) >= K) {
        	System.out.print(steps);
        } else {
        	System.out.print(-1);
        }
    }
    
    public static void add(int[] heap, int heapSize, int value) {
        heap[heapSize] = value;
        
        int parent = (heapSize - 1) / 2;
        while(parent >= 0 && heap[parent] > heap[heapSize]) {
            heap[parent] += heap[heapSize];
            heap[heapSize] = heap[parent] - heap[heapSize];
            heap[parent] -= heap[heapSize];
            heapSize = parent;
            parent = (heapSize - 1) / 2;
        }
    }
    
    public static Integer pop(int[] heap, int heapSize) {
        Integer value = null;
        heapSize--;
        
        if (heapSize >= 0) {
            value = heap[0];
            heap[0] = heap[heapSize--];
            int current = 0;
            int child = current * 2 + 1;
            while (child <= heapSize) {
                boolean left = heap[current] > heap[child];
                boolean right = (child + 1 <= heapSize) && heap[current] > heap[child + 1];
                
                if (left || right) {
                    if (right && heap[child + 1] < heap[child]) {
                        child++;
                    }
                    
                    heap[current] += heap[child];
                    heap[child] = heap[current] - heap[child];
                    heap[current] -= heap[child];
                    
                    current = child;
                    child = current * 2 + 1;
                } else {
                    child = heapSize + 1;
                }
            }
        }
        
        return value;
    }
    
     public static Integer top(int[] heap, int heapSize) {
        Integer value = null;
        
        if (heapSize > 0) {
            value = heap[0];
        }
        
        return value;
     }
}