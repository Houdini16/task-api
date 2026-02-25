package sn.isi.l3gl.api.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task.Task;
import sn.isi.l3gl.core.task.TaskService;
import sn.isi.l3gl.core.task.TaskStatus;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // POST /api/tasks - Créer une tâche (utilise createTask())
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    // GET /api/tasks - Lister toutes les tâches (utilise listTasks())
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> tasks = taskService.listTasks();
        return ResponseEntity.ok(tasks);
    }

    // PUT /api/tasks/{id}/status - Modifier le statut (utilise updateStatus())
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        Task updatedTask = taskService.updateStatus(id, status);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    // GET /api/tasks/done/count - Nombre de tâches DONE (utilise countCompletedTasks())
    @GetMapping("/done/count")
    public ResponseEntity<Long> countCompletedTasks() {
        long count = taskService.countCompletedTasks();
        return ResponseEntity.ok(count);
    }
}
