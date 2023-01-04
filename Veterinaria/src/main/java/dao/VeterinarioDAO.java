package dao;
import model.Veterinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO extends BaseDAO{

    public static List<Veterinario> selectVeterinarios() {
        final String sql = "SELECT * FROM Veterinario ORDER BY nom_vet";
        try
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();
                )
        {
            List<Veterinario> veterinarios = new ArrayList<>();
            while (rs.next()) {
                veterinarios.add(resultsetToVeterinario(rs));
            }
            return veterinarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Veterinario> selectVeterinariosByName(String nom_vet) {
        final String sql = "SELECT * FROM Veterinario WHERE nom_vet LIKE ? ORDER BY nom_vet";
        try
                (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, nom_vet.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Veterinario> veterinarios = new ArrayList<>();
            while (rs.next()) {
                veterinarios.add(resultsetToVeterinario(rs));
            }
            return veterinarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Veterinario selectVeterinarioById(Long id_vet) {
        final String sql = "SELECT * FROM Veterinario WHERE id_vet=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setLong(1, id_vet);
            ResultSet rs = pstmt.executeQuery();
            Veterinario veterinario = null;
            if (rs.next()) {
                veterinario = resultsetToVeterinario(rs);
            }
            rs.close();
            return veterinario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertVeterinario(Veterinario veterinario) {
        final String sql = "INSERT INTO Veterinario (nom_vet, end_vet, tel_vet) VALUES (?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            pstmt.setString(1, veterinario.getNom_vet());
            pstmt.setString(2, veterinario.getEnd_vet());
            pstmt.setString(3, veterinario.getTel_vet());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateVeterinario(Veterinario veterinario) {
        final String sql = "UPDATE Veterinario SET nom_vet=?, end_vet=?, tel_vet=? WHERE id_vet=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            pstmt.setString(1, veterinario.getNom_vet());
            pstmt.setString(2, veterinario.getEnd_vet());
            pstmt.setString(3, veterinario.getTel_vet());
            pstmt.setLong(4, veterinario.getId_vet());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteVeterinario(long id) {
        final String sql = "DELETE FROM Veterinario WHERE id_vet=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private static Veterinario resultsetToVeterinario(ResultSet rs) throws SQLException {
        Veterinario c = new Veterinario();
        c.setId_vet(rs.getLong("id_vet"));
        c.setNom_vet(rs.getString("nom_vet"));
        c.setEnd_vet(rs.getString("end_vet"));
        c.setTel_vet(rs.getString("tel_vet"));

        return c;
    }

    public static void main(String[] args) {
        System.out.println("\nLista de Veterinarios");
        System.out.println(VeterinarioDAO.selectVeterinarios());

        System.out.println("\nVeterinario pelo id");
        System.out.println(VeterinarioDAO.selectVeterinarioById(2L));

        System.out.println("\nCriando um Veterinario");
        Veterinario veterinario = new Veterinario(6L,"Claudia", "Epitacio Pessoa", "991951047", null);
        System.out.println(VeterinarioDAO.insertVeterinario(veterinario));
        System.out.println("\nVeterinario INSERIDO na base de dados: " + VeterinarioDAO.selectVeterinarioById(6L));

        System.out.println("\nCriando um Veterinario");
        Veterinario veterinario2 = new Veterinario(7L,"Marcio", "Saturnino Arruda", "991590174", null);
        System.out.println(VeterinarioDAO.insertVeterinario(veterinario2));
        System.out.println("\nVeterinario INSERIDO na base de dados: " + VeterinarioDAO.selectVeterinarioById(7L));

        System.out.println("\nAlterando um veterinario (o criado recentemente)");
        veterinario = selectVeterinarioById(7L);
        veterinario.setNom_vet("Ana Claudia");
        veterinario.setEnd_vet("Epitacio Pessoa, 456");
        System.out.println(VeterinarioDAO.updateVeterinario(veterinario));
        System.out.println("\nVeterinario ALTERADO na base de dados: " + VeterinarioDAO.selectVeterinarioById(7L));

        System.out.println("\nDeletando um Veterinario");
        System.out.println(deleteVeterinario(4));
        System.out.println("\nVeterinario EXCLUÍDO na base de dados: " + VeterinarioDAO.selectVeterinarioById(4L));
    }

}
