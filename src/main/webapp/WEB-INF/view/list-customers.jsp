<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Customers</title>
        
        <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
       
        <div id="wrapper">
            <div id="header">
                <h2> CRM - Customer Relationship Manager </h2>
                
            </div>
            
        </div>
        
        <div id="container">
            
            <div id="content">
                
                <form:form action="search" method="GET">
                    Search Customer: <input type="text" name="theSearchName" />
                    
                    <input type="submit" value="Search" class="add-button" />
                </form:form>
                
                <input type="button" value="Add Customer" 
                       onclick="window.location.href='addCustomer'; return false;"
                       class="add-button"
                       />
                
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    
                    <c:forEach var="tempCustomer" items="${customers}">
                        <c:url var="updateLink" value="/customer/updateCustomer">
                            <c:param name="customerId" value="${tempCustomer.customerId}" />
                        </c:url>
                        
                        <c:url var="deleteLink" value="/customer/deleteCustomer">
                            <c:param name="customerId" value="${tempCustomer.customerId}" />
                        </c:url>
                        <tr>
                            <td> ${tempCustomer.firstName} </td>
                            <td> ${tempCustomer.lastName} </td>
                            <td> ${tempCustomer.email} </td>
                            <td>
                                <a href="${updateLink}"> Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
                                
                            </td>
                            
                        </tr>
                        
                        
                    </c:forEach>
                    
                    
                    
                </table>
                
                
                
                
            </div>
            
        </div>
        
    </body>
</html>
