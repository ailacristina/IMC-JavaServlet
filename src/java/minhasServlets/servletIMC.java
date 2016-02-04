package minhasServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletIMC extends HttpServlet {
    
    public double calculaIMC(double peso, double altura) {
        
        double IMC = peso / (altura * altura);      
             
            return IMC;
      
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        
        double peso, altura;
        peso = Double.parseDouble(req.getParameter("peso"));
        altura = Double.parseDouble(req.getParameter("altura"));
        double respIMC = calculaIMC(peso, altura);
            
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter pw = res.getWriter()) {
           
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>IMC</title>");
            pw.println("</head>");
            pw.println("<body>");
            
            if (respIMC < 18.5) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Você está abaixo do peso ideal</p>"); 
            }
            if ((respIMC >= 18.5) && (respIMC < 24.9)) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Peso ideal</p>"); 
            }
            if ((respIMC >= 25.0) && (respIMC < 29.9)) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Sobrepeso</p>"); 
            }
            if ((respIMC >= 30.0) && (respIMC < 34.9)) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Obesidade grau I</p>"); 
            }
            if ((respIMC >= 35.0) && (respIMC < 39.9)) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Obesidade grau II</p>"); 
            }
            if (respIMC >= 40.0) {
                pw.println("<p> Seu IMC é " + respIMC + " !</p>");
                pw.println("<p> Obesidade grau III</p>"); 
            } 
            			
					
            pw.println("</body>");
            pw.println("</html>");
        }
    }
}
