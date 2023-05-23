import entity.Brand;
import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置获得sqlsessionfactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获得sqlsession对象来执行SQL代码
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1获得同名接口类的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        //4.释放资源
        sqlSession.close();
    }
    @Test
    public static void addTest() throws IOException {
        Brand brand = new Brand();
        int id=2;
        int status=0;
        String brandname="ios";
        String companyname="苹果";
        Integer ordered=100;
        String description="美利坚企业良心";
        brand.setId(id);
        brand.setStatus(status);
//        brand.setOrdered(ordered);
//        brand.setCompanyName(companyname);
//        brand.setDescription(description);
        brand.setBrandName(brandname);
        String resources="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
//        mapper.add(brand);
//        int id=brand.getId();
//        System.out.println(id);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public static void delTest() throws IOException {
        int id=8;
        String resources="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public static void delTests() throws IOException {
        int []ids={1,2,3};
        System.out.println("被删除的id值为");
        for (int id : ids) {
            System.out.print(id);
        }
        String resources="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();

    }
}
