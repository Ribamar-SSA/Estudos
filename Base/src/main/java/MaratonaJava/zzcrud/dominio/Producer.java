package MaratonaJava.zzcrud.dominio;

import lombok.Builder;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Builder
@Value

public class Producer {
    Integer idautor;
    String name;
}
