package com.tnsif.Shoppingmall.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.Shoppingmall.shop.Shops;
import com.tnsif.Shoppingmall.shop.ShopsRepository;
import com.tnsif.Shoppingmall.employee.Employee;
import com.tnsif.Shoppingmall.employee.EmployeeRepository;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository adminRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private static boolean isAdminLoggedIn = false;

    public void login(String username, String password) {
        MallAdmin admin =
            adminRepository.findByUsernameAndPassword(username, password);

        if (admin == null) {
            throw new UnauthorizedException("Invalid admin credentials");
        }

        isAdminLoggedIn = true;
    }
    
    public void logout() {
        isAdminLoggedIn = false;
    }

    private void checkLogin() {
        if (!isAdminLoggedIn) {
            throw new UnauthorizedException(
                "Please login as admin to access this resource"
            );
        }
    }

    public List<Shops> getAllShops() {
        checkLogin();
        return shopsRepository.findAll();
    }

    public List<Shops> getPendingShops() {
        checkLogin();
        return shopsRepository.findByStatus("PENDING");
    }

    public Shops approveShop(Long id) {
        checkLogin();
        Shops shop = shopsRepository.findById(id).orElse(null);
        if (shop != null) {
            shop.setStatus("APPROVED");
            return shopsRepository.save(shop);
        }
        return null;
    }

    public Shops rejectShop(Long id) {
        checkLogin();
        Shops shop = shopsRepository.findById(id).orElse(null);
        if (shop != null) {
            shop.setStatus("REJECTED");
            return shopsRepository.save(shop);
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        checkLogin();
        return employeeRepository.findAll();
    }
}
