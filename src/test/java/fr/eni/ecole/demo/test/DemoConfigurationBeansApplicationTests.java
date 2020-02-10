package fr.eni.ecole.demo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecole.demo.bll.PlanningManager;
import fr.eni.ecole.demo.bo.Cours;
import fr.eni.ecole.demo.bo.Formateur;
import fr.eni.ecole.demo.bo.Session;
import fr.eni.ecole.demo.dal.DAO;
import fr.eni.ecole.demo.dal.CoursDAOJDBC;
import fr.eni.ecole.demo.dal.FormateurDAOJDBC;
import fr.eni.ecole.demo.dal.SessionDAOJDBC;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoConfigurationBeansApplicationTests {
	private ApplicationContext context;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("WEB-INF/ApplicationContext.xml");
	}

	@After
	public void setDown() {
		((ClassPathXmlApplicationContext) context).close();
	}

	@Test
	public void test01_beanCoursDAOJDBC() {
		DAO<Cours> coursDAOBean = context.getBean("coursDAOBean", CoursDAOJDBC.class);
		assertNotNull(coursDAOBean);
	}

	@Test
	public void test02_beanFormateurDAOJDBC() {
		DAO<Formateur> formateurDAOBean = context.getBean("formateurDAOBean", FormateurDAOJDBC.class);
		assertNotNull(formateurDAOBean);
	}

	@Test
	public void test03_beanSessionDAOJDBC() {
		DAO<Session> sessionDAOBean = context.getBean("sessionDAOBean", SessionDAOJDBC.class);
		assertNotNull(sessionDAOBean);
	}

	@Test
	public void test04_beanPlanningManager() {
		PlanningManager planningManagerBean = context.getBean("planningManagerBean", PlanningManager.class);
		assertNotNull(planningManagerBean);
		assertNotNull(planningManagerBean.getCoursDAO());
		assertNotNull(planningManagerBean.getFormateurDAO());
		assertNotNull(planningManagerBean.getSessionDAO());
	}

}
