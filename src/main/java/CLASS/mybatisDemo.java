package CLASS;

import Mapper.stuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mybatisDemo {
    public static void main(String[] args) throws IOException {

        System.out.println("hello world");


    }


    @Test
    public void selectByName() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);


        stu s = stuMapper.selectByName("汪昊");
        System.out.println(s);

        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Test
    public void selectAll() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);


        List<stu> list = stuMapper.selectAll();
        for (stu stu : list) {
            System.out.println(stu);
        }

        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test05() throws IOException {

        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(Mapper.stuMapper.class);

        int[] ids={6,7};
        stuMapper.deleteByIds(ids);

        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();


    }//根据ID测试批量删除


    @Test
    public void test02() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);
        stu s = new stu(3, "男", "张三", "2023-3-31", 100, "zhangsan@qq.com", "110", 0);
        stu s1 = new stu();
        stuMapper.add(s);

        int id = s.getId();
        System.out.println(id);

        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }//测试添加


    @Test
    public void test03() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);
        stu s = new stu(7, "男", "李四", "2023-7-13", 100, "lisi@qq.com", "110", 0);
        stuMapper.setData(s);


        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }//更改数据

    @Test
    public void test04() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);
        stuMapper.delete(9);

        //提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }//测试删除

    @Test
    public void test01() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);


        //根据Mapper中的函数来完成操作
        /*stuMapper.delete(3);
        List<stu> list = stuMapper.selectAll();*/


        //利用map查询
        String phone = "%1%";
        String gender = "男";
        String name = "%张%";
        Map m = new HashMap();
        //m.put("phone", phone);
        //m.put("gender", gender);
        m.put("name", name);
        List<stu> stu = stuMapper.select(m);
        for (CLASS.stu s : stu) {
            System.out.println(s);
        }
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }//测试模糊查询

    @Test
    public void test() throws IOException {
        //加载MySQL的核心配置文件,获取SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        //获取SQLSession对象,来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL
        //List<stu> list = sqlSession.selectList("test.selectAll");

        //获得stuMapper接口的代理对象
        stuMapper stuMapper = sqlSession.getMapper(stuMapper.class);


        //根据Mapper中的函数来完成操作
        /*stuMapper.delete(3);
        List<stu> list = stuMapper.selectAll();*/


        /*stu stu1 = stuMapper.selectByCondition(4, "男", "%张%");
        String s = stu1.toString();
        System.out.println(s);*/


        //利用map查询
        int id = 4;
        String gender = "男";
        String name = "%张%";
        Map m = new HashMap();
        //m.put("id", id);
        //m.put("gender", gender);
        m.put("name", name);
        List<stu> stu = stuMapper.selectByCondition(m);
        for (CLASS.stu stu1 : stu) {
            System.out.println(stu1);
        }

        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    //测试查询

}
