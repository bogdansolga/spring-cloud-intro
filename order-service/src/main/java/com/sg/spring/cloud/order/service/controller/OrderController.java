package com.sg.spring.cloud.order.service.controller;

import com.sg.spring.cloud.order.service.dto.OrderDTO;
import com.sg.spring.cloud.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        path = "/order"
)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity create(@RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public OrderDTO getOrder(@PathVariable final int id) {
        return orderService.get(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = ""
    )
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/{id}"
    )
    public ResponseEntity update(@PathVariable final int id, @RequestBody OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}"
    )
    public ResponseEntity delete(@PathVariable final int id) {
        orderService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
