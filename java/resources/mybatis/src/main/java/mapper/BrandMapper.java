package mapper;

import entity.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectBrandById(int id);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);
    void update(Brand brand);


    void deleteById(int id);

    void deleteByIds(int []ids);
}
