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
                String IP = request.getAttribute("ipMac").toString();
                
            %>
            
            <%="IP da Maquina: " + IP %><br>
            <%="Classe do IP: "  %><br>
            <%="Mascara da Rede: "  %><br>
            <%="IP da Rede: "  %><br>
        </h4>
            </div>
    </body>
</html>
