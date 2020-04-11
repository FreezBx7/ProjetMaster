package projetM1.graphql.reduction;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

import projetM1.graphql.product.Product;
import projetM1.graphql.product.ProductRepository;


public class ReductionResolver implements GraphQLResolver<Reduction> {
	private final ProductRepository productRepository;

	public ReductionResolver(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public List<Product> products(Reduction reduction) {
		List<Product> listProduct = new ArrayList<Product>();
		List<Integer> listIdProduct = (List<Integer>) reduction.getId_products();
		for(int idProduct : listIdProduct) {
			listProduct.add(productRepository.findById(idProduct));
		}
		return listProduct;
	}
}
