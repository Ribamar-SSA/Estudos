package Interface.equipamentos.multifuncional;

import Interface.equipamentos.copiadora.Copiadora;
import Interface.equipamentos.digitalizadora.Digitalizadora;
import Interface.equipamentos.impressora.Impressora;

//eu não consigo fazer uma heranca multifuncional
public class EquipamentoMultifuncional implements Digitalizadora, Impressora, Copiadora {
    @Override
    public void digitar() {
        System.out.println("digitando via equipamento multifuncional");
    }

    @Override
    public void imprimir() {
        System.out.println("imprimindo via equipamento multifuncional");
    }

    @Override
    public void copiar() {
        System.out.println("copiando via equipamento multifuncional");
    }
}
