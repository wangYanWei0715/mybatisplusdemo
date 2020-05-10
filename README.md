1.本项目集成了springboot+mybatisplus+durid
2.项目中有TypeHandler的实现


TypeHandler的坑

    @MappedTypes({String[].class})
    @MappedJdbcTypes({JdbcType.VARCHAR})
    public class StringArrayTypeHandler implements TypeHandler<String[]> {
        @Override
        public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
            if (parameter == null)
                ps.setNull(i, Types.VARCHAR);
            else {
               JSONArray array =  new JSONArray(Arrays.asList(parameter));
    
                ps.setString(i, array.toString());
            }
        }
    
        @Override
        public String[] getResult(ResultSet rs, String s) throws SQLException {
    
            String columnValue = rs.getString(s);
            return this.getStringArray(columnValue);
        }
    
        @Override
        public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
            String columnValue = rs.getString(columnIndex);
            return this.getStringArray(columnValue);
        }
    
        @Override
        public String[] getResult(CallableStatement cs, int i) throws SQLException {
            String columnValue = cs.getString(i);
            return this.getStringArray(columnValue);
    
        }
    
        private String[] getStringArray(String columnValue) {
    
            if (columnValue == null)
                return null;
            JSONArray jsonArr = JSONArray.parseArray(columnValue);
    
            return  jsonArr.toArray(new String[jsonArr.size()]);
        }
    
由于在项目中使用了mybatisplus，所以使用如下：


    /**
     * 商品货品的规格列表
     */
    @TableField(value = "specifications",el = "specifications,typeHandler=com.seven.wechatshop.shopapi.typehandle.StringArrayTypeHandler")
    private String[] specifications;
   
但是上面的代码，并没有生效。后来阅读文档，发现是缺少了一个配置。如下

//注意使用了plus的是添加下面这个 这个一定要配 不然查询映射不上
mybatis-plus.type-handlers-package = com.seven.wechatshop.shopapi.typehandle

如果只是mybatis，那么添加的配置为
mybatis.type-handlers-package=com.seven.wechatshop.shopapi.typehandle





