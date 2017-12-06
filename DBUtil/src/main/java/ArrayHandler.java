import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayHandler implements ResultSetHandler {
    public Object[] handler(ResultSet rs) throws SQLException {
        return rs.next() ? Rowproce.toArray(rs) : null;
    }
}
