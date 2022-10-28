package br.com.fiap.AppDenuncia.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Calendar;

@Entity
@SequenceGenerator(name="elogio_geral",sequenceName="sq_elogio_geral",allocationSize=1)
public class ElogioGeral {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="elogio_geral")
    private int id;

    @NotBlank(message = "A descriçao é obrigatória")
    private String descricao;

    private boolean novo;

    @Past
    private Calendar registro;

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getRegistro() {
        return registro;
    }

    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }
}
