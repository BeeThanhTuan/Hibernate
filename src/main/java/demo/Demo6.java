package demo;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.ForLoadedExecutableParameterType;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
public class Demo6 {
	static final SessionFactory factory = HibernateUtils.getSessionFactory();
	
public static void main(String[] args) {
	
	Session session = factory.openSession();
	 
	 
	
	Scanner sc = new Scanner(System.in);
	System.out.println("UserName: ");
	String username = sc.nextLine();
	System.out.println("Password: ");
	String password = sc.nextLine();
	
	//Criteria Query
	
	
	CriteriaBuilder builder = session.getCriteriaBuilder();
	CriteriaQuery<User>  query = builder.createQuery(User.class);
	Root<User> root = query.from(User.class);
	query = query.select(root);
	Predicate p1 = builder.like(root.get("userName").as(String.class), username);
	Predicate p2 = builder.like(root.get("password").as(String.class), password);
	query = query.where(builder.and(p1,p2));
	Query<User> q = session.createQuery(query);
	
	try {
	User result = q.getSingleResult();
	System.out.print("Dang nhap thanh cong");
	}
	catch(Exception e) {
		
	System.out.print("Dang nhap khong thanh cong");
	
    }
	

	
	



	session.close();
	
	
}
}
