package projectFiles.utils;

public class ConnectionSingleton {
    private static ConnectionPool connectionPool;

    private ConnectionSingleton() {
    }

    public static ConnectionPool getConnection() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
}
