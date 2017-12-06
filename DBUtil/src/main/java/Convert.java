import java.sql.ResultSet;
import java.sql.SQLException;

public class Convert {
    public static Object convert( ResultSet rs,String columnName,Class<?> type) throws SQLException {
        Object obj = null;
        if(type.equals(String.class)){
            obj = rs.getString(columnName);
        }else if(type.equals(Integer.TYPE)||type.equals(Integer.class)){
            obj = Integer.valueOf(rs.getInt(columnName));
        }else if(type.equals(Double.TYPE)||type.equals(Double.class)){
            obj = Double.valueOf(rs.getDouble(columnName));
        }else if(type.equals(Short.TYPE)||type.equals(Short.class)){
            obj = Short.valueOf(rs.getShort(columnName));
        }else if(type.equals(Long.TYPE)||type.equals(Long.class)){
            obj = Long.valueOf(rs.getLong(columnName));
        }else if(type.equals(Boolean.TRUE)||type.equals(Boolean.class)){
            obj = Boolean.valueOf(rs.getBoolean(columnName));
        }else if (type.equals(Float.TYPE)||type.equals(Float.class)){
            obj = Float.valueOf(rs.getFloat(columnName));
        }else if(type.equals(Byte.TYPE)||type.equals(Byte.class)){
            obj = Byte.valueOf(rs.getByte(columnName));
        }
        return obj;
    }
}
