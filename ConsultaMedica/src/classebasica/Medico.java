/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classebasica;

/**
 *
 * @author MegaKingBR
 */
public final class Medico extends Pessoa{
 private String crm_Medico; 
 private Sexo sexo;
 private Especialidade especialidade;
 
     public Medico(){
        this.especialidade = new Especialidade();
        this.sexo = new Sexo();

        
    }
  

    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the crm_Medico
     */
    public String getCrm_Medico() {
        return crm_Medico;
    }

    /**
     * @param crm_Medico the crm_Medico to set
     */
    public void setCrm_Medico(String crm_Medico) {
        this.crm_Medico = crm_Medico;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

}
