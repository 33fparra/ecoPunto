package com.pe.EcoPunto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "punto_material")
public class PuntoMaterial
{
    @Id
    private Long puntoReciclajeId;

    private String nombrePuntoReciclaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuarios usuario;

    @OneToMany(mappedBy = "puntoMaterial")
    private List<materiales_reciclables> materialesReciclables;
}
