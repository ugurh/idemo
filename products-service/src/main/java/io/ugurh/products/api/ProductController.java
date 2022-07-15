package io.ugurh.products.api;

import io.ugurh.products.commands.CreateProductCommand;
import io.ugurh.products.dto.request.CreateProductDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final CommandGateway commandGateway;

    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public ResponseEntity<String> productInfo() {
        return new ResponseEntity<>("Product Info...", HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public String create(@RequestBody CreateProductDto productDto) {
        CreateProductCommand productCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .title(productDto.getTitle())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(productCommand);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
