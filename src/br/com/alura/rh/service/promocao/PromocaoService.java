package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

import javax.sql.rowset.CachedRowSet;
import java.util.function.Function;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean bateuMeta){

        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
        if(Cargo.GERENTE.equals(cargoAtual)){
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        if(bateuMeta){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        }else{
            throw new ValidacaoException("Funcionario não pode ser promovido!");
        }
    }
}
