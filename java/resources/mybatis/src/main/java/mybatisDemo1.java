import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
mybatis速成
 */
public class mybatisDemo1 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置获得sqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行SQL
        List<User> Users = sqlSession.selectList("test.selectAll");
        System.out.println(Users);
        //4.关闭资源
        sqlSession.close();
    }
}
