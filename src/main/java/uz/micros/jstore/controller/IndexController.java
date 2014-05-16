package uz.micros.jstore.controller;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.entity.Author;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 12.05.14.
 */
@Controller
public class IndexController {

     @ResponseBody
     @RequestMapping(value = "/", method = RequestMethod.GET)
     public String showIndex(){
        return "<h2>Hello World spring!!!</h2>" +
                "" +
                "<a href=\"home\">Home</a>";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView showIndex1(HttpSession session){

        Author a = new Author();
        a.setName("Borya");

        List<Author> list;
        if (session.getAttribute("authors") == null){

            list = new ArrayList<Author>();
            list.add(a);
            list.add(a);
            list.add(a);
            session.setAttribute("authors", list);
        }else{
            list = (List<Author>) session.getAttribute("authors");
        }



        return new ModelAndView("home").addObject("name", "Muzaffar").addObject("author", a).addObject("authors", list)
                .addObject("newAuthor", new Author());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String save(@RequestParam("title") String name, HttpSession session){

        List<Author> list = (List<Author>) session.getAttribute("authors");

        Author a = new Author();
        a.setName(name);
        list.add(a);

        return "redirect:/home";

    }


    @RequestMapping(value = "/save2", method = RequestMethod.POST)

    public String save2(@ModelAttribute Author newAuthor, HttpSession session){

        List<Author> list = (List<Author>) session.getAttribute("authors");

        list.add(newAuthor);

        return "redirect:/home";

    }
}
