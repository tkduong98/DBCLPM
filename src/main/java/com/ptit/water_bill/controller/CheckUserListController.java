package com.ptit.water_bill.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptit.water_bill.dao.KhachHangDAO;
import com.ptit.water_bill.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CheckUserListController {

    @Autowired
    private KhachHangDAO khachHangDAO;

    @GetMapping("/trang-chu")
    public String dashboard() {
        return "userList";
    }

    @PostMapping("/danh-sach-khach-hang")
    @ResponseBody
    public String getUserList() {
        List<Object> userList = khachHangDAO.getAll();
        String data = null;
        try {
            data = (new ObjectMapper()).writeValueAsString(userList);
            return data;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/tim-kiem-khach-hang")
    @ResponseBody
    public String searchCustomerByID(@RequestParam("customerID") String customerID) {
        Object customer = khachHangDAO.getByMaKH(customerID.trim());
        try {
            String data = (new ObjectMapper()).writeValueAsString(customer);
            return data;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/cap-nhat-thong-tin-khach-hang")
    @ResponseBody
    public String updateCustomerByID(@RequestParam("idKH_update") String idKH_update,
                                     @RequestParam("tenKH_update") String tenKH_update,
                                     @RequestParam("dob_update") String dob_update,
                                     @RequestParam("soCmnd_update") String soCmnd_update,
                                     @RequestParam("diaChi_update") String diaChi_update,
                                     @RequestParam("mail_update") String mail_update,
                                     @RequestParam("gioiTinh_update") String gioiTinh_update,
                                     @RequestParam("soDT_update") String soDT_update,
                                     @RequestParam("ngayBDSD_update") String ngayBDSD_update) {
        KhachHang KH = new KhachHang(idKH_update,tenKH_update,dob_update,soCmnd_update,diaChi_update,gioiTinh_update,soDT_update,ngayBDSD_update,mail_update);
        khachHangDAO.updateInformation(KH);
        return "OK";
    }

    @PostMapping("/them-khach-hang")
    @ResponseBody
    public String addCustomer(@RequestParam("idKH_add") String idKH_add,
                                     @RequestParam("tenKH_add") String tenKH_add,
                                     @RequestParam("dob_add") String dob_add,
                                     @RequestParam("soCmnd_add") String soCmnd_add,
                                     @RequestParam("diaChi_add") String diaChi_add,
                                     @RequestParam("mail_add") String mail_add,
                                     @RequestParam("gioiTinh_add") String gioiTinh_add,
                                     @RequestParam("soDT_add") String soDT_add,
                                     @RequestParam("ngayBDSD_add") String ngayBDSD_add) {
        KhachHang KH = new KhachHang(idKH_add,tenKH_add,dob_add,soCmnd_add,diaChi_add,gioiTinh_add,soDT_add,ngayBDSD_add,mail_add);
        khachHangDAO.addKH(KH);
        return "OK";
    }

    @PostMapping("/xoa-khach-hang")
    @ResponseBody
    public String deleteCustomer(@RequestParam("idKHDelete") String idKHDelete) {
        khachHangDAO.deleteKH(idKHDelete);
        return "OK";
    }

}
