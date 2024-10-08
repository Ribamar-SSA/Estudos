package outroCurso.Interface.equipamentos.multifuncional;

import outroCurso.Interface.equipamentos.copiadora.Copiadora;
import outroCurso.Interface.equipamentos.digitalizadora.Digitalizadora;
import outroCurso.Interface.equipamentos.impressora.Impressora;

//eu não consigo fazer uma CursoDio.Carro.heranca multifuncional
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
