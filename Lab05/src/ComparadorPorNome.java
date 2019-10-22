import java.util.Comparator;

public class ComparadorPorNome implements java.util.Comparator<Compra> {
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