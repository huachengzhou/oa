package cn.blake.mvc;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
/**
 * 文件上传
 */
@SuppressWarnings("serial")
public class Product implements Serializable{
    private String name;
    private String description;
    private Double price;
    private MultipartFile image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Product() {
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", image=" + image + "]";
	}
}
