package com.hanwha.msdocument.repository;

import com.hanwha.msdocument.model.BspUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    BspUser selectUserTenant(String userId);
}
