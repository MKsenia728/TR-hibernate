package org.example.togo;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("finalProject.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory())
        {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Stepan", "Fedorov", "IT", 2500);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("DONE!");
            session.close();
        }
    }
}
