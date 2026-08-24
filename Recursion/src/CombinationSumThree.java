import java.util.ArrayList;
import java.util.List;

class CombinatioSumThree {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return ans;
    }

    private void backtrack(int start, int k, int target, List<Integer> current) {
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (k == 0 || target <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) {
                break;
            }
            current.add(i);
            backtrack(i + 1, k - 1, target - i, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinatioSumThree obj = new CombinatioSumThree();

        int k = 3;
        int n = 9;

        List<List<Integer>> result = obj.combinationSum3(k, n);

        System.out.println(result);
    }
}