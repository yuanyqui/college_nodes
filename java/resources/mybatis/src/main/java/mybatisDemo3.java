import entity.Brand;
import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisDemo3 {
    public static void main(String[] args) throws IOException {
        int id=1;
        int statues=1;
        String companyName="华为";
        String brandname="华为";
        companyName="%"+companyName+"%";
        brandname="%"+brandname+"%";
        String resources="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> list = mapper.selectAll();
//        System.out.println(list);
//        Brand brandById = mapper.selectBrandById(id);
//        System.out.println(brandById);
        Brand b1=new Brand();
        b1.setBrandName(brandname);
        b1.setStatus(statues);
        b1.setCompanyName(null);
        List<Brand> brands = mapper.selectByCondition(b1);
//        List<Brand> brands1=mapper.selectByConditionSingle(b1);
        System.out.println();
        sqlSession.close();

    }

}
