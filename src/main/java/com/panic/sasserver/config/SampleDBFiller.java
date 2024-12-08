package com.panic.sasserver.config;

import com.panic.sasserver.enums.Rating;
import com.panic.sasserver.enums.UserRole;
import com.panic.sasserver.enums.VendorStatus;
import com.panic.sasserver.model.*;
import com.panic.sasserver.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


/*
 * Fills the dbs with sample data
 * */


@Component
public class SampleDBFiller {

    @Autowired
    private UserRepository userDB;

    @Autowired
    private ProductRepository prodDB;

    @Autowired
    private VendorRepository vendorDB;

    @Autowired
    private ProductRepository productDB;


    @Autowired
    private CategoryRepository categoryDB;

    @Autowired
    private ReviewRepository reviewDB;

    @Autowired
    private OrderRepository orderDB;

    @Autowired
    private AccessRepository accessDB;

    @Autowired
    private PaymentRepository paymentDB;


    private final String lorem = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente veritatis, facere commodi voluptate dignissimos blanditiis. Quae repellat nesciunt magni modi, eveniet maiores! Repellendus itaque maiores unde libero inventore tenetur corporis.";

    @PostConstruct
    public void fill(){//testing123 is the password for all accounts

        /*
         * VENDOR LIST
         * vendor 1 - PMax
         * vendor 2 - Heavy Duty
         * vendor 3 - ABC
         * vendor 4 - Strength Sports
         * vendor 5 - Bar Breaker
         *
         * USER LIST
         * Arnold - customer (Actor/Mr Olympia)
         * Wamuu - customer (Jojo's bizarre adventure)
         * The Rock - customer (Actor)
         * Nolan - customer (Omni man)
         * Todou - customer (Jujutsu Kaisen)
         * Goku - customer (Dragon Ball)
         * Yujiro - customer (Baki the grappler)
         * Bane - customer (Batman)
         * PMax - vendor (vendor account)
         * Heavy Duty - vendor (vendor account)
         * ABC - vendor (vendor account)
         * Strength Sports - vendor (vendor account)
         * Bar Breaker - vendor (vendor account)
         *
         * ID - CATEGORY
         * 1 - dumbbells
         * 2 - barbells
         * 3 - weight plates
         * 5 - Weighed clothing (weighed cuffs, etc)
         * 6 - weights (parent category of 1,2,3)
         * 7 - yoga mat
         * 8 - Lifting belts
         * 9 - lifting straps/gloves
         * 10 - accessories (parent category of 7,8,9)
         * 11 - power rack
         * 12 - Bench
         * 13 - gym machines
         * 14 - Equipment (parent category of 11, 12, 13)
         * */

        userDB.save(new AppUser("PranavAdmin","$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.ADMIN,"pranavadmin@gmail.com", 9912313123L,"Somewhere",false));
        userDB.save(new AppUser("Arnold", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "arnold@gmail.com", 9876543210L, "123 Olympia Street, Los Angeles, CA", false)); // User ID 2
        userDB.save(new AppUser("Wamuu", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "wamuu@gmail.com", 9876543211L, "456 Joestar Avenue, Tokyo, Japan", false)); // User ID 3
        userDB.save(new AppUser("The Rock", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "therock@gmail.com", 9876543212L, "789 Hollywood Street, Los Angeles, CA", false)); // User ID 4
        userDB.save(new AppUser("Nolan", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "nolan@gmail.com", 9876543213L, "101 Viltrum Avenue, Viltrum", false)); // User ID 5
        userDB.save(new AppUser("Todou", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "todou@gmail.com", 9876543214L, "202 Shibuya Crossing, Tokyo, Japan", false)); // User ID 6
        userDB.save(new AppUser("Goku", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "goku@gmail.com", 9876543215L, "303 Kame House, Turtle Island, East Sea", false)); // User ID 7
        userDB.save(new AppUser("Yujiro", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "yujiro@gmail.com", 9876543216L, "404 Delulu Road, Tokyo, Japan", false)); // User ID 8
        userDB.save(new AppUser("Bane", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "bane@gmail.com", 9876543217L, "505 Gotham Underground, Gotham City", false)); // User ID 9
        userDB.save(new AppUser("Mahoraga", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "bigraga@gmail.com", 9882373213L, "10 Sacred treasure Street, Shadow Realm", false)); // User ID 10
        userDB.save(new AppUser("PMax", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "pmax@gmail.com", 9876543218L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("Heavy Duty", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "heavyduty@gmail.com", 9876543219L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("ABC", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "abc@gmail.com", 9876543220L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("Strength Sports", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "strengthsports@gmail.com", 9876543221L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("Bar Breaker", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "barbreaker@gmail.com", 9870245221L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("Vendor 1", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "vendor1@gmail.com", 7727776789L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("Vendor 2", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "vendor2@gmail.com", 7432176789L, "lorem Street, ipsum", false));

        userDB.save(new AppUser("User 1", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user1@gmail.com", 9882332113L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 2", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user2@gmail.com", 9876543210L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 3", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user3@gmail.com", 9123456789L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 4", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user4@gmail.com", 9234567890L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 5", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user5@gmail.com", 9345678901L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 6", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user6@gmail.com", 9456789012L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 7", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user7@gmail.com", 9567890123L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 8", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user8@gmail.com", 9678901234L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 9", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user9@gmail.com", 9789012345L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 10", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user10@gmail.com", 9890123456L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 11", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user11@gmail.com", 9701234567L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 12", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user12@gmail.com", 9612345678L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 13", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user13@gmail.com", 9523456789L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 14", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user14@gmail.com", 9434567890L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 15", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user15@gmail.com", 9345678901L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 16", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user16@gmail.com", 9276543210L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 17", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user17@gmail.com", 9187654321L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 18", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user18@gmail.com", 9098765432L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 19", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user19@gmail.com", 8912345678L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 20", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user20@gmail.com", 8723456789L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 21", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user21@gmail.com", 8634567890L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 22", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user22@gmail.com", 8545678901L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 23", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user23@gmail.com", 8456789012L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 24", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user24@gmail.com", 8367890123L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 25", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user25@gmail.com", 8278901234L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 26", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user26@gmail.com", 8189012345L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 27", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user27@gmail.com", 8090123456L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 28", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user28@gmail.com", 7901234567L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 29", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user29@gmail.com", 7812345678L, "lorem Street, ipsum", false));
        userDB.save(new AppUser("User 30", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "user30@gmail.com", 7723456789L, "lorem Street, ipsum", false));



        vendorDB.save(new Vendor(11L, "PMax", "pmax@gmail.com,9876543218", lorem,VendorStatus.APPROVED, LocalDate.of(2024, 5, 1)));
        vendorDB.save(new Vendor(12L, "Heavy Duty", "heavyduty@gmail.com,9876543219", lorem, VendorStatus.APPROVED, LocalDate.of(2024, 6, 15)));
        vendorDB.save(new Vendor(13L, "ABC", "abc@gmail.com,9876543220", lorem, VendorStatus.APPROVED, LocalDate.of(2024, 7, 10)));
        vendorDB.save(new Vendor(14L, "Strength Sports", "strengthsports@gmail.com,9876543221", lorem, VendorStatus.APPROVED, LocalDate.of(2024, 8, 20)));
        vendorDB.save(new Vendor(15L, "Bar Breaker", "barbreaker@gmail.com,9876543222", lorem, VendorStatus.APPROVED, LocalDate.of(2024, 9, 25)));
        vendorDB.save(new Vendor(16L, "Vendor 1", "vendor1@gmail.com,9832543221", lorem, VendorStatus.PENDING, LocalDate.of(2024, 1, 20)));
        vendorDB.save(new Vendor(17L, "Vendor 2", "vendor2@gmail.com,9876323222", lorem, VendorStatus.PENDING, LocalDate.of(2024, 2, 25)));


        categoryDB.save(new Category("Dumbbells", "Various weights of dumbbells", null));
        categoryDB.save(new Category("Barbells", "Standard and Olympic barbells", null));
        categoryDB.save(new Category("Weight Plates", "Plates for lifting and machines", null));
        categoryDB.save(new Category("Weighted Clothing", "Weighted cuffs, vests, etc.", null));
        categoryDB.save(new Category("Yoga Mat", "Comfortable and durable yoga mats", null));
        categoryDB.save(new Category("Lifting Belts", "Belts for back support during lifts", null));
        categoryDB.save(new Category("Lifting Straps/Gloves", "Grip aids for lifting", null));
        categoryDB.save(new Category("Power Rack", "Essential for heavy lifting", null));
        categoryDB.save(new Category("Bench", "Flat and incline benches", null));
        categoryDB.save(new Category("Machines", "Various gym machines", null));

        productDB.save(new Product(11L, "Hex Dumbbell 5kg", "Durable rubber-coated 5kg hex dumbbell", 750.0, 1L, 12L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 7.5kg", "Durable rubber-coated 7.5kg hex dumbbell", 1125.0, 1L, 10L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 10kg", "Durable rubber-coated 10kg hex dumbbell", 1500.0, 1L, 8L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 15kg", "Durable rubber-coated 15kg hex dumbbell", 2250.0, 1L, 6L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 20kg", "High-quality 20kg Olympic barbell", 12000.0, 2L, 5L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 15kg", "High-quality 15kg Olympic barbell", 8000.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(12L, "EZ Curl Barbell 10kg", "Curved 10kg EZ curl barbell for arm exercises", 4500.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 2.5kg", "Rubber-coated 2.5kg weight plate", 500.0, 3L, 25L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 5kg", "Rubber-coated 5kg weight plate", 1000.0, 3L, 20L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 10kg", "Rubber-coated 10kg weight plate", 2000.0, 3L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 20kg", "Rubber-coated 20kg weight plate", 4000.0, 3L, 10L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 5kg", "Adjustable 5kg weighted vest", 2500.0, 4L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 10kg", "Adjustable 10kg weighted vest", 3500.0, 4L, 6L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 15kg", "Adjustable 15kg weighted vest", 4500.0, 4L, 4L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Ankle Cuffs 2kg", "Adjustable 2kg weighted ankle cuffs", 1200.0, 4L, 10L, LocalDate.now()));
        productDB.save(new Product(13L, "Yoga Mat", "Eco-friendly non-slip yoga mat", 1000.0, 5L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Premium Yoga Mat", "Extra thick and durable yoga mat", 1500.0, 5L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Travel Yoga Mat", "Lightweight and compact yoga mat", 800.0, 5L, 12L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Medium", "Leather lifting belt for medium builds", 1800.0, 6L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Large", "Leather lifting belt for large builds", 2000.0, 6L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Grip Straps", "Heavy-duty lifting straps for grip support", 700.0, 7L, 20L, LocalDate.now()));
        productDB.save(new Product(14L, "Lifting Gloves", "Padded gloves for extra grip and comfort", 1200.0, 7L, 15L, LocalDate.now()));
        productDB.save(new Product(11L, "Power Rack", "Heavy-duty power rack for advanced lifters", 45000.0, 8L, 3L, LocalDate.now()));
        productDB.save(new Product(12L, "Compact Power Rack", "Compact and affordable power rack", 35000.0, 8L, 5L, LocalDate.now()));
        productDB.save(new Product(15L, "Flat Bench", "Sturdy flat bench for bench presses", 12000.0, 9L, 6L, LocalDate.now()));
        productDB.save(new Product(15L, "Incline Bench", "Adjustable incline bench", 15000.0, 9L, 4L, LocalDate.now()));
        productDB.save(new Product(15L, "Adjustable Bench", "Flat and incline bench in one", 18000.0, 9L, 3L, LocalDate.now()));
        productDB.save(new Product(15L, "Lat Pulldown Machine", "Multi-purpose lat pulldown machine", 65000.0, 10L, 2L, LocalDate.now()));
        productDB.save(new Product(15L, "Leg Press Machine", "High-quality leg press machine", 85000.0, 10L, 2L,  LocalDate.now()));
        productDB.save(new Product(15L, "Cable Crossover Machine", "Versatile cable crossover machine", 95000.0, 10L, 1L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 5kg set of 4", "Durable rubber-coated 5kg hex dumbbell set of 4", 1500.0, 1L, 12L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 7.5kg set of 4", "Durable rubber-coated 7.5kg hex dumbbell set of 4", 2250.0, 1L, 10L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 10kg set of 4", "Durable rubber-coated 10kg hex dumbbell set of 4", 3000.0, 1L, 8L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 15kg set of 4", "Durable rubber-coated 15kg hex dumbbell set of 4", 4500.0, 1L, 6L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 20kg set of 4", "High-quality 20kg Olympic barbell set of 4", 24000.0, 2L, 5L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 15kg set of 4", "High-quality 15kg Olympic barbell set of 4", 16000.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(12L, "EZ Curl Barbell 10kg set of 4", "Curved 10kg EZ curl barbell for arm exercises set of 4", 9000.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 2.5kg set of 4", "Rubber-coated 2.5kg weight plate set of 4", 1000.0, 3L, 25L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 5kg set of 4", "Rubber-coated 5kg weight plate set of 4", 2000.0, 3L, 20L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 10kg set of 4", "Rubber-coated 10kg weight plate set of 4", 4000.0, 3L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 20kg set of 4", "Rubber-coated 20kg weight plate set of 4", 8000.0, 3L, 10L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 5kg set of 4", "Adjustable 5kg weighted vest set of 4", 5000.0, 4L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 10kg set of 4", "Adjustable 10kg weighted vest set of 4", 7000.0, 4L, 6L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 15kg set of 4", "Adjustable 15kg weighted vest set of 4", 9000.0, 4L, 4L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Ankle Cuffs 2kg set of 4", "Adjustable 2kg weighted ankle cuffs set of 4", 2400.0, 4L, 10L, LocalDate.now()));
        productDB.save(new Product(13L, "Yoga Mat set of 2", "Eco-friendly non-slip yoga mat set of 2", 2000.0, 5L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Premium Yoga Mat set of 3", "Extra thick and durable yoga mat set of 3", 4500.0, 5L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Travel Yoga Mat set of 2", "Lightweight and compact yoga mat set of 2", 1600.0, 5L, 12L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Medium set of 2", "Leather lifting belt for medium builds set of 2", 3600.0, 6L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Large set of 2", "Leather lifting belt for large builds set of 2", 4000.0, 6L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Grip Straps set of 2", "Heavy-duty lifting straps for grip support set of 2", 1400.0, 7L, 20L, LocalDate.now()));
        productDB.save(new Product(14L, "Lifting Gloves set of 4", "Padded gloves for extra grip and comfort set of 4", 2189.0, 7L, 15L, LocalDate.now()));
        productDB.save(new Product(11L, "Power Rack set of 2", "Heavy-duty power rack for advanced lifters set of 2", 89999.0, 8L, 3L, LocalDate.now()));
        productDB.save(new Product(12L, "Compact Power Rack set of 2", "Compact and affordable power rack set of 2", 68599.0, 8L, 5L, LocalDate.now()));
        productDB.save(new Product(15L, "Flat Bench set of 2", "Sturdy flat bench for bench presses set of 2", 24699.0, 9L, 6L, LocalDate.now()));
        productDB.save(new Product(15L, "Incline Bench set of 2", "Adjustable incline bench set of 2", 29799.0, 9L, 4L, LocalDate.now()));
        productDB.save(new Product(15L, "Adjustable Bench set of 2", "Flat and incline bench in one set of 2", 35999.0, 9L, 3L, LocalDate.now()));
        productDB.save(new Product(15L, "Lat Pulldown Machine set of 2", "Multi-purpose lat pulldown machine set of 2", 129879.0, 10L, 2L, LocalDate.now()));
        productDB.save(new Product(15L, "Leg Press Machine set of 2", "High-quality leg press machine set of 2", 169892.0, 10L, 2L,  LocalDate.now()));
        productDB.save(new Product(15L, "Cable Crossover Machine set of 3", "Versatile cable crossover machine set of 3", 284799.0, 10L, 1L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 5kg set of 6", "Durable rubber-coated 5kg hex dumbbell set of 6", 2249.0, 1L, 12L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 7.5kg set of 6", "Durable rubber-coated 7.5kg hex dumbbell set of 6", 2250.0, 1L, 10L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 10kg set of 6", "Durable rubber-coated 10kg hex dumbbell set of 6", 4499.0, 1L, 8L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 15kg set of 6", "Durable rubber-coated 15kg hex dumbbell set of 6", 6743.0, 1L, 6L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 20kg set of 6", "High-quality 20kg Olympic barbell set of 6", 35955.0, 2L, 5L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 15kg set of 6", "High-quality 15kg Olympic barbell set of 6", 23976.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(12L, "EZ Curl Barbell 10kg set of 6", "Curved 10kg EZ curl barbell for arm exercises set of 6", 13499.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 2.5kg set of 6", "Rubber-coated 2.5kg weight plate set of 6", 1459.0, 3L, 25L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 5kg set of 6", "Rubber-coated 5kg weight plate set of 6", 2999.0, 3L, 20L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 10kg set of 6", "Rubber-coated 10kg weight plate set of 6", 6000.0, 3L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 20kg set of 6", "Rubber-coated 20kg weight plate set of 6", 11968.0, 3L, 10L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 5kg set of 6", "Adjustable 5kg weighted vest set of 6", 7490.0, 4L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 10kg set of 6", "Adjustable 10kg weighted vest set of 6", 10599.0, 4L, 6L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 15kg set of 6", "Adjustable 15kg weighted vest set of 6", 13499.0, 4L, 4L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Ankle Cuffs 2kg set of 6", "Adjustable 2kg weighted ankle cuffs set of 6", 3555.0, 4L, 10L, LocalDate.now()));
        productDB.save(new Product(13L, "Yoga Mat set of 4", "Eco-friendly non-slip yoga mat set of 4", 3789.0, 5L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Premium Yoga Mat set of 5", "Extra thick and durable yoga mat set of 5", 7688.0, 5L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Travel Yoga Mat set of 4", "Lightweight and compact yoga mat set of 4", 3199.0, 5L, 12L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Medium set of 4", "Leather lifting belt for medium builds set of 4", 7186.0, 6L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Large set of 4", "Leather lifting belt for large builds set of 4", 7999.0, 6L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Grip Straps set of 4", "Heavy-duty lifting straps for grip support set of 4", 2089.0, 7L, 20L, LocalDate.now()));
        productDB.save(new Product(14L, "Lifting Gloves set of 4", "Padded gloves for extra grip and comfort set of 4", 4379.0, 7L, 15L, LocalDate.now()));
        productDB.save(new Product(11L, "Power Rack set of 4", "Heavy-duty power rack for advanced lifters set of 4", 179899.0, 8L, 3L, LocalDate.now()));
        productDB.save(new Product(12L, "Compact Power Rack set of 4", "Compact and affordable power rack set of 4", 139999.0, 8L, 5L, LocalDate.now()));
        productDB.save(new Product(15L, "Flat Bench set of 4", "Sturdy flat bench for bench presses set of 4", 90899.0, 9L, 6L, LocalDate.now()));
        productDB.save(new Product(15L, "Incline Bench set of 4", "Adjustable incline bench set of 4", 59999.0, 9L, 4L, LocalDate.now()));
        productDB.save(new Product(15L, "Adjustable Bench set of 4", "Flat and incline bench in one set of 4", 67899.0, 9L, 3L, LocalDate.now()));
        productDB.save(new Product(15L, "Lat Pulldown Machine set of 4", "Multi-purpose lat pulldown machine set of 4", 259758.0, 10L, 2L, LocalDate.now()));
        productDB.save(new Product(15L, "Leg Press Machine set of 4", "High-quality leg press machine set of 4", 339784.0, 10L, 2L,  LocalDate.now()));
        productDB.save(new Product(15L, "Cable Crossover Machine set of 6", "Versatile cable crossover machine set of 6", 569599.0, 10L, 1L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 5kg set of 8", "Durable rubber-coated 5kg hex dumbbell set of 8", 4999.0, 1L, 12L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 7.5kg set of 8", "Durable rubber-coated 7.5kg hex dumbbell set of 8", 4499.0, 1L, 10L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 10kg set of 8", "Durable rubber-coated 10kg hex dumbbell set of 8", 8999.0, 1L, 8L, LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 15kg set of 8", "Durable rubber-coated 15kg hex dumbbell set of 8", 13599.0, 1L, 6L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 20kg set of 8", "High-quality 20kg Olympic barbell set of 8", 71900.0, 2L, 5L, LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 15kg set of 8", "High-quality 15kg Olympic barbell set of 8", 47988.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(12L, "EZ Curl Barbell 10kg set of 8", "Curved 10kg EZ curl barbell for arm exercises set of 8", 26799.0, 2L, 7L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 2.5kg set of 8", "Rubber-coated 2.5kg weight plate set of 8", 2989.0, 3L, 25L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 5kg set of 8", "Rubber-coated 5kg weight plate set of 8", 5999.0, 3L, 20L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 10kg set of 8", "Rubber-coated 10kg weight plate set of 8", 11986.0, 3L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 20kg set of 8", "Rubber-coated 20kg weight plate set of 8", 23899.0, 3L, 10L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 5kg set of 8", "Adjustable 5kg weighted vest set of 8", 14999.0, 4L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 10kg set of 8", "Adjustable 10kg weighted vest set of 8", 21199.0, 4L, 6L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 15kg set of 8", "Adjustable 15kg weighted vest set of 8", 26788.0, 4L, 4L, LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Ankle Cuffs 2kg set of 8", "Adjustable 2kg weighted ankle cuffs set of 8", 7199.0, 4L, 10L, LocalDate.now()));
        productDB.save(new Product(13L, "Yoga Mat set of 6", "Eco-friendly non-slip yoga mat set of 6", 5689.0, 5L, 15L, LocalDate.now()));
        productDB.save(new Product(13L, "Premium Yoga Mat set of 8", "Extra thick and durable yoga mat set of 8", 12588.0, 5L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Travel Yoga Mat set of 6", "Lightweight and compact yoga mat set of 6", 4789.0, 5L, 12L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Medium set of 6", "Leather lifting belt for medium builds set of 6", 10799.0, 6L, 10L, LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Large set of 6", "Leather lifting belt for large builds set of 6", 12000.0, 6L, 8L, LocalDate.now()));
        productDB.save(new Product(14L, "Grip Straps set of 6", "Heavy-duty lifting straps for grip support set of 6", 3139.0, 7L, 20L, LocalDate.now()));
        productDB.save(new Product(14L, "Lifting Gloves set of 6", "Padded gloves for extra grip and comfort set of 6", 6599.0, 7L, 15L, LocalDate.now()));
        productDB.save(new Product(11L, "Power Rack set of 6", "Heavy-duty power rack for advanced lifters set of 6", 269899.0, 8L, 3L, LocalDate.now()));
        productDB.save(new Product(12L, "Compact Power Rack set of 6", "Compact and affordable power rack set of 6", 209998.5, 8L, 5L, LocalDate.now()));
        productDB.save(new Product(15L, "Flat Bench set of 6", "Sturdy flat bench for bench presses set of 6", 136349.0, 9L, 6L, LocalDate.now()));
        productDB.save(new Product(15L, "Incline Bench set of 6", "Adjustable incline bench set of 6", 134999.0, 9L, 4L, LocalDate.now()));
        productDB.save(new Product(15L, "Adjustable Bench set of 6", "Flat and incline bench in one set of 6", 152779.0, 9L, 3L, LocalDate.now()));
        productDB.save(new Product(15L, "Lat Pulldown Machine set of 6", "Multi-purpose lat pulldown machine set of 6", 389699.0, 10L, 2L, LocalDate.now()));
        productDB.save(new Product(15L, "Leg Press Machine set of 6", "High-quality leg press machine set of 6", 509699.0, 10L, 2L,  LocalDate.now()));
        productDB.save(new Product(15L, "Cable Crossover Machine set of 8", "Versatile cable crossover machine set of 8", 759599.0, 10L, 1L, LocalDate.now()));



        // Example: Reviews for Product ID 1 - "Hex Dumbbell 5kg"
        reviewDB.save(new Review(1L, 2L, Rating.EXCELLENT, "Perfect for my morning workouts. Solid and durable!", LocalDate.now())); // Arnold
        reviewDB.save(new Review(1L, 3L, Rating.GOOD, "The weight is balanced. Good for training, but I wish the grip was softer.", LocalDate.now())); // Wamuu
        reviewDB.save(new Review(1L, 8L, Rating.POOR, "Are you kidding me? 5kg is for kids. This dumbbell is a joke.", LocalDate.now())); // Yujiro
        reviewDB.save(new Review(1L, 6L, Rating.SATISFACTORY, "It's fine, but it's nothing special. Gets the job done.", LocalDate.now())); // Todou

        // Reviews for Product ID 2 - "Hex Dumbbell 7.5kg"
        reviewDB.save(new Review(2L, 7L, Rating.GOOD, "Feels good in the hand! I can feel my Saiyan strength increasing!", LocalDate.now())); // Goku
        reviewDB.save(new Review(2L, 9L, Rating.EXCELLENT, "Great quality. Perfect for the dungeon gym.", LocalDate.now())); // Bane
        reviewDB.save(new Review(2L, 8L, Rating.HORRIBLE, "Laughable. 7.5kg? My finger lifts more than this.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 3 - "Hex Dumbbell 10kg"
        reviewDB.save(new Review(3L, 4L, Rating.EXCELLENT, "Finally, something challenging. Good grip and balance.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(3L, 6L, Rating.SATISFACTORY, "It's okay, but I expected better padding on the handle.", LocalDate.now())); // Todou
        reviewDB.save(new Review(3L, 8L, Rating.POOR, "Even my shadow can lift this. Waste of my time.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 4 - "Hex Dumbbell 15kg"
        reviewDB.save(new Review(4L, 5L, Rating.GOOD, "Good weight for building strength, but could be more affordable.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(4L, 3L, Rating.EXCELLENT, "This is a warrior's dumbbell. Perfectly balanced and reliable.", LocalDate.now())); // Wamuu
        reviewDB.save(new Review(4L, 8L, Rating.POOR, "Still too light. When will this store sell real weights?", LocalDate.now())); // Yujiro

        // Reviews for Product ID 5 - "Olympic Barbell 20kg"
        reviewDB.save(new Review(5L, 7L, Rating.EXCELLENT, "This is great! Now I can push my limits even more!", LocalDate.now())); // Goku
        reviewDB.save(new Review(5L, 2L, Rating.GOOD, "Solid and durable. Just what I needed.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(5L, 8L, Rating.SATISFACTORY, "Decent. At least it's better than those baby dumbbells.", LocalDate.now())); // Yujiro
        reviewDB.save(new Review(5L, 10L, Rating.EXCELLENT, "*Wide Smile*", LocalDate.now())); // Big Raga

        // Reviews for Product ID 6 - "Olympic Barbell 15kg"
        reviewDB.save(new Review(6L, 6L, Rating.SATISFACTORY, "Good barbell, but feels a little overpriced.", LocalDate.now())); // Todou
        reviewDB.save(new Review(6L, 4L, Rating.GOOD, "Reliable and sturdy. Works well for my training.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(6L, 8L, Rating.POOR, "Pathetic. Is this supposed to impress anyone?", LocalDate.now())); // Yujiro

        // Reviews for Product ID 7 - "EZ Curl Barbell 10kg"
        reviewDB.save(new Review(7L, 9L, Rating.EXCELLENT, "Perfect for isolating arm muscles. Great design.", LocalDate.now())); // Bane
        reviewDB.save(new Review(7L, 5L, Rating.SATISFACTORY, "It's okay, but not as versatile as I hoped.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(7L, 8L, Rating.HORRIBLE, "Who even uses these? Embarrassing product.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 8 - "Weight Plate 2.5kg"
        reviewDB.save(new Review(8L, 2L, Rating.SATISFACTORY, "These are okay for light exercises, but not challenging enough.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(8L, 7L, Rating.EXCELLENT, "Great for warming up or as part of a bigger workout. I love it!", LocalDate.now())); // Goku
        reviewDB.save(new Review(8L, 3L, Rating.POOR, "This is practically a toy. I can lift this with one finger.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 9 - "Weight Plate 5kg"
        reviewDB.save(new Review(9L, 4L, Rating.EXCELLENT, "Perfect for adding extra weight during my sets. Durable and reliable.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(9L, 6L, Rating.SATISFACTORY, "Good product, but I feel like I could use something heavier.", LocalDate.now())); // Todou
        // Reviews for Product ID 10 - "Weight Plate 10kg"
        reviewDB.save(new Review(10L, 5L, Rating.EXCELLENT, "Solid weight. Ideal for intermediate training.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(10L, 9L, Rating.GOOD, "Nice balance, good quality, but I wish the price was lower.", LocalDate.now())); // Bane

        // Reviews for Product ID 11 - "Weight Plate 20kg"
        reviewDB.save(new Review(11L, 7L, Rating.GOOD, "Good weight plate, but it could be more compact for storage.", LocalDate.now())); // Goku
        reviewDB.save(new Review(11L, 4L, Rating.EXCELLENT, "Heavy duty and well-built. Exactly what I needed.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(11L, 8L, Rating.POOR, "Too light. Not worth the money. I need something heavier.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 12 - "Weighted Vest 5kg"
        reviewDB.save(new Review(12L, 6L, Rating.SATISFACTORY, "Not bad, but it could be a bit more comfortable during longer workouts.", LocalDate.now())); // Todou
        reviewDB.save(new Review(12L, 5L, Rating.EXCELLENT, "Great for adding intensity to my exercises. A solid piece of equipment.", LocalDate.now())); // Nolan

        // Reviews for Product ID 13 - "Weighted Vest 10kg"
        reviewDB.save(new Review(13L, 4L, Rating.EXCELLENT, "Perfect for strength training. Adds just the right amount of challenge.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(13L, 6L, Rating.SATISFACTORY, "Good for short workouts, but I wish it was more adjustable.", LocalDate.now())); // Todou
        reviewDB.save(new Review(13L, 10L, Rating.POOR, "*Angry Smile*", LocalDate.now())); // Big Raga
        // Reviews for Product ID 14 - "Weighted Vest 15kg"
        reviewDB.save(new Review(14L, 7L, Rating.GOOD, "This is a good vest for added resistance during training. I like it!", LocalDate.now())); // Goku
        reviewDB.save(new Review(14L, 2L, Rating.EXCELLENT, "Great vest, it really adds that extra push to my workout.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(14L, 8L, Rating.POOR, "This vest is not enough. I demand more. It's not a challenge for me.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 15 - "Weighted Ankle Cuffs 2kg"
        reviewDB.save(new Review(15L, 5L, Rating.SATISFACTORY, "Okay, but not much use for them in my routine.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(15L, 4L, Rating.EXCELLENT, "Great for ankle exercises. High-quality and comfortable.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(15L, 8L, Rating.POOR, "2kg? What a joke. Real ankle cuffs should weigh at least 10kg.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 16 - "Yoga Mat"
        reviewDB.save(new Review(16L, 2L, Rating.GOOD, "A good yoga mat. Not something I use, but it seems well made.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(16L, 6L, Rating.EXCELLENT, "Very durable, perfect for stretching and light yoga. Nice quality.", LocalDate.now())); // Todou
        reviewDB.save(new Review(2L, 10L, Rating.SATISFACTORY, "*Smile*", LocalDate.now())); // Big Raga

        // Reviews for Product ID 17 - "Premium Yoga Mat"
        reviewDB.save(new Review(17L, 7L, Rating.GOOD, "Comfortable and supportive. I used it for my warm-up stretches.", LocalDate.now())); // Goku
        reviewDB.save(new Review(17L, 4L, Rating.EXCELLENT, "Thick and durable. Perfect for a good stretch or light exercises.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(17L, 8L, Rating.POOR, "I don't need this.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 18 - "Travel Yoga Mat"
        reviewDB.save(new Review(18L, 6L, Rating.SATISFACTORY, "Good for travel, but I prefer a thicker mat for my usual routine.", LocalDate.now())); // Todou
        reviewDB.save(new Review(18L, 2L, Rating.GOOD, "Compact and easy to store. Great for on-the-go yoga!", LocalDate.now())); // Arnold
        reviewDB.save(new Review(18L, 8L, Rating.POOR, "This is the worst. Waste of time.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 19 - "Lifting Belt Medium"
        reviewDB.save(new Review(19L, 7L, Rating.GOOD, "A good, solid lifting belt. Not as comfortable as I expected, but it works.", LocalDate.now())); // Goku
        reviewDB.save(new Review(19L, 5L, Rating.EXCELLENT, "Perfect for added back support. I love the feel of it.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(19L, 8L, Rating.POOR, "I don't need a lifting belt. Real strength doesn't need support.", LocalDate.now())); // Yujiro

        // Reviews for Product ID 20 - "Lifting Belt Large"
        reviewDB.save(new Review(20L, 6L, Rating.SATISFACTORY, "Good size, but the quality could be improved.", LocalDate.now())); // Todou
        reviewDB.save(new Review(20L, 2L, Rating.EXCELLENT, "Great for heavy lifts. Gives me the confidence to push harder.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(20L, 10L, Rating.EXCELLENT, "*Wide Smile*", LocalDate.now())); // Big Raga

        // Reviews for Product ID 21 - "Grip Straps"
        reviewDB.save(new Review(21L, 4L, Rating.EXCELLENT, "A solid pair of grip straps. Makes my lifts easier and more secure.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(21L, 7L, Rating.GOOD, "Good straps for lifting, but I don’t need them all the time.", LocalDate.now())); // Goku

        // Reviews for Product ID 22 - "Lifting Gloves"
        reviewDB.save(new Review(22L, 5L, Rating.EXCELLENT, "Comfortable and padded. Perfect for long training sessions.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(22L, 7L, Rating.GOOD, "Nice gloves, but I prefer lifting without them when I can.", LocalDate.now())); // Goku
        reviewDB.save(new Review(22L, 8L, Rating.POOR, "Lifting gloves? Why don't you just lift with your bare hands?", LocalDate.now())); // yujiro

        // Reviews for product ID 23 - power rack
        reviewDB.save(new Review(23L, 2L, Rating.EXCELLENT, "Solid power rack, built to last. Perfect for advanced lifters like me.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(23L, 5L, Rating.EXCELLENT, "This power rack is a game changer for my home gym. Very sturdy and reliable.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(23L, 4L, Rating.GOOD, "Nice power rack, but it takes up quite a bit of space in my gym.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(23L, 7L, Rating.EXCELLENT, "This power rack is a beast! It’s very versatile for my heavy lifts.", LocalDate.now())); // Goku
        reviewDB.save(new Review(23L, 6L, Rating.SATISFACTORY, "Good quality, but it's a bit too large for my smaller workout space.", LocalDate.now())); // Todou
        //Reviews for Product ID 24 - Compact Power Rack

        reviewDB.save(new Review(24L, 4L, Rating.EXCELLENT, "Great compact power rack. Takes up less space but still very sturdy.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(24L, 5L, Rating.GOOD, "Nice rack for those with limited space. The quality is good for its size.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(24L, 2L, Rating.SATISFACTORY, "It’s compact, but it feels a bit flimsy compared to larger racks.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(24L, 6L, Rating.EXCELLENT, "Perfect for smaller gyms. It doesn’t compromise on quality despite its size.", LocalDate.now())); // Todou
        reviewDB.save(new Review(24L, 7L, Rating.GOOD, "Good power rack, but I prefer the larger versions for more versatility.", LocalDate.now())); // Goku

        //Reviews for Product ID 25 - Flat Bench

        reviewDB.save(new Review(25L, 7L, Rating.EXCELLENT, "Very sturdy flat bench. Perfect for bench presses and other exercises.", LocalDate.now())); // Goku
        reviewDB.save(new Review(25L, 2L, Rating.GOOD, "Good bench, but I prefer one with adjustable features for more versatility.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(25L, 5L, Rating.SATISFACTORY, "Decent bench. Does the job but could use a more comfortable cushion.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(25L, 6L, Rating.EXCELLENT, "I’ve used many benches, and this one’s one of the best for my bench presses.", LocalDate.now())); // Todou
        reviewDB.save(new Review(25L, 4L, Rating.GOOD, "A solid flat bench, but I need a bit more padding for comfort during long workouts.", LocalDate.now())); // The Rock

        //Reviews for Product ID 26 - Incline Bench

        reviewDB.save(new Review(26L, 4L, Rating.EXCELLENT, "Great incline bench. Adjustable and sturdy, perfect for my chest workouts.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(26L, 7L, Rating.GOOD, "Good incline bench, but it could have a wider range of incline settings.", LocalDate.now())); // Goku
        reviewDB.save(new Review(26L, 2L, Rating.SATISFACTORY, "Decent bench, but I prefer a more adjustable and robust one for heavy lifts.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(26L, 5L, Rating.EXCELLENT, "Perfect for targeting the upper chest. Very solid build.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(26L, 6L, Rating.GOOD, "Nice bench, but I wish the padding was a little firmer for added support.", LocalDate.now())); // Todou

        //Reviews for Product ID 27 - Adjustable Bench

        reviewDB.save(new Review(27L, 7L, Rating.EXCELLENT, "This adjustable bench is awesome! Perfect for all types of bench press variations.", LocalDate.now())); // Goku
        reviewDB.save(new Review(27L, 2L, Rating.GOOD, "Nice bench, but the adjustment mechanism could be smoother.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(27L, 6L, Rating.SATISFACTORY, "Good adjustable bench, but I prefer one with a more ergonomic design.", LocalDate.now())); // Todou
        reviewDB.save(new Review(27L, 5L, Rating.EXCELLENT, "Very versatile. I can use it for all kinds of exercises, not just bench presses.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(27L, 4L, Rating.GOOD, "Nice and sturdy, but it’s a bit bulky for my gym setup.", LocalDate.now())); // The Rock

        //Reviews for Product ID 28 - Lat Pulldown Machine

        reviewDB.save(new Review(28L, 4L, Rating.EXCELLENT, "Great lat pulldown machine! Very smooth movement and sturdy.", LocalDate.now())); // The Rock
        reviewDB.save(new Review(28L, 6L, Rating.GOOD, "Solid machine, but the range of motion could be improved for a smoother pull.", LocalDate.now())); // Todou
        reviewDB.save(new Review(28L, 2L, Rating.SATISFACTORY, "It’s okay, but I prefer more cable options and adjustments.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(28L, 5L, Rating.EXCELLENT, "Excellent quality for a lat pulldown machine. It feels like the ones at the gym.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(28L, 7L, Rating.GOOD, "Nice machine, but I prefer free-weight exercises for lat work.", LocalDate.now())); // Goku

        //Reviews for Product ID 29 - Leg Press Machine

        reviewDB.save(new Review(29L, 7L, Rating.EXCELLENT, "This leg press machine is fantastic! Great for building leg strength.", LocalDate.now())); // Goku
        reviewDB.save(new Review(29L, 5L, Rating.GOOD, "Nice machine, but I prefer other leg exercises like squats for more intensity.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(29L, 2L, Rating.SATISFACTORY, "It’s good, but I expected more range and smoother movement.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(29L, 6L, Rating.EXCELLENT, "Solid machine, very stable. Great for pushing my legs to the limit.", LocalDate.now())); // Todou
        reviewDB.save(new Review(29L, 4L, Rating.GOOD, "A solid leg press, but it takes up a lot of space.", LocalDate.now())); // The Rock

        //Reviews for Product ID 30 - Cable Crossover Machine

        reviewDB.save(new Review(30L, 5L, Rating.EXCELLENT, "This cable crossover machine is amazing! It's so versatile for my workouts.", LocalDate.now())); // Nolan
        reviewDB.save(new Review(30L, 2L, Rating.GOOD, "Good machine, but it’s a bit bulky for my smaller home gym.", LocalDate.now())); // Arnold
        reviewDB.save(new Review(30L, 7L, Rating.EXCELLENT, "A must-have for any serious home gym. I use it daily for a variety of exercises.", LocalDate.now())); // Goku
        reviewDB.save(new Review(30L, 6L, Rating.GOOD, "This machine is useful, but I prefer machines with more features.", LocalDate.now())); // Todou
        reviewDB.save(new Review(30L, 4L, Rating.SATISFACTORY, "Nice machine, but I prefer cable machines with more adjustable settings.", LocalDate.now())); // The Rock

        // random data
        reviewDB.save(new Review(45L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 27)));
        reviewDB.save(new Review(65L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 6)));
        reviewDB.save(new Review(53L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 17)));
        reviewDB.save(new Review(69L, 32L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 4, 11)));
        reviewDB.save(new Review(67L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 30)));
        reviewDB.save(new Review(49L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 19)));
        reviewDB.save(new Review(63L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 27)));
        reviewDB.save(new Review(75L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 6)));
        reviewDB.save(new Review(51L, 35L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 17)));
        reviewDB.save(new Review(47L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 20)));
        reviewDB.save(new Review(17L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 17)));
        reviewDB.save(new Review(24L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(62L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 16)));
        reviewDB.save(new Review(10L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 4)));
        reviewDB.save(new Review(44L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 25)));
        reviewDB.save(new Review(57L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 29)));
        reviewDB.save(new Review(75L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 23)));
        reviewDB.save(new Review(38L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 25)));
        reviewDB.save(new Review(17L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 6)));
        reviewDB.save(new Review(64L, 18L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 3, 26)));
        reviewDB.save(new Review(35L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 3)));
        reviewDB.save(new Review(5L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(31L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 5)));
        reviewDB.save(new Review(64L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(72L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 2)));
        reviewDB.save(new Review(38L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 30)));
        reviewDB.save(new Review(6L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 28)));
        reviewDB.save(new Review(41L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 9)));
        reviewDB.save(new Review(33L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 21)));
        reviewDB.save(new Review(49L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 23)));
        reviewDB.save(new Review(66L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 24)));
        reviewDB.save(new Review(40L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 8)));
        reviewDB.save(new Review(20L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 23)));
        reviewDB.save(new Review(55L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 9)));
        reviewDB.save(new Review(10L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 20)));
        reviewDB.save(new Review(1L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 25)));
        reviewDB.save(new Review(19L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 2)));
        reviewDB.save(new Review(29L, 18L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 25)));
        reviewDB.save(new Review(68L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(66L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 28)));
        reviewDB.save(new Review(32L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 16)));
        reviewDB.save(new Review(52L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 18)));
        reviewDB.save(new Review(8L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 31)));
        reviewDB.save(new Review(77L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 3)));
        reviewDB.save(new Review(18L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 31)));
        reviewDB.save(new Review(22L, 23L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 19)));
        reviewDB.save(new Review(73L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 15)));
        reviewDB.save(new Review(32L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 22)));
        reviewDB.save(new Review(15L, 25L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 4, 25)));
        reviewDB.save(new Review(7L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 14)));
        reviewDB.save(new Review(57L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 31)));
        reviewDB.save(new Review(70L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 24)));
        reviewDB.save(new Review(75L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(8L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 15)));
        reviewDB.save(new Review(77L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 27)));
        reviewDB.save(new Review(50L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 19)));
        reviewDB.save(new Review(2L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 20)));
        reviewDB.save(new Review(19L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(26L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 8)));
        reviewDB.save(new Review(36L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 27)));
        reviewDB.save(new Review(2L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 23)));
        reviewDB.save(new Review(51L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 27)));
        reviewDB.save(new Review(59L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 3)));
        reviewDB.save(new Review(33L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 16)));
        reviewDB.save(new Review(48L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(50L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 26)));
        reviewDB.save(new Review(47L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 10)));
        reviewDB.save(new Review(37L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 26)));
        reviewDB.save(new Review(8L, 34L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 1, 1)));
        reviewDB.save(new Review(74L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 13)));
        reviewDB.save(new Review(41L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 2)));
        reviewDB.save(new Review(2L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 28)));
        reviewDB.save(new Review(72L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 31)));
        reviewDB.save(new Review(62L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 2, 26)));
        reviewDB.save(new Review(75L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 16)));
        reviewDB.save(new Review(13L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(56L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 13)));
        reviewDB.save(new Review(42L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(12L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 28)));
        reviewDB.save(new Review(34L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 21)));
        reviewDB.save(new Review(16L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(47L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 23)));
        reviewDB.save(new Review(47L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 17)));
        reviewDB.save(new Review(53L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 29)));
        reviewDB.save(new Review(67L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 25)));
        reviewDB.save(new Review(39L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 19)));
        reviewDB.save(new Review(67L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 18)));
        reviewDB.save(new Review(74L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 23)));
        reviewDB.save(new Review(76L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 10)));
        reviewDB.save(new Review(34L, 36L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(12L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 26)));
        reviewDB.save(new Review(52L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 23)));
        reviewDB.save(new Review(48L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(28L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 8)));
        reviewDB.save(new Review(49L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 23)));
        reviewDB.save(new Review(71L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 9)));
        reviewDB.save(new Review(18L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 23)));
        reviewDB.save(new Review(20L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 27)));
        reviewDB.save(new Review(76L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(22L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 11)));
        reviewDB.save(new Review(52L, 34L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 3, 7)));
        reviewDB.save(new Review(51L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 24)));
        reviewDB.save(new Review(58L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(28L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 5)));
        reviewDB.save(new Review(41L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 8)));
        reviewDB.save(new Review(22L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 9)));
        reviewDB.save(new Review(34L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 12)));
        reviewDB.save(new Review(28L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 23)));
        reviewDB.save(new Review(25L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(12L, 25L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 9, 2)));
        reviewDB.save(new Review(38L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 20)));
        reviewDB.save(new Review(18L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 12)));
        reviewDB.save(new Review(6L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(38L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 25)));
        reviewDB.save(new Review(66L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 7)));
        reviewDB.save(new Review(3L, 32L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(78L, 35L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 23)));
        reviewDB.save(new Review(5L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 29)));
        reviewDB.save(new Review(47L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 19)));
        reviewDB.save(new Review(75L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 15)));
        reviewDB.save(new Review(2L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(44L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 27)));
        reviewDB.save(new Review(78L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 11)));
        reviewDB.save(new Review(73L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 11)));
        reviewDB.save(new Review(25L, 21L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 4)));
        reviewDB.save(new Review(60L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 4)));
        reviewDB.save(new Review(75L, 25L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 3, 27)));
        reviewDB.save(new Review(71L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 29)));
        reviewDB.save(new Review(35L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 26)));
        reviewDB.save(new Review(50L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 23)));
        reviewDB.save(new Review(47L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(6L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 4)));
        reviewDB.save(new Review(59L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 29)));
        reviewDB.save(new Review(16L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 7)));
        reviewDB.save(new Review(36L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 9)));
        reviewDB.save(new Review(56L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 18)));
        reviewDB.save(new Review(12L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 16)));
        reviewDB.save(new Review(3L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 31)));
        reviewDB.save(new Review(68L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(40L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 17)));
        reviewDB.save(new Review(1L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(46L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 18)));
        reviewDB.save(new Review(18L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 20)));
        reviewDB.save(new Review(34L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 1)));
        reviewDB.save(new Review(18L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 14)));
        reviewDB.save(new Review(24L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(19L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 10)));
        reviewDB.save(new Review(35L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 6)));
        reviewDB.save(new Review(64L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 14)));
        reviewDB.save(new Review(28L, 16L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 23)));
        reviewDB.save(new Review(58L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 18)));
        reviewDB.save(new Review(45L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 1)));
        reviewDB.save(new Review(61L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(33L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 7)));
        reviewDB.save(new Review(23L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 21)));
        reviewDB.save(new Review(36L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(62L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 3)));
        reviewDB.save(new Review(28L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(12L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 19)));
        reviewDB.save(new Review(14L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 1)));
        reviewDB.save(new Review(36L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 17)));
        reviewDB.save(new Review(68L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(38L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(38L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 3)));
        reviewDB.save(new Review(60L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 25)));
        reviewDB.save(new Review(26L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 19)));
        reviewDB.save(new Review(55L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 6)));
        reviewDB.save(new Review(26L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 25)));
        reviewDB.save(new Review(7L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 19)));
        reviewDB.save(new Review(73L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 14)));
        reviewDB.save(new Review(54L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 15)));
        reviewDB.save(new Review(31L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 16)));
        reviewDB.save(new Review(5L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 29)));
        reviewDB.save(new Review(47L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 21)));
        reviewDB.save(new Review(7L, 35L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 3, 16)));
        reviewDB.save(new Review(32L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(63L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 9)));
        reviewDB.save(new Review(39L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(62L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 1)));
        reviewDB.save(new Review(36L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 11)));
        reviewDB.save(new Review(44L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 12)));
        reviewDB.save(new Review(8L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 18)));
        reviewDB.save(new Review(65L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(67L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 18)));
        reviewDB.save(new Review(74L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 9)));
        reviewDB.save(new Review(15L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 25)));
        reviewDB.save(new Review(33L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 26)));
        reviewDB.save(new Review(65L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 6)));
        reviewDB.save(new Review(73L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(45L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 25)));
        reviewDB.save(new Review(24L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 2)));
        reviewDB.save(new Review(64L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 26)));
        reviewDB.save(new Review(12L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 1)));
        reviewDB.save(new Review(20L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 29)));
        reviewDB.save(new Review(12L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 24)));
        reviewDB.save(new Review(50L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 19)));
        reviewDB.save(new Review(12L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 12)));
        reviewDB.save(new Review(65L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 17)));
        reviewDB.save(new Review(5L, 32L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 11)));
        reviewDB.save(new Review(34L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 23)));
        reviewDB.save(new Review(33L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 13)));
        reviewDB.save(new Review(10L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 17)));
        reviewDB.save(new Review(55L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 20)));
        reviewDB.save(new Review(51L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 24)));
        reviewDB.save(new Review(3L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 13)));
        reviewDB.save(new Review(72L, 22L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 8)));
        reviewDB.save(new Review(31L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 4)));
        reviewDB.save(new Review(6L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 17)));
        reviewDB.save(new Review(7L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 5)));
        reviewDB.save(new Review(17L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(22L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 10)));
        reviewDB.save(new Review(77L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 18)));
        reviewDB.save(new Review(3L, 28L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(66L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 21)));
        reviewDB.save(new Review(32L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 31)));
        reviewDB.save(new Review(7L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 7)));
        reviewDB.save(new Review(59L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(56L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 15)));
        reviewDB.save(new Review(1L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(68L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 11)));
        reviewDB.save(new Review(68L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 6)));
        reviewDB.save(new Review(56L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(34L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 11)));
        reviewDB.save(new Review(54L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 30)));
        reviewDB.save(new Review(73L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 6)));
        reviewDB.save(new Review(41L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 17)));
        reviewDB.save(new Review(15L, 21L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 12, 3)));
        reviewDB.save(new Review(37L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 29)));
        reviewDB.save(new Review(53L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 15)));
        reviewDB.save(new Review(29L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 27)));
        reviewDB.save(new Review(9L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 16)));
        reviewDB.save(new Review(10L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(17L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(58L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 17)));
        reviewDB.save(new Review(7L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 22)));
        reviewDB.save(new Review(73L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 2)));
        reviewDB.save(new Review(71L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 11)));
        reviewDB.save(new Review(50L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 14)));
        reviewDB.save(new Review(26L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 23)));
        reviewDB.save(new Review(31L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 17)));
        reviewDB.save(new Review(58L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 21)));
        reviewDB.save(new Review(65L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 19)));
        reviewDB.save(new Review(18L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 7)));
        reviewDB.save(new Review(10L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(23L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 8)));
        reviewDB.save(new Review(24L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 17)));
        reviewDB.save(new Review(38L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 26)));
        reviewDB.save(new Review(43L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 20)));
        reviewDB.save(new Review(41L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 26)));
        reviewDB.save(new Review(1L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 20)));
        reviewDB.save(new Review(74L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 5)));
        reviewDB.save(new Review(51L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 4)));
        reviewDB.save(new Review(18L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 19)));
        reviewDB.save(new Review(75L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 11)));
        reviewDB.save(new Review(70L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 29)));
        reviewDB.save(new Review(18L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(70L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 15)));
        reviewDB.save(new Review(3L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 31)));
        reviewDB.save(new Review(60L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 11)));
        reviewDB.save(new Review(29L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 15)));
        reviewDB.save(new Review(56L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 5)));
        reviewDB.save(new Review(59L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 6)));
        reviewDB.save(new Review(17L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 12)));
        reviewDB.save(new Review(64L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 23)));
        reviewDB.save(new Review(24L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 31)));
        reviewDB.save(new Review(73L, 34L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2023, 12, 16)));
        reviewDB.save(new Review(46L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 14)));
        reviewDB.save(new Review(44L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 4)));
        reviewDB.save(new Review(37L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(57L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 9)));
        reviewDB.save(new Review(53L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 28)));
        reviewDB.save(new Review(17L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(26L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 29)));
        reviewDB.save(new Review(57L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(17L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(24L, 22L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 6)));
        reviewDB.save(new Review(30L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 13)));
        reviewDB.save(new Review(75L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 10)));
        reviewDB.save(new Review(18L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 23)));
        reviewDB.save(new Review(20L, 36L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 9, 14)));
        reviewDB.save(new Review(18L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 1)));
        reviewDB.save(new Review(64L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(76L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 2)));
        reviewDB.save(new Review(62L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 26)));
        reviewDB.save(new Review(9L, 24L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 3, 2)));
        reviewDB.save(new Review(2L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 20)));
        reviewDB.save(new Review(13L, 16L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 12)));
        reviewDB.save(new Review(35L, 36L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 11)));
        reviewDB.save(new Review(35L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 2)));
        reviewDB.save(new Review(61L, 33L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(55L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 23)));
        reviewDB.save(new Review(28L, 19L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 25)));
        reviewDB.save(new Review(38L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 9)));
        reviewDB.save(new Review(13L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 28)));
        reviewDB.save(new Review(61L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 22)));
        reviewDB.save(new Review(68L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 24)));
        reviewDB.save(new Review(73L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 18)));
        reviewDB.save(new Review(14L, 16L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 4, 17)));
        reviewDB.save(new Review(69L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 25)));
        reviewDB.save(new Review(47L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(10L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 12)));
        reviewDB.save(new Review(34L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(55L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 26)));
        reviewDB.save(new Review(78L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 16)));
        reviewDB.save(new Review(12L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 26)));
        reviewDB.save(new Review(70L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 15)));
        reviewDB.save(new Review(17L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 23)));
        reviewDB.save(new Review(42L, 35L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 2, 3)));
        reviewDB.save(new Review(56L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 7)));
        reviewDB.save(new Review(16L, 33L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 5, 30)));
        reviewDB.save(new Review(70L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 27)));
        reviewDB.save(new Review(40L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 11)));
        reviewDB.save(new Review(78L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(29L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 18)));
        reviewDB.save(new Review(43L, 36L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(20L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 8)));
        reviewDB.save(new Review(14L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 5)));
        reviewDB.save(new Review(8L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 27)));
        reviewDB.save(new Review(29L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 20)));
        reviewDB.save(new Review(48L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 26)));
        reviewDB.save(new Review(40L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 25)));
        reviewDB.save(new Review(46L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 10)));
        reviewDB.save(new Review(68L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 15)));
        reviewDB.save(new Review(31L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 30)));
        reviewDB.save(new Review(19L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(63L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 24)));
        reviewDB.save(new Review(12L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 8)));
        reviewDB.save(new Review(77L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 12)));
        reviewDB.save(new Review(77L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(11L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 2)));
        reviewDB.save(new Review(24L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 7)));
        reviewDB.save(new Review(57L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 6)));
        reviewDB.save(new Review(70L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 8)));
        reviewDB.save(new Review(3L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 17)));
        reviewDB.save(new Review(9L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 11)));
        reviewDB.save(new Review(60L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 16)));
        reviewDB.save(new Review(8L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 12)));
        reviewDB.save(new Review(60L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 30)));
        reviewDB.save(new Review(61L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 4)));
        reviewDB.save(new Review(34L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(19L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 6)));
        reviewDB.save(new Review(20L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 24)));
        reviewDB.save(new Review(32L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 17)));
        reviewDB.save(new Review(63L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(58L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 30)));
        reviewDB.save(new Review(11L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 7)));
        reviewDB.save(new Review(52L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 30)));
        reviewDB.save(new Review(30L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 21)));
        reviewDB.save(new Review(10L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 17)));
        reviewDB.save(new Review(30L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 21)));
        reviewDB.save(new Review(40L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 21)));
        reviewDB.save(new Review(39L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(66L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 18)));
        reviewDB.save(new Review(8L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 2)));
        reviewDB.save(new Review(12L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 20)));
        reviewDB.save(new Review(11L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(67L, 31L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 10, 1)));
        reviewDB.save(new Review(68L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 25)));
        reviewDB.save(new Review(78L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 11)));
        reviewDB.save(new Review(1L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 6)));
        reviewDB.save(new Review(65L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 7)));
        reviewDB.save(new Review(72L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 5)));
        reviewDB.save(new Review(14L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 29)));
        reviewDB.save(new Review(9L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 15)));
        reviewDB.save(new Review(38L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 15)));
        reviewDB.save(new Review(7L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(66L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 2)));
        reviewDB.save(new Review(62L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 5)));
        reviewDB.save(new Review(51L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 11)));
        reviewDB.save(new Review(26L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 13)));
        reviewDB.save(new Review(24L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 4)));
        reviewDB.save(new Review(62L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 15)));
        reviewDB.save(new Review(61L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 24)));
        reviewDB.save(new Review(62L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 11)));
        reviewDB.save(new Review(1L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(17L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 15)));
        reviewDB.save(new Review(60L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 18)));
        reviewDB.save(new Review(60L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 27)));
        reviewDB.save(new Review(78L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 1)));
        reviewDB.save(new Review(49L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 24)));
        reviewDB.save(new Review(49L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(11L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 29)));
        reviewDB.save(new Review(61L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 8)));
        reviewDB.save(new Review(20L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 26)));
        reviewDB.save(new Review(60L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 8)));
        reviewDB.save(new Review(49L, 26L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 5, 22)));
        reviewDB.save(new Review(52L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 3)));
        reviewDB.save(new Review(70L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(46L, 26L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 31)));
        reviewDB.save(new Review(50L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 11)));
        reviewDB.save(new Review(34L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 18)));
        reviewDB.save(new Review(38L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 13)));
        reviewDB.save(new Review(43L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 11)));
        reviewDB.save(new Review(16L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(15L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 16)));
        reviewDB.save(new Review(34L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 24)));
        reviewDB.save(new Review(38L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 7)));
        reviewDB.save(new Review(49L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 25)));
        reviewDB.save(new Review(16L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 4)));
        reviewDB.save(new Review(70L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 10)));
        reviewDB.save(new Review(52L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 27)));
        reviewDB.save(new Review(64L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 18)));
        reviewDB.save(new Review(45L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 20)));
        reviewDB.save(new Review(60L, 24L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 6, 15)));
        reviewDB.save(new Review(38L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 8)));
        reviewDB.save(new Review(68L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 2)));
        reviewDB.save(new Review(57L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 23)));
        reviewDB.save(new Review(73L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 13)));
        reviewDB.save(new Review(30L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 23)));
        reviewDB.save(new Review(61L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 18)));
        reviewDB.save(new Review(50L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 17)));
        reviewDB.save(new Review(56L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(52L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 13)));
        reviewDB.save(new Review(58L, 35L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 9, 13)));
        reviewDB.save(new Review(49L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 18)));
        reviewDB.save(new Review(8L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 6)));
        reviewDB.save(new Review(67L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 1)));
        reviewDB.save(new Review(62L, 23L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 12, 1)));
        reviewDB.save(new Review(53L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 16)));
        reviewDB.save(new Review(20L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 11)));
        reviewDB.save(new Review(23L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 25)));
        reviewDB.save(new Review(48L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 2)));
        reviewDB.save(new Review(14L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 26)));
        reviewDB.save(new Review(51L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 5)));
        reviewDB.save(new Review(78L, 21L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 9)));
        reviewDB.save(new Review(19L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 28)));
        reviewDB.save(new Review(66L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 14)));
        reviewDB.save(new Review(58L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 11)));
        reviewDB.save(new Review(63L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 14)));
        reviewDB.save(new Review(27L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 22)));
        reviewDB.save(new Review(36L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(49L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 5)));
        reviewDB.save(new Review(22L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 21)));
        reviewDB.save(new Review(34L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 9)));
        reviewDB.save(new Review(61L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 27)));
        reviewDB.save(new Review(18L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 27)));
        reviewDB.save(new Review(54L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 18)));
        reviewDB.save(new Review(12L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 5)));
        reviewDB.save(new Review(36L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 7)));
        reviewDB.save(new Review(17L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 25)));
        reviewDB.save(new Review(46L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 17)));
        reviewDB.save(new Review(20L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 4)));
        reviewDB.save(new Review(70L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 18)));
        reviewDB.save(new Review(78L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 4, 7)));
        reviewDB.save(new Review(64L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 21)));
        reviewDB.save(new Review(11L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(38L, 26L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 6)));
        reviewDB.save(new Review(24L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 10)));
        reviewDB.save(new Review(49L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 29)));
        reviewDB.save(new Review(3L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 10)));
        reviewDB.save(new Review(77L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 7)));
        reviewDB.save(new Review(9L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 27)));
        reviewDB.save(new Review(37L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 3)));
        reviewDB.save(new Review(5L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 4)));
        reviewDB.save(new Review(1L, 30L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 8, 27)));
        reviewDB.save(new Review(46L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 19)));
        reviewDB.save(new Review(34L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 26)));
        reviewDB.save(new Review(64L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(32L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 23)));
        reviewDB.save(new Review(55L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 15)));
        reviewDB.save(new Review(22L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 12)));
        reviewDB.save(new Review(32L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 19)));
        reviewDB.save(new Review(17L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(74L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(10L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 6)));
        reviewDB.save(new Review(13L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 12)));
        reviewDB.save(new Review(75L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(44L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(52L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 10)));
        reviewDB.save(new Review(49L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 19)));
        reviewDB.save(new Review(7L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(4L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 23)));
        reviewDB.save(new Review(41L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 17)));
        reviewDB.save(new Review(77L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 8)));
        reviewDB.save(new Review(25L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(16L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 5)));
        reviewDB.save(new Review(9L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 15)));
        reviewDB.save(new Review(9L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(28L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(66L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 4)));
        reviewDB.save(new Review(68L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 25)));
        reviewDB.save(new Review(43L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 27)));
        reviewDB.save(new Review(65L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 7)));
        reviewDB.save(new Review(59L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 20)));
        reviewDB.save(new Review(17L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 31)));
        reviewDB.save(new Review(72L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(63L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 30)));
        reviewDB.save(new Review(60L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 3)));
        reviewDB.save(new Review(5L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(36L, 19L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 10)));
        reviewDB.save(new Review(22L, 21L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 24)));
        reviewDB.save(new Review(26L, 32L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(70L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 7)));
        reviewDB.save(new Review(25L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 2)));
        reviewDB.save(new Review(32L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 9)));
        reviewDB.save(new Review(66L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 1)));
        reviewDB.save(new Review(77L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 23)));
        reviewDB.save(new Review(27L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 16)));
        reviewDB.save(new Review(36L, 25L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 11)));
        reviewDB.save(new Review(49L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 4)));
        reviewDB.save(new Review(78L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 1)));
        reviewDB.save(new Review(60L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 21)));
        reviewDB.save(new Review(5L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 1)));
        reviewDB.save(new Review(37L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 27)));
        reviewDB.save(new Review(8L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 13)));
        reviewDB.save(new Review(9L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 7)));
        reviewDB.save(new Review(68L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(34L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 12, 2)));
        reviewDB.save(new Review(13L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 16)));
        reviewDB.save(new Review(13L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 4)));
        reviewDB.save(new Review(62L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 3)));
        reviewDB.save(new Review(28L, 31L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 2, 22)));
        reviewDB.save(new Review(67L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 17)));
        reviewDB.save(new Review(53L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 22)));
        reviewDB.save(new Review(39L, 34L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 12)));
        reviewDB.save(new Review(31L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 14)));
        reviewDB.save(new Review(61L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 16)));
        reviewDB.save(new Review(23L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 21)));
        reviewDB.save(new Review(39L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 4)));
        reviewDB.save(new Review(64L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(57L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 28)));
        reviewDB.save(new Review(35L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 20)));
        reviewDB.save(new Review(42L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 16)));
        reviewDB.save(new Review(41L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 17)));
        reviewDB.save(new Review(53L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 20)));
        reviewDB.save(new Review(36L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 15)));
        reviewDB.save(new Review(61L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 2)));
        reviewDB.save(new Review(49L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 18)));
        reviewDB.save(new Review(75L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(69L, 20L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 19)));
        reviewDB.save(new Review(71L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 30)));
        reviewDB.save(new Review(19L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 11)));
        reviewDB.save(new Review(11L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 1)));
        reviewDB.save(new Review(4L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 15)));
        reviewDB.save(new Review(78L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 7)));
        reviewDB.save(new Review(20L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 14)));
        reviewDB.save(new Review(8L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(28L, 29L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(32L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 5)));
        reviewDB.save(new Review(70L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 28)));
        reviewDB.save(new Review(39L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 20)));
        reviewDB.save(new Review(31L, 20L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 11)));
        reviewDB.save(new Review(30L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 23)));
        reviewDB.save(new Review(1L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 21)));
        reviewDB.save(new Review(54L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(66L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 23)));
        reviewDB.save(new Review(29L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 8)));
        reviewDB.save(new Review(58L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 26)));
        reviewDB.save(new Review(15L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(74L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 30)));
        reviewDB.save(new Review(37L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 17)));
        reviewDB.save(new Review(39L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 29)));
        reviewDB.save(new Review(73L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 22)));
        reviewDB.save(new Review(24L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 20)));
        reviewDB.save(new Review(45L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 27)));
        reviewDB.save(new Review(58L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 26)));
        reviewDB.save(new Review(7L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 16)));
        reviewDB.save(new Review(8L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 15)));
        reviewDB.save(new Review(45L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 31)));
        reviewDB.save(new Review(37L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 3)));
        reviewDB.save(new Review(51L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 2)));
        reviewDB.save(new Review(29L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(14L, 25L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 29)));
        reviewDB.save(new Review(27L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 30)));
        reviewDB.save(new Review(42L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 11)));
        reviewDB.save(new Review(46L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(56L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 4)));
        reviewDB.save(new Review(2L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 27)));
        reviewDB.save(new Review(17L, 33L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 2, 1)));
        reviewDB.save(new Review(18L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 16)));
        reviewDB.save(new Review(49L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 13)));
        reviewDB.save(new Review(11L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 24)));
        reviewDB.save(new Review(11L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 2)));
        reviewDB.save(new Review(23L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 28)));
        reviewDB.save(new Review(25L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 7)));
        reviewDB.save(new Review(42L, 26L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 4, 24)));
        reviewDB.save(new Review(62L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 5)));
        reviewDB.save(new Review(3L, 34L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 27)));
        reviewDB.save(new Review(26L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 11)));
        reviewDB.save(new Review(15L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(66L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 10)));
        reviewDB.save(new Review(25L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 13)));
        reviewDB.save(new Review(21L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 2)));
        reviewDB.save(new Review(77L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 17)));
        reviewDB.save(new Review(20L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 27)));
        reviewDB.save(new Review(40L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 25)));
        reviewDB.save(new Review(53L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 24)));
        reviewDB.save(new Review(56L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(14L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 25)));
        reviewDB.save(new Review(54L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 16)));
        reviewDB.save(new Review(71L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 2)));
        reviewDB.save(new Review(62L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 5)));
        reviewDB.save(new Review(25L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 2)));
        reviewDB.save(new Review(23L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 11)));
        reviewDB.save(new Review(34L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 28)));
        reviewDB.save(new Review(29L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 19)));
        reviewDB.save(new Review(28L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 29)));
        reviewDB.save(new Review(13L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(28L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 26)));
        reviewDB.save(new Review(41L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 2)));
        reviewDB.save(new Review(3L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 19)));
        reviewDB.save(new Review(47L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 29)));
        reviewDB.save(new Review(77L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(29L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(49L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 26)));
        reviewDB.save(new Review(20L, 26L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 7, 8)));
        reviewDB.save(new Review(33L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 16)));
        reviewDB.save(new Review(59L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 15)));
        reviewDB.save(new Review(35L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(50L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 9)));
        reviewDB.save(new Review(33L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 5)));
        reviewDB.save(new Review(11L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 12)));
        reviewDB.save(new Review(9L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 16)));
        reviewDB.save(new Review(49L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 26)));
        reviewDB.save(new Review(67L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 25)));
        reviewDB.save(new Review(28L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 13)));
        reviewDB.save(new Review(50L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 1)));
        reviewDB.save(new Review(36L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 26)));
        reviewDB.save(new Review(58L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(41L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(40L, 36L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 18)));
        reviewDB.save(new Review(25L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 6)));
        reviewDB.save(new Review(4L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 7)));
        reviewDB.save(new Review(12L, 35L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 4, 5)));
        reviewDB.save(new Review(41L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 31)));
        reviewDB.save(new Review(19L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 23)));
        reviewDB.save(new Review(21L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(53L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 7)));
        reviewDB.save(new Review(24L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 19)));
        reviewDB.save(new Review(33L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 16)));
        reviewDB.save(new Review(35L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 1)));
        reviewDB.save(new Review(47L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 28)));
        reviewDB.save(new Review(39L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 19)));
        reviewDB.save(new Review(19L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 22)));
        reviewDB.save(new Review(44L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 20)));
        reviewDB.save(new Review(73L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 3)));
        reviewDB.save(new Review(74L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 10)));
        reviewDB.save(new Review(31L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 9)));
        reviewDB.save(new Review(51L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 1, 19)));
        reviewDB.save(new Review(34L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 16)));
        reviewDB.save(new Review(66L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(32L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 8)));
        reviewDB.save(new Review(29L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 3)));
        reviewDB.save(new Review(15L, 20L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 8, 30)));
        reviewDB.save(new Review(49L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 20)));
        reviewDB.save(new Review(71L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 3)));
        reviewDB.save(new Review(77L, 36L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 19)));
        reviewDB.save(new Review(74L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 12)));
        reviewDB.save(new Review(34L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 12, 1)));
        reviewDB.save(new Review(69L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 31)));
        reviewDB.save(new Review(29L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 7)));
        reviewDB.save(new Review(27L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 2)));
        reviewDB.save(new Review(56L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(7L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 1)));
        reviewDB.save(new Review(57L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 3)));
        reviewDB.save(new Review(40L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 10)));
        reviewDB.save(new Review(59L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(11L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 21)));
        reviewDB.save(new Review(50L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 10)));
        reviewDB.save(new Review(48L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 11)));
        reviewDB.save(new Review(60L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 20)));
        reviewDB.save(new Review(50L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 25)));
        reviewDB.save(new Review(33L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 1)));
        reviewDB.save(new Review(30L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 7)));
        reviewDB.save(new Review(1L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 25)));
        reviewDB.save(new Review(71L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(5L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 17)));
        reviewDB.save(new Review(22L, 34L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 10)));
        reviewDB.save(new Review(58L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 13)));
        reviewDB.save(new Review(51L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 7)));
        reviewDB.save(new Review(6L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 19)));
        reviewDB.save(new Review(76L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 6)));
        reviewDB.save(new Review(71L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 5)));
        reviewDB.save(new Review(31L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 15)));
        reviewDB.save(new Review(46L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 29)));
        reviewDB.save(new Review(74L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 7)));
        reviewDB.save(new Review(11L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 8)));
        reviewDB.save(new Review(47L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 28)));
        reviewDB.save(new Review(63L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 30)));
        reviewDB.save(new Review(73L, 22L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(68L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 9)));
        reviewDB.save(new Review(52L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(59L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 26)));
        reviewDB.save(new Review(38L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 10)));
        reviewDB.save(new Review(39L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 10)));
        reviewDB.save(new Review(44L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(14L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 12)));
        reviewDB.save(new Review(76L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 17)));
        reviewDB.save(new Review(72L, 33L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(15L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 16)));
        reviewDB.save(new Review(21L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 30)));
        reviewDB.save(new Review(7L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 6)));
        reviewDB.save(new Review(4L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 24)));
        reviewDB.save(new Review(74L, 23L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 22)));
        reviewDB.save(new Review(71L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 2)));
        reviewDB.save(new Review(70L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 21)));
        reviewDB.save(new Review(50L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(6L, 27L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 20)));
        reviewDB.save(new Review(14L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(18L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 20)));
        reviewDB.save(new Review(33L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 16)));
        reviewDB.save(new Review(22L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 1)));
        reviewDB.save(new Review(1L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 31)));
        reviewDB.save(new Review(55L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 17)));
        reviewDB.save(new Review(68L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 21)));
        reviewDB.save(new Review(10L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 29)));
        reviewDB.save(new Review(70L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 29)));
        reviewDB.save(new Review(1L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 11)));
        reviewDB.save(new Review(77L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 8)));
        reviewDB.save(new Review(72L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 18)));
        reviewDB.save(new Review(54L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 27)));
        reviewDB.save(new Review(15L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 31)));
        reviewDB.save(new Review(61L, 18L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 3, 15)));
        reviewDB.save(new Review(49L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 1)));
        reviewDB.save(new Review(63L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(44L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 3)));
        reviewDB.save(new Review(78L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 8)));
        reviewDB.save(new Review(62L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 8)));
        reviewDB.save(new Review(19L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 14)));
        reviewDB.save(new Review(67L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 30)));
        reviewDB.save(new Review(18L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(27L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 24)));
        reviewDB.save(new Review(73L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(40L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 8)));
        reviewDB.save(new Review(59L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 9)));
        reviewDB.save(new Review(30L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 21)));
        reviewDB.save(new Review(3L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 6)));
        reviewDB.save(new Review(2L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 21)));
        reviewDB.save(new Review(34L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 19)));
        reviewDB.save(new Review(45L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 13)));
        reviewDB.save(new Review(12L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 21)));
        reviewDB.save(new Review(18L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 25)));
        reviewDB.save(new Review(72L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 21)));
        reviewDB.save(new Review(50L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 1)));
        reviewDB.save(new Review(20L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 19)));
        reviewDB.save(new Review(9L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(9L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 5)));
        reviewDB.save(new Review(7L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 18)));
        reviewDB.save(new Review(17L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 13)));
        reviewDB.save(new Review(53L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(5L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 14)));
        reviewDB.save(new Review(46L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 20)));
        reviewDB.save(new Review(76L, 35L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 5)));
        reviewDB.save(new Review(78L, 20L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 11, 15)));
        reviewDB.save(new Review(65L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 8)));
        reviewDB.save(new Review(50L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 19)));
        reviewDB.save(new Review(28L, 20L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 6, 24)));
        reviewDB.save(new Review(40L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 16)));
        reviewDB.save(new Review(67L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 19)));
        reviewDB.save(new Review(13L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 18)));
        reviewDB.save(new Review(8L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 3)));
        reviewDB.save(new Review(42L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 6)));
        reviewDB.save(new Review(1L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 21)));
        reviewDB.save(new Review(24L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 15)));
        reviewDB.save(new Review(6L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 3)));
        reviewDB.save(new Review(27L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 28)));
        reviewDB.save(new Review(23L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 3)));
        reviewDB.save(new Review(36L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 17)));
        reviewDB.save(new Review(63L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 25)));
        reviewDB.save(new Review(31L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 9)));
        reviewDB.save(new Review(55L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(56L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 17)));
        reviewDB.save(new Review(30L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 25)));
        reviewDB.save(new Review(75L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(55L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 5)));
        reviewDB.save(new Review(47L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(5L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 28)));
        reviewDB.save(new Review(59L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 18)));
        reviewDB.save(new Review(72L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 8)));
        reviewDB.save(new Review(6L, 18L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 25)));
        reviewDB.save(new Review(61L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(7L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 29)));
        reviewDB.save(new Review(43L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 4)));
        reviewDB.save(new Review(50L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 5)));
        reviewDB.save(new Review(50L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 3)));
        reviewDB.save(new Review(54L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 20)));
        reviewDB.save(new Review(18L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 14)));
        reviewDB.save(new Review(39L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 2)));
        reviewDB.save(new Review(43L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 6)));
        reviewDB.save(new Review(23L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 9)));
        reviewDB.save(new Review(7L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(29L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 21)));
        reviewDB.save(new Review(34L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 10)));
        reviewDB.save(new Review(8L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 15)));
        reviewDB.save(new Review(1L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(53L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 22)));
        reviewDB.save(new Review(39L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 18)));
        reviewDB.save(new Review(52L, 32L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 8, 5)));
        reviewDB.save(new Review(56L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(6L, 17L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 4, 3)));
        reviewDB.save(new Review(38L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 17)));
        reviewDB.save(new Review(44L, 18L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 11, 27)));
        reviewDB.save(new Review(74L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 22)));
        reviewDB.save(new Review(50L, 29L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 30)));
        reviewDB.save(new Review(39L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 25)));
        reviewDB.save(new Review(19L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 18)));
        reviewDB.save(new Review(63L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 16)));
        reviewDB.save(new Review(52L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 27)));
        reviewDB.save(new Review(10L, 18L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2023, 12, 18)));
        reviewDB.save(new Review(33L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 27)));
        reviewDB.save(new Review(73L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 18)));
        reviewDB.save(new Review(73L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(17L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 18)));
        reviewDB.save(new Review(16L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 4)));
        reviewDB.save(new Review(67L, 30L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 11, 25)));
        reviewDB.save(new Review(41L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 30)));
        reviewDB.save(new Review(68L, 26L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 7, 4)));
        reviewDB.save(new Review(5L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 19)));
        reviewDB.save(new Review(16L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(42L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 26)));
        reviewDB.save(new Review(30L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 5)));
        reviewDB.save(new Review(35L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 24)));
        reviewDB.save(new Review(38L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 1)));
        reviewDB.save(new Review(6L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 28)));
        reviewDB.save(new Review(30L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 6)));
        reviewDB.save(new Review(77L, 24L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 22)));
        reviewDB.save(new Review(72L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 26)));
        reviewDB.save(new Review(62L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 28)));
        reviewDB.save(new Review(22L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 13)));
        reviewDB.save(new Review(75L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 4)));
        reviewDB.save(new Review(11L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 29)));
        reviewDB.save(new Review(37L, 20L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 10)));
        reviewDB.save(new Review(28L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 30)));
        reviewDB.save(new Review(53L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 13)));
        reviewDB.save(new Review(32L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 4)));
        reviewDB.save(new Review(68L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 2)));
        reviewDB.save(new Review(47L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 26)));
        reviewDB.save(new Review(47L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 28)));
        reviewDB.save(new Review(9L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 25)));
        reviewDB.save(new Review(77L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 5)));
        reviewDB.save(new Review(74L, 34L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 5, 23)));
        reviewDB.save(new Review(38L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 24)));
        reviewDB.save(new Review(38L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 8)));
        reviewDB.save(new Review(5L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 7)));
        reviewDB.save(new Review(30L, 19L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 10, 12)));
        reviewDB.save(new Review(74L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 23)));
        reviewDB.save(new Review(31L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 14)));
        reviewDB.save(new Review(31L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 11)));
        reviewDB.save(new Review(49L, 24L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 9, 10)));
        reviewDB.save(new Review(69L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 27)));
        reviewDB.save(new Review(1L, 17L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 16)));
        reviewDB.save(new Review(50L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 9)));
        reviewDB.save(new Review(27L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(17L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 12)));
        reviewDB.save(new Review(19L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 25)));
        reviewDB.save(new Review(78L, 28L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 11, 11)));
        reviewDB.save(new Review(48L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(27L, 35L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 21)));
        reviewDB.save(new Review(41L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 10)));
        reviewDB.save(new Review(73L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 10)));
        reviewDB.save(new Review(16L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 6)));
        reviewDB.save(new Review(48L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 14)));
        reviewDB.save(new Review(34L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 7)));
        reviewDB.save(new Review(15L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 29)));
        reviewDB.save(new Review(50L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 6)));
        reviewDB.save(new Review(69L, 19L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 26)));
        reviewDB.save(new Review(18L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 27)));
        reviewDB.save(new Review(56L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 16)));
        reviewDB.save(new Review(30L, 33L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 21)));
        reviewDB.save(new Review(55L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 9)));
        reviewDB.save(new Review(2L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 26)));
        reviewDB.save(new Review(53L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 23)));
        reviewDB.save(new Review(47L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 16)));
        reviewDB.save(new Review(68L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 10)));
        reviewDB.save(new Review(37L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 16)));
        reviewDB.save(new Review(11L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 9)));
        reviewDB.save(new Review(77L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 7)));
        reviewDB.save(new Review(13L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 29)));
        reviewDB.save(new Review(61L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 15)));
        reviewDB.save(new Review(22L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 14)));
        reviewDB.save(new Review(40L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 10)));
        reviewDB.save(new Review(24L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 7)));
        reviewDB.save(new Review(32L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 29)));
        reviewDB.save(new Review(58L, 22L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(76L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 18)));
        reviewDB.save(new Review(72L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 20)));
        reviewDB.save(new Review(7L, 27L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 15)));
        reviewDB.save(new Review(36L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 9)));
        reviewDB.save(new Review(4L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 21)));
        reviewDB.save(new Review(26L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 12)));
        reviewDB.save(new Review(11L, 16L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(68L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(3L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 1)));
        reviewDB.save(new Review(77L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(18L, 18L, Rating.HORRIBLE, "lorem ipsum the product is horrible", LocalDate.of(2024, 5, 26)));
        reviewDB.save(new Review(13L, 28L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 27)));
        reviewDB.save(new Review(31L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 24)));
        reviewDB.save(new Review(15L, 26L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 27)));
        reviewDB.save(new Review(4L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 11)));
        reviewDB.save(new Review(36L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 18)));
        reviewDB.save(new Review(41L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 18)));
        reviewDB.save(new Review(6L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 19)));
        reviewDB.save(new Review(76L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 13)));
        reviewDB.save(new Review(30L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 10)));
        reviewDB.save(new Review(13L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 19)));
        reviewDB.save(new Review(65L, 26L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 19)));
        reviewDB.save(new Review(36L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 20)));
        reviewDB.save(new Review(13L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 14)));
        reviewDB.save(new Review(4L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 5)));
        reviewDB.save(new Review(34L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 14)));
        reviewDB.save(new Review(32L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 24)));
        reviewDB.save(new Review(35L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 10, 25)));
        reviewDB.save(new Review(24L, 32L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(19L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 12)));
        reviewDB.save(new Review(56L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 29)));
        reviewDB.save(new Review(66L, 30L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 4, 8)));
        reviewDB.save(new Review(58L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 3)));
        reviewDB.save(new Review(51L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 22)));
        reviewDB.save(new Review(28L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 24)));
        reviewDB.save(new Review(78L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 14)));
        reviewDB.save(new Review(17L, 34L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 6, 15)));
        reviewDB.save(new Review(4L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 20)));
        reviewDB.save(new Review(48L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 2)));
        reviewDB.save(new Review(8L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(62L, 27L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 8, 3)));
        reviewDB.save(new Review(2L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 3)));
        reviewDB.save(new Review(51L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(25L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 9)));
        reviewDB.save(new Review(58L, 32L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 2)));
        reviewDB.save(new Review(65L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 20)));
        reviewDB.save(new Review(59L, 16L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 2)));
        reviewDB.save(new Review(28L, 17L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 22)));
        reviewDB.save(new Review(45L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 23)));
        reviewDB.save(new Review(39L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 15)));
        reviewDB.save(new Review(74L, 30L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 25)));
        reviewDB.save(new Review(70L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(21L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(77L, 22L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 7, 5)));
        reviewDB.save(new Review(30L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 8)));
        reviewDB.save(new Review(58L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 23)));
        reviewDB.save(new Review(14L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 4)));
        reviewDB.save(new Review(7L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 8, 7)));
        reviewDB.save(new Review(10L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 24)));
        reviewDB.save(new Review(3L, 21L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 30)));
        reviewDB.save(new Review(30L, 16L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 29)));
        reviewDB.save(new Review(10L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 10)));
        reviewDB.save(new Review(25L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 16)));
        reviewDB.save(new Review(50L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(71L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 11)));
        reviewDB.save(new Review(1L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 4)));
        reviewDB.save(new Review(75L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 8, 31)));
        reviewDB.save(new Review(25L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 14)));
        reviewDB.save(new Review(74L, 18L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 10, 13)));
        reviewDB.save(new Review(65L, 21L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 1, 3)));
        reviewDB.save(new Review(41L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 3, 31)));
        reviewDB.save(new Review(6L, 24L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 16)));
        reviewDB.save(new Review(48L, 17L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 24)));
        reviewDB.save(new Review(23L, 24L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 14)));
        reviewDB.save(new Review(67L, 16L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 5, 25)));
        reviewDB.save(new Review(64L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 29)));
        reviewDB.save(new Review(14L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 10, 24)));
        reviewDB.save(new Review(25L, 30L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 13)));
        reviewDB.save(new Review(51L, 33L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 16)));
        reviewDB.save(new Review(33L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 3, 6)));
        reviewDB.save(new Review(28L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 23)));
        reviewDB.save(new Review(4L, 25L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 25)));
        reviewDB.save(new Review(1L, 25L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 1, 20)));
        reviewDB.save(new Review(31L, 31L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 5, 25)));
        reviewDB.save(new Review(58L, 17L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 6, 26)));
        reviewDB.save(new Review(73L, 19L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 21)));
        reviewDB.save(new Review(41L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 22)));
        reviewDB.save(new Review(18L, 18L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 29)));
        reviewDB.save(new Review(71L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 25)));
        reviewDB.save(new Review(52L, 23L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 5, 31)));
        reviewDB.save(new Review(12L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 5)));
        reviewDB.save(new Review(19L, 33L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 4)));
        reviewDB.save(new Review(13L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 2, 6)));
        reviewDB.save(new Review(66L, 35L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 2, 8)));
        reviewDB.save(new Review(13L, 27L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 12)));
        reviewDB.save(new Review(46L, 30L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 28)));
        reviewDB.save(new Review(68L, 23L, Rating.POOR, "lorem ipsum the product is bad", LocalDate.of(2024, 1, 28)));
        reviewDB.save(new Review(66L, 23L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2023, 12, 29)));
        reviewDB.save(new Review(33L, 28L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 2, 9)));
        reviewDB.save(new Review(59L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 12, 6)));
        reviewDB.save(new Review(75L, 28L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 7, 29)));
        reviewDB.save(new Review(68L, 16L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 4, 22)));
        reviewDB.save(new Review(29L, 20L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 21)));
        reviewDB.save(new Review(36L, 19L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 7, 10)));
        reviewDB.save(new Review(19L, 32L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 10, 19)));
        reviewDB.save(new Review(18L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 13)));
        reviewDB.save(new Review(29L, 36L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 2)));
        reviewDB.save(new Review(51L, 25L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 6, 8)));
        reviewDB.save(new Review(51L, 18L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(62L, 35L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 21)));
        reviewDB.save(new Review(44L, 23L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 9, 30)));
        reviewDB.save(new Review(20L, 34L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 14)));
        reviewDB.save(new Review(76L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 4, 8)));
        reviewDB.save(new Review(64L, 21L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 11)));
        reviewDB.save(new Review(35L, 31L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 7, 24)));
        reviewDB.save(new Review(66L, 31L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 11, 23)));
        reviewDB.save(new Review(22L, 26L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 4)));
        reviewDB.save(new Review(64L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2023, 12, 21)));
        reviewDB.save(new Review(25L, 29L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 1, 27)));
        reviewDB.save(new Review(32L, 22L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2023, 12, 26)));
        reviewDB.save(new Review(7L, 22L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 3, 1)));
        reviewDB.save(new Review(44L, 29L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 4, 22)));
        reviewDB.save(new Review(54L, 20L, Rating.EXCELLENT, "lorem ipsum the product is excellent", LocalDate.of(2024, 9, 14)));
        reviewDB.save(new Review(28L, 36L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 11, 26)));
        reviewDB.save(new Review(58L, 36L, Rating.GOOD, "lorem ipsum the product is good", LocalDate.of(2024, 11, 3)));
        reviewDB.save(new Review(63L, 25L, Rating.SATISFACTORY, "lorem ipsum the product is ok", LocalDate.of(2024, 9, 2)));



    }

}
