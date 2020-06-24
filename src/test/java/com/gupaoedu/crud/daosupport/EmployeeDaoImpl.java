package com.gupaoedu.crud.daosupport;

import com.gupaoedu.crud.bean.Employee;
import com.gupaoedu.crud.dao.EmployeeMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: qingshan
 * @Date: 2019/3/9 14:58
 * @Description: 咕泡学院，只为更好的你
 */
//在baseDao的实现类中，继承了BaseDao，并且实现了Mapper接口
//  这样就可以拿到baseDao中封装好的方法了
@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeMapper {
    /**
     * 暂时只实现了这一个方法
     * @param empId
     * @return
     */

    /*
    * 然后可以通过empluyeeDao.selectByPrimaryKey(1)；执行测试了
    * 但是实际的情况并不是这样用的
    *可以去拿到sqlsessionTemplate，但是不想去写一个实现类
    * 实际的情况就是直接注入Mapper就可以使用了
    * */

    @Override
    public Employee selectByPrimaryKey(Integer empId) {
        Employee emp = (Employee) this.selectOne("com.gupaoedu.crud.dao.EmployeeMapper.selectByPrimaryKey",empId);
        return emp;
    }

    @Override
    public int deleteByPrimaryKey(Integer empId) {
        return 0;
    }

    @Override
    public int insert(Employee record) {
        return 0;
    }

    @Override
    public int updateBatch(List<Employee> list) {
        return 0;
    }

    @Override
    public int insertSelective(Employee record) {
        return 0;
    }

    @Override
    public int batchInsert(List<Employee> list) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return 0;
    }

    @Override
    public void deleteByList(List<Integer> ids) {

    }

    @Override
    public long countByMap(HashMap<String, String> map) {
        return 0;
    }

    @Override
    public List<Employee> selectByMap(HashMap<String, Object> map) {
        return null;
    }
}
