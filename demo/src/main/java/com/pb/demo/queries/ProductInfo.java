package com.pb.demo.queries;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

//import com.jayway.jsonpath.Criteria;
import com.pb.demo.bean.Product;
import com.pb.demo.util.MongoDBConfig;

@Service
public class ProductInfo {
	
	private MongoTemplate tmp;
	
	public ProductInfo () throws Exception {
		MongoDBConfig mc = new MongoDBConfig();
		this.tmp = mc.mongoTemplate();
	}
	
	public List<Product> test() {
		return this.tmp.find(
				Query.query( Criteria.where("name").is("playera") ),
				Product.class
				);
		
//		return this.tmp.findAll(Product.class);
	}
	
	// insert
	public void simpleInsert(Product p) {
		// insert    > insercion simple 		
		this.tmp.insert(p);
		// insertAll > insercion multiple
	}
	
	// save
	public void saving(Product p) {
		this.tmp.save(p);
	}
	
	// update
	public void updating () {
		// update table set field = newValue where criteria = value
		
		// where criteria = value
//		Query test = Query.query( Criteria.where("name").is("playera") );
//		// set field = newValue
//		Update setPrice = Update.update("price", 250);
//		
//		this.tmp.updateMulti(
//				test,
//				setPrice,
//				ProductInfo.class
//				);
		Product pi = new Product();
		pi.setNameP("calcetin");
		Query query = new Query();
        query.addCriteria(Criteria.where("id").is("3"));
        Update update = new Update();
        update.set("name", pi.getNameP());
//        update.set("price", pi.getPriceF());
         this.tmp.findAndModify(query, update, ProductInfo.class);
	
		
	}
	
	//	delete
	public void deteleting() {
		// delete table where crite = value
		 Query query = new Query();
	        query.addCriteria(Criteria.where("id").is("2"));
	        this.tmp.remove(query, ProductInfo.class);
	}

	public void print(List<Product> tmp2) {
		for (Product productInfo : tmp2) {
			System.out.println(tmp2.toString());
		}
	}
}
