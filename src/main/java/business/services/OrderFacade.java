package business.services;

import business.persistence.CupcakeMapper;
import business.persistence.OrderMapper;

public class OrderFacade {

    CupcakeMapper cupcakeMapper;

    public OrderFacade(CupcakeMapper cupcakeMapper) {
        this.cupcakeMapper = cupcakeMapper;
    }

    OrderMapper orderMapper;

    public OrderFacade(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
}
