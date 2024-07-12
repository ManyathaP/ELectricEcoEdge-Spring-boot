package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.CustomerRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        
//        Signup customer1 = new Signup();
//        customer1.setName("Manyatha");
//        customer1.setEmail("manyatha2001@gmail.com");
//        customer1.setPhone_no("9019428645");;
//        customer1.setLocation("Hassan");
//        customer1.setPassword("1234");
//        customerRepository.save(customer1);
//  
//        
//        Signup customer2 = new Signup();
//        customer2.setName("Likitha");
//        customer2.setEmail("likitha2002@gmail.com");
//        customer2.setPhone_no("7483180800");
//        customer2.setLocation("Hassan");
//        customer2.setPassword("5678");
//        customerRepository.save(customer2);
    	
    }
    @Controller
    public static class ReactRouterController {
        @RequestMapping({"/{path:[^\\.]*}", "/{path:^(?!api$).*$}/**"})
        public String redirect() {
            return "forward:/index.html";
        }
    }
}
