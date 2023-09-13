
package DTO;

public class CadastroDTO {
    private String senha_sigIN, nome_sigIN;
    private int id_user;

    /**
     * @return the endereco_sigIN
     */
    public String getSenha_sigIN() {
        return senha_sigIN;
    }

    /**
     * @param endereco_sigIN the endereco_sigIN to set
     */
    public void setSenha_sigIN(String endereco_sigIN) {
        this.senha_sigIN = endereco_sigIN;
    }

    /**
     * @return the nome_sigIN
     */
    public String getNome_sigIN() {
        return nome_sigIN;
    }

    /**
     * @param nome_sigIN the nome_sigIN to set
     */
    public void setNome_sigIN(String nome_sigIN) {
        this.nome_sigIN = nome_sigIN;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
