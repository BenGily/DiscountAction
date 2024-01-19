/**
package com.example.discountproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/discount")

public class DiscountController {
}
 */

package com.example.discountproj.controllers;

import com.example.discountproj.model.Basket;
import com.example.discountproj.model.LineItem;
import com.example.discountproj.model.TransactionResponse;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DiscountController {

    @PostMapping(path = "/calculateDiscount")
    public ResponseEntity<?> calculateDiscount(@RequestBody Basket basket) {
        System.out.println("Received basket: " + new Gson().toJson(basket)); // For debugging

        List<LineItem> items = basket.getItems();
        for (LineItem item : items) {
            System.out.println(item.getItemName());
        }
        //double discountedTotal = applyDiscounts(basket);

        //System.out.println("Discounted total: " + discountedTotal); // For debugging

        for (LineItem item : items) {
            item.setPrice(discountAction(item));
            //basket.addItem(item);
            System.out.println(item.getPrice());
        }

        System.out.println("Discounted total: " + basket.calculateTotal());

        // Create and return a response
        //TransactionResponse response = new TransactionResponse(discountedTotal);
        //return ResponseEntity.ok(response);
        return ResponseEntity.ok(basket);
    }

    private double discountAction(LineItem item){
        final double DISCOUNT_RATE = 0.10;
        double originalValue = item.getPrice();
        double discountAmount = originalValue * DISCOUNT_RATE;
        return originalValue - discountAmount;
    }

    private double applyDiscounts(Basket basket) {
        final double DISCOUNT_RATE = 0.10;
        double originalTotal = basket.calculateTotal();
        double discountAmount = originalTotal * DISCOUNT_RATE;
        return originalTotal - discountAmount;
    }


}

