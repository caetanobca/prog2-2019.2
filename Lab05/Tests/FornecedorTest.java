import SAGA.Fornecedor.Fornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    Fornecedor fornecedor1;

    @BeforeEach
    void setUp() {
        this.fornecedor1 = new Fornecedor("Dona Ines", "dona.ines@cantina.ufcg.br", "83 99876-5432" );
    }

    @Test
    void setEmail() {
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 99876-5432", fornecedor1.toString());
        this.fornecedor1.setEmail("ines.dona@cantina.ufcg.br");
        assertEquals("Dona Ines - ines.dona@cantina.ufcg.br - 83 99876-5432", fornecedor1.toString());
    }

    @Test
    void setEmailNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.setEmail(null);
        });
    }

    @Test
    void setEmailVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.setEmail("");
        });
    }

    @Test
    void setTelefone() {
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 99876-5432", fornecedor1.toString());
        this.fornecedor1.setTelefone("83 98805-3354");
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 98805-3354", fornecedor1.toString());
    }

    @Test
    void setTelefoneNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.setTelefone(null);
        });
    }

    @Test
    void setTelefoneVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.setTelefone("");
        });
    }

    @Test
    void toString1() {
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 99876-5432", fornecedor1.toString());
    }

    @Test
    void cadastraProduto() {
        assertEquals("Nenhum produto cadastrado pelo fornecedor: Dona Ines", this.fornecedor1.listarProdutos());
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Tapioca - tapioca com queijo - R$2,75", this.fornecedor1.listarProdutos());
    }

    @Test
    void cadastraProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.cadastraProduto(null, "Bala de mente", 0.15);
        });
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.cadastraProduto("Bala", null, 0.15);
        });
    }

    @Test
    void cadastraProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.cadastraProduto("", "Bala de menta", 0.15);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.cadastraProduto("Bala", "", 0.15);
        });
    }

    @Test
    void exibeProduto() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        this.fornecedor1.cadastraProduto("Tapioca G", "tapioca com queijo", 5.00);

        assertEquals("Tapioca - tapioca com queijo - R$2,75",
                this.fornecedor1.exibeProduto("Tapioca", "tapioca com queijo"));
        assertEquals("Tapioca G - tapioca com queijo - R$5,00",
                this.fornecedor1.exibeProduto("Tapioca G", "tapioca com queijo"));
    }

    @Test
    void exibeProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.cadastraProduto(null, null, 0.15);
        });
    }

    @Test
    void exibeProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.cadastraProduto("Bala", "", 0.15);
        });
    }

    @Test
    void listarProdutos() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Tapioca - tapioca com queijo - R$2,75", this.fornecedor1.listarProdutos());

        this.fornecedor1.cadastraProduto("Bala", "bala de menta", 0.15);

        assertEquals("Tapioca - tapioca com queijo - R$2,75" +
                " | Bala - bala de menta - R$0,15", this.fornecedor1.listarProdutos());

    }

    @Test
    void listarProdutosComNome() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Dona Ines - Tapioca - tapioca com queijo - R$2,75", this.fornecedor1.listarProdutosComNome());

        this.fornecedor1.cadastraProduto("Bala", "bala de menta", 0.15);

        assertEquals("Dona Ines - Tapioca - tapioca com queijo - R$2,75" +
                " | Dona Ines - Bala - bala de menta - R$0,15", this.fornecedor1.listarProdutosComNome());

    }

    @Test
    void editarProduto() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Tapioca - tapioca com queijo - R$2,75",
                this.fornecedor1.exibeProduto("Tapioca", "tapioca com queijo"));

        this.fornecedor1.editarProduto("Tapioca", "tapioca com queijo", 3.00);
        assertEquals("Tapioca - tapioca com queijo - R$3,00",
                this.fornecedor1.exibeProduto("Tapioca", "tapioca com queijo"));
    }

    @Test
    void editarProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.editarProduto(null, "Bala de menta", 0.2);
        });
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.editarProduto("Bala", null, 0.2);
        });
    }

    @Test
    void editarProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.editarProduto("", "Bala de menta", 0.15);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.editarProduto("Bala", "", 0.15);
        });
    }

    @Test
    void removeProduto() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        this.fornecedor1.cadastraProduto("Bala", "bala de menta", 0.10);
        assertEquals("Tapioca - tapioca com queijo - R$2,75" +
                " | Bala - bala de menta - R$0,10", this.fornecedor1.listarProdutos());

        this.fornecedor1.removeProduto("Bala", "bala de menta");
        assertEquals("Tapioca - tapioca com queijo - R$2,75", this.fornecedor1.listarProdutos());
    }

    @Test
    void removeProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.removeProduto(null, "Bala de menta");
        });
        assertThrows(NullPointerException.class, () -> {
            this.fornecedor1.removeProduto("Bala", null);
        });
    }

    @Test
    void removeProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.cadastraProduto("", "Bala de menta", 0.15);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.fornecedor1.cadastraProduto("Bala", "", 0.15);
        });
    }

    @Test
    void equals1() {
        assertFalse(this.fornecedor1.equals(new Fornecedor("Dona Inalda", "inaldinha@gmail.com", "83 99574-2021")));
        assertFalse(this.fornecedor1.equals(new Fornecedor("Dona Inesvalda", "dona.ines@cantina.ufcg.br", "83 99415-6421")));
        assertTrue(this.fornecedor1.equals(new Fornecedor("Dona Ines", "ines@gmail.com", "83 98814-2034")));
    }


}