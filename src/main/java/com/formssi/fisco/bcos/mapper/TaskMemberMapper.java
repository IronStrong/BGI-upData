package com.formssi.fisco.bcos.mapper;


import com.formssi.fisco.bcos.domain.TaskMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
@Component
@Mapper
public interface TaskMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskMember record);

    int insertSelective(TaskMember record);

    TaskMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskMember record);

    int updateByPrimaryKey(TaskMember record);

    List<TaskMember> findByTaskNoIn(@Param("taskNoCollection") Collection<String> taskNoCollection);

    List<TaskMember> findByUserIdAndTaskNoAndRole(@Param("userId") Integer userId, @Param("taskNo") String taskNo, @Param("role") Integer role);

    List<TaskMember> findByTaskNoAndStatus(@Param("taskNo") String taskNo, @Param("status") Integer status);

    int deleteByTaskNoAndStatus(@Param("taskNo") String taskNo, @Param("status") Integer status);

List<TaskMember> FindAllTaskMemeberNoChain();






}