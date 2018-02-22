package ru.solomatin.hibernate.example1;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;


/**
 * Created by lesha on 14.02.2018.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final Configuration ourConfiguration;

    static {
        try {

            ourConfiguration = new Configuration().configure("hibernate.cfg.xml");
            ourSessionFactory = ourConfiguration.buildSessionFactory();

            // Создадим структуру бд и заполним ее данными (через jdbc)
            InitializeDatabase.InitDB(ourConfiguration);

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        final Session session = getSession();

        try {

            System.out.println("----------------------------------------------------");

            Query query = session.createQuery("from PeopleEntity order by peopleId");
            for (Object o : query.list()) {
                System.out.println("  " + o);
            }

            System.out.println("----------------------------------------------------");

            query = session.createQuery("from PeopleEntity where name = 'Alexey' order by surname desc");
            for (Object o : query.list()) {
                System.out.println("  " + o);
            }

            System.out.println("----------------------------------------------------");
        }
        finally {
            session.close();
        }

        ourSessionFactory.close();

    }
}
