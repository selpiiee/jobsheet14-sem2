package Week14;

public class BinaryTreeArray21 {
    Student21[] data;
    int idxLast;

    public BinaryTreeArray21() {
        data = new Student21[15];
        idxLast = -1;
    }

    void populateData(Student21[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            data[idxStart].print();
            traverseInOrder(2 * idxStart + 2);
        }
    }
    
    public void add(Student21 studentData) {
        if (idxLast == -1) {
            data[0] = studentData;
            idxLast = 0;
            return;
        }

        int current = 0;
        while (current < data.length) {
            if (studentData.gpa < data[current].gpa) {
                int leftChild = 2 * current + 1;
                if (leftChild >= data.length) {
                    System.out.println("The tree is full! Cannot add data " + studentData.name);
                    break;
                }
                if (data[leftChild] == null) {
                    data[leftChild] = studentData;
                    if (leftChild > idxLast) {
                        idxLast = leftChild;
                    }
                    break;
                } else {
                    current = leftChild;
                }
            } 
            else if (studentData.gpa > data[current].gpa) {
                int rightChild = 2 * current + 2;
                if (rightChild >= data.length) {
                    System.out.println("The tree is full! Cannot add data " + studentData.name);
                    break;
                }
                if (data[rightChild] == null) {
                    data[rightChild] = studentData;
                    if (rightChild > idxLast) {
                        idxLast = rightChild;
                    }
                    break;
                } else {
                    current = rightChild;
                }
            } else {
                break;
            }
        }
    }

    public void traversePreOrder() {
        if (idxLast == -1) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("Binary Tree Array (Pre-Order Traversal)");
        traversePreOrder(0);
        System.out.println();
    }

    private void traversePreOrder(int idx) {
        if (idx <= idxLast && data[idx] != null) {
            data[idx].print();
            traversePreOrder(2 * idx + 1);
            traversePreOrder(2 * idx + 2);
        }
    }
}
