package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl; // Replace with your actual service implementation

public class IOperateurServiceTest {

    @InjectMocks
    private OperateurServiceImpl operateurService; // Replace with your actual service implementation
    @Mock
    private OperateurRepository operateurRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        // Define a list of Operateurs for the mock
        List<Operateur> operateurs = new ArrayList<>();
        Operateur operateur1 = new Operateur(1L, "John", "Doe", "password1", Collections.EMPTY_SET);
        Operateur operateur2 = new Operateur(2L, "Jane", "Smith", "password2",Collections.EMPTY_SET);
        operateurs.add(operateur1);
        operateurs.add(operateur2);

        // Define the behavior of the mock repository
        when(operateurRepository.findAll()).thenReturn(operateurs);

        // Perform the test
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Verify that the repository method was called and the result matches the expected list
        verify(operateurRepository, times(1)).findAll();
        assertEquals(operateurs, result);
    }

    @Test
    public void testAddOperateur() {
        // Create a sample Operateur
        Operateur operateur = new Operateur(1L, "John", "Doe", "password1",Collections.EMPTY_SET);

        // Define the behavior of the mock repository
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        // Perform the test
        Operateur result = operateurService.addOperateur(operateur);

        // Verify that the repository method was called and the result matches the expected Operateur
        verify(operateurRepository, times(1)).save(operateur);
        assertEquals(operateur, result);
    }

    @Test
    public void testDeleteOperateur() {
        // Define an Operateur ID to be deleted
        Long operateurId = 1L;

        // Perform the test
        operateurService.deleteOperateur(operateurId);

        // Verify that the repository method was called to delete the Operateur
        verify(operateurRepository, times(1)).deleteById(operateurId);
    }

    @Test
    public void testUpdateOperateur() {
        // Create a sample Operateur
        Operateur operateur = new Operateur(1L, "John", "Doe", "password1",Collections.EMPTY_SET);

        // Define the behavior of the mock repository
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        // Perform the test
        Operateur result = operateurService.updateOperateur(operateur);

        // Verify that the repository method was called and the result matches the expected Operateur
        verify(operateurRepository, times(1)).save(operateur);
        assertEquals(operateur, result);
    }

    @Test
    public void testRetrieveOperateur() {
        // Define an Operateur ID to be retrieved
        Long operateurId = 1L;

        // Create a sample Operateur
        Operateur operateur = new Operateur(operateurId, "John", "Doe", "password1",Collections.EMPTY_SET);
        Optional<Operateur> optionalOperateur = Optional.of(operateur);

        // Define the behavior of the mock repository
        when(operateurRepository.findById(operateurId)).thenReturn(optionalOperateur);

        // Perform the test
        Operateur result = operateurService.retrieveOperateur(operateurId);

        // Verify that the repository method was called and the result matches the expected Operateur
        verify(operateurRepository, times(1)).findById(operateurId);
        assertEquals(operateur, result);
    }

    // Additional tests for edge cases and error handling can be added here
}