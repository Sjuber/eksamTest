package utils;

import entities.Book;
import entities.Role;
import entities.User;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
        // CHANGE the three passwords below, before you uncomment and execute the code below
        // Also, either delete this file, when users are created or rename and add to .gitignore
        // Whatever you do DO NOT COMMIT and PUSH with the real passwords
        User user = new User("Hades", "Earth");
        User admin = new User("Posidon", "Ocean");
        User both = new User("Zeus", "Sky");


        Book b1 = new Book("Shadows Hunters: The End of Gaming", "Mads", "The bois Discord", 2017);
        Book b2 = new Book("Denmark: Acording to americans", "Karl", "The Book Company", 2008);
        Book b3 = new Book("Kvante Dynamoe", "Bjørn", "Gyldendahl", 1928);

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);  
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.getTransaction().commit();
        System.out.println("PW: " + user.getUserPass());
//    System.out.println("Testing user with OK password: " + user.verifyPassword("Earth"));
//    System.out.println("Testing user with wrong password: " + user.verifyPassword("Hell"));
        System.out.println("Created TEST Users");

    }

}
