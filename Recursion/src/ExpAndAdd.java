import java.util.ArrayList;
import java.util.List;

class ExpAndAdd {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void backtrack(
            String num,
            long target,
            int index,
            long value,
            long prev,
            String expression,
            List<String> result
    ) {
        if (index == num.length()) {
            if (value == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String current = num.substring(index, i + 1);
            long currentValue = Long.parseLong(current);
            if (index == 0) {
                backtrack(
                        num,
                        target,
                        i + 1,
                        currentValue,
                        currentValue,
                        current,
                        result
                );
            } else {
                backtrack(
                        num,
                        target,
                        i + 1,
                        value + currentValue,
                        currentValue,
                        expression + "+" + current,
                        result
                );
                backtrack(
                        num,
                        target,
                        i + 1,
                        value - currentValue,
                        -currentValue,
                        expression + "-" + current,
                        result
                );
                backtrack(
                        num,
                        target,
                        i + 1,
                        value - prev + prev * currentValue,
                        prev * currentValue,
                        expression + "*" + current,
                        result
                );
            }
        }
    }

    public static void main(String[] args) {
        ExpAndAdd solver = new ExpAndAdd();

        String num = "123";
        int target = 6;

        List<String> result = solver.addOperators(num, target);

        System.out.println("Input: " + num);
        System.out.println("Target: " + target);
        System.out.println("Expressions: " + result);
    }
}