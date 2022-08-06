package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dto.Car;
import org.example.dto.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello world!");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("김씨");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K4");
        car1.setCarNumber("11가 123123");
        car1.setType("sedan");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        user.setCars(cars);

        System.out.println("user = " + user);
        
        String json = objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("_age = " + _age);
        System.out.println("_name = " + _name);

        JsonNode _list = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) _list;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});

        System.out.println("_cars = " + _cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name","dd");
        objectNode.put("age",20);

        System.out.println("objectNode = " + objectNode.toPrettyString());
    }
}