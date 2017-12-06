import java.sql.ResultSet;
import java.sql.SQLException;

public class MapListHandler extends ListHandler {
    public Object getRow( ResultSet rs ) throws SQLException {
        return Rowproce.toMap(rs);
    }
}
