package com.gupaoedu.crud.service;

import com.gupaoedu.crud.bean.Employee;
import com.gupaoedu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
@Service
public class EmployeeService {
    //Mapper什么时候注入到IOC的？
    @Autowired
    //到这里在实例化service的时候会,实例化属性employeeMapper,这个employeeMapper就是一个MapperFactoryBean
    //  再次进入MapperFactoryBean，而它继承FactoryBean，看下复写的getObject方法

    //  回到这里分析一下，其实getObject最后就是返回MapperProxy，这个里面的invoke 方法，后面就和mybatis一样的流程了。

    //  总结一下：注册的时候，把mapper替换成了MapperFactoryBean，然后注入使用的时候，会调用MapperFactoryBean的
    //   getObject方法，在getObject方法里,调用sqlSessionTemplate(因为继承了sqlSessionDaoSupport)的getMapper方法
    //  拿到了代理对象MapperProxy,所以下面就可以走到employeeMapper.selectByMap(null);代理对象的流程了.

    //  就是说注入其实返回的是一个mapperProxy
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
      // 可以看到在Demo中注入mapper，就可以直接开始使用方法了
        return employeeMapper.selectByMap(null);
    }

    public void saveEmpsInfo(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    //检查用户名
    public boolean cheUser(String empName) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("empName",empName);

        long count = employeeMapper.countByMap(map);
        return count == 0;
    }

    //按id查询
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    //员工更新
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        employeeMapper.deleteByList(ids);

    }
}
