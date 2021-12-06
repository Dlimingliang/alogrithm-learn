package com.lml.algorithmlearn.binaryTree;

public class AvlTree {
    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public int height;
        TreeNode(int e) {
            this.val = e;
            this.height = 1;
        }
        TreeNode(int e, TreeNode left, TreeNode right) {
            this.val = e;
            this.left = left;
            this.right = right;
            this.height = 1;
        }
    }

    private TreeNode root;
    private int size;

    public AvlTree(TreeNode root, int size) {
        this.root = null;
        this.size = 0;
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode != null) {
            return root.height;
        }
        return 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getBalanceFactory(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    public boolean isBalance() {
        return isBalance(this.root);
    }

    private boolean isBalance(TreeNode node) {
        if (node == null) {
            return true;
        }
        int balanceFactory = Math.abs(getBalanceFactory(node));
        if (balanceFactory > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }

    private TreeNode rightRotate(TreeNode y) {

        TreeNode x = y.left;
        TreeNode t3 = x.right;
        x.right = y;
        y.left = t3;
        //更新高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private TreeNode leftRotate(TreeNode y) {

        TreeNode x = y.right;
        TreeNode t3 = x.left;
        x.left = y;
        y.right = t3;
        //更新高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

        public TreeNode searchBST(TreeNode root, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    //LL, 平衡因子大于1，并且左子树的平衡因子大于等于0 一次右旋
    //RR, 平衡因子小于-1，并且右子树的平衡因子小于等于0 一次左旋
    //LR, 平衡因子大于1，并且左子树的平衡因子小于0 左旋右旋
    //RL, 平衡因子小于-1，并且右子树的平衡因子大于0 右旋左旋
    public TreeNode insertIntoBST(TreeNode root, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactory(root);
        if (balanceFactor > 1 && getBalanceFactory(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balanceFactor < -1 && getBalanceFactory(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balanceFactor > 1 && getBalanceFactory(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balanceFactor < -1 && getBalanceFactory(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                //没有子节点
                root = null;
            } else if (root.right != null) {
                //存在右节点，后继节点和当前节点替换，然后删除这个节点
                TreeNode almostLeftNode = getAlmostLeftNode(root.right);
                root.val = almostLeftNode.val;
                root.right = deleteNode(root.right, almostLeftNode.val);
            } else if (root.left != null) {
                //存在左节点，前置节点和当前节点替换，然后删除这个节点
                TreeNode almostRightNode = getAlmostRightNode(root.left);
                root.val = almostRightNode.val;
                root.left =deleteNode(root.left, almostRightNode.val);
            }
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactory(root);
        if (balanceFactor > 1 && getBalanceFactory(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balanceFactor < -1 && getBalanceFactory(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balanceFactor > 1 && getBalanceFactory(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balanceFactor < -1 && getBalanceFactory(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private TreeNode getAlmostLeftNode(TreeNode treeNode) {

        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    private TreeNode getAlmostRightNode(TreeNode treeNode) {
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }
}
