package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		try {
			SellerDao sellerDao = DaoFactory.createSellerDao();
	
			System.out.println("=== TEST 1: seller findById ===");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			System.out.println();
			
			System.out.println("=== TEST 2: seller findByDepartment ===");
			Department department = new Department(2, null);
			List<Seller> list = sellerDao.findByDepartment(department);
			list.forEach(System.out::println);
			System.out.println();		
			
			System.out.println("=== TEST 3: seller findAll ===");
			list = sellerDao.findAll();
			list.forEach(System.out::println);
			System.out.println();
			
			System.out.println("=== TEST 4: seller insert ===");
			Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted! New id = " + newSeller.getId());
			System.out.println();
			
			System.out.println("=== TEST 5: seller update ===");
			seller = sellerDao.findById(8);
			seller.setName("Martha Waine");
			sellerDao.update(seller);
			System.out.println("Updated completed!");
			System.out.println();
			
			System.out.println("=== TEST 6: seller delete ===");
			sellerDao.deleteById(20);
			System.out.println("Delete completed!");
			System.out.println();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
