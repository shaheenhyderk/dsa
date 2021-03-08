import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class s {
    List<Integer> heap = new ArrayList<>();

    public s() {
    }

    public s(List<Integer> array) {
        buildHeap(array);
    }

    private void buildHeap(List<Integer> array) {
        heap = array;
        int firstParentIdx = (heap.size() - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            shiftDown(currentIdx);
        }
    }

    private void shiftDown(int currentIdx) {
        int endIdx = heap.size() - 1;
        int child1Idx = currentIdx * 2 + 1;
        while (child1Idx <= endIdx) {
            int child2Idx = currentIdx * 2 + 2;
            int idxToSwap;
            if (child2Idx <= endIdx && heap.get(child2Idx) < heap.get(child1Idx)) {
                idxToSwap = child2Idx;
            } else {
                idxToSwap = child1Idx;
            }
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                Collections.swap(heap, currentIdx, idxToSwap);
                currentIdx = idxToSwap;
                child1Idx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    private void shiftUp(int currentIdx) {
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            Collections.swap(heap, currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        int valToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(0);
        return valToRemove;
    }

    public void insert(int value) {
        heap.add(value);
        shiftUp(heap.size() - 1);
    }

    public void display() {
        heap.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2));
        s heap = new s(array);
        heap.insert(3);
        heap.insert(0);
        heap.insert(1);
        heap.remove();
        heap.display();
    }
}
