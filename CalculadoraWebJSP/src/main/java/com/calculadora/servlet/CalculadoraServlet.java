package com.calculadora.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/CalculadoraServlet"})
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //parametros
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operacion = request.getParameter("operacion");

        try {
            // txt a decimales
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double resultado = 0;
            boolean errorDiv = false;

            //operaciones
            switch (operacion) {
                case "suma":
                    resultado = num1 + num2;
                    break;
                case "resta":
                    resultado = num1 - num2;
                    break;
                case "multiplicacion":
                      resultado = num1 * num2;
                    break;
                case "division":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        errorDiv = true;
                    }
                    break;
                default:
                    request.setAttribute("error", "Operación no válida.");
                    break;
            }

            //asignacion de atributos
            if (errorDiv) {
                request.setAttribute("error", "Error: No es posible dividir por cero.");
            } else {
                request.setAttribute("resultado", resultado);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Error: Por favor ingresa valores numéricos válidos.");
        }
                //de vuelta al index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}