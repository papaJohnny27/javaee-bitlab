<%@ page import="servlets.model.Task" %><%--
  Created by IntelliJ IDEA.
  User: eldos
  Date: 18.09.2023
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Details</title>
    <%@ include file="/import/frontend-libs.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row mt-5">
            <h1 class="display-3"><%=task.getName()%></h1>
        </div>
        <div class="row mt-5">
            <form action="/update" method="post">
                <input type="hidden" name="task_id" value="<%=task.getId()%>"/>
                <div class="form-group">
                    <label for="table_title_input">Наименование:</label>
                    <input type="text" id="table_title_input" name="task_title" class="form-control"value="<%=task.getName()%>" required>
                </div>

                <div class="form-group">
                    <label for="table_description_input">Описание:</label>
                    <input type="text" id="table_description_input" name="task_description" class="form-control"value="<%=task.getDescription()%>" required>
                </div>

                <div class="form-group">
                    <label for="table_deadline_date_input">Крайний срок:</label>
                    <input type="date" id="table_deadline_date_input" name="task_deadline_date" class="form-control"value="<%=task.getDeadlineDate()%>" required>
                </div>
                <div class="form-group">
                    <label for="task_is_done">Выполнено:</label>
                    <select name="task_is_done" class="form-select" id="task_is_done" required>
                        <option value="true">Да</option>
                        <option value="false"
                                    <%
                                        if(task.getIsDone()){
                                    %>

                                    selected
                                    <%
                                        }else {}
                                    %>
                        >Нет</option>
                    </select>
                </div>

                <div class="form-group mt-3">
                    <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Сохранить</button>
                </div>
            </form>
            <form action="/delete" method="post">
                <input type="hidden" name="task_id" value="<%=task.getId()%>"/>
                <div class="form-group mt-3 col-5">
                    <button type="submit" class="btn btn-danger">Удалить</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
