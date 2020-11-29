package org.o7planning.resthiber;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.File;    
import java.io.IOException;  
import java.io.InputStream; 
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.o7planning.resthiber.product;
 
public class prodDAO {
 
    private static final Map<Integer, product> empMap = new HashMap<Integer, product>(); 
    //called by prodService path POST
    //use to add product details to db
    public static product addproduct(product emp) {
    	System.out.println("addproduct");
    	empMap.put(emp.getisbn(), emp);
    	  SessionFactory sessionFactory = new Configuration().
    configure().buildSessionFactory();
    	  product empx = new product();
    	  // Session is created by calling openSession()
    	  // method on SessionFactory object
    	  Session session = sessionFactory.openSession();
    	  // Creating a transaction from session
    	  Transaction tx = session.beginTransaction();
    	  try {
    		//   Creating a product object 
    		 // setting product name , email and phone
    		  empx.setisbn(emp.getisbn());
    		  empx.settitle(emp.gettitle());
    		  empx.setcat(emp.getcat());
    		  empx.setpub(emp.getpub());
    		  empx.setauth(emp.getauth());
    		  empx.setprice(emp.getprice());
    		  empx.setquantity(emp.getquantity());
    		  empx.setimgPath("img/"+emp.getimgPath());
    		  // Saving the product into the database 
    		  session.save(empx);
    		  // Committing the transaction
    		  session.getTransaction().commit();
    		  }catch(Exception sqlException) {
    			  System.out.println(sqlException);
    			  System.out.println("nope");
    			  empx.setisbn(111111111);
    			  return empx;
    		  }finally {
    		      if(session != null) {
    		    	  System.out.println("done");
    		    	  // closing the session
    		    	  session.close();};
     		      };
     		     return empx;
    }
 //called by prodService from GET path of POST2.jsp
 public static List<product> getproduct(String x) {
	 System.out.println("DAO_getProd starts");
	 @SuppressWarnings("unchecked")
		List<product> result = new ArrayList<product>();
    SessionFactory sessionFactory = new Configuration().
    	    configure().buildSessionFactory();

    	  // Session is created by calling openSession()
    	  // method on SessionFactory object
    	  Session session = sessionFactory.openSession();
    	  // Creating a transaction from session
    	  Transaction tx = session.beginTransaction();
    	  System.out.println("DAO_getProd+"+x);
    	  // Creating a product object 
    	  product pproduct = new product();
    	  try {
    		  System.out.println("DAO_getProd+"+x+" try");
    		  Query query = session.createQuery("FROM product WHERE isbn="+x);
    		 result= query.list();
    	      if(result != null) {
    	    	  System.out.println("DAO_getProd+"+pproduct.getisbn()+" notnull");
    	          System.out.println("\nProduct Details= \n" + result.toString());
    	      }else {
    	    	  System.out.println("DAO_getProd+"+x+" null");
    	      }
    	  }catch(Exception sqlException) {
    	      if(null != session.getTransaction()) {
    	          System.out.println("\n.......Transaction Is Being Rolled Back.......");
    	          session.getTransaction().rollback();
    	   }
    	   sqlException.printStackTrace();
    	  }finally {
    		  System.out.println("DAO_getProd+"+x+" finally");
    	      if(session != null) {
    	          session.close();
    	   }
    	  }
    	  return result;
 }
//called by prodService from GET path with json object
 public static List<product> getsearch(product x) {
	 System.out.println("DAO_getsearch starts");
	 @SuppressWarnings("unchecked")
		List<product> result = new ArrayList<product>();
    SessionFactory sessionFactory = new Configuration().
    	    configure().buildSessionFactory();

    	  // Session is created by calling openSession()
    	  // method on SessionFactory object
    	  Session session = sessionFactory.openSession();
    	  // Creating a transaction from session
    	  Transaction tx = session.beginTransaction();
    	  System.out.println("DAO_getsearch+"+x);
    	  // Creating a product object 
    	
    	  String queryLike = "";
    	  //check if isbn has value, if not, the it will not included in string query
    	  if(x.getisbn() != 0 && x.getisbn() != null) {
    		  System.out.println("DAO_getsearch+"+x.getisbn());
    		  if (queryLike == "") {
    			  queryLike = "isbn LIKE '%"+x.getisbn()+"%' ";
    		  }else if(queryLike != null) {
    			  queryLike += "AND isbn LIKE '%"+x.getisbn()+"%' ";
    		  }
    	  }
    	//check if title has value, if not, the it will not included in string query
    	  if(x.gettitle() != "" && x.gettitle() != null && x.gettitle().isEmpty() == false && x.gettitle().trim().isEmpty() == false) {
    		  System.out.println("DAO_getsearch+"+x.gettitle());
    		  if (queryLike == "") {
    			  queryLike = "title LIKE '%"+x.gettitle()+"%' ";
    		  }else if(queryLike != null) {
    			  queryLike += "AND title LIKE '%"+x.gettitle()+"%' ";
    		  }
    	  }
    	//check if author has value, if not, the it will not included in string query
    	  if(x.getauth() != "" && x.getauth() != null&& x.getauth().isEmpty() == false && x.getauth().trim().isEmpty() == false) {
    		  System.out.println("DAO_getsearch+"+x.getauth());
    		  if (queryLike == "") {
    			  queryLike = "auth LIKE '%"+x.getauth()+"%' ";
    		  }else if(queryLike != null) {
    			  queryLike += "AND auth LIKE '%"+x.getauth()+"%' ";
    		  }
    	  }
    	//check if category has value, if not, the it will not included in string query
    	  if(x.getcat() != "" && x.getcat() != null&& x.getcat().isEmpty() == false && x.getcat().trim().isEmpty() == false) {
    		  System.out.println("DAO_getsearch+"+x.getcat());
    		  if (queryLike == "") {
    			  queryLike = "cat LIKE '%"+x.getcat()+"%' ";
    		  }else if(queryLike != null) {
    			  queryLike += "AND cat LIKE '%"+x.getcat()+"%' ";
    		  }
    	  }
    	//check if publisher has value, if not, the it will not included in string query
    	  if(x.getpub() != "" && x.getpub() != null&& x.getpub().isEmpty() == false && x.getpub().trim().isEmpty() == false) {
    		  System.out.println("DAO_getsearch+"+x.getpub());
    		  if (queryLike == "") {
    			  queryLike = "pub LIKE '%"+x.getpub()+"%' ";
    		  }else if(queryLike != null) {
    			  queryLike += "AND pub LIKE '%"+x.getpub()+"%' ";
    		  }
    	  }
    	
    	  queryLike +="ORDER by quantity ASC";
    	  
    	  /*the picture of how the query will be like
    	   * queryLike = "isbn LIKE '%"+x.getisbn()+"%' "+
    			  			"AND title LIKE '%"+x.gettitle()+"%' "+
    						"AND cat LIKE '%"+x.getcat()+"%' "+
    						"AND pub LIKE '%"+x.getpub()+"%' "+
    						"AND auth LIKE '%"+x.getauth()+"%' "+
    						"AND price LIKE '%"+x.getprice()+"%' "+
    						"ORDER by quantity ASC";
    		*/
    	  try {
    		  System.out.println("DAO_getsearch+"+x+" try");
    		  System.out.println("DAO_getsearch+"+queryLike+"");
    		  Query query = session.createQuery("FROM product WHERE "+queryLike);
    		 result= query.list();
    	      if(result != null && result.toString()!= "[]") {
    	    	//  System.out.println("DAO_getsearch+"+x.getisbn()+" notnull");
    	          System.out.println("\nProduct Details= \n" + result.toString());
    	      }else {
    	    	  System.out.println("DAO_getsearch+"+x+" null");
    	    	  return null;
    	      }
    	  }catch(Exception sqlException) {
    	      if(null != session.getTransaction()) {
    	          System.out.println("\n.......Transaction Is Being Rolled Back.......");
    	          session.getTransaction().rollback();
    	   }
    	   sqlException.printStackTrace();
    	  }finally {
    		  System.out.println("DAO_getProd_finally+"+result.toString());
    	      if(session != null) {
    	          session.close();
    	   }
    	  }
    	  return result;
 }
//called by prodService via GET path from GET_TABLE.jsp
    public static List<product> getAllproducts1() {
    	  // SessionFactory gives us a factory of sessions
    	  // Usually SessionFactory is been configured by the 
    	  // configuration file named as hibernate.cfg.xml
    	  // buildSessionFactory() builds the sessionFactory for us
    	  SessionFactory sessionFactory = new Configuration().
    	    configure().buildSessionFactory();
          List<product> list = new ArrayList<product>();
    	  // Session is created by calling openSession()
    	  // method on SessionFactory object
    	  Session session = sessionFactory.openSession();
    	  // Creating a transaction from session
    	  Transaction tx = session.beginTransaction();

    	  // Creating a product object 
    	   	  try {
    	      // Get The product Details
    	      Query query = session.createQuery("from product");
    	      if(query != null) {
    	    	  list = query.list();
    	          System.out.println("\nProduct Details= \n" + query.toString());
    	      } else {
    	          System.out.println(query);
    	      }
    	  } catch(Exception sqlException) {
    	      if(null != session.getTransaction()) {
    	          System.out.println("\n.......Transaction Is Being Rolled Back.......");
    	          session.getTransaction().rollback();
    	      }
    	      sqlException.printStackTrace();
    	  } finally {
    	      if(session != null) {
    	    	
    	          session.close();
    	      }
    	  }
    	
    	//putting all empMap to list
    
        return list;
    }

	public static String uploadImage(String y, InputStream imagefile) {
		// TODO Auto-generated method stub
		String path = "/img/"+y+".png";
		try {  
            FileOutputStream out = new FileOutputStream(new File(path));  
            int read = 0;  
            byte[] bytes = new byte[1024];  
            out = new FileOutputStream(new File(path));  
            while ((read = imagefile.read(bytes)) != -1) {  
                out.write(bytes, 0, read);  
            }  
            out.flush();  
            out.close(); 
            String output = "File successfully uploaded to : " + path;  
            return output;  
        } catch (IOException e) {e.printStackTrace();}  
		return null;
	}
 
}
