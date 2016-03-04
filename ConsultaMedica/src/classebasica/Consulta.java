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
public final class Consulta {
    private String numeroProntuario;
    private String descricaoConsulta;
    private String horaInicio;
    private String horaFinal;
    private String dataConsulta;
    private Medico medico;
    private Paciente paciente;
    private PlanodeSaude planodeSaude;
    private Especialidade especialidade;
    
     public Consulta(){
        this.medico = new Medico();
        this.paciente = new Paciente();
        this.planodeSaude = new PlanodeSaude();
        this.especialidade = new Especialidade();
        
    }

    /**
     * @return the numeroProntuario
     */
    public String getNumeroProntuario() {
        return numeroProntuario;
    }

    /**
     * @param numeroProntuario the numeroProntuario to set
     */
    public void setNumeroProntuario(String numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    /**
     * @return the descricaoConsulta
     */
    public String getDescricaoConsulta() {
        return descricaoConsulta;
    }

    /**
     * @param descricaoConsulta the descricaoConsulta to set
     */
    public void setDescricaoConsulta(String descricaoConsulta) {
        this.descricaoConsulta = descricaoConsulta;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFinal
     */
    public String getHoraFinal() {
        return horaFinal;
    }

    /**
     * @param horaFinal the horaFinal to set
     */
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * @return the dataConsulta
     */
    public String getDataConsulta() {
        return dataConsulta;
    }

    /**
     * @param dataConsulta the dataConsulta to set
     */
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
    
}
