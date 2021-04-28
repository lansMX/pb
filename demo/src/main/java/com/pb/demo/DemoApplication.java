package com.pb.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pb.demo.bean.Product;
import com.pb.demo.queries.ProductInfo;

@SpringBootApplication
@RestController
public class DemoApplication {
	

	private ProductInfo productInfo;

	public static void main(String[] args) {
//		this.productInfo = productInfo
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication.run(ApplicationRunner.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/productList")
	public Product productList() {
		return new Product("1", "asd", 32.54f);
	}
	
	@GetMapping("/product")
	public List<Product> product() {
		
		ProductInfo pInfo = null;
		try {
			pInfo = new ProductInfo();
		} catch (Exception e) {
			System.out.println("na");
			e.printStackTrace();
		}
		return pInfo.test();
	}
	
	@GetMapping("/saving")
	public String saving() {
		ProductInfo pInfo = null;
		Product p = new Product("2", "asd", 32.54f);  
		try {
			pInfo = new ProductInfo();
		} catch (Exception e) {
			System.out.println("na");
			e.printStackTrace();
		}
		pInfo.saving(p);
		return String.format("Saved!");
	}
	@GetMapping("/insert")
	public String insert() {
		ProductInfo pInfo = null;
		Product p = new Product("3", "short", 150.54f);  
		try {
			pInfo = new ProductInfo();
		} catch (Exception e) {
			System.out.println("na");
			e.printStackTrace();
		}
		pInfo.saving(p);
		return String.format("insert!");
	}
	
	@GetMapping("/update")
	public String update() {
		ProductInfo pInfo = null;
		try {
			pInfo = new ProductInfo();
		} catch (Exception e) {
			System.out.println("na");
			e.printStackTrace();
		}
		pInfo.updating();
		return String.format("updated!");
	}
	@GetMapping("/delete")
	public String delete() {
		ProductInfo pInfo = null;
		try {
			pInfo = new ProductInfo();
		} catch (Exception e) {
			System.out.println("na");
			e.printStackTrace();
		}
		pInfo.deteleting();
		return String.format("deleted!");
	}
	
}