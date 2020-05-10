package com.wyw.test.mybatisdemo.typehandler;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @author 王延伟
 * @description TODO
 * @createTime 2020年5月10日$ 23点44分$
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({List.class})
public class MyTypeHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> integers,
        JdbcType jdbcType) throws SQLException {
        if (!CollectionUtils.isEmpty(integers)){
            String result = integers.stream().collect(Collectors.joining(","));
            preparedStatement.setString(i,result);
        }

    }


    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);

        return converValueToScopes(string);
    }


    private List<String> converValueToScopes(String string) {
        if (StringUtils.isEmpty(string)){
            return Collections.emptyList();
        }
        String[] split = string.split(",");
        return Arrays.stream(split).collect(Collectors.toList());

    }


    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return converValueToScopes(string);
    }


    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return converValueToScopes(string);
    }
}
