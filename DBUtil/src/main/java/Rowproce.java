import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Rowproce {
    public static <T> T toBean(ResultSet rs, Class<T> type) {
        Object obj = null;
        try {
            obj = type.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            Field[] fields = type.getDeclaredFields();

            for(Field field : fields){
                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
                String columnName = column.value();
                Class<?> fieldType = field.getType();

                for(int i = 1;i<=metaData.getColumnCount();i++){
                    String columnName1 = metaData.getColumnName(i);
                    if(columnName1.equals(columnName)){
                        Object o = Convert.convert(rs,columnName,fieldType);
                        field.set(obj,o);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }

    public static Object[] toArray(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Object[] objs = new Object[metaData.getColumnCount()];
        for(int i = 1;i<=metaData.getColumnCount();i++){
            objs[i-1] = rs.getObject(metaData.getColumnName(i));
        }
        return objs;
    }

    public static Map<String,Object> toMap(ResultSet rs) throws SQLException{
        Map<String,Object> map = new HashMap();
        ResultSetMetaData metaData = rs.getMetaData();
        for(int i = 1;i<=metaData.getColumnCount();i++){
            map.put(metaData.getColumnName(i),rs.getObject(metaData.getColumnName(i)));
        }
        return map;
    }
}
