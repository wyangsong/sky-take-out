package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /*
     * 新增菜品
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /*
     * 菜品分页查询
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /*
     * 根据id查询菜品
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /*
     * 根据id删除菜品数据
     */
    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);

    /*
     * 批量删除菜品
     */
    void deleteBatch(List<Long> ids);

    /*
     * 修改菜品
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);
}
