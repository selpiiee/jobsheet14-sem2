package Week14;

public class BinaryTree21 {

    Node21 root;

    public BinaryTree21() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Student21 data) {
        if (isEmpty()) {
            root = new Node21(data);
        } else {
            Node21 current = root;
            while (true) {
                if (data.gpa < current.data.gpa) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node21(data);
                        break;
                    }
                } else if (data.gpa > current.data.gpa) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node21(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public boolean find(double gpa) {
        boolean result = false;
        Node21 current = root;
        while (current != null) {
            if (current.data.gpa == gpa) {
                return true;
            } else if (gpa < current.data.gpa) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    public void traversePreOrder(Node21 node) {
        if (node != null) {
            node.data.print();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node21 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.data.print();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node21 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.data.print();
        }
    }

    Node21 getSuccessor(Node21 del) {
        Node21 successor = del.right;
        Node21 successorParent = del;
        while(successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }

        return successor;
    }

    public void delete(double gpa) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
         Node21 parent = root;
         Node21 current = root;
         boolean isLeftChild = false;
         while(current.data.gpa != gpa) {
            parent = current;
            if(gpa < current.data.gpa) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            if(current == null) {
                System.out.println("Couldn't find data!");
                return;
            }
         }

         if (current.left == null && current.right == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
         } else if (current.right == null) {
            if(current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.right;
            }
         } else if (current.left == null) {
            if(current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
         } else {
            Node21 successor =getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = current.left;
            }
            successor.left = current.left;
         }
    }

    public void addRekursif(Student21 data) {
        if (isEmpty()) {
            root = new Node21(data);
        } else {
            addRekursif(root, data);
        }
    }

    private void addRekursif(Node21 current, Student21 data) {
        if (data.gpa < current.data.gpa) {
            if (current.left == null) {
                current.left = new Node21(data);
            } else {
                addRekursif(current.left, data);
            }
        } else if (data.gpa > current.data.gpa) {
            if (current.right == null) {
                current.right = new Node21(data);
            } else {
                addRekursif(current.right, data);
            }
        }
    }

    public void getMinGPA() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node21 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Student with the lowest GPA");
        current.data.print();
    }

    public void getMaxGPA() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node21 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Student with the highest GPA");
        current.data.print();
    }

    public void displayStudentsWithGPAAbove(double threshold) {
        System.out.println("Student with a GPA above " + threshold);
        displayStudentsWithGPAAbove(root, threshold);
    }

    private void displayStudentsWithGPAAbove(Node21 node, double threshold) {
        if (node != null) {
            displayStudentsWithGPAAbove(node.left, threshold);
            if (node.data.gpa > threshold) {
                node.data.print();
            }
            displayStudentsWithGPAAbove(node.right, threshold);
        }
    }
}
