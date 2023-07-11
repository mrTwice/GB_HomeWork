public class BinTree {
    private Node root;


    public boolean add(int value){
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return  result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

//    public boolean add(int value) {
//        if (root == null) {
//            root = new Node(value);
//            root.color = Color.black;
//            return true;
//        }
//        if (addNode(root, value))
//            return true;
//        return false;
//
//    }



//    private Node addNode(Node node, int value) {
//        if (node.value == value)
//            return null;
//        if (node.value > value) {
//            if (node.left == null) {
//                node.left = new Node(value);
//                return node.left;
//            } else
//                return addNode(node.left, value);
//        } else  {
//            if (node.right == null) {
//                node.right = new Node(value);
//                return node.right;
//            } else
//                return addNode(node.right, value);
//        }
//    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private void  colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node betweenChild = left.right;
        left.right = node;
        node.left = betweenChild;
        left.color = node.color;
        node.color = Color.RED;
        return  left;
    }

    private Node rightSwap(Node node) {
        Node rigth = node.right;
        Node betweenChild = rigth.left;
        rigth.left = node;
        node.right = betweenChild;
        rigth.color = node.color;
        node.color = Color.RED;
        return rigth;
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return  result;
    }

    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }



    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Color color;
//        Node() {
//            this.color = Color.red;
//        }
//
//        Node(int _value) {
//            this.value = _value;
//            this.color = Color.red;
//        }
    }
    private enum Color {RED, BLACK}
}
