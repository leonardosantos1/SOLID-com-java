package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidarPeriodicidadeEntreReajuste implements ValidacaoReajuste {
    
    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesEntreUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if(mesesEntreUltimoReajuste < 6){
            throw  new ValidacaoException("Intervalo entre reajuste não atende o tempo minimo");
        }
    }
}
