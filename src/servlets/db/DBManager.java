package servlets.db;

import servlets.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DBManager {

    private static List<Task> tasks = new ArrayList<>();
    private static Long idGenerator = 1L;
    static {
        tasks.add(new Task(idGenerator++,"Создать веб приложения JAVA EE","Да", LocalDate.parse("2021-12-21"),true));
        tasks.add(new Task(idGenerator++,"Убраться дома и закупить продукты","Да",LocalDate.parse("2021-12-23"),true));
        tasks.add(new Task(idGenerator++,"Выполнить все домашнее задания","Нет",LocalDate.parse("2021-12-25"),false));
        tasks.add(new Task(idGenerator++,"Записаться на качку","Нет",LocalDate.parse("2021-12-28"),false));
        tasks.add(new Task(idGenerator++,"Учить итальянский","Нет",LocalDate.parse("2021-12-31"),true));
    }

    public static void addTask(Task task){
        task.setId(idGenerator++);
        tasks.add(task);
    }

    public static Task getTask(Long id){
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId()==id) {
                return tasks.get(i);
            }
        }
        return null;
    }
    public static List<Task> getAllTasks(){
       return tasks;
    }

    public static void deleteTask(Long id){
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (Objects.equals(next.getId(), id)) {
                it.remove();
                return;
            }
        }
    }

    public static void updateTask(Long id,Task task){
        int index = -1;
        for (int i = 0; i < tasks.size(); i++) {

            if (Objects.equals(tasks.get(i).getId(),id)) {
                 index = i;
                 break;
            }
        }
        if(index!=-1){
            task.setId(id);
            tasks.set(index,task);
        }
    }
}
