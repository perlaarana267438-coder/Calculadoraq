<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calculadora Web JSP & Servlet</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="calculadora">
        <h2>Calculadora</h2>
        
        <!--Formulario-->
        <form action="CalculadoraServlet" method="POST">
             <div class="formulario">
                <label for="num1">Primer Valor:</label>
                <input type="number" step="any" id="num1" name="num1" 
                       value="${param.num1}" placeholder="Ingrese un número" required>
            </div>

            <div class="formulario">
                <label for="operacion">Operación:</label>
                <select id="operacion" name="operacion" required>
                    <option value="suma" ${param.operacion == 'suma' ? 'selected' : ''}>Suma (+)</option>
                    <option value="resta" ${param.operacion == 'resta' ? 'selected' : ''}>Resta (-)</option>
                    <option value="multiplicacion" ${param.operacion == 'multiplicacion' ? 'selected' : ''}>Multiplicación (×)</option>
                    <option value="division" ${param.operacion == 'division' ? 'selected' : ''}>División (÷)</option>
                </select>
                            </div>

            <div class="formulario">
                <label for="num2">Segundo Valor:</label>
                <input type="number" step="any" id="num2" name="num2" 
                       value="${param.num2}" placeholder="Ingrese otro número" required>
            </div>

            <button type="submit">Calcular</button>
        </form>

        <%--renderizado condicional del resultado--%>
        <c:if test="${not empty resultado}">
            <div class="resultado">
                Resultado: <c:out value="${resultado}" />
            </div>
        </c:if>

        <%--errrores--%>
        <c:if test="${not empty error}">
            <div class="error">
                <c:out value="${error}" />
            </div>
        </c:if>
        
            </div>

</body>
</html>