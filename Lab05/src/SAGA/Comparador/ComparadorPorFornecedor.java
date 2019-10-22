package SAGA.Comparador;

import SAGA.Compra.Compra;

import java.util.Comparator;

/**
 * Classe criada para comparar as compras pelo fornecedor
 *
 * @author  Caetano Albuquqerque
 */
public class ComparadorPorFornecedor implements Comparator<Compra> {

    /**
     * Metodo que compara duas compras na ordem de prioridade <fornecedor, cliente, descricaoProduto, data>
     * @param compra - compra que sera comparada com t1
     * @param t1 - objeto do tipo compra que sera comparado com compra
     * @return um numero possitivo caso compra venha antes que t1, um numero negativo caso t1 venha primeiro e 0 caso
     * os dois objetos forem iguais
     */
    @Override
    public int compare(Compra compra, Compra t1) {
        int result;
        if (compra.getFornecedor().compareTo(t1.getFornecedor()) == 0){
            if (compra.getCliente().compareTo(t1.getCliente()) == 0){
                if (compra.getDescricaoProduto().compareTo(t1.getDescricaoProduto()) == 0){
                    result = ComparadorPorData.comparaData(compra.getData(), t1.getData());
                }else{
                    result = compra.getDescricaoProduto().compareTo(t1.getDescricaoProduto());
                }
            }else {
                result = compra.getCliente().compareTo(t1.getCliente());
            }
        }else {
            result = compra.getFornecedor().compareTo(t1.getFornecedor());
        }
        return result;
    }
}
