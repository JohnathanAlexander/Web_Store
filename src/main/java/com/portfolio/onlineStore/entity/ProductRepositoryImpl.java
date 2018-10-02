package com.alexandersEmporium.onlineStore.repositoryImpl;

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
import com.alexandersEmporium.onlineStore.domain.Product;
import com.alexandersEmporium.onlineStore.repository.Repository;
import java.util.ArrayList;

public class ProductRepositoryImpl implements Repository{
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
			String productId = myRs.getString("productId");
			String productName = myRs.getString("productName");
			String productDescription = myRs.getString("productDescription");
			double productPrice = myRs.getDouble("price");
			String imgExt = myRs.getString("imageExtension");
			
			byte[] image = imageRetrieval(myRs, 6);
			
			
			product.setRecordId(recordId);
			product.setProductId(productId);
			product.setTitle(productName);
			product.setDescription(productDescription);
			product.setPrice(productPrice);
			product.setImage(image);
			product.setImageExtension(imgExt);
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
			
			p.setRecordId(rs.getInt("recordId"));
			p.setProductId(rs.getString("productId"));
			p.setTitle(rs.getString("productName"));
			p.setDescription(rs.getString("productDescription"));
			p.setPrice(rs.getDouble("price"));
			p.setCost(rs.getDouble("cost"));
			if(imageRetrieval(rs, 7) != null) {
				p.setImage(imageRetrieval(rs, 7));
				p.setImageExtension(rs.getString("imageExtension"));
			}
			p.setQuantityInStock(rs.getInt("quantityOnHand"));
			p.setQuantityOnOrder(rs.getInt("quantityOnOrder"));
			p.setTotalSalesLifetime(rs.getInt("totalSales"));
			
			list.add(p);
		}
		return list;
	}
	
	public Product getProductByProductId(String productId) throws SQLException{
		Product product = new Product();
		
		CallableStatement cStmt = this.conn.prepareCall("{getProductByProductId(?,?,?,?,?,?,?,?,?)}");
		
		cStmt.setString(1, productId);
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
			product.setTotalSalesLifetime(myRs.getInt("totalSalesLifetime"));
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
	public String deleteProduct(String productId, String username, String password) throws SQLException{
		//does not actually remove product.  It'll just change isActive to false
		//only an admin can change it back
		boolean isAuthenticated = authenticate(new String[] {"admin", "manager"}, username, password);
		if(isAuthenticated) {
			//'delete' product
			return "TRUE";
		}else {
			return "FALSE";
		}

	}
	@Override
	//Parameter levelAuthTo[]: level(s) user must be authenticated to
	public boolean authenticate(String[] levelAuthTo, String username, String password) throws SQLException{
		
		return false;
	}
	
	
	
}
