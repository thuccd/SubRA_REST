package com.ACB.SubRA.Repository;

import com.ACB.SubRA.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where role.role_name= :roleName",
            nativeQuery = true)
    Role findByRoleName(@Param("roleName") String roleName);


}
