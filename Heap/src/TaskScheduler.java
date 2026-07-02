import java.util.*;

class Task {
    int freq;
    int time;

    public Task(int f, int t) {
        freq = f;
        time = t;
    }
}

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        Queue<Task> q = new LinkedList<>();

        int[] counts = new int[26];

        for (char t : tasks) {
            counts[t - 'A']++;
        }

        for (int c : counts) {
            if (c > 0) {
                pq.add(new Task(c, 1));
            }
        }

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;

            while (!q.isEmpty() && q.peek().time <= time) {
                pq.add(q.poll());
            }

            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.freq--;

                if (task.freq > 0) {
                    task.time = time + n + 1;
                    q.add(task);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        TaskScheduler sol = new TaskScheduler();

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int ans = sol.leastInterval(tasks, n);

        System.out.println("Least Interval = " + ans);
    }
}