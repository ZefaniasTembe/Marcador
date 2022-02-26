package com.onesystem.marcador.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PresenceInfo {
    private long id;
    private Date day;
    private String entrada;
    private String saida;
    private String atraso;
    private String horaExtra;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    public static final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

    public PresenceInfo() {

    }
    public PresenceInfo(Date day) {
        this.day = day;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }
    public String getFormattedDay() {
        return dateFormat.format(day);
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getAtraso() {
        return atraso;
    }

    public void setAtraso(String atraso) {
        this.atraso = atraso;
    }

    // TODO deve verificar a hora prevista para saida e calcular
    public String getHoraExtra() {
        return horaExtra;
    }

    // TODO deve verificar a hora prevista para saida e calcular
    public void setHoraExtra(String horaExtra) {
        this.horaExtra = horaExtra;
    }
}
