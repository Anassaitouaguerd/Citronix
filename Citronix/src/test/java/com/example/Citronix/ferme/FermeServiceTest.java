package com.example.Citronix.ferme;

import com.example.Citronix.DTO.farme.FermeDTO;
import com.example.Citronix.DTO.farme.FermeReqDTO;
import com.example.Citronix.entity.Ferme;
import com.example.Citronix.mapper.FermeMapper;
import com.example.Citronix.repository.ferme.FermeRepository;
import com.example.Citronix.services.ferme.FermeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FermeServiceTest {

    @Mock
    private FermeRepository fermeRepository;

    @Mock
    private FermeMapper fermeMapper;

    @InjectMocks
    private FermeService fermeService;

    private FermeReqDTO fermeReqDTO;
    private Ferme ferme;
    private FermeDTO fermeDTO;

    @BeforeEach
    void setUp() {
        // Initialize test data
        fermeReqDTO = new FermeReqDTO();
        fermeReqDTO.setName("Test Farm");
        fermeReqDTO.setLocation("Test Location");
        fermeReqDTO.setArea(100.0);

        ferme = new Ferme();
        ferme.setId(1L);
        ferme.setName("Test Farm");
        ferme.setLocation("Test Location");
        ferme.setArea(100.0);
        ferme.setCreationDate(LocalDateTime.now());

        fermeDTO = new FermeDTO();
        fermeDTO.setId(1L);
        fermeDTO.setName("Test Farm");
        fermeDTO.setLocation("Test Location");
        fermeDTO.setArea(100.0);
    }

    @Test
    void createFerme_ShouldCreateAndReturnFermeDTO() {
        // Arrange
        when(fermeMapper.toEntity(any(FermeReqDTO.class))).thenReturn(ferme);
        when(fermeRepository.save(any(Ferme.class))).thenReturn(ferme);
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDTO);

        // Act
        FermeDTO result = fermeService.createFerme(fermeReqDTO);

        // Assert
        assertNotNull(result);
        assertEquals(fermeDTO.getId(), result.getId());
        assertEquals(fermeDTO.getName(), result.getName());
        assertEquals(fermeDTO.getLocation(), result.getLocation());
        assertEquals(fermeDTO.getArea(), result.getArea());

        // Verify interactions
        verify(fermeMapper).toEntity(fermeReqDTO);
        verify(fermeRepository).save(any(Ferme.class));
        verify(fermeMapper).toDTO(any(Ferme.class));
    }

    @Test
    void updateFerme_WhenFermeExists_ShouldUpdateAndReturnFermeDTO() {
        // Arrange
        Long id = 1L;
        when(fermeRepository.findById(id)).thenReturn(Optional.of(ferme));
        when(fermeMapper.toEntity(any(FermeReqDTO.class))).thenReturn(ferme);
        when(fermeRepository.save(any(Ferme.class))).thenReturn(ferme);
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDTO);

        // Act
        FermeDTO result = fermeService.updateFerme(id, fermeReqDTO);

        // Assert
        assertNotNull(result);
        assertEquals(fermeDTO.getId(), result.getId());
        verify(fermeRepository).findById(id);
        verify(fermeRepository).save(any(Ferme.class));
    }

    @Test
    void updateFerme_WhenFermeDoesNotExist_ShouldThrowException() {
        // Arrange
        Long id = 1L;
        when(fermeRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> fermeService.updateFerme(id, fermeReqDTO));
        verify(fermeRepository).findById(id);
        verify(fermeRepository, never()).save(any(Ferme.class));
    }

    @Test
    void getAllFermes_ShouldReturnListOfFermeDTOs() {
        // Arrange
        List<Ferme> fermes = Arrays.asList(ferme);
        when(fermeRepository.findAll()).thenReturn(fermes);
        when(fermeMapper.toDTO(any(Ferme.class))).thenReturn(fermeDTO);

        // Act
        List<FermeDTO> result = fermeService.getAllFermes();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(fermeRepository).findAll();
        verify(fermeMapper, times(1)).toDTO(any(Ferme.class));
    }

    @Test
    void deleteFerme_ShouldDeleteFerme() {
        // Arrange
        Long id = 1L;
        doNothing().when(fermeRepository).deleteById(id);

        // Act
        fermeService.deleteFerme(id);

        // Assert
        verify(fermeRepository).deleteById(id);
    }
}