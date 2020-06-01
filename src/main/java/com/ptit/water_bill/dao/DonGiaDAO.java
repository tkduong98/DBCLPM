package com.ptit.water_bill.dao;

import com.ptit.water_bill.model.DonGia;

import java.util.List;

public interface DonGiaDAO {
    List<Object> getAll();
    void update(DonGia donGia);
    void add(DonGia donGia);
    void delete(String IDDonGia);
    List<Integer> getGia(String loaiDonGia);
}
