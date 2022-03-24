package com.motivity;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class MainMethod {
	public static void main(String[] args){
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hib2.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		Query qr=session.createQuery("select e.employee_name,e.employee_mobile,er.employer_name from Employer er inner join Employee e on er.employer_id=e.employer");
		List li=qr.list();
		Iterator itr=li.iterator();
		while(itr.hasNext()) {
			Object[] x=(Object[])itr.next();
			System.out.println(x[0]+"  "+x[1]+" "+x[2]);
		}
		
		/*Employer empr1=new Employer();
		empr1.setEmployer_id(1);
		empr1.setEmployer_name("Anurag");
		empr1.setEmployer_mobile(7396165092l);
		empr1.setEmployer_department("IT");
		
		Employer empr2=new Employer();
		empr2.setEmployer_id(5);
		empr2.setEmployer_name("Suresh");
		empr2.setEmployer_mobile(8396165074l);
		empr2.setEmployer_department("Finance");
		
		Employer empr3=new Employer();
		empr3.setEmployer_id(3);
		empr3.setEmployer_name("Deepak");
		empr3.setEmployer_mobile(9896165078l);
		empr3.setEmployer_department("Market");
	
		Employee emp1=new Employee();
		emp1.setEmployee_id(7);
		emp1.setEmployee_name("karthik");
		emp1.setEmployee_mobile(9912143235l);
		emp1.setEmployee_address("delhi");
		emp1.setEmployer(empr1);
		
		Employee emp2=new Employee();
		emp2.setEmployee_id(9);
		emp2.setEmployee_name("kumar");
		emp2.setEmployee_mobile(9912354624l);
		emp2.setEmployee_address("Hyderabad");
		emp2.setEmployer(empr2);
		
		Employee emp3=new Employee();
		emp3.setEmployee_id(10);
		emp3.setEmployee_name("arun");
		emp3.setEmployee_mobile(9912354789l);
		emp3.setEmployee_address("Mysore");
		emp3.setEmployer(empr3);
		
		Employee emp4=new Employee();
		emp4.setEmployee_id(11);
		emp4.setEmployee_name("kushal");
		emp4.setEmployee_mobile(9932154612l);
		emp4.setEmployee_address("vizag");
		emp4.setEmployer(empr3);
		
	
		List<Employee> al1=new ArrayList<Employee>();
		al1.add(emp1);
		//empr1.setEmployee(al1);
		
		List<Employee> al2=new ArrayList<Employee>();
		al2.add(emp2);
		//al2.add(emp3);
		//empr2.setEmployee(al2);
		
		List<Employee> al3=new ArrayList<Employee>();
	//	empr3.setEmployee(al3);
		//empr3.setEmployee(al3);
		
		al3.add(emp3);
		al3.add(emp4);
		empr1.setEmployee(al1);
		empr2.setEmployee(al2);
		empr3.setEmployee(al3);
		session.save(empr1);
		session.save(empr2);
		session.save(empr3);
		session.save(emp1);
		session.save(emp2);
		
		session.save(emp3);
		session.save(emp4);
		
		t.commit();
		session.close();*/
	}

}
