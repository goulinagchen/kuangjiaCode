package mybatis.dao;

import java.util.List;
import mybatis.bean.Employee;
import mybatis.bean.EmployeeExample;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_employee
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByPrimaryKey(Employee record);
}