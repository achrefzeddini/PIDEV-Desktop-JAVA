/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

/**
 *
 * @author Dorsaf
 */
public class productEntity {
    
    int id;
    String name;
    float price;
    String description;
    String photo;
    int promotion_id;
    int user_id;
    String username;
    String lastname;

    public productEntity(int id, String name, float price, String description, String photo, int promotion_id, int user_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.promotion_id = promotion_id;
        this.user_id = user_id;
    }

    public productEntity(int id, String name, float price, String description, String photo, String username, String lastname) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.username = username;
        this.lastname = lastname;
    }
    
    
    
    //add
        public productEntity(String name, float price, String description, String photo, String username, String lastname) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.username = username;
        this.lastname = lastname;
    }

        //delete 
    public productEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    
           
    
    
    
//    Users owner= new Users();
//    String username;
//    String lastname;
//
//    public String getUsername() {
//        return owner.getFnameUser();
//    }
//
//    
//
//    public String getLastname() {
//        return owner.getLnameUser();
//    }
//
//    
//    
//    
//    
//
//    public productEntity() {
//    }
//
//    public productEntity(int IdProduct, String Name, String Description, String Photo, float Price, Users u) {
//        this.IdProduct = IdProduct;
//        this.Name = Name;
//        this.Description = Description;
//        this.Photo = Photo;
//        this.Price = Price;
//        this.owner = u;
//    }
//
//    public productEntity(String Name, String Description, String Photo, float Price, Users u) {
//        this.Name = Name;
//        this.Description = Description;
//        this.Photo = Photo;
//        this.Price = Price;
//        this.owner = u;
//    }
//
//    public int getIdProduct() {
//        return IdProduct;
//    }
//
//    public void setIdProduct(int IdProduct) {
//        this.IdProduct = IdProduct;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String Description) {
//        this.Description = Description;
//    }
//
//    public String getPhoto() {
//        return Photo;
//    }
//
//    public void setPhoto(String Photo) {
//        this.Photo = Photo;
//    }
//
//    public float getPrice() {
//        return Price;
//    }
//
//    public void setPrice(float Price) {
//        this.Price = Price;
//    }
//
//    public Users getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Users owner) {
//        this.owner = owner;
//    }
//
//    @Override
//    public String toString() {
//        return "productEntity{" + "IdProduct=" + IdProduct + ", Name=" + Name + ", Description=" + Description + ", Photo=" + Photo + ", Price=" + Price + ", owner=" + owner + '}';
//    }
//   
//    
//    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   
    
    
}
