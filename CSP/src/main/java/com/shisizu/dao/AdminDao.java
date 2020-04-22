package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.Admin;
import com.shisizu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 袁红
 * @create 2020-04-11-19:02
 */
@Mapper
public interface AdminDao extends BaseMapper<Admin> {
    Admin selectAdmin(@Param("admName") String admName,@Param("admPassword") String admPassword);
}
