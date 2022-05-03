package cn.edu.guet.shopdemo.been;


import java.util.Objects;

public class Product {
    private int product_id;
    private String product_name;
    private float product_price;
    private String product_comment;

    public Product(){}

    public Product(int product_id,String product_name,float product_price,String product_comment) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_comment = product_comment;
    }

    public int getproduct_id() {
        return product_id;
    }

    public void setproduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getproduct_name() {
        return product_name;
    }

    public void setproduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getproduct_price() {
        return product_price;
    }

    public void setproduct_price(float product_price) {
        this.product_price = product_price;
    }

    public String getproduct_comment() {
        return product_comment;
    }

    public void setproduct_comment(String product_comment) {
        this.product_comment = product_comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_name, product_price,product_comment);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_price='" + product_price + '\'' +
                ", product_comment="+ product_comment +'\''+
                '}';
    }

}
