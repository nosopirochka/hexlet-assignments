package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params) {
        return categoryId(params.getCategoryId())
                .and(priceGt(params.getPriceGt()))
                .and(priceLt(params.getPriceLt()))
                .and(ratingGt(params.getRatingGt()))
                .and(containSubstring(params.getTitleCont()));
    }

    private Specification<Product> categoryId(Long id) {
        return ((root, query, criteriaBuilder) -> id == null
                ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("category").get("id"), id));
    }

    private Specification<Product> priceGt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction() : criteriaBuilder.greaterThan(root.get("price"), price));
    }

    private Specification<Product> priceLt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction() : criteriaBuilder.lessThan(root.get("price"), price));
    }

    private Specification<Product> ratingGt(Double rating) {
        return ((root, query, criteriaBuilder) -> rating == null
        ? criteriaBuilder.conjunction() : criteriaBuilder.greaterThan(root.get("rating"), rating));
    }

    private Specification<Product> containSubstring(String substring) {
        return (root, query, criteriaBuilder) -> substring == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), substring.toLowerCase());
    }
}
// END
