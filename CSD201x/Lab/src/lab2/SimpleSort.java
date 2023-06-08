package lab2;

class SimpleSort {
    int[] a;
    int n;

    SimpleSort() {
    }

    /**
     * Tạo một instance clone của mảng được truyền vào tham số */
    SimpleSort(int[] o) {
        n = o.length;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = o[i];
        }
    }

    /**
     * Hiển thị thông tin ra màn hình */
    void display() {
        for(int e : a) {
            System.out.print(" " + e);
        }
        System.out.println();
    }

    /**
     * Đổi chỗ 2 element a[i] và a[j] */
    void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Hàm sắp xếp bằng thuật toán nổi bọt,
     * sau mỗi bước sắp xếp gọi tới hàm display()
     * để hiển thị giá trị của mảng a ra màn hình */
    void bubbleSort() {
        for (int i = n - 2 ; i >= 0 ; i--) {
            boolean hasSwap = false;
            for (int j = 0; j <= i ; j++) {
                if (a[j] > a[j+1]) {
                    swap(j, j+1);   // Đổi vị trí a[j] và a[j+1]
                    hasSwap = true;
                }
            }
            display();

            // Nếu không có swap thì mảng đã được sắp xếp, thoát vòng lặp
            if (!hasSwap) break;
        }
    }

    /**
     * Hàm sắp xếp bằng thuật toán selectSort,
     * sau mỗi bước sắp xếp gọi tới hàm display()
     * để hiển thị giá trị của mảng a ra màn hình */
    void selectSort() {
        for (int i = 0; i < n -1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
        display();
    }

    /**
     * Hàm sắp xếp bằng thuật toán insertSort,
     * sau mỗi bước sắp xếp gọi tới hàm display()
     * để hiển thị giá trị của mảng a ra màn hình */
    void insertSort() {
        int i, j, x;
        for (i = 0; i < n; i++) {
            x = a[i];
            j = i;
            while (j > 0 && x < a[j-1]) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }

        display();
        
    }

    /**
     * Search (int value) trả về số nguyên là vị trí đầu tiên của value
     * trong mảng a sử dụng thuật toán tìm kiếm tuyến tính */
    int search(int value) {
        for (int i = 0; i < n; i++) {
            if (a[i] == value) {
                return i;
            }
        }

        return -1; // Khong tim thay
    }
}

