package cn.edu.guet.shopdemo.dao;

import cn.edu.guet.shopdemo.been.Product;

public interface ProductDao {
    void deletep(int PID);//删除,得到id

    void updatep(Product product, int PID);//修改

    void insertp(Product product);
}