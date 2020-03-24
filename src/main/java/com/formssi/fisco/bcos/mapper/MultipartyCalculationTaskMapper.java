package com.formssi.fisco.bcos.mapper;

import com.formssi.fisco.bcos.domain.MultipartyCalculationTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
@Component
@Mapper
public interface MultipartyCalculationTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MultipartyCalculationTask record);

    int insertSelective(MultipartyCalculationTask record);

    MultipartyCalculationTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MultipartyCalculationTask record);

    int updateByPrimaryKey(MultipartyCalculationTask record);

    List<MultipartyCalculationTask> findByCreateUserIdAndStatusInOrderByIdDesc(@Param("createUserId") Integer createUserId, @Param("statusList") List<Integer> statusList);

    List<MultipartyCalculationTask> findByCreateUserIdOrderByIdDesc(@Param("createUserId") Integer createUserId);

    List<String> findNoByCreateUserIdAndJoinCountAndStatus(@Param("createUserId") Integer createUserId, @Param("joinCount") Integer joinCount, @Param("status") Integer status);

    List<MultipartyCalculationTask> findCanjoinMultiCaculateUserByUserNameLike(@Param("userName") String userName);

    List<MultipartyCalculationTask> findByJoinTaskByStatusAndUserId(@Param("status") Integer status, @Param("userId") Integer userId);

    List<MultipartyCalculationTask> findByJoinTaskByStatusInAndUserId(@Param("memberStatusLsit") List<Integer> memberStatusLsit, @Param("taskStatusList") List<Integer> taskStatusList, @Param("userId") Integer userId);

    MultipartyCalculationTask findByCreateUserIdAndStatusAndNo(@Param("createUserId") Integer createUserId, @Param("status") Integer status, @Param("no") String no);

    MultipartyCalculationTask findByCreateUserIdAndStatusAndNoAndJoinCount(@Param("createUserId") Integer createUserId, @Param("status") Integer status, @Param("no") String no, @Param("joinCount") Integer joinCount);

    MultipartyCalculationTask findByNo(@Param("no") String no);

    List<MultipartyCalculationTask> findByCreateUserIdAndStatusIn(@Param("createUserId") Integer createUserId, @Param("statusCollection") Collection<Integer> statusCollection);

    int deleteByCreateUserIdAndNoAndStatus(@Param("createUserId") Integer createUserId, @Param("no") String no, @Param("status") Integer status);


    List<MultipartyCalculationTask> findAllDataByStatus();

}