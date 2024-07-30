import java.util.*;
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }
}
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
public class TaskManagementSystem {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equalsIgnoreCase(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.task.getTaskId() + ", Name: " + current.task.getTaskName() + ", Status: " + current.task.getStatus());
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equalsIgnoreCase(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagementSystem tms = new TaskManagementSystem();
        
        System.out.println("Enter number of tasks:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter taskId:");
            String taskId = sc.nextLine();
            System.out.println("Enter taskName:");
            String taskName = sc.nextLine();
            System.out.println("Enter status:");
            String status = sc.nextLine();
            tms.addTask(new Task(taskId, taskName, status));
        }

        System.out.println("Traverse Tasks:");
        tms.traverseTasks();

        System.out.println("Search Task:");
        System.out.println("Enter taskId:");
        String searchTaskId = sc.nextLine();
        Task task = tms.searchTask(searchTaskId);
        System.out.println("Found: " + (task != null ? task.getTaskName() : "null"));

        System.out.println("Delete Task:");
        System.out.println("Enter taskId:");
        String deleteTaskId = sc.nextLine();
        tms.deleteTask(deleteTaskId);
        tms.traverseTasks();

        sc.close(); // Close the scanner
    }
}