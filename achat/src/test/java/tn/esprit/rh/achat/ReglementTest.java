package tn.esprit.rh.achat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.IReglementService;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReglementTest {


    @InjectMocks
    private IReglementService ReglementService = new ReglementServiceImpl();

    @Mock
    private ReglementRepository ReglementRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllReglements() {
        // Créez une liste factice de secteurs d'activité pour simuler la réponse du repository.
        List<Reglement> ReglementList = new ArrayList<>();
        ReglementList.add(new Reglement());
        ReglementList.add(new Reglement());

        when(ReglementRepository.findAll()).thenReturn(ReglementList);

        List<Reglement> result = ReglementService.retrieveAllReglements();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddReglement() {
        Reglement Reglement = new Reglement();
        when(ReglementRepository.save(Reglement)).thenReturn(Reglement);

        Reglement addedReglement = ReglementService.addReglement(Reglement);

        assertNotNull(addedReglement);
    }



    @Test
    public void testRetrieveReglement() {
        Long id = 1L;
        Reglement Reglement = new Reglement();
        when(ReglementRepository.findById(id)).thenReturn(java.util.Optional.of(Reglement));

        Reglement retrievedReglement = ReglementService.retrieveReglement(id);

        assertNotNull(retrievedReglement);
    }
}
