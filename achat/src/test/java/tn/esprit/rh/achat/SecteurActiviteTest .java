package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

public class SecteurActiviteTest {

    @InjectMocks
    private ISecteurActiviteService secteurActiviteService = new SecteurActiviteServiceImpl();

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllSecteurActivite() {
        // Créez une liste factice de secteurs d'activité pour simuler la réponse du repository.
        List<SecteurActivite> secteurActiviteList = new ArrayList<>();
        secteurActiviteList.add(new SecteurActivite());
        secteurActiviteList.add(new SecteurActivite());

        when(secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);

        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite addedSecteurActivite = secteurActiviteService.addSecteurActivite(secteurActivite);

        assertNotNull(addedSecteurActivite);
    }

    @Test
    public void testDeleteSecteurActivite() {
        Long id = 1L;
        doNothing().when(secteurActiviteRepository).deleteById(id);

        secteurActiviteService.deleteSecteurActivite(id);

        verify(secteurActiviteRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.save(secteurActivite)).thenReturn(secteurActivite);

        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(secteurActivite);

        assertNotNull(updatedSecteurActivite);
    }

    @Test
    public void testRetrieveSecteurActivite() {
        Long id = 1L;
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteRepository.findById(id)).thenReturn(java.util.Optional.of(secteurActivite));

        SecteurActivite retrievedSecteurActivite = secteurActiviteService.retrieveSecteurActivite(id);

        assertNotNull(retrievedSecteurActivite);
    }
}