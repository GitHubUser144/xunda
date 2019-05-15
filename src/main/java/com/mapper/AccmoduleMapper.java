package com.mapper;

import com.pojo.Accmodule;
import com.pojo.AccmoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccmoduleMapper {
    long countByExample(AccmoduleExample example);

    int deleteByExample(AccmoduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Accmodule record);

    int insertSelective(Accmodule record);

    List<Accmodule> selectByExample(AccmoduleExample example);

    List<Accmodule> selectWithModuleByUserid(Integer userId);

    Accmodule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Accmodule record, @Param("example") AccmoduleExample example);

    int updateByExample(@Param("record") Accmodule record, @Param("example") AccmoduleExample example);

    int updateByPrimaryKeySelective(Accmodule record);

    int updateByPrimaryKey(Accmodule record);
}