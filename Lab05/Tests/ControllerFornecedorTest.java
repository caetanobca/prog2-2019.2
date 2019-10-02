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
    void exibeFornecedor() {
        assertEquals("Dona Ines - dona.ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.exibeFornecedor("Dona Ines"));

        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766",
                this.controllerFornecedor.exibeFornecedor("Dona Inalda"));
    }

    @Test
    void listarFornecedores() {
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321",
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
    void removerFornecedor() {
        assertEquals("Dona Inalda - inalda@gmail.com - 83 99988-7766 | Dona Ines - dona.ines@gmail.com - 83 99965-4321",
                this.controllerFornecedor.listarFornecedores());

        this.controllerFornecedor.removerFornecedor("Dona Inalda");
        assertEquals("Dona Ines - dona.ines@gmail.com - 83 99965-4321", this.controllerFornecedor.listarFornecedores());

    }

    @Test
    void cadastrarProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);

        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));

    }

    @Test
    void exibeProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);

        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.exibeProduto("Dona Ines", "Tapioca", "Tapioca com queijo"));

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
    void listarTodosProdutos() {
        this.controllerFornecedor.cadastrarProduto("Dona Inalda", "Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75", this.controllerFornecedor.listarTodosProdutos());

        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "tapioca com queijo", 2.75);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75 | " +
                "Dona Ines - Tapioca - tapioca com queijo - R$2,75", this.controllerFornecedor.listarTodosProdutos());

        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "bala de menta", 0.15);
        assertEquals("Dona Inalda - Tapioca - tapioca com queijo - R$2,75 | " +
                "Dona Ines - Tapioca - tapioca com queijo - R$2,75 | Dona Ines - Bala - bala de menta - R$0,15",
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
    void removerProduto() {
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Tapioca", "Tapioca com queijo", 3.00);
        this.controllerFornecedor.cadastrarProduto("Dona Ines", "Bala", "Bala de menta", 0.15 );
        assertEquals("Tapioca - Tapioca com queijo - R$3,00 | Bala - Bala de menta - R$0,15",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));


        this.controllerFornecedor.removerProduto("Dona Ines", "Bala", "Bala de menta");
        assertEquals("Tapioca - Tapioca com queijo - R$3,00",
                this.controllerFornecedor.listarProdutosDoFornecedor("Dona Ines"));
    }
}