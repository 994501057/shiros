package global.com.web;

import global.com.dao.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class shopCard {
    //准备商品数据
    private static List<Product> list;
    static{
        list = new ArrayList<Product>();

        list.add(new Product(1,"iphone6s" ,3788));
        list.add(new Product(2,"小米8" ,2788));
        list.add(new Product(3,"vivo20" ,4788));
        list.add(new Product(4,"meizu6" ,3690));
        list.add(new Product(5,"诺基亚200" ,188));
    }
    @RequestMapping("/list")
    public String setSession(Model model){
        model.addAttribute("list",list);
        return "list";
    }
    //添加商品到购物车， 现在拿到的是商品的索引
    @RequestMapping("addToCart")
    public String addToCart(HttpServletRequest request , int index){

        System.out.println("要添加商品到购物车了~");

        HttpSession session = request.getSession();
        System.out.println("要添加商品的索引~"+index);

        //1. 根据索引，获取到要添加到购物车的商品
        Product product  = list.get(index);

        //2. 加入购物车 购物车其实就是商品和数量的对应关系。
        Map<Product , Integer> map = (Map<Product , Integer>)session.getAttribute("cartMap");
        //第一次来，连购物车都没有
        if(map == null){
            map = new HashMap<Product , Integer>();
        }

        //判断购物车里面是否有该商品 ，如果有  数量 + 1  ，如果没有，数量-1
        if(map.containsKey(product)){
            map.put(product , map.get(product) +1 );
        }else{
            map.put(product , 1 );
        }

        //3. 存储到session中。
        request.getSession().setAttribute("cartMap" , map);

        //当前的跳转是基于template/list.html ，所以需要重定向跳转到中转页面
        return "redirect:transfer.html";
    }
    @RequestMapping("toCart")
    public String toCart(){

        return "cart";
    }
}
