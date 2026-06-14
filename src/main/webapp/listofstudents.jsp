<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    background:#F3F4F6;
    padding:30px;
}

.container{
    max-width:1400px;
    margin:auto;
}

.page-title{
    text-align:center;
    color:#1E3A8A;
    margin-bottom:25px;
    font-size:32px;
    font-weight:bold;
}

.card{
    background:white;
    padding:20px;
    border-radius:12px;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
}

table{
    width:100%;
    border-collapse:collapse;
}

table th{
    background:#1E3A8A;
    color:white;
    padding:12px;
    text-align:center;
}

table td{
    padding:10px;
    text-align:center;
    border-bottom:1px solid #ddd;
}

table tr:nth-child(even){
    background:#f9fafb;
}

table tr:hover{
    background:#e0f2fe;
    transition:0.3s;
}

.btn{
    text-decoration:none;
    padding:8px 15px;
    border-radius:5px;
    color:white;
    font-size:14px;
    font-weight:bold;
}

.btn-edit{
    background:#10B981;
}

.btn-edit:hover{
    background:#059669;
}

.btn-delete{
    background:#EF4444;
}

.btn-delete:hover{
    background:#DC2626;
}

.top-bar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:20px;
}

.add-btn{
    background:#2563EB;
    color:white;
    padding:10px 18px;
    text-decoration:none;
    border-radius:6px;
    font-weight:bold;
}

.add-btn:hover{
    background:#1D4ED8;
}

</style>

</head>
<body>

<%
    ArrayList<StudentBean> list =
        (ArrayList<StudentBean>)request.getAttribute("list");
%>

<div class="container">

    <h1 class="page-title">
        Student Management System
    </h1>

    <div class="top-bar">
        <h3>Total Students : <%= list.size() %></h3>

        <a href="studentregi.jsp" class="add-btn">
            + Add New Student
        </a>
    </div>

    <div class="card">

        <table>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Age</th>
                <th>Course</th>
                <th>Gender</th>
                <th>Hobbies</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Action</th>
            </tr>

            <%
                for(StudentBean s : list)
                {
            %>

            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getFullName()%></td>
                <td><%=s.getAge()%></td>
                <td><%=s.getCourse()%></td>
                <td><%=s.getGender()%></td>
                <td><%=s.getHoobiesStr()%></td>
                <td><%=s.getDob()%></td>
                <td><%=s.getEmail()%></td>
                <td><%=s.getMobile()%></td>
                <td><%=s.getAddress()%></td>

                <td>
                    <a href="EditStudent?id=<%=s.getId()%>"
                       class="btn btn-edit">
                        Edit
                    </a>

                    <a href="DeleteStudentServlet?id=<%=s.getId()%>"
                       class="btn btn-delete"
                       onclick="return confirm('Are you sure you want to delete this student?');">
                        Delete
                    </a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>
</body>
</html>