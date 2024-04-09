package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.model.Category;
import org.mapstruct.*;

// BEGIN
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public abstract class CategoryMapper {
    public abstract Category map(CategoryCreateDTO createDTO);
    public abstract CategoryDTO map(Category category);
}
// END
