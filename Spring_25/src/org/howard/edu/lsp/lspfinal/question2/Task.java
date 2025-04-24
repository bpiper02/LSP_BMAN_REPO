package org.howard.edu.lsp.lspfinal.question2;

/**
 * References:
 * 1. Java Documentation on Exception Handling - https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * 2. Java String Documentation - https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
 * 3. Task Management Best Practices - https://www.atlassian.com/work-management/project-management/task-management
 */

/**
 * Represents a task in the task management system.
 * Each task has a unique name, priority, and status.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Constructs a new Task with the specified name, priority, and status.
     *
     * @param name     The unique name of the task
     * @param priority The priority of the task (lower number = higher priority)
     * @param status   The current status of the task
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Gets the name of the task.
     *
     * @return The task name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the priority of the task.
     *
     * @return The task priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the current status of the task.
     *
     * @return The task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     *
     * @param status The new status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string containing the task's name, priority, and status
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
} 