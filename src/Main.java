import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n=== TEST 2: Seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

//        System.out.println("\n=== TEST 4: Seller Insert ===");
//        Seller newSeller = new Seller(null, "Joao", "joao@gmail.com", new Date(), 3000.0, department);
//        sellerDao.insert(newSeller);
//        System.out.println("Inserted! new insert: " + newSeller.getId());

        System.out.println("\n=== TEST 5: Seller update===");
        seller = sellerDao.findById(8);
        seller.setName("Rafael Romão");
        sellerDao.update(seller);
        System.out.println("update completed");

        System.out.println("\n=== TEST 6: Seller delete ===");
        System.out.println("Enter id for delete test:");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.print("Delete completede: ");

        sc.close();
    }
}