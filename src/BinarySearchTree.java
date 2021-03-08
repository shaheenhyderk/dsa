class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    void insert(int data) {
        Node currentNode = root;
        if (currentNode == null){
            root = new Node(data);
            return;
        }
        while (true) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    boolean contains(int data) {
        Node currentNode = root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;
    }

    void remove(int data) {
        removeHelper(data, root, null);
    }

    void removeHelper(int data, Node currentNode, Node parentNode) {
        while (currentNode != null) {
            if (data < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.data = getMinValue(currentNode.right);
                    removeHelper(currentNode.data, currentNode.right, currentNode);
                } else if (parentNode == null) {
                    if (currentNode.left != null) {
                        currentNode.data = currentNode.left.data;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else if (currentNode.right != null) {
                        currentNode.data = currentNode.right.data;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    } else {
                        root = null;
                    }
                } else if (parentNode.left == currentNode) {
                    if (currentNode.left != null) {
                        parentNode.left = currentNode.left;
                    } else {
                        parentNode.left = currentNode.right;
                    }
                } else if (parentNode.right == currentNode) {
                    if (currentNode.left != null) {
                        parentNode.right = currentNode.left;
                    } else {
                        parentNode.right = currentNode.right;
                    }
                }
                break;
            }
        }
    }

    int getMinValue(Node node) {
        if (node.left == null) {
            return node.data;
        } else {
            return getMinValue(node.left);
        }
    }


    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    int findClosest(int target) {
        Node currentNode = root;
        int closest = currentNode.data;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.data)) {
                closest = currentNode.data;
            }
            if (target < currentNode.data) {
                currentNode = currentNode.left;
            } else if (target > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
//        tree.insertRecursively(50);
        tree.insert(30);
//        tree.insertRecursively(20);
        tree.insert(40);
//        tree.insertRecursively(70);
//        tree.insertIteratively(60);
//        tree.insertRecursively(80);
//        tree.remove(50);
//        tree.insertRecursively(15);
//        tree.insertRecursively(25);
//        tree.insertRecursively(35);
//        tree.insertRecursively(45);
//        tree.insertRecursively(55);
//        tree.insertRecursively(65);
//        tree.insertRecursively(75);
//        tree.insertRecursively(85);

//        tree.remove(50);

        // print inorder traversal of the BST
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.postorder();

//        System.out.println(tree.findClosest(39));
    }

}