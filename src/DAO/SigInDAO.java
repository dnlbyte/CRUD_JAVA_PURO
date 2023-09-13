package DAO;

import DTO.CadastroDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SigInDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<CadastroDTO> lista = new ArrayList<>();
     
    public void sigInInsert(CadastroDTO objtCadDTO) {
        conn = new ConexaoDAO().conexaoDB();
   

        try {

            String sql = "INSERT INTO usuario (nome_usuario, senha_usuario) values (?,?)";

            pstm = conn.prepareStatement(sql);
            
            
            pstm.setString(1, objtCadDTO.getNome_sigIN());
            pstm.setString(2, objtCadDTO.getSenha_sigIN());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de inserção de usuário no banco de dados:" + erro);

        }
    }
    
    public void deleteAccount(CadastroDTO objDTO){
        conn = new ConexaoDAO().conexaoDB();
        
           try {

            String sql = "DELETE FROM usuario WHERE id_usuario = ?";

            pstm = conn.prepareStatement(sql);
            
            
            pstm.setInt(1, objDTO.getId_user());            

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar usuário no banco de dados:" + erro);

        }
    }

    
     
    public void editAccount(CadastroDTO objDTO, String nome, String senha){
        conn = new ConexaoDAO().conexaoDB();
        
           try {

            String sql = "UPDATE usuario SET nome_usuario = ?, senha_usuario = ? WHERE  id_usuario = ?";

            pstm = conn.prepareStatement(sql);
            
            
            pstm.setString(1, nome);
            pstm.setString(2, senha);            
            pstm.setInt(3, objDTO.getId_user());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao  usuário usuário no banco de dados:" + erro);

        }
    }
    
    public ResultSet sigInAutentification(CadastroDTO objtCadDTO) {
        conn = new ConexaoDAO().conexaoDB();

        try {
            String sql = "select * from usuario where nome_usuario = ? ";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objtCadDTO.getNome_sigIN());
           ;

            rs = pstm.executeQuery();
                
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de autentificação 0:" + e);
            return null;
        }

    }
    
    public boolean isAdmin(CadastroDTO objCadastroDTO){
        
        boolean result = false;
       
        conn = new ConexaoDAO().conexaoDB();

        try {
            String sql = "select * from usuario where nome_usuario = ? ";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objCadastroDTO.getNome_sigIN());
           

            rs = pstm.executeQuery();
          if (rs.next()) {      
            if(rs.getString("nome_usuario").equals("admin")){
                result = true;
            }
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de autentificação 1:" + e);
            
        }
        return result;
    }

    public ArrayList<CadastroDTO> pesquisarFuncionario(){
        conn = new ConexaoDAO().conexaoDB();
        
        String sql = " select * from usuario";

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                CadastroDTO objDTO = new CadastroDTO();
                
                objDTO.setId_user(rs.getInt("id_usuario"));
                objDTO.setNome_sigIN(rs.getString("nome_usuario"));
                objDTO.setSenha_sigIN(rs.getString("senha_usuario"));
                
                lista.add(objDTO);
            }   
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionario pesquisar:" + e);
        }
        return lista;
    }

}
