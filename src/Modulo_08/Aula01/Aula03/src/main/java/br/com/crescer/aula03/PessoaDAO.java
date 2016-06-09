package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PessoaDAO implements IPessoa {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    private final String insert = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
            + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";

    private final String update = "UPDATE PESSOA "
            + "SET NM_PESSOA = ? "
            + "WHERE ID_PESSOA = ?";

    private final String delete = "DELETE FROM PESSOA "
            + "WHERE ID_PESSOA = ?";

    private final String selectAll = "SELECT * FROM PESSOA";

    private final String selectByName = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";

    @Override
    public void insert(Pessoa pessoa) {
        try (Connection conexao = ConnectionUtils.getConnection()) {
            final PreparedStatement preStatement = conexao.prepareStatement(insert);
            preStatement.setString(1, pessoa.getNome());
            preStatement.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        try (Connection conexao = ConnectionUtils.getConnection()) {
            final PreparedStatement preStatement = conexao.prepareStatement(update);
            preStatement.setString(1, pessoa.getNome());
            preStatement.setLong(2, pessoa.getId());
            preStatement.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        try (Connection conexao = ConnectionUtils.getConnection()) {
            final PreparedStatement preStatement = conexao.prepareStatement(delete);
            preStatement.setLong(1, pessoa.getId());
            preStatement.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> resultado = new ArrayList<>();
        try (final Connection conexao = ConnectionUtils.getConnection()) {
            try (final Statement statement = conexao.createStatement()) {
                try (final ResultSet rs = statement.executeQuery(selectAll)) {
                    while (rs.next()) {
                        resultado.add(new Pessoa(rs.getLong("ID_PESSOA"), rs.getString("NM_PESSOA")));
                    }
                } catch (final SQLException ex) {
                    LOGGER.severe(ex.getMessage());
                }
            } catch (final SQLException ex) {
                LOGGER.severe(ex.getMessage());
            }
        } catch (final SQLException ex) {
            LOGGER.severe(ex.getMessage());
        }
        return resultado;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        List<Pessoa> resultado = new ArrayList<>();
        try (final Connection conexao = ConnectionUtils.getConnection()) {
            final PreparedStatement preStatement = conexao.prepareStatement(selectByName);
            preStatement.setString(1, "%" + nome + "%");            
            try (final ResultSet rs = preStatement.executeQuery()) {
                while (rs.next()) {
                    resultado.add(new Pessoa(rs.getLong("ID_PESSOA"), rs.getString("NM_PESSOA")));
                }
            } catch (final SQLException ex) {
                LOGGER.severe(ex.getMessage());
            }
        } catch (final SQLException ex) {
            LOGGER.severe(ex.getMessage());
        }
        return resultado;
    }

}
