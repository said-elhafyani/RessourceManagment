package com.ressourcemanagement.model;

import com.ressourcemanagement.enumeration.RessourceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
public abstract class RessourceMaterielle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int barCode;
    private RessourceStatus status;
    @ManyToOne
    @JoinColumn(name = "enseigant_id", nullable = false)
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;
    @OneToMany(mappedBy = "ressources")
    private List<Soumission> soumissions;
    @OneToMany(mappedBy = "ressources")
    private List<Panne> pannes;
    @ManyToOne
    @JoinColumn(name = "appel_offre_id", nullable = true)
    private AppelOffre appelOffre;

}