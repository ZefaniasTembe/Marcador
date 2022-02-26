package com.onesystem.marcador.model;

import java.util.Date;

public class Missao {
    private long id;
    private String contacto;
    private String localizacao;
    private String tipoProtecao;
    private Date day;

    public Missao(String contacto, String localizacao, String tipoProtecao, Date day) {
        this.contacto = contacto;
        this.localizacao = localizacao;
        this.tipoProtecao = tipoProtecao;
        this.day = day;
    }

    public Missao() {
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoProtecao() {
        return tipoProtecao;
    }

    public void setTipoProtecao(String tipoProtecao) {
        this.tipoProtecao = tipoProtecao;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
