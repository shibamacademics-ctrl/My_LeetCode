import java.util.*;
class TreeNode14 {
    int val;
    TreeNode14 left;
    TreeNode14 right;

    TreeNode14(int val) {
        this.val = val;
    }

    TreeNode14(int val, TreeNode14 left, TreeNode14 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Pair2{
    TreeNode14 node;
    int line;
    Pair2(TreeNode14 node, int line){
        this.node = node;
        this.line = line;
    }
}
class TopViewOfBT {
    public static ArrayList<Integer> topView(TreeNode14 root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(root,0));
        while(!q.isEmpty()){
            Pair2 val = q.remove();
            int line = val.line;
            TreeNode14 temp = val.node;
            if(!map.containsKey(line)){
                map.put(line,temp.val);
            }
            if(temp.left!=null){
                q.add(new Pair2(temp.left,line-1));
            }
            if(temp.right!=null){
                q.add(new Pair2(temp.right,line+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode14 root = new TreeNode14(1);

        root.left = new TreeNode14(2);
        root.right = new TreeNode14(3);

        root.left.right = new TreeNode14(4);
        root.right.right = new TreeNode14(5);

        root.left.right.right = new TreeNode14(6);

        ArrayList<Integer> result = topView(root);

        System.out.println("Top View: " + result);
    }
}
