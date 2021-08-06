package com.factor_it.challenge.controller;

import com.factor_it.challenge.service.impl.EmpresasServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/api")
@Api(value = "Empresas Controller")
public class EmpresasController {

    @Autowired
    EmpresasServiceImpl empresasService;


    @GetMapping("/create")
    @ApiOperation("Lee y devuelve en formato Excel")
    public ResponseEntity<InputStreamResource> mostrar1() throws IOException ,Exception{

        ByteArrayInputStream stream = empresasService.ReadXmlEmpresas();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition" , "attachment; filename=empresas.xls");
        return ResponseEntity.ok().headers(httpHeaders).body(new InputStreamResource(stream));
    }

}
