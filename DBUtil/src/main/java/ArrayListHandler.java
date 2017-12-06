import java.sql.ResultSet;
import java.sql.SQLException;

public class ArrayListHandler extends ListHandler {
    public Object[] getRow( ResultSet rs ) throws SQLException {
        return Rowproce.toArray(rs);
    }
}
