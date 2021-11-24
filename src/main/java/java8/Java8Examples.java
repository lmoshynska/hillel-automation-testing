package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Examples {

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        // return prices of products > 30000
/*        List<Float> productPriceList2 = productsList.stream()
                .filter(p -> p.price > 30000)
                .map(p -> p.price)
                .collect(Collectors.toList());
        System.out.println("productPriceList2 = " + productPriceList2);*/

//
//        // print product names with price = 30000
//        productsList.stream()
//                .filter(product -> product.price == 30000)
//                .forEach(product -> System.out.println(product.name));
/*
        // return sum of all products' prices
        Float totalPrice = productsList.stream()
                .map(product -> product.price)
                .reduce(0.0f, (sum, price) -> sum + price);
        System.out.println(totalPrice);*/

        // return sum of all products' prices with method reference
//        float totalPrice2 = productsList.stream()
//                .map(product -> product.price)
//                .reduce(0.0f, Float::sum);
//        System.out.println(totalPrice2);
//
//        // return sum of all products' prices with mapToDouble
//        double totalPrice3 = productsList.stream()
//                .mapToDouble(product -> product.price).sum();
//        System.out.println(totalPrice3);

//        // return count of products with price < 30000
//        long count = productsList.stream()
//                .filter(product -> product.price < 30000)
//                .count();
//        System.out.println(count);
//
        // return set of prices < 30000
//        Set<Float> productPriceList =
//                productsList.stream()
//                        .filter(product -> product.price < 30000)
//                        .map(product -> product.price)
//                        .collect(Collectors.toSet());
//        System.out.println(productPriceList);
//
        // return map of products with id as key and name as value
//        Map<Integer, String> productPriceMap =
//                productsList.stream()
//                        .collect(Collectors.toMap(p -> p.id, p -> p.name));
//        System.out.println(productPriceMap);
//
   }

}
