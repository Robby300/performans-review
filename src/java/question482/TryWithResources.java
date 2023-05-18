package question482;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class TryWithResources {

    private static final String QUERY = "some query";
    private static final String URL = "some URL";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    void tryWithResources() {
//        try (Connection con = getSomeDataSource().getConnection();
//             CallableStatement cstm = con.prepareCall(QUERY)) {
//            ResultSet rs = cstm.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e.getMessage());
//        }
    }

    private DataSource getSomeDataSource() {
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSourceBuilder.url(URL);
//        dataSourceBuilder.username(USERNAME);
//        dataSourceBuilder.password(PASSWORD);
//        return dataSourceBuilder.build();
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
    }
}
