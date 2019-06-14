<%-- 
    Document   : resposta
    Created on : 14/06/2019, 01:12:17
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <header>
                <h2>Informações</h2>
            </header>
        </div>
        <div>
        <h4>
            <% 
                String IP = request.getParameter("ip");
                String ClasseIP = request.getParameter("ClasseIp");
                String MaskRede = request.getParameter("MaskRede");
                String EndRede = request.getParameter("EndRede");
            %>
            
            <%="IP da Maquina: " + IP %><br>
            <%="Classe do IP: " + ClasseIP %><br>
            <%="Mascara da Rede: " + MaskRede %><br>
            <%="IP da Rede: " + EndRede %><br>
        </h4>
            </div>
    </body>
</html>
