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
    void setTelefone() {
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 99876-5432", fornecedor1.toString());
        this.fornecedor1.setTelefone("83 98805-3354");
        assertEquals("Dona Ines - dona.ines@cantina.ufcg.br - 83 98805-3354", fornecedor1.toString());
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
    void exibeProduto() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        this.fornecedor1.cadastraProduto("Tapioca G", "tapioca com queijo", 5.00);

        assertEquals("Tapioca - tapioca com queijo - R$2,75",
                this.fornecedor1.exibeProduto("Tapioca", "tapioca com queijo"));
        assertEquals("Tapioca G - tapioca com queijo - R$5,00",
                this.fornecedor1.exibeProduto("Tapioca G", "tapioca com queijo"));
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
    void removeProduto() {
        this.fornecedor1.cadastraProduto("Tapioca", "tapioca com queijo", 2.75);
        this.fornecedor1.cadastraProduto("Bala", "bala de menta", 0.10);
        assertEquals("Tapioca - tapioca com queijo - R$2,75" +
                " | Bala - bala de menta - R$0,10", this.fornecedor1.listarProdutos());

        this.fornecedor1.removeProduto("Bala", "bala de menta");
        assertEquals("Tapioca - tapioca com queijo - R$2,75", this.fornecedor1.listarProdutos());
    }

    @Test
    void equals1() {
        assertFalse(this.fornecedor1.equals(new Fornecedor("Dona Inalda", "inaldinha@gmail.com", "83 99574-2021")));
        assertFalse(this.fornecedor1.equals(new Fornecedor("Dona Inesvalda", "dona.ines@cantina.ufcg.br", "83 99415-6421")));
        assertTrue(this.fornecedor1.equals(new Fornecedor("Dona Ines", "ines@gmail.com", "83 98814-2034")));
    }


}