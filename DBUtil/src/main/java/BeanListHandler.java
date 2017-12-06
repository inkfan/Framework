import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanListHandler<T> extends ListHandler {
    private Class<T> type;

    public BeanListHandler(Class<T> type){
        this.type = type;
    }

    public Object getRow( ResultSet rs ) throws SQLException {
        return Rowproce.toBean(rs,type);
    }
}
