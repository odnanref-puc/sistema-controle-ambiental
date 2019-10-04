package br.edu.puc.sca.util;

import java.util.Comparator;
import br.edu.puc.sca.model.Ativo;

public class OrderById implements Comparator<Ativo> 
{ 
    public int compare(Ativo a, Ativo b) 
    { 
        return Long.compare(a.getId(), b.getId());
    } 
}