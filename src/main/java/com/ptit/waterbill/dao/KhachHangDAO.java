package com.ptit.waterbill.dao;

import com.ptit.waterbill.model.KhachHang;

import java.util.List;

public interface KhachHangDAO {
    List<Object> getAll();
    Object getByMaKH(String maKH);
    void updateInformation(KhachHang KH);
    void addKH(KhachHang KH);
    void deleteKH(String idKH);
}
