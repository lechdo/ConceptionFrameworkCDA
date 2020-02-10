package fr.eni.ecole.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.ecole.demo.bll.PlanningManager;
import fr.eni.ecole.demo.bo.Cours;
import fr.eni.ecole.demo.bo.Formateur;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PlanningManager PlanningManagerBean;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cours spring = PlanningManagerBean.creerUnCours("Spring java avancé", 4);
		List<Cours> l = new ArrayList<Cours>();
		l.add(spring);
		Formateur formateur = PlanningManagerBean.creerUnFormateur("Awkins", "Steven", l);
		
		request.setAttribute("nom", formateur.getNom());
		request.setAttribute("prenom", formateur.getPrenom());
		
		RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public PlanningManager getPlanningManagerBean() {
		return PlanningManagerBean;
	}

	public void setPlanningManagerBean(PlanningManager planningManagerBean) {
		PlanningManagerBean = planningManagerBean;
	}

}
