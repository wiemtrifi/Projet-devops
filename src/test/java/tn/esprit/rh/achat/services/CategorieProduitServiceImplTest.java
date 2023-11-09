package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategorieProduitServiceImplTest {

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitService;

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void retrieveAllCategorieProduits() {

        // Create some dummy data
        CategorieProduit categorie1 = new CategorieProduit();
        categorie1.setIdCategorieProduit(1L);
        categorie1.setLibelleCategorie("Category 1");

        CategorieProduit categorie2 = new CategorieProduit();
        categorie2.setIdCategorieProduit(2L);
        categorie2.setLibelleCategorie("Category 2");

        List<CategorieProduit> categorieList = Arrays.asList(categorie1, categorie2);

        // Mock the behavior of categorieProduitRepository.findAll() to return the dummy data
        when(categorieProduitRepository.findAll()).thenReturn(categorieList);

        // Call the method under test
        List<CategorieProduit> retrievedCategories = categorieProduitService.retrieveAllCategorieProduits();

        // Verify the result
        assertEquals(2, retrievedCategories.size());
        assertEquals(categorie1, retrievedCategories.get(0));
        assertEquals(categorie2, retrievedCategories.get(1));
        System.out.println("Unit test for retrieveAllOperateurs method passed." + retrievedCategories.size());

    }

    @Test
    void addCategorieProduit() {
        // Create a sample CategorieProduit
        CategorieProduit cp = new CategorieProduit();
        cp.setIdCategorieProduit(1L);
        cp.setLibelleCategorie("Category 1");

        // Mock the behavior of categorieProduitRepository.save() to return the same object
        when(categorieProduitRepository.save(cp)).thenReturn(cp);

        // Call the method under test
        CategorieProduit savedCategorie = categorieProduitService.addCategorieProduit(cp);

        // Verify that the repository's save method was called with the same object
        verify(categorieProduitRepository).save(cp);

        // Verify that the returned object is the same as the input object
        assertEquals(cp, savedCategorie);
        System.out.println("Input CategorieProduit: " + cp.getIdCategorieProduit());
        System.out.println("The CategorieProduit added is: " + savedCategorie.getIdCategorieProduit());
    }

    @Test
    void deleteCategorieProduit() {
        // Create a sample ID
        Long idToDelete = 1L;

        // Mock the behavior of categorieProduitRepository.deleteById() to do nothing (void method)
        doNothing().when(categorieProduitRepository).deleteById(idToDelete);

        // Call the method under test
        categorieProduitService.deleteCategorieProduit(idToDelete);

        // Verify that the repository's deleteById method was called with the correct ID
        verify(categorieProduitRepository).deleteById(idToDelete);
    }

    @Test
    void testUpdateCategorieProduit() {
        // Créez un objet initial avec les données d'origine
        CategorieProduit initialCategorie = new CategorieProduit();
        initialCategorie.setIdCategorieProduit(1L);
        initialCategorie.setLibelleCategorie("Category 1");

        // Mockez la méthode de mise à jour pour qu'elle renvoie l'objet initial avec les données mises à jour
        when(categorieProduitService.updateCategorieProduit(initialCategorie)).thenReturn(initialCategorie);

        // Appelez la méthode de mise à jour avec l'objet initial
        CategorieProduit updatedCategorie = categorieProduitService.updateCategorieProduit(initialCategorie);

        // Modifiez l'objet initial avec les nouvelles données que vous attendez après la mise à jour
        initialCategorie.setLibelleCategorie("Updated Category 1");

        // Vérifiez que l'objet retourné par la méthode de mise à jour correspond à l'objet initial avec les données mises à jour
        assertEquals(initialCategorie, updatedCategorie);

        // Affichez un message dans la console pour indiquer que la mise à jour a réussi
        System.out.println("Unit test for updateCategorieProduit method passed.");
        System.out.println("Updated CategorieProduit: " + initialCategorie.getLibelleCategorie());
    }


    @Test
    void retrieveCategorieProduit() {
        // Create a sample CategorieProduit with a known ID
        Long knownId = 1L;
        CategorieProduit sampleCategorie = new CategorieProduit();
        sampleCategorie.setIdCategorieProduit(knownId);
        sampleCategorie.setLibelleCategorie("Sample Category");

        // Mock the behavior of categorieProduitRepository.findById(id) to return the sample object
        when(categorieProduitRepository.findById(knownId)).thenReturn(java.util.Optional.of(sampleCategorie));

        // Call the retrieveCategorieProduit method with the known ID
        CategorieProduit retrievedCategorie = categorieProduitService.retrieveCategorieProduit(knownId);

        // Verify that the returned CategorieProduit object is the same as the sample object
        assertEquals(sampleCategorie, retrievedCategorie);

        // Test the case when the repository returns null (e.g., when the ID is not found)
        when(categorieProduitRepository.findById(2L)).thenReturn(java.util.Optional.empty());
        CategorieProduit notFoundCategorie = categorieProduitService.retrieveCategorieProduit(2L);

        // Verify that the method returns null when the repository returns null
        assertNull(notFoundCategorie);
        // Print messages to the terminal to indicate the progress and results of the test
        System.out.println("Test for retrieveCategorieProduit method passed.");
        System.out.println("Sample Categorie: " + sampleCategorie.getIdCategorieProduit() + " Retrieved Categorie: " + retrievedCategorie.getIdCategorieProduit());
        System.out.println("Not Found Categorie: " + notFoundCategorie);
    }
}