package command.Implementatiion.Order;

import Services.Implementation.OrderService;
import command.Command;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class OrderCreate implements Command {
    private OrderService orderService=new OrderService();
    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {


        return new Page();
    }
}