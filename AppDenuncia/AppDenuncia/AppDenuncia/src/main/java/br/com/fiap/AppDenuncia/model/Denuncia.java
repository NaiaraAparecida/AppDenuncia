package br.com.fiap.AppDenuncia.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
@SequenceGenerator(name="denuncia",sequenceName="sq_denuncia",allocationSize=1)
public class Denuncia {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="denuncia")
    private int id;

    @NotBlank(message = "Nome do titulo não pode ser em branco")
    @Size(max = 200)
    private String titulo;

    private boolean novo;

    @NotBlank(message = "Precisamos que explique o ocorrido, para registro, é obrigatório")
    private String descricao;


    private String anonima;

    @Past
    private Calendar registro;

    @NotBlank(message = "O enderenço não pode ser em branco")
    private String enderenco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnonima() {
        return anonima;
    }

    public void setAnonima(String anonima) {
        this.anonima = anonima;
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
}
