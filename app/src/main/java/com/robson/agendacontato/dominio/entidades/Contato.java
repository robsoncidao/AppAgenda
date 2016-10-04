package com.robson.agendacontato.dominio.entidades;

import java.util.Date;

/**
 * Created by CIDAO on 06/09/2016.
 */
public class Contato {

     long   id;
     String nome;
     String telefone;
     String tipoTelefone;
     String email;
     String tipoEmail;
     String endereco;
     String tipoEndereco;
     Date   datasEspeciais;
     String tipoDatasEspeciais;
     String grupos;

    public Contato() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Date getDatasEspeciais() {
        return datasEspeciais;
    }

    public void setDatasEspeciais(Date dataEspeciais) {
        this.datasEspeciais = dataEspeciais;
    }

    public String getTipoDatasEspeciais() {
        return tipoDatasEspeciais;
    }

    public void setTipoDatasEspeciais(String tipoDatasEspeciais) {
        this.tipoDatasEspeciais = tipoDatasEspeciais;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }


}
