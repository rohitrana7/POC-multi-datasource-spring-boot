package com.mds.poc;

import com.mds.poc.mysqlentity.Product;
import com.mds.poc.mysqlrepository.ProductDAO;
import com.mds.poc.psqlentity.Order;
import com.mds.poc.psqlrepository.OrderDAO;
import com.mds.poc.util.CustomConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PocApplication implements CommandLineRunner {

//    @Autowired
//    private CustomConfigProperties student;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product("key", 1200.0);
        productDAO.save(product);

        Order order = new Order("Mohit", LocalDate.now());
        orderDAO.save(order);

    }
}
