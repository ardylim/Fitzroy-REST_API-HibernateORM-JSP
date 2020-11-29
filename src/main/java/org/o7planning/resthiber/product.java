package org.o7planning.resthiber;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class product {

	 private Integer isbn;
	 private String title;
	 private String cat;
	 private String auth;
	 private String pub;
	 private Double price;
	 private Integer quantity;
	 private String imgPath;
	 private Integer no;

	 public product() {

	 }
	 public product(Integer isbn, String title, String cat, String pub, String auth, Double price, Integer quantity, String imgPath) {
	     this.isbn = isbn;
	     this.title = title;
	     this.cat = cat;
	     this.pub = pub;
	     this.auth = auth;
	     this.price = price;
	     this.quantity = quantity;
	     this.imgPath = imgPath;
	 }
	 public Integer getNo() {
		  return no;
		 }


	public void setNo(Integer no) {
	  this.no = no;
	}
	
	public Integer getisbn() {
	  return isbn;
	}


	 public void setisbn(Integer isbn) {
	  this.isbn = isbn;
	 }


	 public String gettitle() {
	  return title;
	 }


	 public void settitle(String title) {
	  this.title = title;
	 }


	 public String getcat() {
	  return cat;
	 }


	 public void setcat(String cat) {
	  this.cat = cat;
	 }


	 public String getpub() {
	  return pub;
	 }


	 public void setpub(String pub) {
	  this.pub = pub;
	 }
	 
	 public String getauth() {
	  return auth;
		 }

	 public void setauth(String auth) {
	  this.auth = auth;
	 }

	public Double getprice() {
	  return price;
	}


	public void setprice(Double price) {
	  this.price = price;
	}

	public Integer getquantity() {
	  return quantity;
	}

	public void setquantity(Integer quantity) {
	  this.quantity = quantity;
	}
	public String getimgPath() {
	  return imgPath;
	}

	public void setimgPath(String imgPath) {
	  this.imgPath = imgPath;
	}


	public String toString() {
	    return "  ISBN: " + isbn + "\n, Title: " + title 
	    		+ "\n, Category: " + cat + "\n, Publisher: " 
	    		+ pub + "\n, Author:" + auth +"\n, Price: $" + price +"\n, Available:" + quantity + "\n";
	}
	public product getResultList() {
		// TODO Auto-generated method stub
		return null;
	}

}
