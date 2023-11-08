package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplMock {
    @Mock
    FournisseurRepository fr ;
    Fournisseur fournisseur = new Fournisseur();
    @InjectMocks
            FournisseurServiceImpl fournisseurService ;
        List<Fournisseur> fournisseurList = new ArrayList<Fournisseur>();
        @Test
        public void testRetreiveFournisseur() {
        Mockito.when(fr.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur ft = fournisseurService.retrieveFournisseur(fournisseur.getIdFournisseur());
        Assertions.assertNotNull(ft);
    }
    @Test
    public void testRetreiveFournisseurs(){
        Mockito.when(fr.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> fournisseursList = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotNull(fournisseursList);


    }
}
