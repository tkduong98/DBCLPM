package com.ptit.water_bill.dao;

import com.ptit.water_bill.model.KhachHang;

import java.util.List;

public interface KhachHangDAO {
    List<Object> getAll();
    Object getByMaKH(String maKH);
    void updateInformation(KhachHang KH);
    void addKH(KhachHang KH);
    void deleteKH(String idKH);
}
