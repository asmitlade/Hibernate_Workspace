
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
    <c:choose>
      <c:when test="${!empty empData }">
            <h1 style="color:red;text-align:center"> Employee Details </h1>
            <b>Employee Number :: ${empData.eno } </b> <br>
             <b>Employee Name :: ${empData.empName } </b> <br>
              <b>Employee Designation :: ${empData.desg} </b> <br>
             <b>Employee Salary :: ${empData.salary} </b> <br>
        </c:when>
        <c:otherwise>
              <b> Record not found</b>
        </c:otherwise>
     </c:choose>
     <br><br>
     <a href="search.html">home</a>