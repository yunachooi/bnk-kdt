package chapter05;

import java.sql.SQLException;
import java.util.Scanner;

import chapter05_vo.DBcon;
import chapter05_vo.ProductService;
import chapter05_vo.StockService;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();
		
		ProductService product = new ProductService(sc, jdbc);
		StockService stock = new StockService(sc, jdbc);
		
		product.productInfo();
		stock.getProductStock();
	}

}
