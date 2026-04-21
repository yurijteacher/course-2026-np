package ua.com.kisit.course2026np.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.course2026np.bl.Cart;
import ua.com.kisit.course2026np.entity.Products;

@Controller
public class CartController {

    @GetMapping({"/cart","/cart/"})
    public String getCart(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        session.setAttribute("cart", cart);
        // session.getAttribute("cart")
        // session.setAttribute("cart", Obj)

        model.addAttribute("cart", cart);
        model.addAttribute("value", cart.getTotalValueFromCart());
        model.addAttribute("el", cart.getSumItem());

        return "cart";
    }


    @PostMapping("/addItemFromCart")
    public String addItemFromCart(@RequestParam(name = "id") Products product,
                                  @RequestParam(name = "quantity") int quantity,
                                  HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(product, quantity);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/updateItemFromCart")
    public String updateItemFromCart(@RequestParam(name = "id") Products product,
                                     @RequestParam(name = "quantity") int quantity,
                                     HttpServletRequest request) {
        HttpSession session = request.getSession();


        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        cart.updateItemFromCart(product, quantity);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/deleteItemFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Products product,
                                     HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        cart.removeItemFromCart(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


}
