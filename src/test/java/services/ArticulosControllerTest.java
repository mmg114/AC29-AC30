package services;

import com.alkosto.tienda_online.controller.ArticulosController;
import com.alkosto.tienda_online.domain.Articulo;
import com.alkosto.tienda_online.services.IArticuloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticulosControllerTest {

    @Mock
    private IArticuloService articuloService;

    @InjectMocks
    private ArticulosController articulosController;

    @Test
    void getAll_ShouldReturnListOfArticulos() {
        // Arrange
        List<Articulo> articulos = Arrays.asList(new Articulo(), new Articulo());
        when(articuloService.findByAll()).thenReturn(articulos);

        // Act
        ResponseEntity<List<Articulo>> response = articulosController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(articulos, response.getBody());
        verify(articuloService).findByAll();
    }

    @Test
    void getArticuloById_WhenExists_ShouldReturnArticulo() {
        // Arrange
        Long id = 1L;
        Articulo articulo = new Articulo();
        articulo.setId(id);
        when(articuloService.findById(id)).thenReturn(articulo);

        // Act
        ResponseEntity<Articulo> response = articulosController.getArticuloById(id);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(articulo, response.getBody());
        verify(articuloService).findById(id);
    }

    @Test
    void getArticuloById_WhenNotExists_ShouldReturnAcceptedWithNull() {
        // Arrange
        Long id = 1L;
        when(articuloService.findById(id)).thenReturn(null);

        // Act
        ResponseEntity<Articulo> response = articulosController.getArticuloById(id);

        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertNull(response.getBody());
        verify(articuloService).findById(id);
    }

    @Test
    void modifyArticulo_ShouldReturnUpdatedArticulo() {
        // Arrange
        Articulo articulo = new Articulo();
        when(articuloService.update(articulo)).thenReturn(articulo);

        // Act
        ResponseEntity<Articulo> response = articulosController.modifyArticulo(articulo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(articulo, response.getBody());
        verify(articuloService).update(articulo);
    }

    @Test
    void saveArticulo_ShouldReturnCreatedArticulo() {
        // Arrange
        Articulo articulo = new Articulo();
        when(articuloService.save(articulo)).thenReturn(articulo);

        // Act
        ResponseEntity<Articulo> response = articulosController.saveArticulo(articulo);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(articulo, response.getBody());
        verify(articuloService).save(articulo);
    }

    @Test
    void deleteArticulo_ShouldCallServiceDeleteAndReturnNoContent() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<Void> response = articulosController.deleteArticulo(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        ArgumentCaptor<Articulo> captor = ArgumentCaptor.forClass(Articulo.class);
        verify(articuloService).deleteById(captor.capture());
        Articulo capturedArticulo = captor.getValue();
        assertEquals(id, capturedArticulo.getId());
    }
}