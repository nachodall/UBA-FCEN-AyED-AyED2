package aed;

public class Heap {
    private Router [] arr;
    private int size;

    public Heap(Router [] routers){
        this.arr = routers;
        heapSort();
        this.size = routers.length;
    }

    private void heapSort(){
		int N = arr.length;

		// Build heap (rearrange array)
		for (int i = N / 2 - 1; i >= 0; i--){
			heapifySort(N, i);
        }
		// One by one extract an element from heap
		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			Router temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapifySort(i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	private void heapifySort(int N, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && arr[l].compareTo(arr[largest]) == -1){
			largest = l;
        }
		// If right child is larger than largest so far
		if (r < N && arr[r].compareTo(arr[largest]) == -1){
			largest = r;
        }
		// If largest is not root
		if (largest != i) {
			Router swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapifySort(N, largest);
		}
	}

	private void heapify(int N, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && arr[l].compareTo(arr[largest]) == 1){
			largest = l;
        }
		// If right child is larger than largest so far
		if (r < N && arr[r].compareTo(arr[largest]) == 1){
			largest = r;
        }
		// If largest is not root
		if (largest != i) {
			Router swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(N, largest);
		}
	}

    public Router desencolar(){ //O(log P) 
        Router elem = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(size, 0);
        return elem;
	}  

}
