import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanHandler<T> implements ResultSetHandler {
    private Class<T> type;

    public BeanHandler(Class<T> type){
        this.type = type;
    }

    public Object handler( ResultSet rs ) throws SQLException {
        return rs.next() ? Rowproce.toBean(rs,type) : null;
    }
}
