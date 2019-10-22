import SAGA.Produto.ProdutoUnitario;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private ProdutoUnitario produto;

    @BeforeEach
    void setUp() {
        this.produto = new ProdutoUnitario("Tapioca", "Tapioca com queijo", 3.00);
    }

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals("Tapioca - Tapioca com queijo - R$3,00", this.produto.toString());
    }

    @org.junit.jupiter.api.Test
    void setPreco() {
        assertEquals("Tapioca - Tapioca com queijo - R$3,00", this.produto.toString());

        this.produto.editarProduto(2.75);

        assertEquals("Tapioca - Tapioca com queijo - R$2,75", this.produto.toString());
    }

    @org.junit.jupiter.api.Test
    void equals1() {
        assertFalse(this.produto.equals(new ProdutoUnitario("Tapioca", "Tapioca com coco", 3.00)));
        assertFalse(this.produto.equals(new ProdutoUnitario("Tapioca Grande", "Tapioca com queijo", 5.00)));
        assertTrue((this.produto.equals(new ProdutoUnitario("Tapioca", "Tapioca com queijo", 2.50))));
    }
}