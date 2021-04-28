package com.pb.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pb.demo.bean.Product;
import com.pb.demo.queries.ProductInfo;

@Component
public class ApplicationRunner implements CommandLineRunner {

	private ProductInfo productInfo;
	
	public ApplicationRunner(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Product> tmp = this.productInfo.test(); 
		productInfo.print(tmp);
	}

	
}
