package util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static TreeNode getParentNode(TreeNode root, int val){
        if(null == root.left && val <= root.val){
            return root;
        }
        if(null == root.right && val > root.val){
            return root;
        }

        if(val <= root.val){
           return getParentNode(root.left, val);
        }else{
            return getParentNode(root.right, val);
        }
    }

    private static void buildNode(TreeNode root, int val){
        TreeNode curr = getParentNode(root, val);
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        if(val <=curr.val) {
            curr.left = newNode;
        }else{
            curr.right = newNode;
        }
    }

    public static TreeNode buildBinaryTree(int[] array){
        TreeNode rootNode = new TreeNode();
        rootNode.val = array[0];
        for(int i=1;i<array.length;i++){
            buildNode(rootNode, array[i]);
        }
        return rootNode;
    }
}

