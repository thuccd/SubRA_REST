package com.ACB.SubRA.Repository;

import com.ACB.SubRA.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer > {

     @Query( value = "SELECT * FROM `group`  where group.group_code = :groupCode",
          nativeQuery = true
     )
     Group findGroupByCode(@Param("groupCode") String groupCode);

     Group findByGroupCode(String groupCode);
}
