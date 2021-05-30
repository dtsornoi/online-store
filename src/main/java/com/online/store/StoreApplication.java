package com.online.store;

import com.online.store.entity.Category;
import com.online.store.entity.CategoryType;
import com.online.store.entity.Role;
import com.online.store.entity.RoleType;
import com.online.store.repository.CategoryRepository;
import com.online.store.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication /*implements CommandLineRunner*/ {


   /* @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RoleRepository roleRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }


    /*@Override
    public void run(String... args) throws Exception {
        Category foods = new Category();
        foods.setName(CategoryType.FOODS);

        Category furniture = new Category();
        furniture.setName(CategoryType.FURNITURE);

        Category electronics = new Category();
        electronics.setName(CategoryType.ELECTRONICS);

        Category clothes = new Category();
        clothes.setName(CategoryType.CLOTHING);

        categoryRepository.deleteAll();
        categoryRepository.save(foods);
        categoryRepository.save(electronics);
        categoryRepository.save(clothes);
        categoryRepository.save(furniture);

        Role user = new Role();
        user.setName(RoleType.ROLE_USER);

        Role admin = new Role();
        admin.setName(RoleType.ROLE_ADMIN);

        roleRepository.deleteAll();
        roleRepository.save(admin);
        roleRepository.save(user);
    }*/
}
