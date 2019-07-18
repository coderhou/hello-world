package com.houjun.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.houjun.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class MybatisTest1 {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory factory2 = new SqlSessionFactoryBuilder().build(resourceAsReader);
        System.out.println(factory);
        System.out.println(factory2);
        SqlSession openSession = factory.openSession();
        Student student = openSession.selectOne("com.houjun.dao.StudentMapper.selectById", 1);//前面是方法后面是参数
        System.out.println(student);
        //查
        Page<Object> startPage = PageHelper.startPage(1, 1);//见证了使用pageHelper
        List<Student> list = openSession.selectList("com.houjun.dao.StudentMapper.selectByAll");//前面是方法后面是参数
        System.out.println(list);
        System.out.println(startPage.getTotal());
        //增
        Student student1 = new Student("侯军",22,true,new Date(1996-8-9));
        int insert = openSession.insert("com.houjun.dao.StudentMapper.insert",student1 );
        System.out.println(insert);
        //删
        int delete = openSession.delete("com.houjun.dao.StudentMapper.deleteById", 2);
        System.out.println(delete);
        //改
        Student 虚竹 = new Student("虚竹", 24, true, new Date(1234 - 5 - 6));
        虚竹.setId(15);
        int update = openSession.update("com.houjun.dao.StudentMapper.update", 虚竹);
        System.out.println(update);
        openSession.commit();
    }
}
