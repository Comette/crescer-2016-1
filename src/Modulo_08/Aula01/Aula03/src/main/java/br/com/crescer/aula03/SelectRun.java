package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

    public static void main(String[] args) {

        final String query = "SELECT * FROM PESSOA";

        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet rs = statement.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println(rs.getString("NM_PESSOA"));
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
