package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Produit;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {
    @Autowired
    IFournisseurService ps;
    @Test
    @Order(1)
    public void testRetreiveAllUsers(){
        List<Fournisseur> listf=ps.retrieveAllFournisseurs();
        Assertions.assertEquals(0,listf.size());
    }

}
