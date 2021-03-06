package com.portfolio.onlineStore.ejb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import com.portfolio.onlineStore.entity.Product;

import java.util.ArrayList;

public class ProductRepositoryImpl{
	private Connection conn;
	public ProductRepositoryImpl(Connection conn) {
		this.conn = conn;
	}
	public List<Product> getAllFeaturedProducts() throws SQLException, IOException{
		List<Product> list = new ArrayList<>();
		
		Statement myStmt = this.conn.createStatement();
		String sql = "SELECT recordId, productId, productName, "
						   +"productDescription, price, image, imageExtension "
					+"FROM products.products "
					+"WHERE isFeatured = 'TRUE'";
		System.out.println(sql);
		ResultSet myRs = myStmt.executeQuery(sql);
		while(myRs.next()) {
			Product product = new Product();
			
			int recordId = myRs.getInt("recordId");
			int productId = myRs.getInt("productId");
			String productName = myRs.getString("productName");
			String productDescription = myRs.getString("productDescription");
			double productPrice = myRs.getDouble("price");
			String imgExt = myRs.getString("imageExtension");
			
			byte[] image = imageRetrieval(myRs, 6);
			
			
			product.setProductId(productId);
			product.setTitle(productName);
			product.setDescription(productDescription);
			product.setPrice(productPrice);
			product.setImage(image);
			product.setImageExt(imgExt);
			list.add(product);
		}
		
		return list;
	}
	public byte[] imageRetrieval(ResultSet myRs, int colNum) throws SQLException, IOException {
		if(myRs.getBinaryStream(colNum) != null) {
			InputStream stream = myRs.getBinaryStream(colNum);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			int a1 = stream.read();
			while(a1 >= 0) {
				output.write((char) a1);
				a1 = stream.read();
			}
			
			output.close();
			return output.toByteArray();
		}else {
			return null;
		}
		
	}
	public List<Product> getAllProducts() throws SQLException, IOException{
		List<Product> list = new ArrayList<>();
		
		Statement stmt = this.conn.createStatement();
		String sql = "SELECT p.recordId, p.productId, p.productName, p.productDescription, "
				   		  + "p.price, p.cost, p.image, p.imageExtension, i.quantityOnHand, i.quantityOnOrder, s.totalSales "
				   + "FROM products as p join inventory as i join sales as s "
				   + "WHERE p.isActive = 'TRUE' "
				   + "AND p.productId = i.productId "
				   + "AND p.productId = s.productId "
				   + "AND i.productId = s.productId;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Product p = new Product();
			
			p.setProductId(rs.getInt("productId"));
			p.setTitle(rs.getString("productName"));
			p.setDescription(rs.getString("productDescription"));
			p.setPrice(rs.getDouble("price"));
			p.setCost(rs.getDouble("cost"));
			if(imageRetrieval(rs, 7) != null) {
				p.setImage(imageRetrieval(rs, 7));
				p.setImageExt(rs.getString("imageExtension"));
			}
			p.setQuantityInStock(rs.getInt("quantityOnHand"));
			p.setQuantityOnOrder(rs.getInt("quantityOnOrder"));
			p.setTotalSales(rs.getInt("totalSales"));
			
			list.add(p);
		}
		return list;
	}
	
	public Product getProductByProductId(int productId) throws SQLException{
		Product product = new Product();
		
		CallableStatement cStmt = this.conn.prepareCall("{getProductByProductId(?,?,?,?,?,?,?,?,?)}");
		
		cStmt.setInt(1, productId);
		cStmt.registerOutParameter(2, Types.VARCHAR);
		cStmt.registerOutParameter(3, Types.VARCHAR);
		cStmt.registerOutParameter(4, Types.DECIMAL);
		cStmt.registerOutParameter(5, Types.DECIMAL);
		//cStmt.registerOutParameter(6, Types.BLOB);
		cStmt.registerOutParameter(7, Types.INTEGER);
		cStmt.registerOutParameter(8, Types.INTEGER);
		cStmt.registerOutParameter(9, Types.INTEGER);
		
		ResultSet myRs = cStmt.executeQuery();
		
		while(myRs.next()) {
			product.setProductId(productId);
			product.setTitle(myRs.getString("title"));
			product.setDescription(myRs.getString("description"));
			product.setCost(myRs.getDouble("cost"));
			product.setPrice(myRs.getDouble("price"));
			//product.setImage(myRs.getBlob("image"));
			product.setQuantityInStock(myRs.getInt("inStock"));
			product.setQuantityOnOrder(myRs.getInt("onOrder"));
			product.setTotalSales(myRs.getInt("totalSalesLifetime"));
		}
		return product;
	}
	public String addNewProduct(String name, String desc, String prodId,
								 double cost, double price, byte[] image,
								 String imgExt, int stock, int order) throws SQLException{
		String success = "false";
		String sql = "INSERT INTO products(productId, productName, productDescription, price, cost, image, imageExtension, isActive)"
				    +"VALUES('"+prodId+"', '"+name+"', '"+desc+"', "+price+", "+cost+", "+image+", '"+imgExt+"', TRUE";
		Statement stmt = conn.createStatement();
		
		if(stmt.executeUpdate(sql) == 1)
			success = "true";
		
		return success;
	}
	//TODO
	public String deleteProduct(String productId, String username, String password) throws SQLException{
		//does not actually remove product.  It'll just change isActive to false
		//only an admin can change it back
		return "";
		//change return type to boolean?

	}
	
	
	
	
}
