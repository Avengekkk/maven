package Mapper;

import CLASS.stu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface stuMapper {
    List<stu> selectAll();

    stu selectID(int id);

    boolean setData(stu s);

    boolean delete(int id);

    void deleteByIds(@Param("ids") int[] ids);

    boolean add(stu s);

    List<stu> selectByCondition(@Param("id") int id, @Param("gender") String gender, @Param("name") String name);

    List<stu> select(@Param("phone") String phone, @Param("gender") String gender, @Param("name") String name);

    List<stu> select(Map map);

    List<stu> selectByCondition(Map map);

    @Select("select * from stu where name=#{name}; ")
    // 上面的是对的,编译器有毛病
    stu selectByName(String name);


}
