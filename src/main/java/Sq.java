

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.Math;


@WebServlet("/Sq")
public class Sq extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Sq() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        String numStr = request.getParameter("num");
        if (numStr != null) {
            try {
                int num = Integer.parseInt(numStr);
                int s = (int) Math.sqrt(num);
                if (isPerfectSquare(num)) {
                    out.println("<p>" + num + " is a perfect square</p>");
                    out.println("<p>"+ s +"is the root value");
                } else {
                    out.println("<p>" + num + " is not a perfect square</p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p>please enter a valid integer.</p>");
            }
        }

        out.println("<form action='' method='get'>");
        out.println("Enter number: <input type='text' name='num' />");
        out.println("<input type='submit' value='Check' />");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    private boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
        
    }

    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
