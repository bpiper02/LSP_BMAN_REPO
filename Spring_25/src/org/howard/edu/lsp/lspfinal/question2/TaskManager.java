package org.howard.edu.lsp.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Manages a collection of tasks with operations to add, retrieve, and update tasks.
 */
public class TaskManager {
    private final Map<String, Task> tasks;

    /**
     * Constructs a new TaskManager with an empty task collection.
     */
    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    /**
     * Adds a new task to the manager.
     *
     * @param name     The unique name of the task
     * @param priority The priority of the task
     * @param status   The initial status of the task
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(name);
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name The name of the task to retrieve
     * @return The task with the specified name
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException(name);
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name   The name of the task to update
     * @param status The new status to set
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status.
     * Tasks are printed in the order: TODO, IN_PROGRESS, DONE.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        
        List<String> statuses = List.of("TODO", "IN_PROGRESS", "DONE");
        for (String status : statuses) {
            List<Task> tasksWithStatus = tasks.values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
            
            if (!tasksWithStatus.isEmpty()) {
                System.out.println(status + ":");
                for (Task task : tasksWithStatus) {
                    System.out.println("  " + task);
                }
            }
        }
    }
} 