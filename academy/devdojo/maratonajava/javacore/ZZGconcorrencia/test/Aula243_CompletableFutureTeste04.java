package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.domain.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;

public class Aula243_CompletableFutureTeste04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount storeServiceWithDiscount = new StoreServiceWithDiscount();
        searchPrciesWithDiscount(storeServiceWithDiscount);
//        searchPrciesWithDiscount(storeServiceWithDiscount);
    }

    private static void searchPrciesWithDiscount(StoreServiceWithDiscount service){
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
//        stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync) //store:price:quote
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);
    }
}
