package com.onesystem.marcador.model;

import java.util.Date;

public class UserDismiss {
    private String motivo;
    private Date day;
    private int totalDiasDispensa;

    public UserDismiss(String motivo, Date date, int totalDiasDispensa) {
        this.motivo = motivo;
        this.day = date;
        this.totalDiasDispensa = totalDiasDispensa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDate() {
        return day;
    }

    public void setDate(Date date) {
        day = date;
    }

    public int getTotalDiasDispensa() {
        return totalDiasDispensa;
    }

    public void setTotalDiasDispensa(int totalDiasDispensa) {
        this.totalDiasDispensa = totalDiasDispensa;
    }
}
