package map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Map1{

    public static void main(String[] args){
        
        @SuppressWarnings("serial")
		Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPopulares);
        System.out.println("Substitua o consumo do gol por 15,2");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
        System.out.println("Confira se o modelo tucson esta no dicionario: " + carrosPopulares.containsKey("tucson"));
        System.out.println("Confira se o modelo tol esta no dicionario: " + carrosPopulares.containsKey("gol"));
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        // nao e possivel System.out.println("Exiba o terceiro modelo adicionado");
        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais economico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for(Map.Entry<String, Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                //system foi aqui pq se tiver outro com consumo igual ira imprimir tambem
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o modelo menos economico e seu consumo: ");

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        
        for(Map.Entry<String, Double> entry: carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();

        Double soma = 0d;

        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("A soma dos consumos e: " + soma);

        System.out.println("Exiba a media dos consumos deste dicionario de carros: " + (soma/carrosPopulares.size()));


        System.out.println(carrosPopulares);
        System.out.println("Remova os modelos com consumo igual a 15,6 km/l: ");

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }

        System.out.println(carrosPopulares);

        System.out.println("Exiba os carros na ordem que foram informados: ");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o dicionario de carros");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionario esta vazio: " + carrosPopulares.isEmpty());


        


    }
}