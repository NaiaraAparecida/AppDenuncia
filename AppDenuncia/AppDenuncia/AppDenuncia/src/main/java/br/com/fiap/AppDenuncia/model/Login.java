package br.com.fiap.AppDenuncia.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="login",sequenceName="sq_login",allocationSize=1)
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="login")
    private int id;

    @NotBlank(message = "Por favor inserir um e-mail válida")
    private String email;


    @NotBlank(message = "Por favor inserir uma senha válida")
    private int senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
