package br.com.fiap.AppDenuncia.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;


@Entity
@SequenceGenerator(name="usuario",sequenceName="sq_usuario",allocationSize=1)
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private int id;

    @NotBlank(message = "Nome do usuário não pode ser em branco")
    @Size(max = 50)
    private String usuario;

    private boolean novo;

    @NotBlank(message = "E-mail precisa conter @ (ex:nina@gmail.com")
    private String email;

    @NotNull
    private int senha;

    private String genero;

    @Past
    private Calendar nascimento;

    @NotBlank(message = "Nome do enderenço não pode ficar em branco")
    private String enderenco;

    @ManyToOne
    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }


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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(String enderenco) {
        this.enderenco = enderenco;
    }
}



