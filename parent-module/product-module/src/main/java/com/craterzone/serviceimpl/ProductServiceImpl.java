package com.craterzone.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.craterzone.dao.ProductDao;
import com.craterzone.gateway.RetrofitClientGateway;
import com.craterzone.model.Product;
import com.craterzone.repo.ProductRepository;
import com.craterzone.service.ProductService;
import com.craterzone.util.DynamicObjectMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	RetrofitClientGateway re;
	@Override
	public Optional<Product> createProduct(Product product) {
		try {
			ProductDao productDao = new ProductDao();
			//ProductDao saveproductDao = (ProductDao) DynamicObjectMapper.convertObjectToDao(product, productDao);
			productDao.setName(product.getName());
			productDao.setPrice(product.getPrice());
			productDao.setProduct_code(product.getProduct_code()); 
			Optional<ProductDao> productDb = productRepository.findByname(product.getName());
			if(productDb.isPresent()) {
				return Optional.ofNullable(null);
			}
			ProductDao proDao = productRepository.save(productDao);
			Product productdto = new Product();
			productdto.setName(proDao.getName());
			productdto.setPrice(proDao.getPrice());
			productdto.setProduct_code(proDao.getProduct_code()); 
			//Product productDto = (Product) DynamicObjectMapper.convertObjectToDto(saveproductDao, product);
			return Optional.of(productdto);
			
 		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
}

	@Override
	public Optional<Product> getProduct() {
		List<ProductDao> list = productRepository.findAll();
		if(list.isEmpty()) {
			return Optional.ofNullable(null); 
		}
		ProductDao productdaofromlist = list.stream().iterator().next();
		Product productDto = (Product) DynamicObjectMapper.convertObjectToDto(productdaofromlist, new Product());
		Optional<Product> NotEmptyList = Optional.of(productDto);
		return NotEmptyList; 
	}

	@Override
	public Optional<Product> Update(Product product, long id) {
		Optional<ProductDao> productDbObj = productRepository.findById(id);
		 if(productDbObj.isPresent()) {
			 ProductDao productFromOptional =  productDbObj.get();
			 ProductDao saveproductDao = (ProductDao) DynamicObjectMapper.convertObjectToDao(product, productFromOptional);
			 productRepository.save(saveproductDao);
			 Product productDto = (Product)DynamicObjectMapper.convertObjectToDto(productFromOptional, product);
			 Optional<Product> optionalUser = Optional.of(productDto);
			 return optionalUser;
		 }
		  return null;
}

	@Override
	public Object fetchById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
    public ResponseEntity<Object> getProductWithUsers(String accessToken)throws Exception {
    	//retrofitClient.getObject(accessToken);
    	//RetrofitClientGateway re = new RetrofitClientGateway();
    	//User user = (User)re.getObject(accessToken);
    	System.out.println("Response " +re.getObject(accessToken)); 
	 return null;
    }
}
