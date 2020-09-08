/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Domain.Category;
import Domain.Supplier;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lehm
 */
public class Test {

    public static void main(String args[]) {
        Category cat=new Category();
        cat.setCategoryName("hibernate");
        
    }

}
