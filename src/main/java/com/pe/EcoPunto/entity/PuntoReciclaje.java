package com.pe.EcoPunto.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "punto_reciclaje")
public class PuntoReciclaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    private String horarioAtencion;

    private Double latitud;

    private Double longitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuarios usuario;

    @OneToMany(mappedBy = "puntoReciclaje")
    private List<materiales_reciclables> materialesReciclables;
}
