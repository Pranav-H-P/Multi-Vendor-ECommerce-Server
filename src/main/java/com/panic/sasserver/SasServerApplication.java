package com.panic.sasserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SasServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SasServerApplication.class, args);
	}

}
/*

[
  {
    "productName": "Hex Dumbbell 5kg",
    "vendorName": "PMax",
    "productId": 1,
    "vendorId": 11,
    "price": 750,
    "description": "Durable rubber-coated 5kg hex dumbbell",
    "categoryId": 1
  },
  {
    "productName": "Hex Dumbbell 7.5kg",
    "vendorName": "PMax",
    "productId": 2,
    "vendorId": 11,
    "price": 1125,
    "description": "Durable rubber-coated 7.5kg hex dumbbell",
    "categoryId": 1
  },
  {
    "productName": "Hex Dumbbell 10kg",
    "vendorName": "PMax",
    "productId": 3,
    "vendorId": 11,
    "price": 1500,
    "description": "Durable rubber-coated 10kg hex dumbbell",
    "categoryId": 1
  },
  {
    "productName": "Hex Dumbbell 15kg",
    "vendorName": "PMax",
    "productId": 4,
    "vendorId": 11,
    "price": 2250,
    "description": "Durable rubber-coated 15kg hex dumbbell",
    "categoryId": 1
  },
  {
    "productName": "Olympic Barbell 20kg",
    "vendorName": "HeavyDuty",
    "productId": 5,
    "vendorId": 12,
    "price": 12000,
    "description": "High-quality 20kg Olympic barbell",
    "categoryId": 2
  },
  {
    "productName": "Olympic Barbell 15kg",
    "vendorName": "HeavyDuty",
    "productId": 6,
    "vendorId": 12,
    "price": 8000,
    "description": "High-quality 15kg Olympic barbell",
    "categoryId": 2
  },
  {
    "productName": "EZ Curl Barbell 10kg",
    "vendorName": "HeavyDuty",
    "productId": 7,
    "vendorId": 12,
    "price": 4500,
    "description": "Curved 10kg EZ curl barbell for arm exercises",
    "categoryId": 2
  },
  {
    "productName": "Weight Plate 2.5kg",
    "vendorName": "ABC",
    "productId": 8,
    "vendorId": 13,
    "price": 500,
    "description": "Rubber-coated 2.5kg weight plate",
    "categoryId": 3
  },
  {
    "productName": "Weight Plate 5kg",
    "vendorName": "ABC",
    "productId": 9,
    "vendorId": 13,
    "price": 1000,
    "description": "Rubber-coated 5kg weight plate",
    "categoryId": 3
  },
  {
    "productName": "Weight Plate 10kg",
    "vendorName": "ABC",
    "productId": 10,
    "vendorId": 13,
    "price": 2000,
    "description": "Rubber-coated 10kg weight plate",
    "categoryId": 3
  },
  {
    "productName": "Weight Plate 20kg",
    "vendorName": "ABC",
    "productId": 11,
    "vendorId": 13,
    "price": 4000,
    "description": "Rubber-coated 20kg weight plate",
    "categoryId": 3
  },
  {
    "productName": "Weighted Vest 5kg",
    "vendorName": "StrengthSports",
    "productId": 12,
    "vendorId": 14,
    "price": 2500,
    "description": "Adjustable 5kg weighted vest",
    "categoryId": 4
  },
  {
    "productName": "Weighted Vest 10kg",
    "vendorName": "StrengthSports",
    "productId": 13,
    "vendorId": 14,
    "price": 3500,
    "description": "Adjustable 10kg weighted vest",
    "categoryId": 4
  },
  {
    "productName": "Weighted Vest 15kg",
    "vendorName": "StrengthSports",
    "productId": 14,
    "vendorId": 14,
    "price": 4500,
    "description": "Adjustable 15kg weighted vest",
    "categoryId": 4
  },
  {
    "productName": "Weighted Ankle Cuffs 2kg",
    "vendorName": "StrengthSports",
    "productId": 15,
    "vendorId": 14,
    "price": 1200,
    "description": "Adjustable 2kg weighted ankle cuffs",
    "categoryId": 4
  },
  {
    "productName": "Yoga Mat",
    "vendorName": "ABC",
    "productId": 16,
    "vendorId": 13,
    "price": 1000,
    "description": "Eco-friendly non-slip yoga mat",
    "categoryId": 5
  },
  {
    "productName": "Premium Yoga Mat",
    "vendorName": "ABC",
    "productId": 17,
    "vendorId": 13,
    "price": 1500,
    "description": "Extra thick and durable yoga mat",
    "categoryId": 5
  },
  {
    "productName": "Travel Yoga Mat",
    "vendorName": "HeavyDuty",
    "productId": 18,
    "vendorId": 12,
    "price": 800,
    "description": "Lightweight and compact yoga mat",
    "categoryId": 5
  },
  {
    "productName": "Lifting Belt Medium",
    "vendorName": "HeavyDuty",
    "productId": 19,
    "vendorId": 12,
    "price": 1800,
    "description": "Leather lifting belt for medium builds",
    "categoryId": 6
  },
  {
    "productName": "Lifting Belt Large",
    "vendorName": "HeavyDuty",
    "productId": 20,
    "vendorId": 12,
    "price": 2000,
    "description": "Leather lifting belt for large builds",
    "categoryId": 6
  },
  {
    "productName": "Grip Straps",
    "vendorName": "StrengthSports",
    "productId": 21,
    "vendorId": 14,
    "price": 700,
    "description": "Heavy-duty lifting straps for grip support",
    "categoryId": 7
  },
  {
    "productName": "Lifting Gloves",
    "vendorName": "StrengthSports",
    "productId": 22,
    "vendorId": 14,
    "price": 1200,
    "description": "Padded gloves for extra grip and comfort",
    "categoryId": 7
  },
  {
    "productName": "Power Rack",
    "vendorName": "PMax",
    "productId": 23,
    "vendorId": 11,
    "price": 45000,
    "description": "Heavy-duty power rack for advanced lifters",
    "categoryId": 8
  },
  {
    "productName": "Compact Power Rack",
    "vendorName": "HeavyDuty",
    "productId": 24,
    "vendorId": 12,
    "price": 35000,
    "description": "Compact and affordable power rack",
    "categoryId": 8
  },
  {
    "productName": "Flat Bench",
    "vendorName": "BarBreaker",
    "productId": 25,
    "vendorId": 15,
    "price": 12000,
    "description": "Sturdy flat bench for bench presses",
    "categoryId": 9
  },
  {
    "productName": "Incline Bench",
    "vendorName": "BarBreaker",
    "productId": 26,
    "vendorId": 15,
    "price": 15000,
    "description": "Adjustable incline bench",
    "categoryId": 9
  },
  {
    "productName": "Adjustable Bench",
    "vendorName": "BarBreaker",
    "productId": 27,
    "vendorId": 15,
    "price": 18000,
    "description": "Flat and incline bench in one",
    "categoryId": 9
  },
  {
    "productName": "Lat Pulldown Machine",
    "vendorName": "BarBreaker",
    "productId": 28,
    "vendorId": 15,
    "price": 65000,
    "description": "Multi-purpose lat pulldown machine",
    "categoryId": 10
  },
  {
    "productName": "Leg Press Machine",
    "vendorName": "BarBreaker",
    "productId": 29,
    "vendorId": 15,
    "price": 85000,
    "description": "High-quality leg press machine",
    "categoryId": 10
  },
  {
    "productName": "Cable Crossover Machine",
    "vendorName": "BarBreaker",
    "productId": 30,
    "vendorId": 15,
    "price": 95000,
    "description": "Versatile cable crossover machine",
    "categoryId": 10
  }
]

*/