package com.tnsif.Shoppingmall.admin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.tnsif.Shoppingmall.shop.Shops;
import com.tnsif.Shoppingmall.employee.Employee;


@RestController
@RequestMapping("/admin")
public class MallAdminController {


@Autowired
private MallAdminService adminService;


@PostMapping("/login")
public MallAdmin login(@RequestBody MallAdmin admin) {
return adminService.login(admin.getUsername(), admin.getPassword());
}


@GetMapping("/shops")
public List<Shops> viewAllShops() {
return adminService.getAllShops();
}


@GetMapping("/shops/pending")
public List<Shops> viewPendingShops() {
return adminService.getPendingShops();
}


@PutMapping("/shops/{id}/approve")
public Shops approveShop(@PathVariable Long id) {
return adminService.approveShop(id);
}


@PutMapping("/shops/{id}/reject")
public Shops rejectShop(@PathVariable Long id) {
return adminService.rejectShop(id);
}


@GetMapping("/employees")
public List<Employee> viewEmployees() {
return adminService.getAllEmployees();
}


}
