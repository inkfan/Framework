import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class MapHandler implements ResultSetHandler {
    public Map<String ,Object> handler(ResultSet rs) throws SQLException {
        return rs.next() ? Rowproce.toMap(rs) : null;
    }
}
