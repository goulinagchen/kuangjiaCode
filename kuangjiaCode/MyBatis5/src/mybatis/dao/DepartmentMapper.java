package mybatis.dao;

import java.util.List;
import mybatis.bean.Department;
import mybatis.bean.DepartmentExample;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int countByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int deleteByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int insertSelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    List<Department> selectByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tal_dept
     *
     * @mbggenerated Sun Oct 15 12:33:28 CST 2017
     */
    int updateByPrimaryKey(Department record);
}