package MaratonaJava.zzijdbc.dominio;


import lombok.Builder;
import lombok.Value;

@Value//transforma tudo em imutável
@Builder//cria um builder


public class Producer {

    Integer id;
    String name;
}
