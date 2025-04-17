package chapter05;

import java.sql.SQLException;
import java.util.Scanner;

import chapter05_vo.CustomerService;
import chapter05_vo.DBcon;
import chapter05_vo.EmployeeService;
import chapter05_vo.ProductService;
import chapter05_vo.StockService;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();
		
		CustomerService customer = new CustomerService(sc, jdbc);
		ProductService product = new ProductService(sc, jdbc);
		StockService stock = new StockService(sc, jdbc);
		EmployeeService employee = new EmployeeService(sc, jdbc);
		
	}

}
