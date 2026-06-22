package com.ACB.SubRA.Repository;

import com.ACB.SubRA.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ThucCD
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee where employee.user_name = :userName ",nativeQuery = true)
    public Employee findByuserName (@Param("userName") String userName);

    @Query(value = "select * from employee where employee.employee_id = :id ",nativeQuery = true)
    public Employee findByEmployeeID (@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "delete from employee where employee.employee_id = :id ",nativeQuery = true)
    int deleteEmployeeID (@Param("id") int id);

    /*Kiểm tra sự tồn tại*/
    boolean existsByUserName(String userName);

    /*countByEmployeeID đếm số lượng*/
    /**/
}
