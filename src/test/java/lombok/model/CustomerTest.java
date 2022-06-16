package lombok.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getCustomerId() {
        Customer customer = Customer.builder()
                .customerId("ewert-ggg")
                .email("hbjhb@hg.r")
                .favoriteFood("bread")
                .favoriteFood("ham")
                .build();
        assertEquals("ewert-ggg", customer.getCustomerId());
        System.out.println(customer.getFavoriteFoods());
    }
}