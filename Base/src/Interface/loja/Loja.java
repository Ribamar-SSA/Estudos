package Interface.loja;

import Interface.equipamentos.copiadora.Copiadora;
import Interface.equipamentos.digitalizadora.Digitalizadora;
import Interface.equipamentos.impressora.Deskjet;
import Interface.equipamentos.impressora.Impressora;
import Interface.equipamentos.multifuncional.EquipamentoMultifuncional;

public class Loja {
    public static void main(String[] args) {

        //deskjet é uma classe que implementa a interface impressora
        Impressora minha_impressora = new Deskjet();
        minha_impressora.imprimir();

        //a classe EquipamentoMultifuncional implementas as 3 interfaces nesse pacote
        //,ou seja ele pode representar qualquer um dos 3 papeis
        Impressora minha_impressora_multifuncional = new EquipamentoMultifuncional();
        minha_impressora_multifuncional.imprimir();

        EquipamentoMultifuncional em = new EquipamentoMultifuncional();

        Deskjet deskjet = new Deskjet();

        Impressora impressora = deskjet;
        //apesar de aceitar o valor do tipo EquipamentoMultifuncional, ele não deixa
        //executar metodos diferentes do que copiadora poderia fazer
        Copiadora copiadora = em;
        Digitalizadora digitalizadora = em;




    }
}
