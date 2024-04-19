package com.ressourcemanagement.service;

import com.ressourcemanagement.model.AppelOffre;
import com.ressourcemanagement.model.Fournisseur;
import com.ressourcemanagement.repository.AppleOffreRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ressourcemanagement.repository.FournisseurRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    private AppleOffreRepository appleOffreRepository;
    public boolean existFournisseur(String username) {
        return fournisseurRepository.existsFournisseurByEmail(username);
    }
    public Fournisseur getFournissuerByEmail(String username) {
        return fournisseurRepository.getFournisseurByEmail(username);
    }


    public List<AppelOffre> getAllAppleOffre(){
        return appleOffreRepository.findAll();
    }

}