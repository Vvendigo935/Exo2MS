package org.example.order.service;

import org.example.order.dto.OrderResponseDto;
import org.example.order.entity.Customer;
import org.example.order.entity.Order;
import org.example.order.entity.Product;
import org.example.order.util.RestClient;
import org.springframework.stereotype.Service;


@Service
public class OrderService {


    public Order getOrderById(int id){
        return new Order(id,"ma commande pour les vacances",2,5);
    }

    public OrderResponseDto orderToOrderResponseDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDescription(order.getDescription());
        RestClient<Product> productRestClient = new RestClient<>("http://PRODUCT/product/"+order.getProductId()); // "http://localhost:8081/product/"
        Product product = productRestClient.get(Product.class);
        orderResponseDto.setProduct(product);
        RestClient<Customer> customerRestClient = new RestClient<>("http://CUSTOMER/customer/2"); // "http://localhost:8080/customer/2"
        Customer customer = customerRestClient.get(Customer.class);
        orderResponseDto.setCustomer(customer);
        return orderResponseDto;
    }
}
