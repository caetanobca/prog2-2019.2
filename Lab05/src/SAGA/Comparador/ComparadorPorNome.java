package SAGA.Comparador;

import SAGA.Compra.Compra;

/**
 * Classe criada para comparar as compras pelo cliente
 *
 * @author  Caetano Albuquqerque
 */
public class ComparadorPorNome implements java.util.Comparator<Compra> {
    /**
     * Metodo que compara duas compras na ordem de prioridade <cliente, fornecedor, descricaoProduto, data>
     * @param compra - compra que sera comparada com t1
     * @param t1 - objeto do tipo compra que sera comparado com compra
     * @return um numero possitivo caso compra venha antes que t1, um numero negativo caso t1 venha primeiro e 0 caso
     * os dois objetos forem iguais
     */
    @Override
    public int compare(Compra compra, Compra t1) {
        int result;
        if (compra.getCliente().compareTo(t1.getCliente()) == 0){
            if (compra.getFornecedor().compareTo(t1.getFornecedor()) == 0){
                if (compra.getDescricaoProduto().compareTo(t1.getDescricaoProduto()) == 0){
                    result = ComparadorPorData.comparaData(compra.getData(), t1.getData());
                }else{
                    result = compra.getDescricaoProduto().compareTo(t1.getDescricaoProduto());
                }
            }else {
                result = compra.getFornecedor().compareTo(t1.getFornecedor());
            }
        }else {
            result = compra.getCliente().compareTo(t1.getCliente());
        }
        return result;
    }

}