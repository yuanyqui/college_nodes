import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis集成mapper代理开发
 */
public class mybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置获得sqlsessionfactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获得sqlsession对象来执行SQL代码
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.1获得同名接口类的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
        //4.释放资源
        sqlSession.close();

    }
}
