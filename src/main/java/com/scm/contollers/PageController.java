package com.scm.contollers;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/") 
        public String index() {
            return "redirect:/home";
        }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");
        model.addAttribute("Name", "Lakshya Bhardwaj");
        return "home";
    }

   @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page handler");
        return "about";
    }
    
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page handler");
        return "services";
        }

        //contact page
        @GetMapping("/contact")
        public String contact() {
            return new String("contact");
        }


        // this is a registration controller
         @GetMapping("/login")
        public String login() {
            return new String("login");
        }
        
        @GetMapping("/register")
        public String register(Model model) {
            UserForm userForm = new UserForm();
            model.addAttribute("userForm", userForm);
            return ("register");
        }
        
        // processing register
        @RequestMapping(value = "/do-register", method = RequestMethod.POST)
        public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session) {

            if(rBindingResult.hasErrors()) {
                return "register";
            }

            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            user.setAbout(userForm.getAbout());
            user.setPhoneNumber(userForm.getPhoneNumber());
            user.setProfilePic(
                    "https://instagram.fdel74-1.fna.fbcdn.net/v/t51.2885-19/349738619_207012722157351_1006066007933630941_n.jpg?_nc_ht=instagram.fdel74-1.fna.fbcdn.net&_nc_cat=103&_nc_ohc=G0WYaT-l4bQQ7kNvgHYGtPH&edm=AEhyXUkBAAAA&ccb=7-5&oh=00_AYBqZj9X1PhzkQZJT6WvMasz33-VBG0f847v8TS9xsP3wA&oe=66921B3A&_nc_sid=8f1549");
    
            User savedUser = userService.saveUser(user);
    
            System.out.println("user saved :");

            //add the message
           Message message =  Message.builder().content("Resgistration Sucessful").type(MessageType.green).build();
            session.setAttribute("message",  message);
    

            return "redirect:/register";
        }
}
