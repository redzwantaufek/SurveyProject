

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddSurveyServlet
 */
@WebServlet("/AddSurveyServlet")
public class AddSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String donate = request.getParameter("donate");
        String donated = request.getParameter("donated");

        String[] reasons = request.getParameterValues("reason");

        out.print("<!DOCTYPE html><html><head><title>Blood Donation Survey</title></head><body>");
        out.print("<h1>Blood Donation Survey</h1>");

        out.print("<p>Please indicate your gender: " + (gender != null ? gender : "") + "</p>");
        out.print("<p>Please indicate your age: " + (age != null ? age : "") + "</p>");
        out.print("<p>Have you ever donated blood: " + (donate != null ? donate : "") + "</p>");
        out.print("<p>If yes, how many times within the last 2 years?: " + (donated != null ? donated : "") + "</p>");

        out.print("<p>What prompted you to donate blood?:</p>");
        if (reasons != null) {
            for (String r : reasons) {
                if (r.equals("emergency")) {
                    out.print("Emergency call for blood donation<br>");
                } else if (r.equals("community")) {
                    out.print("Community Support<br>");
                } else if (r.equals("other")) {
                    out.print("Other<br>");
                }
            }
        }
        
        out.print("</body></html>");
    }

}
