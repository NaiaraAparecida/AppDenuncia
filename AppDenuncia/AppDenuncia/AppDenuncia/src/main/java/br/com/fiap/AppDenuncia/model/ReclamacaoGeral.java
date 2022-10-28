package br.com.fiap.AppDenuncia.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Calendar;

@Entity
@SequenceGenerator(name="reclamacao_geral",sequenceName="sq_tb_reclamacao_geral",allocationSize=1)
public class ReclamacaoGeral {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="reclamacao_geral")
    private int id;

    private String tipo;

    @NotBlank(message = "A reclamação é obrigatória")
    private String reclamacao;

    private boolean novo;
    @Past
    private Calendar registro;

    @NotBlank(message = "O endereço é obrigatório")
    private String enderenco;

    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public Calendar getRegistro() {
        return registro;
    }

    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }

    public String getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(String enderenco) {
        this.enderenco = enderenco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }
}
