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
public final class Paciente extends Pessoa{
    private String cpf_Paciente;
    private Sexo sexo;
    private PlanodeSaude planodeSaude;

    public Paciente(){
        this.planodeSaude = new PlanodeSaude();
        this.sexo = new Sexo();


}
    /**
     * @return the cpf_Paciente
     */
    public String getCpf_Paciente() {
        return cpf_Paciente;
    }

    /**
     * @param cpf_Paciente the cpf_Paciente to set
     */
    public void setCpf_Paciente(String cpf_Paciente) {
        this.cpf_Paciente = cpf_Paciente;
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

    /**
     * @return the planodeSaude
     */
    public PlanodeSaude getPlanodeSaude() {
        return planodeSaude;
    }

    /**
     * @param planodeSaude the planodeSaude to set
     */
    public void setPlanodeSaude(PlanodeSaude planodeSaude) {
        this.planodeSaude = planodeSaude;
    }
}

