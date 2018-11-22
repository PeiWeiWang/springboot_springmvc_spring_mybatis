package net.wanho.mapper;

import net.wanho.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    @Results(value = {
            @Result(property = "name", column = "name"),
            @Result(property = "id", column = "id")
        }
    )
    @Select("select * from t_user")
    public List<User> query();

    @Delete("delete from t_user where id=#{id}")
    public void delete(int id);

    @Select("select * from t_user where id=#{id}")
    User get(int id);

    @Insert("insert into t_user(name) values(#{name})")
    void insert(String name);


    @Update("update t_user set name=#{name} where id=#{id}")
    void update(@Param("id") int id, @Param("name") String name);
}
