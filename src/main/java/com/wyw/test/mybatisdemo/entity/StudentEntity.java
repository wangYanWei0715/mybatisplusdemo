package com.wyw.test.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年5月10日$ 23点09分$
 */
@TableName("t_student")
@Getter
@Setter
@ToString
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 2323186691053032471L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField
    private String name;

    @TableField
    private Integer age;

    @TableField(el = "hobbyies,typeHandler=com.wyw.test.mybatisdemo.typehandler.MyTypeHandler")
    private List<String> hobbyies;


}
