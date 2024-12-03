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

    @PostConstruct
    public void fill(){//testing123 is the password for all accounts

        /*
         * VENDOR LIST
         * vendor 1 - PMax
         * vendor 2 - HeavyDuty
         * vendor 3 - ABC
         * vendor 4 - StrengthSports
         * vendor 5 - BarBreaker
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
         * HeavyDuty - vendor (vendor account)
         * ABC - vendor (vendor account)
         * StrengthSports - vendor (vendor account)
         * BarBreaker - vendor (vendor account)
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

        userDB.save(new AppUser("PranavAdmin","$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.ADMIN,"pranavadmin@gmail.com", 9912313123L,null,false));
        userDB.save(new AppUser("Arnold", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "arnold@gmail.com", 9876543210L, "123 Olympia Street, Los Angeles, CA", false));
        userDB.save(new AppUser("Wamuu", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "wamuu@gmail.com", 9876543211L, "456 Joestar Avenue, Tokyo, Japan", false));
        userDB.save(new AppUser("The Rock", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "therock@gmail.com", 9876543212L, "789 Hollywood Street, Los Angeles, CA", false));
        userDB.save(new AppUser("Nolan", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "nolan@gmail.com", 9876543213L, "101 Viltrum Avenue, Viltrum", false));
        userDB.save(new AppUser("Todou", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "todou@gmail.com", 9876543214L, "202 Shibuya Crossing, Tokyo, Japan", false));
        userDB.save(new AppUser("Goku", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "goku@gmail.com", 9876543215L, "303 Kame House, Turtle Island, East Sea", false));
        userDB.save(new AppUser("Yujiro", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "yujiro@gmail.com", 9876543216L, "404 Delulu Road, Tokyo, Japan", false));
        userDB.save(new AppUser("Bane", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "bane@gmail.com", 9876543217L, "505 Gotham Underground, Gotham City", false));
        userDB.save(new AppUser("Mahoraga", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.CUSTOMER, "bigraga@gmail.com", 9882373213L, "10 Sacred treasure Street, Shadow Realm", false));
        userDB.save(new AppUser("PMax", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "pmax@gmail.com", 9876543218L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("HeavyDuty", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "heavyduty@gmail.com", 9876543219L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("ABC", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "abc@gmail.com", 9876543220L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("StrengthSports", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "strengthsports@gmail.com", 9876543221L, "789 Main Market, Central Plaza", false));
        userDB.save(new AppUser("BarBreaker", "$2a$12$amYnvLmADyPDmqaZ.zdxIuLexslVqWejDUkvjx9YJPcU6cm4ASHgK", UserRole.VENDOR, "barbreaker@gmail.com", 9870245221L, "789 Main Market, Central Plaza", false));

        vendorDB.save(new Vendor(11L, "PMax", "pmax@gmail.com, 9876543218", VendorStatus.APPROVED, LocalDate.of(2024, 5, 1)));
        vendorDB.save(new Vendor(12L, "HeavyDuty", "heavyduty@gmail.com, 9876543219", VendorStatus.APPROVED, LocalDate.of(2024, 6, 15)));
        vendorDB.save(new Vendor(13L, "ABC", "abc@gmail.com, 9876543220", VendorStatus.APPROVED, LocalDate.of(2024, 7, 10)));
        vendorDB.save(new Vendor(14L, "StrengthSports", "strengthsports@gmail.com, 9876543221", VendorStatus.APPROVED, LocalDate.of(2024, 8, 20)));
        vendorDB.save(new Vendor(15L, "BarBreaker", "barbreaker@gmail.com, 9876543222", VendorStatus.APPROVED, LocalDate.of(2024, 9, 25)));


        categoryDB.save(new Category("Dumbbells", "Various weights of dumbbells", 11L));
        categoryDB.save(new Category("Barbells", "Standard and Olympic barbells", 11L));
        categoryDB.save(new Category("Weight Plates", "Plates for lifting and machines", 11L));
        categoryDB.save(new Category("Weighted Clothing", "Weighted cuffs, vests, etc.", 11L));
        categoryDB.save(new Category("Yoga Mat", "Comfortable and durable yoga mats", 12L));
        categoryDB.save(new Category("Lifting Belts", "Belts for back support during lifts", 12L));
        categoryDB.save(new Category("Lifting Straps/Gloves", "Grip aids for lifting", 12L));
        categoryDB.save(new Category("Power Rack", "Essential for heavy lifting", 13L));
        categoryDB.save(new Category("Bench", "Flat and incline benches", 13L));
        categoryDB.save(new Category("Machines", "Various gym machines", 13L));
        categoryDB.save(new Category("Weights", "Parent category for lifting equipment", null));
        categoryDB.save(new Category("Accessories", "Parent category for gym accessories", null));
        categoryDB.save(new Category("Equipment", "Parent category for gym equipment", null));

        productDB.save(new Product(11L, "Hex Dumbbell 5kg", "Durable rubber-coated 5kg hex dumbbell", 750.0, 1L, 12, "images/dumbbell_5kg.jpg", LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 7.5kg", "Durable rubber-coated 7.5kg hex dumbbell", 1125.0, 1L, 10, "images/dumbbell_7_5kg.jpg", LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 10kg", "Durable rubber-coated 10kg hex dumbbell", 1500.0, 1L, 8, "images/dumbbell_10kg.jpg", LocalDate.now()));
        productDB.save(new Product(11L, "Hex Dumbbell 15kg", "Durable rubber-coated 15kg hex dumbbell", 2250.0, 1L, 6, "images/dumbbell_15kg.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 20kg", "High-quality 20kg Olympic barbell", 12000.0, 2L, 5, "images/barbell_20kg.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Olympic Barbell 15kg", "High-quality 15kg Olympic barbell", 8000.0, 2L, 7, "images/barbell_15kg.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "EZ Curl Barbell 10kg", "Curved 10kg EZ curl barbell for arm exercises", 4500.0, 2L, 7, "images/ez_curl_barbell.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 2.5kg", "Rubber-coated 2.5kg weight plate", 500.0, 3L, 25, "images/weight_plate_2_5kg.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 5kg", "Rubber-coated 5kg weight plate", 1000.0, 3L, 20, "images/weight_plate_5kg.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 10kg", "Rubber-coated 10kg weight plate", 2000.0, 3L, 15, "images/weight_plate_10kg.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Weight Plate 20kg", "Rubber-coated 20kg weight plate", 4000.0, 3L, 10, "images/weight_plate_20kg.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 5kg", "Adjustable 5kg weighted vest", 2500.0, 4L, 8, "images/weighted_vest_5kg.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 10kg", "Adjustable 10kg weighted vest", 3500.0, 4L, 6, "images/weighted_vest_10kg.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Vest 15kg", "Adjustable 15kg weighted vest", 4500.0, 4L, 4, "images/weighted_vest_15kg.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Weighted Ankle Cuffs 2kg", "Adjustable 2kg weighted ankle cuffs", 1200.0, 4L, 10, "images/weighted_ankle_cuffs.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Yoga Mat", "Eco-friendly non-slip yoga mat", 1000.0, 5L, 15, "images/yoga_mat.jpg", LocalDate.now()));
        productDB.save(new Product(13L, "Premium Yoga Mat", "Extra thick and durable yoga mat", 1500.0, 5L, 10, "images/premium_yoga_mat.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Travel Yoga Mat", "Lightweight and compact yoga mat", 800.0, 5L, 12, "images/travel_yoga_mat.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Medium", "Leather lifting belt for medium builds", 1800.0, 6L, 10, "images/lifting_belt_medium.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Lifting Belt Large", "Leather lifting belt for large builds", 2000.0, 6L, 8, "images/lifting_belt_large.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Grip Straps", "Heavy-duty lifting straps for grip support", 700.0, 7L, 20, "images/grip_straps.jpg", LocalDate.now()));
        productDB.save(new Product(14L, "Lifting Gloves", "Padded gloves for extra grip and comfort", 1200.0, 7L, 15, "images/lifting_gloves.jpg", LocalDate.now()));
        productDB.save(new Product(11L, "Power Rack", "Heavy-duty power rack for advanced lifters", 45000.0, 8L, 3, "images/power_rack.jpg", LocalDate.now()));
        productDB.save(new Product(12L, "Compact Power Rack", "Compact and affordable power rack", 35000.0, 8L, 5, "images/compact_power_rack.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Flat Bench", "Sturdy flat bench for bench presses", 12000.0, 9L, 6, "images/flat_bench.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Incline Bench", "Adjustable incline bench", 15000.0, 9L, 4, "images/incline_bench.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Adjustable Bench", "Flat and incline bench in one", 18000.0, 9L, 3, "images/adjustable_bench.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Lat Pulldown Machine", "Multi-purpose lat pulldown machine", 65000.0, 10L, 2, "images/lat_pulldown_machine.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Leg Press Machine", "High-quality leg press machine", 85000.0, 10L, 2, "images/leg_press_machine.jpg", LocalDate.now()));
        productDB.save(new Product(15L, "Cable Crossover Machine", "Versatile cable crossover machine", 95000.0, 10L, 1, "images/cable_crossover_machine.jpg", LocalDate.now()));

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


    }

}
