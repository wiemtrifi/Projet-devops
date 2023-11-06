package tn.esprit.rh.achat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
import tn.esprit.rh.achat.services.IProduitService;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class testOperateur {

        @InjectMocks
        OperateurServiceImpl os;
    @InjectMocks
    @Mock
        OperateurRepository or;
        Set<Facture> f=new HashSet<>();
        Operateur p = new Operateur(123L,"achref","karoui","123",f);
        List<Operateur> listp=new ArrayList<Operateur>(){
            {
            add(new Operateur(124L,"achref","karoui","123",f));
            add(new Operateur(125L,"achref","karoui","123",f));
        }};@Test
    public void testRetrieveOperator() {
        Mockito.when(or.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Operateur o=os.retrieveOperateur(2L);
        Assertions.assertNotNull(o);
    }
}
