
import java.util.*;

 class ClockNode {
    int id;
    int time; // simulated time in seconds

    ClockNode(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class BerkeleyAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        int n = sc.nextInt();

        ClockNode[] nodes = new ClockNode[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter time for process " + i + " (in seconds): ");
            int time = sc.nextInt();
            nodes[i] = new ClockNode(i, time);
        }

        System.out.print("Enter master process ID (0 to " + (n - 1) + "): ");
        int masterId = sc.nextInt();

        synchronizeClocks(nodes, masterId);

        sc.close();
    }

    public static void synchronizeClocks(ClockNode[] nodes, int masterId) {
        ClockNode master = nodes[masterId];

        System.out.println("\nMaster Process ID: " + masterId);
        System.out.println("Master Time: " + master.time + " seconds\n");

        int sum = 0;
        int count = 0;
        int[] diffs = new int[nodes.length];

        // Calculate time differences
        for (ClockNode node : nodes) {
            if (node.id != masterId) {
                int diff = node.time - master.time;
                diffs[node.id] = diff;
                sum += diff;
                count++;
                System.out.println("Process " + node.id + " difference: " + diff);
            }
        }

        // Calculate average difference
        int average = Math.round(sum / (float) (count + 1)); // +1 to include master
        System.out.println("\nAverage difference: " + average);

        // Adjust clocks
        for (ClockNode node : nodes) {
            if (node.id != masterId) {
                node.time -= (diffs[node.id] - average);
            } else {
                node.time += average;
            }
        }

        System.out.println("\nSynchronized Clock Times:");
        for (ClockNode node : nodes) {
            System.out.println("Process " + node.id + ": " + node.time + " seconds");
        }
    }
}
