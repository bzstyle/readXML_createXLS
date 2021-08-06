package com.factor_it.challenge.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "person")
public class EmpresaDto {

    private String nroContrato;
    private String cuit;
    private String denominacion;
    private String domicilio;
    private String codigoPostal;
    private String fechaDesdeNov;
    private String fechaHastaNov;
    private String organizador;
    private String productor;
    private String ciiu;

    public EmpresaDto() {
    }

    public EmpresaDto(String nroContrato, String cuit, String denominacion,
                      String domicilio, String codigoPostal, String fechaDesdeNov,
                      String fechaHastaNov, String organizador, String productor, String ciiu) {
        this.nroContrato = nroContrato;
        this.cuit = cuit;
        this.denominacion = denominacion;
        this.domicilio = domicilio;
        this.codigoPostal = codigoPostal;
        this.fechaDesdeNov = fechaDesdeNov;
        this.fechaHastaNov = fechaHastaNov;
        this.organizador = organizador;
        this.productor = productor;
        this.ciiu = ciiu;
    }

    public String getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(String nroContrato) {
        this.nroContrato = nroContrato;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getFechaDesdeNov() {
        return fechaDesdeNov;
    }

    public void setFechaDesdeNov(String fechaDesdeNov) {
        this.fechaDesdeNov = fechaDesdeNov;
    }

    public String getFechaHastaNov() {
        return fechaHastaNov;
    }

    public void setFechaHastaNov(String fechaHastaNov) {
        this.fechaHastaNov = fechaHastaNov;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getCiiu() {
        return ciiu;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }
}
