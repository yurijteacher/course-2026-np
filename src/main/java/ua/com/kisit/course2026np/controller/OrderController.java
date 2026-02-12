package ua.com.kisit.course2026np.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.course2026np.bl.Cart;
import ua.com.kisit.course2026np.bl.ItemCart;
import ua.com.kisit.course2026np.entity.*;
import ua.com.kisit.course2026np.repository.DeliveryRepository;
import ua.com.kisit.course2026np.repository.PaymentRepository;
import ua.com.kisit.course2026np.service.ClientsService;
import ua.com.kisit.course2026np.service.OrderService;
import ua.com.kisit.course2026np.service.ProductHasOrderService;
import ua.com.kisit.course2026np.service.UserService;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ClientsService clientService;
    private final PaymentRepository paymentRepository;
    private final DeliveryRepository deliveryRepository;
    private final ProductHasOrderService productHasOrderService;

    @GetMapping("/order")
    public String getPageOrder(Model model,
                               HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) userService.loadUserByUsername(authentication.getName());

        if(user == null){
            return "redirect:/login";
        }

        Clients client = clientService.findById(user.getId());

        model.addAttribute("client", client);

        HttpSession session = request.getSession();

        //        session.setAttribute("client", client);
        //        session.getAttribute("client");

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            return "redirect:/";
        }

        model.addAttribute("cart", cart);
        model.addAttribute("value", cart.getTotalValueFromCart());
        model.addAttribute("el", cart.getSumItem());

        return "order";
    }


    @PostMapping("/buy")
    public String saveOrder(@RequestParam(name = "delivery") Delivery delivery,
                            @RequestParam(name = "payment") Payment payment,
                            Model model,
                            HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) userService.loadUserByUsername(authentication.getName());

        if(user == null){
            return "redirect:/login";
        }

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

//        if(cart == null){
//            return "redirect:/";
//        }
//
//        if(cart.getCart().size()==0){  // .isEmpty()
//            return "redirect:/";
//        }

        if (cart == null || cart.getCart().isEmpty()) {
            return "redirect:/";
        }

        Clients client = clientService.findById(user.getId());

        Orders order = new Orders();
        order.setClient(client);
        order.setPayment(payment);
        order.setDelivery(delivery);
        order.setCreationDate(new Date());

        Orders order_ = orderService.saveNewOrder(order);

        for(ItemCart el : cart.getCart()){
            productHasOrderService.saveNewProductsHasOrderToDB(new ProductsHasOrder(order_, el.getProducts(), el.getQuantity()));
        }

        cart.removeAllItemFromCart();

        session.setAttribute("cart", cart);

        redirectAttributes.addAttribute("message", "Order has been saved successfully!");
        redirectAttributes.addAttribute("id_order", order_.getId());

        return "redirect:/thank";
    }


    @GetMapping("/thank")
    public String getThankPage(@RequestParam(name = "message", defaultValue = " ") String info,
                               @RequestParam(name = "id_order", defaultValue= " ") Long id,
                               Model model) {

        model.addAttribute("info", info);
        model.addAttribute("id_order", id);

        return "thank";
    }

}
