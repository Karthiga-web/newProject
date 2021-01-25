/**
 * 
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.SweetsEntity;
import hibernate.HibernateUtils;

/**
 * @author grkar
 *
 */
@WebServlet("/sweets")
public class SweetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Session session;

	public SweetServlet() {
	}

	public void init() {
		session = HibernateUtils.buildSessionFactory().openSession();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		SweetsEntity sweet = new SweetsEntity();
		sweet.setName(name);
		float floatValue = 0F;
		try {
			floatValue = Float.parseFloat(price);
			sweet.setPrice(floatValue);
			if (floatValue != 0F) {
				Transaction transaction = session.beginTransaction();
				session.save(sweet);
				transaction.commit();
				session.close();
				response.setContentType("text/html");
				out.println("Sweet is added to the Checklist!");
			}
		} catch (NumberFormatException e) {
			RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp");
			RequetsDispatcherObj.forward(request, response);
		} catch (NullPointerException e1) {
			RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/index.jsp");
			RequetsDispatcherObj.forward(request, response);
		}
	}

}