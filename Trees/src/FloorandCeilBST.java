import java.util.*;
class TreeNode27 {
    int data;
    TreeNode27 left;
    TreeNode27 right;

    TreeNode27(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class FloorandCeilBST {
    public static List<Integer> floorCeilOfBST(TreeNode27 root, int key) {
        List<Integer> res = new ArrayList<>();
        res.add(floor(root,key));
        res.add(ceil(root,key));
        return res;
    }
    private static int floor(TreeNode27 root,int key){
        int floor = -1;
        while(root!=null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            if(key>root.data){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
    private static int ceil(TreeNode27 root,int key){
        int ceil = -1;
        while(root!=null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(key<root.data){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;

    }

    public static void main(String[] args) {

        TreeNode27 root = new TreeNode27(8);

        root.left = new TreeNode27(4);
        root.right = new TreeNode27(12);

        root.left.left = new TreeNode27(2);
        root.left.right = new TreeNode27(6);

        root.right.left = new TreeNode27(10);
        root.right.right = new TreeNode27(14);

        int key = 5;

        List<Integer> ans = floorCeilOfBST(root, key);

        System.out.println("Floor: " + ans.get(0));
        System.out.println("Ceil: " + ans.get(1));
    }
}
