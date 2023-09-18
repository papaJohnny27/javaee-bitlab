<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.model.Task" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 17.09.2023
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TASK MANAGER  Все задания</title>
   <%@ include file="/import/frontend-libs.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-primary bg-gradient" >
    <div class="container-fluid">
        <a class="navbar-brand" href="#">TASK MANAGER</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Все задания</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <div class="container">
        <button type="button" class="btn btn-primary row mt-5" data-bs-toggle="modal" data-bs-target="#exampleModalCenter">
            Создать
        </button>
        <div class="row mt-5">
            <div class="col-sm-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>НАИМЕНОВАНИЯ</th>
                        <th>КРАЙНИЙ СРОК</th>
                        <th>ВЫПОЛНЕНО</th>
                        <th>ДЕТАЛИ</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Task> tasks = (ArrayList<Task>) request.getAttribute("taskList");
                        if (tasks != null) {
                            for (Task task : tasks) {

                    %>
                    <tr>
                        <td>
                            <%
                                out.print(task.getId());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(task.getName());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(task.getDeadlineDate());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(task.getIsDone() ? "Да" : "Нет");
                            %>
                        </td>
                        <td>
                            <a href="/details?id=<%=task.getId()%>" class="btn btn-info btn-sm">ДЕТАЛИ</a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>



    </div>



    <div class="modal fade" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle" style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalCenterTitle">Новое задание</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/" method="post">
                        <div class="form-group">
                            <label for="table_title_input">Наименование:</label>
                            <input type="text" id="table_title_input" name="task_title" class="form-control" required>
                        </div>

                        <div class="form-group">
                            <label for="table_description_input">Описание:</label>
                            <input type="text" id="table_description_input" name="task_description" class="form-control" required>
                        </div>

                        <div class="form-group">
                            <label for="table_deadline_date_input">Крайний срок:</label>
                            <input type="date" id="table_deadline_date_input" name="task_deadline_date" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="task_is_done">Выполнено:</label>
                            <select name="task_is_done" class="form-select" id="task_is_done" required>
                                <option value="true">Да</option>
                                <option value="false" selected>Нет</option>
                            </select>
                        </div>

                        <div class="form-group mt-3">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary">Добавить</button>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</body>
</html>
