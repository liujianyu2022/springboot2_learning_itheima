package com.itheima.mapper;

import com.itheima.dao.Book;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookMapper {
    @Select("select * from books where id = #{id}")
    Book getById(@Param("id") Integer id);

    @Insert("insert into books values(#{id},#{name},#{authors},#{price},#{publishdate},#{note},#{num})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertBook(Book book);

    @Update("update books set id = #{id} where name = #{name}")
    int updateBookByName(@Param("name") String name, @Param("id") Integer id);

    @Delete("delete from books where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Delete("delete from books where name = #{name}")
    int deleteByName(@Param("name") String name);
}
