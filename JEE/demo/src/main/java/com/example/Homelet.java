package com.example;



import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Homelet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
			
			String message = "Jérémy";
			request.setAttribute("name", message);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/home.jsp");
			dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(request.getParameter("kg") != null && request.getParameter("taille") != null){
				System.out.println(request.getParameter("taille"));
				System.out.println(request.getParameter("kg"));
				float kg = Float.parseFloat(request.getParameter("kg"));
				float taille = Float.parseFloat(request.getParameter("taille"));
				System.out.println(kg);
				System.out.println(taille);
				request.setAttribute("kg", kg);
				request.setAttribute("taille", taille);
				float imc = kg / (taille*taille);
				request.setAttribute("imc", imc);
				String responseIMC = 
						imc < 16.5 ? "Dénutrition" :
						imc > 16.5 && imc < 18.5 ? "Maigreur" :
						imc > 18.5 && imc < 25 ? "Normal" :
						imc > 25 && imc < 30 ? "Surpoids" :
						imc > 30 && imc < 35 ? "Obésité modérée" :
						imc > 35 && imc < 40 ? "Obésité sévère" :
						imc > 40 ? "Obésité morbide" : "ERREUR VOUS ETES PAS HUMAIN";
				request.setAttribute("responseIMC", responseIMC);
			}
			

			System.out.println(username);
			System.out.println(password);
			
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/response.jsp");
			if(request.getParameter("kg") != null && request.getParameter("taille") != null){
				dispatcher = request.getRequestDispatcher("jsp/responseIMC.jsp");
			}else{
				dispatcher = request.getRequestDispatcher("jsp/response.jsp");
			}

			
			dispatcher.forward(request, response);
		}

}
