package com.wyw.test.mybatisdemo.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年5月10日$ 23点15分$
 */
@ToString
@Setter
@Getter
public class StudentDTO implements Serializable {

    private static final long serialVersionUID = -6834505198042840392L;
    private Integer id;

    private String name;

    private Integer age;

    private List<String> hobbyies;
}
