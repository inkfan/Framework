import java.sql.*;

public class SQLExecutor {
    private Connection conn;
    private Boolean autoClose;
    public SQLExecutor(Connection conn) throws SQLException {
        if (conn == null){
            throw new SQLException("空连接");
        }
        this.conn = conn;
    }

    public int executeUpdate(String sql ,Object...args) throws SQLException {
        if (sql == null){
            throw new SQLException("空查询语句");
        }
        PreparedStatement pst = conn.prepareStatement(sql);
        setArgus(pst, args);
        int i = pst.executeUpdate();
        close(pst);
        return i;
    }

    public <T> T executeQuery(String sql, ResultSetHandler handler, Object...params) throws Exception {
        if(sql == null){
            throw new SQLException("空sql语句");
        }

        PreparedStatement pst = conn.prepareStatement(sql);
        setArgus(pst,params);
        ResultSet rs = pst.executeQuery();
        Object o = handler.handler(rs);
        close(pst);
        return (T)o;
    }

    public int[] executeBatch(String sql,Object[][] objs) throws SQLException {
        int [] resluts = null;
        PreparedStatement pst = conn.prepareStatement(sql);
        for(int i = 0;i<objs.length;i++){
            setArgus(pst,objs[i]);
            pst.addBatch();
        }
        resluts = pst.executeBatch();
        return resluts;
    }

    public void beginTransaction() throws SQLException {
        conn.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        conn.commit();
        close(conn);
    }

    public void rollback() throws SQLException {
        conn.rollback();
        conn.close();
    }

    private void close(Connection conn) throws SQLException {
        if (conn != null){
            conn.close();
        }
    }

    private void close(PreparedStatement pst) throws SQLException {
        if (pst != null){
            pst.close();
        }
    }

    private void setArgus(PreparedStatement pst, Object[] args) throws SQLException {
        if (args.length != 0){
            for (int i = 0; i < args.length; i++) {
                pst.setObject(i+1 ,args[i]);
            }
        }
    }


}
