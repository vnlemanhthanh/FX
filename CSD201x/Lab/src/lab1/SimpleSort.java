package lab1;

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
    void swap(int i, int j)
    {
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

}

