package com.zs.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.tmall.pojo.Order;
import com.zs.tmall.service.OrderItemService;
import com.zs.tmall.service.OrderService;
import com.zs.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class OrderController {

    /**
     * 因为订单的增加和删除，都是在前台进行的。 所以OrderController提供的是list方法和delivery(发货)方法
     */

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Order> orders = orderService.list();
        int total = (int) new PageInfo<>(orders).getTotal();
        page.setTotal(total);
        /**
         * 将items添加到order中
         */
        orderItemService.fill(orders);
        model.addAttribute("orders", orders);
        model.addAttribute("page", page);
        return "admin/listOrder";
    }

    @RequestMapping("admin_order_delivery")
    public String delivey(Order order){
        /**
         * 发货前先判断当前订单的状态
         */
        Order oldOrder = orderService.get(order.getId());
        if(oldOrder.getStatus().equals(OrderService.WAIT_DELIVERY)){
            order.setDeliveryDate(new Date());
            order.setStatus(OrderService.WAIT_CONFIRM);
            orderService.update(order);
        }
        return "redirect:/admin_order_list";
    }
}
