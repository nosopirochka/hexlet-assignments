package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;


import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        var sql = "INSERT INTO products (title, price) VALUES (?, ?)";
        try (var conn = dataSource.getConnection();
             var stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stat.setString(1, product.getTitle());
            stat.setInt(2, product.getPrice());
            stat.executeUpdate();
            var generatedKeys = stat.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find(Long id) throws SQLException {
        var sql = "SELECT * FROM products WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stat = conn.prepareStatement(sql)) {
            stat.setLong(1, id);
            var data = stat.executeQuery();
            if (data.next()) {
                var title = data.getString("title");
                var price = data.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            } else {
                return Optional.empty();
            }
        }
    }
    public static List<Product> getEntities() throws SQLException {
        var sql = "SELECT * FROM products";
        try (var conn = dataSource.getConnection();
             var stat = conn.prepareStatement(sql)) {
            var data = stat.executeQuery();
            var products = new ArrayList<Product>();
            while (data.next()) {
                var id = data.getLong("id");
                var title = data.getString("title");
                var price = data.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                products.add(product);
            }
            return products;
        }
    }
    // END
}
