package MaratonaJava.colletion.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest1 {
    public static void main(String[] args) {
        Map<String,String> stringStringMap = new HashMap<>();
        //se quiser manter a ordem de inserção é só mudar para LinkedHashMap


        stringStringMap.put("rib","ribamar");
        stringStringMap.put("ssa","sousa");
        //no set ele ignora, mas aqui é feita a sobrescrita
        stringStringMap.put("ssa","sousa2");
        //solução
        stringStringMap.putIfAbsent("ssa","sousa3");

        //as keys representam elementos únicos -> são um set
        //os values já podem ter valores duplicados -> podem ser um collection normal

        System.out.println("chave e valor");
        for(String s : stringStringMap.keySet()){
            System.out.println(s+":"+stringStringMap.get(s));
        }
        System.out.println("valores");
        for(String s : stringStringMap.values()){
            System.out.println(s);
        }

        System.out.println("entry");
        //cada par chave-valor é representado como um objeto Map.Entry<K,V>
        // o method .entrySey() retorna um Set de entrys
        for(Map.Entry<String, String> entry : stringStringMap.entrySet()){
            System.out.println(entry.getKey() + " - "+ entry.getValue());
        }

    }
}
