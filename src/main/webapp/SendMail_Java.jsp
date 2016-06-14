<%-- 
    Document   : SendMail
    Created on : Jun 13, 2016, 3:23:04 PM
    Author     : Mallick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="JavaMailAPI" method="GET">
            <table align="center">
                <tr>
                    <th>Mail To</th>
                    <th> <input type="text" name="to"/></th>
                </tr>
                 <tr>
                    <th>Map Id</th>
                    <th> <input type="text" value="125" name="mid"/></th>
                </tr>
                 <tr>
                    <th>Map Name</th>
                    <th> <input type="text" value="Test Map" name="mname"/></th>
                </tr>
                 <tr>
                    <th>Project Name</th>
                    <th> <input type="text" value="DemoProject" name="pname"/></th>
                </tr>
                 <tr>
                    <th>Created By</th>
                    <th> <input type="text" value="Administrator" name="createdby"/></th>
                </tr>
                <tr>
                    <th>Description</th>
                    <th><textarea rows="5" name="Message"></textarea></th>
                </tr> 
                <tr>
                    <th>Save</th>
                    <th><input type="submit"value="Send"/></th>
                </tr>                  
            </table>
        </form>
    </body>
</html>
