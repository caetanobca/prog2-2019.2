import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerFornecedorTest {

    private ControllerFornecedor controllerFornecedor;

    @BeforeEach
    void setUp() {
        this.controllerFornecedor = new ControllerFornecedor();
        this.controllerFornecedor.cadastraFornecedor("Dona Inalda", "inalda@gmail.com", "83 99988-7766");
        this.controllerFornecedor.cadastraFornecedor("Dona Ines", "dona.ines@gmail.com", "83 99965-4321");
    }

    @Test
    void cadastraFornecedor() {
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.listarFornecedores());

        this.controllerFornecedor.cadastraFornecedor("Dona Iraci", "donairaci@gmail.com", "83 98877-6655");

        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321" +
                        " | Dona Iraci - donairaci@gmail.com - 83 98877-6655",
                this.controllerFornecedor.listarFornecedores());
    }

    @Test
    void cadastraFornecedorNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor(null, "neuza@gmail.com", "83 99988-0065");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor("Dona Neuza", null, "83 99988-0065");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor("Dona Neuza", "neuza@gmail.com", null);
        });

    }

    @Test
    void cadastraFornecedorVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor("", "neuza@gmail.com", "83 99988-0065");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor("Dona Neuza", "", "83 99988-0065");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastraFornecedor("Dona Neuza", "neuza@gmail.com", "");
        });
    }

    @Test
    void exibeFornecedor() {
        assertEquals("Dona Ines - dona.ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.exibeFornecedor("Dona Ines"));

        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766",
                this.controllerFornecedor.exibeFornecedor("Dona Inalda"));
    }

    @Test
    void exibeFornecedorNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.exibeFornecedor(null);
        });
    }

    @Test
    void exibeFornecedorVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.exibeFornecedor("");
        });
    }

    @Test
    void listarFornecedores() {
        this.controllerFornecedor.cadastraFornecedor("Seu Helio", "seu.helio@gmail.com", "83 99808-0808");
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321" +
                        " | Seu Helio - seu.helio@gmail.com - 83 99808-0808",
                this.controllerFornecedor.listarFornecedores());

    }

    @Test
    void editarFornecedor() {
        this.controllerFornecedor.editarFornecedor("Dona Ines", "email", "ines@gmail.com");
        assertEquals("Dona Ines - ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.exibeFornecedor("Dona Ines"));

        this.controllerFornecedor.editarFornecedor("Dona Inalda", "telefone", "83 99876-5432");
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99876-5432",
                this.controllerFornecedor.exibeFornecedor("Dona Inalda"));
    }

    @Test
    void editarFornecedorNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarFornecedor(null, "email", "dona.inalidinha@gmail.com");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarFornecedor("Dona Inalda", null, "dona.inalidinha@gmail.com");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarFornecedor("Dona Inalda", "email", null);
        });
    }

    @Test
    void editarFornecedorVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarFornecedor("", "email", "dona.inalidinha@gmail.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarFornecedor("Dona Inalda", "", "dona.inalidinha@gmail.com");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarFornecedor("Dona Inalda", "email", "");
        });
    }

    @Test
    void removerFornecedor() {
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.listarFornecedores());

        this.controllerFornecedor.removerFornecedor("Dona Inalda");
        assertEquals("Dona Ines - dona.ines@gmail.com - 83 99965-4321", this.controllerFornecedor.listarFornecedores());

    }

    @Test
    void removerFornecedorNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.removerFornecedor(null);
        });
    }

    @Test
    void removerFornecedorVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.removerFornecedor("");
        });
    }

    @Test
    void cadastrarProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);

        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));

    }

    @Test
    void cadastrarProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastrarProduto(null, "Bala", "Bala de menta",
                    2.50);
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastrarProduto("Dona Ines", null, "Bala de menta",
                    2.50);
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", null,
                    2.50);
        });
    }

    @Test
    void cadastrarProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastrarProduto("", "Bala", "Bala de menta",
                    2.50);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastrarProduto("Dona Ines", "", "Bala de menta",
                    2.50);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "",
                    2.50);
        });
    }

    @Test
    void exibeProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);

        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));

    }

    @Test
    void exibeProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.exibeProduto(null, "Tapioca", "Tapioca com queijo");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.exibeProduto("Dona Ines", null, "Tapioca com queijo");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", null);
        });

    }

    @Test
    void exibeProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.exibeProduto("", "Tapioca", "Tapioca com queijo");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.exibeProduto("Dona Ines", "", "Tapioca com queijo");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "");
        });
    }

    @Test
    void listarProdutosDoFornecedor() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);
        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));

        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "Bala de menta", 0.15 );

        assertEquals("Tapioca - Tapioca com queijo - R$3,00 | Bala - Bala de menta - R$0,15",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));

    }

    @Test
    void listarProdutosDoFornecedorNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.listarProdutosDoFornecedor(null);
        });
    }

    @Test
    void listarProdutosDoFornecedorVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.listarProdutosDoFornecedor("");
        });
    }

    @Test
    void listarTodosProdutos() {
        this.controllerFornecedor.cadastraFornecedor("Seu Helio", "seu.helio@gmail.com", "83 99808-0808");

        this.controllerFornecedor.cadastrarProduto("Dona Inalda", "Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75", this.controllerFornecedor.listarTodosProdutos());

        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75 | " +
                "Dona Ines - Tapioca - tapioca com queijo - R$2,75", this.controllerFornecedor.listarTodosProdutos());

        this.controllerFornecedor.cadastrarProduto("Seu Helio", "Misto", "Pao presunto e queijo", 3);

        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "bala de menta", 0.15);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75 | " +
                "Dona Ines - Tapioca - tapioca com queijo - R$2,75 | Dona Ines - Bala - bala de menta - R$0,15 | Seu Helio - Misto - Pao presunto e queijo - R$3,00",
                this.controllerFornecedor.listarTodosProdutos());
    }

    @Test
    void editarProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);
        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));

        this.controllerFornecedor.editarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 2.75);
        assertEquals("Tapioca - Tapioca com queijo - R$2,75",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));
    }

    @Test
    void editarProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarProduto(null, "Bala", "Bala de menta", 2.5);
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarProduto("Dona Ines", null, "Bala de menta", 2.5);
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.editarProduto("Dona Ines", "Bala", null, 2.5);
        });
    }

    @Test
    void editarProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarProduto("", "Bala", "Bala de menta", 2.5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarProduto("Dona Ines", "", "Bala de menta", 2.5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.editarProduto("Dona Ines", "Bala", "", 2.5);
        });
    }

    @Test
    void removerProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "Bala de menta", 0.15 );
        assertEquals("Tapioca - Tapioca com queijo - R$3,00 | Bala - Bala de menta - R$0,15",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));


        this.controllerFornecedor.removerProduto("Dona Ines", "Bala", "Bala de menta");
        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));
    }

    @Test
    void removerProdutoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.removerProduto(null, "Bala", "Bala de menta");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.removerProduto("Dona Ines", null, "Bala de menta");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerFornecedor.removerProduto("Dona Ines", "Bala", null);
        });
    }

    @Test
    void removerProdutoVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.removerProduto("", "Bala", "Bala de menta");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.removerProduto("Dona Ines", "", "Bala de menta");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerFornecedor.removerProduto("Dona Ines", "Bala", "");
        });
    }

    @Test
    void exibeProdutosFornecedor() {
    }

    @Test
    void getPrecoProduto() {
    }

    @Test
    void existeFornecedo() {
    }

    @Test
    void adicionaCombo() {
    }

    @Test
    void editaCombo() {
    }
}