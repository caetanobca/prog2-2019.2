package SAGA.Comparador;

import SAGA.Compra.Compra;

/**
 * Classe criada para comparar as compras pela a data de venda
 *
 * @author  Caetano Albuquqerque
 */
public class ComparadorPorData implements java.util.Comparator<Compra> {

    /**
     * Metodo que compara duas compras na ordem de prioridade <data, cliente, fornecedor, descricaoProduto>
     * @param compra - compra que sera comparada com t1
     * @param t1 - objeto do tipo compra que sera comparado com compra
     * @return um numero possitivo caso compra venha antes que t1, um numero negativo caso t1 venha primeiro e 0 caso
     * os dois objetos forem iguais
     */
    @Override
    public int compare(Compra compra, Compra t1) {
        int result;
      if (this.comparaData(compra.getData(), t1.getData()) == 0) {
          if (compra.getCliente().compareTo(t1.getCliente()) == 0) {
              if (compra.getFornecedor().compareTo(t1.getFornecedor()) == 0) {
                  result = compra.getDescricaoProduto().compareTo(t1.getDescricaoProduto());
              } else {
                  result = compra.getFornecedor().compareTo(t1.getFornecedor());
              }
          } else {
              result = compra.getCliente().compareTo(t1.getCliente());
          }
      }else {
          result = this.comparaData(compra.getData(), t1.getData());
      }
        return result;
    }

    /**
     * compara duas datas
     * @param compraData1 - data 1 que sera comparada
     * @param compraData2 - data 2 que sera comparada
     * @return - um numero possitivo caso a data1 seja mais antiga que a data2
     */
    public static int comparaData(String compraData1, String compraData2){
        int result;
        Integer [] data1 = new Integer[3];
        Integer [] data2 = new Integer[3];

        for (int i=0; i<3; i++){
            data1[i] = Integer.parseInt(compraData1.split("/")[i]);
            data2[i] = Integer.parseInt(compraData2.split("/")[i]);
        }

        if(data1[2].compareTo(data2[2]) == 0){
            if (data1[1].compareTo(data2[1]) == 0){
                result =  data1[0].compareTo(data2[0]);
            }
            else {
                result = data1[1].compareTo(data2[1]);
            }
        }else{
            result = data1[2].compareTo(data2[2]);
        }
        return result;
    }
}
