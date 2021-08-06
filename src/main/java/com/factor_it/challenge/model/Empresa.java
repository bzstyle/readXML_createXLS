package com.factor_it.challenge.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Movimiento> movimientos = new ArrayList<>();



}
