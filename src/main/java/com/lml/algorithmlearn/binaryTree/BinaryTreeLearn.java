package com.lml.algorithmlearn.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeLearn {

    public List<Integer> preorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度 每个节点访问一次 O(n)
        //空间复杂度 递归的深度为树的深度，即o(n)
        //前序遍历 首先根节点、然后左子树，然后右子树
        List<Integer> result = new LinkedList<>();
        getTreeValue(root, result);
        return  result;
    }

    private void getTreeValue(TreeNode treeNode, List<Integer> result) {

        if (treeNode != null) {
            result.add(treeNode.val);
            if (treeNode.left != null) {
                getTreeValue(treeNode.left, result);
            }
            if (treeNode.right != null) {
                getTreeValue(treeNode.right, result);
            }
        }
    }

    public List<Integer> preorderTraversalLoop(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        //前序遍历 首先根节点、然后左子树，然后右子树
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return  result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n) 每个节点访问一次
        //空间复杂度O(n) 递归的深度
        //中序排序 先遍历左子树，然后访问根节点，然后遍历右子树
        List<Integer> result = new LinkedList<>();
        inorderRecursion(root, result);
        return  result;
    }

    private void inorderRecursion(TreeNode node, List<Integer> result) {

        if (node != null) {
            inorderRecursion(node.left, result);
            result.add(node.val);
            inorderRecursion(node.right, result);
        }
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {

        //n为树的节点数
        //时间复杂度 O(n)
        //空间复杂度 O(n)
        //中序排序 先遍历左子树，然后访问根节点，然后遍历右子树
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        //后序遍历 先遍历左子树，然后遍历右子树，然后访问根元素
        List<Integer> result = new LinkedList<>();
        postorderRecursion(root, result);
        return  result;
    }

    private void postorderRecursion(TreeNode node,  List<Integer> result) {

        if (node != null) {
            postorderRecursion(node.left, result);
            postorderRecursion(node.right, result);
            result.add(node.val);
        }
    }

    public List<Integer> postorderTraversalLoop(TreeNode root) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode node = root;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right != null && pre != node.right) {
                stack.push(node);
                node = node.right;
            } else {
                result.add(node.val);
                pre = node;
                node = null;
            }
        }
        return result;
    }

    public List<Integer> preorderMorris(TreeNode root) {

        //n为节点数
        //时间复杂度O(n)
        //空间复杂度O(1)
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {

            mostRight = cur.left;
            if (mostRight != null) {

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    result.add(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                result.add(cur.val);
            }
            cur = cur.right;
        }
        return result;
    }

    public static List<Integer> inorderMorris(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode cur = root;
        TreeNode mostRight = null;

        while (cur != null) {

            mostRight = cur.left;
            if (mostRight != null) {

                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public List<Integer> postorderMorris(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {

            mostRight = mostRight.left;
            if (mostRight != null) {

                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right ==  null) {

                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    addPath(result, cur.left);
                }
            }
            cur = cur.right;
        }
        return result;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        //n为节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> integerList = new ArrayList<>();
            int size = queue.size();
            for (int i = 1; i <= size; i++) {

                TreeNode node = queue.poll();
                integerList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(integerList);
        }
        return result;
    }

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {

        getDepth(root, 1);
        return maxDepth;
    }

    private void getDepth(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        getDepth(root.left, depth + 1);
        getDepth(root.right, depth + 1);
    }

    public int maxDepthLow(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static boolean isSymmetricLoop(TreeNode root) {

        //n为节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        //循环的方式判断二叉树是不是一个对称二叉树
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        return isSymmetricRecursion(root, root);
    }

    private static boolean isSymmetricRecursion(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && isSymmetricRecursion(left.right, right.left) && isSymmetricRecursion(left.left, right.right);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        //时间复杂度O(n)
        //空间复杂度O(n)
//        if (root == null) {
//            return false;
//        }
//        return hasPathSumUp(root, targetSum, 0);
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private boolean hasPathSumUp(TreeNode root, int targetSum, int sum) {

        if (root == null) {
            return false;
        }
        if (root != null) {
            sum += root.val;
        }
        if (root != null && root.left == null && root.right == null && sum == targetSum) {
            return true;
        }
        return hasPathSumUp(root.left, targetSum, sum) || hasPathSumUp(root.right, targetSum, sum);
    }

    Map<Integer, Integer> inorderIndex = new HashMap<>();
    int[] inorder; int[] postorder;
    int post_idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //时间复杂度 O(n)
        //空间复杂度O(n) 因为栈地空间复杂度为树的高度，树的高度小于节点数
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return calculateBinaryTree(0, postorder.length - 1);
    }

    private TreeNode calculateBinaryTree(int left, int right) {

        if (left > right) {
            return null;
        }

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = inorderIndex.get(root_val);
        post_idx--;


        root.right = calculateBinaryTree(index + 1, right);
        root.left = calculateBinaryTree(left, index - 1);
        return root;
    }

    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] preOrderVal; int[] inorderVal;
    int preOrderIndex = 0;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        this.preOrderVal = preorder;
        this.inorderVal = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helpTreeNode(0, inorder.length - 1);
    }

    private TreeNode helpTreeNode(int left, int right) {

        if (left > right) {
            return null;
        }

        int val = preOrderVal[preOrderIndex];
        TreeNode root = new TreeNode(val);
        int index = inorderMap.get(val);
        preOrderIndex++;

        root.left = helpTreeNode(left, index - 1);
        root.right = helpTreeNode(index + 1, right);
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //n为节点数
        //时间复杂度O(n) 因为比较的时间复杂度为o(logn),但是获取中序遍历的时间复杂度为O(n)
        //空间复杂度O(n)
        //大致思路,获取全部树的列表.然后比较其顺序
        List<Integer> integerList = new ArrayList<>();
        lowestCommonAncestorRecursion(root, integerList);

        TreeNode head = root;
        while (head != null) {
            int pIndex = integerList.indexOf(p.val);
            int qIndex = integerList.indexOf(q.val);
            int rootIndex = integerList.indexOf(head.val);
            if (pIndex == rootIndex || qIndex == rootIndex) {
                return head;
            }
            if ((pIndex < rootIndex && qIndex > rootIndex) || (pIndex > rootIndex && qIndex < rootIndex)) {
                return head;
            }
            if (pIndex < rootIndex && qIndex < rootIndex) {
                head = head.left;
            }
            if (pIndex > rootIndex && qIndex > rootIndex) {
                head = head.right;
            }
        }
        return head;
    }

    Map<Integer, TreeNode> hashMap = new HashMap<>();
    Set<Integer> visitNode = new HashSet<>();
    public  TreeNode lowestCommonAncestorByHash(TreeNode root, TreeNode p, TreeNode q) {

        //时间复杂度 o(n)
        //空间复杂度  由于要进行递归和存储节点，所以空间复杂度为o(n)
        this.depthFirstSearch(root);
        while (p != null) {
            visitNode.add(p.val);
            p = hashMap.get(p.val);
        }

        while (q != null) {
            if (visitNode.contains(q.val)) {
                return q;
            }
            q = hashMap.get(q.val);
        }
        return null;
    }

    private void depthFirstSearch(TreeNode root) {
        if (root.left != null) {
            hashMap.put(root.left.val, root);
            depthFirstSearch(root.left);
        }
        if (root.right != null) {
            hashMap.put(root.right.val, root);
            depthFirstSearch(root.right);
        }
    }

    private static void lowestCommonAncestorRecursion(TreeNode node, List<Integer> integerList) {

        if (node != null) {
            lowestCommonAncestorRecursion(node.left, integerList);
            integerList.add(node.val);
            lowestCommonAncestorRecursion(node.right, integerList);
        }
    }

    public static void main(String[] args) {

        TreeNode rootLeftLeft = new TreeNode(6);
        TreeNode rootLeftRightLeft = new TreeNode(7);
        TreeNode rootLeftRightRight = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(2, rootLeftRightLeft, rootLeftRightRight);
        TreeNode rootLeft = new TreeNode(5, rootLeftLeft, rootLeftRight);
        TreeNode rootRightLeft = new TreeNode(0);
        TreeNode rootRightRight = new TreeNode(8);
        TreeNode rootRight = new TreeNode(1, rootRightLeft, rootRightRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);
        System.out.println(new BinaryTreeLearn().lowestCommonAncestorByHash(root, rootLeft, rootRight).val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }

}
