package com.kamu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kamu.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// crate session
				Session session = factory.getCurrentSession();
				
				try {			
					// create 3 student object
					System.out.println("Creating new student object...");
					Student tempStudent = new Student("Paul", "Smith", "Paul@kamu72code.com");
					Student tempStudent1 = new Student("Jonny", "Vali", "Jonny@kamu72code.com");
					Student tempStudent2 = new Student("Alex", "Sandra", "Alex@kamu72code.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent);
					session.save(tempStudent1);
					session.save(tempStudent2);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
		
	}

}
