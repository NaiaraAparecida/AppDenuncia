package br.com.fiap.AppDenuncia.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Calendar;

@Entity
@SequenceGenerator(name="elogio_cidade",sequenceName="sq_elogio_cidade",allocationSize=1)
public class ElogioCidade {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="elogio_cidade")
    private int id;

    @NotBlank(message = "Nome da cidade é obrigatório")
    private String cidade;

    private boolean novo;
    @NotBlank(message = "É necessário inserir uma descrição")
    private String descricao;

    @Past
    private Calendar registro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }
}
