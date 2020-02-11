package fr.eni.ecole.demo.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DataSource ds = context.getBean("datasource", DataSource.class);
		try {
			Connection connection = ds.getConnection();
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		context.close();
	}

}
