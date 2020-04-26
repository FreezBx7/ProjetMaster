package projetM1.graphql.sale;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;

public class LineSaleResolver implements GraphQLResolver<LineSale> {
	private final ProductRepository productRepository;

	public LineSaleResolver(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public Product product(LineSale lineSale) {
		return productRepository.findById(lineSale.getId_product());
	}

}
