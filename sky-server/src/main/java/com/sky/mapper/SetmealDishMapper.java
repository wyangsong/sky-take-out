package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**DishMapper.xml
     * 根据菜品id查询套餐id
     *
     * @param ids
     * @return
     */
    List<Long> getSetmealIdsByDishIds(@Param("ids") List<Long> ids);
}
