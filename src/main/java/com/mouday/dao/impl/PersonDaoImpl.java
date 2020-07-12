package com.mouday.dao.impl;

import com.mouday.dao.PersonDao;
import com.mouday.pojo.Person;
import com.mouday.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    public Integer createTable() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Integer result = mapper.createTable();
            session.commit();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer dropTable() {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Integer result = mapper.dropTable();
            session.commit();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Person> selectAll() {
        List<Person> list = null;

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            // Person person = session.selectOne("com.mouday.dao.PersonDao.selectById", 1);
            // 等价于

            PersonDao mapper = session.getMapper(PersonDao.class);
            list = mapper.selectAll();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Person selectById(Integer id) {
        Person person = null;

        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            // Person person = session.selectOne("com.mouday.dao.PersonDao.selectById", 1);
            // 等价于

            PersonDao mapper = session.getMapper(PersonDao.class);
            person = mapper.selectById(id);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    public Integer deleteById(Integer id) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Integer result = mapper.deleteById(id);
            session.commit();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer insert(Person person) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Integer result = mapper.insert(person);
            session.commit();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Integer update(Person person) {
        try (SqlSession session = MyBatisUtil.getSqlSession()) {
            PersonDao mapper = session.getMapper(PersonDao.class);
            Integer result = mapper.update(person);
            session.commit();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
