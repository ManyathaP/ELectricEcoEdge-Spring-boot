
package net.javaguides.springboot.controller;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.model.Computer;
import net.javaguides.springboot.model.Laptop;
import net.javaguides.springboot.model.Mobile;
import net.javaguides.springboot.model.OtherItem;
import net.javaguides.springboot.model.Tablet;
import net.javaguides.springboot.model.Watch;
import net.javaguides.springboot.dto.ComputerDetailsDTO;
import net.javaguides.springboot.dto.LaptopDetailsDTO;
import net.javaguides.springboot.dto.MobileDetailsDTO;
import net.javaguides.springboot.dto.OtherItemDetailsDTO;
import net.javaguides.springboot.dto.TabletDetailsDTO;
import net.javaguides.springboot.dto.WatchDetailsDTO;
import net.javaguides.springboot.service.ComputerService;
import net.javaguides.springboot.service.ImageService;
import net.javaguides.springboot.service.LaptopService;
import net.javaguides.springboot.service.MobileService;
import net.javaguides.springboot.service.OtherItemService;
import net.javaguides.springboot.service.WatchService;
import net.javaguides.springboot.service.TabletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ComputerService computerService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/computers")
    public Computer createComputer(@RequestParam("brand") String brand,
                                   @RequestParam("yearsUsed") int yearsUsed,
                                   @RequestParam("description") String description,
                                   @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
                                   @RequestParam("signupId") Long signupId) throws IOException {
        String imageUrlString = null;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            imageUrlString = imageService.saveImage(imageUrl);
        }
        //return computerService.saveComputer(brand, yearsUsed, description, imageUrlString);
        Signup signup = new Signup();
        signup.setId(signupId); // Assuming signupId is provided to link with Computer
        return computerService.saveComputer(brand, yearsUsed, description, imageUrlString, signup);
    }
        
    
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/laptops")
    public Laptop createLaptop(@RequestParam("brand") String brand,
                               @RequestParam("yearsUsed") int yearsUsed,
                               @RequestParam("description") String description,
                               @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl, 
                               @RequestParam("signupId") Long signupId) throws IOException {
    	 String imageUrlString = null;
         if (imageUrl != null && !imageUrl.isEmpty()) {
             imageUrlString = imageService.saveImage(imageUrl);
        }
        Signup signup = new Signup();
        signup.setId(signupId); // Assuming signupId is provided to link with Computer
        return laptopService.saveLaptop(brand, yearsUsed, description, imageUrlString, signup);
    }
    
    @Autowired
    private MobileService mobileService;

    @PostMapping("/mobiles")
    public Mobile createMobile(@RequestParam("brand") String brand,
                               @RequestParam("yearsUsed") int yearsUsed,
                               @RequestParam("description") String description,
                               @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
                               @RequestParam("signupId") Long signupId) throws IOException {
    	String imageUrlString = null;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            imageUrlString = imageService.saveImage(imageUrl);
       }
        Signup signup = new Signup();
        signup.setId(signupId); 
        return mobileService.saveMobile(brand,yearsUsed, description, imageUrlString,signup);
    }
    
    @Autowired
    private OtherItemService otherItemService;

    
    @PostMapping("/other_items")
    public OtherItem createOtherItem(@RequestParam("brand") String brand,
                               @RequestParam("yearsUsed") int yearsUsed,
                               @RequestParam("description") String description,
                               @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
                               @RequestParam("signupId") Long signupId) throws IOException {
    	String imageUrlString = null;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            imageUrlString = imageService.saveImage(imageUrl);
       }
        Signup signup = new Signup();
        signup.setId(signupId); 
        return otherItemService.saveOtherItem(brand,yearsUsed, description, imageUrlString,signup);
    }
    
    @Autowired
    private WatchService watchService;
    
    @PostMapping("/watches")
    public Watch createWatch(@RequestParam("brand") String brand,
                               @RequestParam("yearsUsed") int yearsUsed,
                               @RequestParam("description") String description,
                               @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
                               @RequestParam("signupId") Long signupId)throws IOException {
    	String imageUrlString = null;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            imageUrlString = imageService.saveImage(imageUrl);
        }
        Signup signup = new Signup();
        signup.setId(signupId); 
        return watchService.saveWatch(brand,yearsUsed, description, imageUrlString,signup);
    }
    
    @Autowired
    private TabletService tabletService;
    
    @PostMapping("/tablets")
    public Tablet createTablet(@RequestParam("brand") String brand,
                               @RequestParam("yearsUsed") int yearsUsed,
                               @RequestParam("description") String description,
                               @RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl,
                               @RequestParam("signupId") Long signupId) throws IOException {
    	String imageUrlString = null;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            imageUrlString = imageService.saveImage(imageUrl);
        }
        Signup signup = new Signup();
        signup.setId(signupId); 
        return tabletService.saveTablet(brand,yearsUsed, description, imageUrlString,signup);
    }
    

    @GetMapping("/computers")
    public List<ComputerDetailsDTO> getAllComputerDetails() {
        return computerService.getAllComputerDetails();
    }
    
    @GetMapping("/laptops")
    public List<LaptopDetailsDTO> getAllLaptopDetails() {
        return laptopService.getAllLaptopDetails();
    }
    
    @GetMapping("/mobiles")
    public List<MobileDetailsDTO> getAllMobileDetails() {
        return mobileService.getAllMobileDetails();
    }
    
    @GetMapping("/other_items")
    public List<OtherItemDetailsDTO> getAllOtherItemDetails() {
        return otherItemService.getAllOtherItemDetails();
    }
    
    @GetMapping("/watches")
    public List<WatchDetailsDTO> getAllWatchDetails() {
        return watchService.getAllWatchDetails();
    }
    
    @GetMapping("/tablets")
    public List<TabletDetailsDTO> getAllTabletDetails() {
        return tabletService.getAllTabletDetails();
    }
    
    
}
