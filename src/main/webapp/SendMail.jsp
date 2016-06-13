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
         <form action="SendMail" method="GET">
            <table align="center">
                <tr>
                    <th>Mail To</th>
                    <th> <input type="text" name="to"/></th>
                </tr>
                <tr>
                    <th>Message</th>
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
