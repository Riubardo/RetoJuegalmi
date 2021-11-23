package com.example.tabbedtienda.ui.models.Llamadas;

public class LlamadaBusqueda {
    private String criterio;

    public LlamadaBusqueda(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
}
