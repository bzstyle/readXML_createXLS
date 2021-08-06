package com.factor_it.challenge.dto;

import com.factor_it.challenge.model.Empresa;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.ArrayList;
import java.util.List;


@JacksonXmlRootElement(localName = "empresas")
public class EmpresasDto {


    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Empresa> empresa = new ArrayList<>();

    public EmpresasDto(List<Empresa> empresa) {
        this.empresa = empresa;
    }

    public EmpresasDto() {
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }
}
