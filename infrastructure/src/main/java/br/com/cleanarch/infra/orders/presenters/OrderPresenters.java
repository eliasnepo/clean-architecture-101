package br.com.cleanarch.infra.orders.presenters;

import br.com.cleanarch.application.orders.retrieve.list.ListOrderOutput;
import br.com.cleanarch.application.orders.update.UpdateOrderInput;
import br.com.cleanarch.infra.orders.controllers.dtos.ListOrdersResponse;
import br.com.cleanarch.infra.orders.controllers.dtos.UpdateOrderRequest;

public interface OrderPresenters {

    static ListOrdersResponse present(ListOrderOutput orderOutput) {
        return new ListOrdersResponse(orderOutput.id(), orderOutput.price(), orderOutput.source());
    }

    static UpdateOrderInput present(Long id, UpdateOrderRequest request) {
        return new UpdateOrderInput(id, request.price());
    }
}
