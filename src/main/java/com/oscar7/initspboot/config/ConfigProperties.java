package com.oscar7.initspboot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app")

public class ConfigProperties {

    private String title;
    private String logo;
    private String legende;
    private String login;

    private String prestation;
    private String offrePublic;
    private String offreProf;
    private String offreParticulier;

    private String products;
    private String addProduct;
    private String editProduct;
    private String deleteProduct;
    private String category;
    private String addCategory;
    private String newProductCategory;
    private String bestProductCategory;
    private String addCompany;
    private String addToWishList;
    private String deleteWishList;
    private String orderList;
    private String addToContact;
    private String productList;
    private String presentlyAddToCardProductList;
    private String recentlyEditProductList;
    private String outOfStockProduct;
    private String outOfStockCategory;
    private String categorytList;
    private String promotionCategories;
    private String updateAttributesCategorie;
    private String addBillingAddress;
    private String pointOfServices;
    private String sanitizedMonitoring;
    private String OthersService;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLegende() {
        return legende;
    }

    public void setLegende(String legende) {
        this.legende = legende;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPrestation() {
        return prestation;
    }

    public void setPrestation(String prestation) {
        this.prestation = prestation;
    }

    public String getOffrePublic() {
        return offrePublic;
    }

    public void setOffrePublic(String offrePublic) {
        this.offrePublic = offrePublic;
    }

    public String getOffreProf() {
        return offreProf;
    }

    public void setOffreProf(String offreProf) {
        this.offreProf = offreProf;
    }

    public String getOffreParticulier() {
        return offreParticulier;
    }

    public void setOffreParticulier(String offreParticulier) {
        this.offreParticulier = offreParticulier;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(String addProduct) {
        this.addProduct = addProduct;
    }

    public String getEditProduct() {
        return editProduct;
    }

    public void setEditProduct(String editProduct) {
        this.editProduct = editProduct;
    }

    public String getDeleteProduct() {
        return deleteProduct;
    }

    public void setDeleteProduct(String deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddCategory() {
        return addCategory;
    }

    public void setAddCategory(String addCategory) {
        this.addCategory = addCategory;
    }

    public String getNewProductCategory() {
        return newProductCategory;
    }

    public void setNewProductCategory(String newProductCategory) {
        this.newProductCategory = newProductCategory;
    }

    public String getBestProductCategory() {
        return bestProductCategory;
    }

    public void setBestProductCategory(String bestProductCategory) {
        this.bestProductCategory = bestProductCategory;
    }

    public String getAddCompany() {
        return addCompany;
    }

    public void setAddCompany(String addCompany) {
        this.addCompany = addCompany;
    }

    public String getAddToWishList() {
        return addToWishList;
    }

    public void setAddToWishList(String addToWishList) {
        this.addToWishList = addToWishList;
    }

    public String getDeleteWishList() {
        return deleteWishList;
    }

    public void setDeleteWishList(String deleteWishList) {
        this.deleteWishList = deleteWishList;
    }

    public String getOrderList() {
        return orderList;
    }

    public void setOrderList(String orderList) {
        this.orderList = orderList;
    }

    public String getAddToContact() {
        return addToContact;
    }

    public void setAddToContact(String addToContact) {
        this.addToContact = addToContact;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getPresentlyAddToCardProductList() {
        return presentlyAddToCardProductList;
    }

    public void setPresentlyAddToCardProductList(String presentlyAddToCardProductList) {
        this.presentlyAddToCardProductList = presentlyAddToCardProductList;
    }

    public String getRecentlyEditProductList() {
        return recentlyEditProductList;
    }

    public void setRecentlyEditProductList(String recentlyEditProductList) {
        this.recentlyEditProductList = recentlyEditProductList;
    }

    public String getOutOfStockProduct() {
        return outOfStockProduct;
    }

    public void setOutOfStockProduct(String outOfStockProduct) {
        this.outOfStockProduct = outOfStockProduct;
    }

    public String getOutOfStockCategory() {
        return outOfStockCategory;
    }

    public void setOutOfStockCategory(String outOfStockCategory) {
        this.outOfStockCategory = outOfStockCategory;
    }

    public String getCategorytList() {
        return categorytList;
    }

    public void setCategorytList(String categorytList) {
        this.categorytList = categorytList;
    }

    public String getPromotionCategories() {
        return promotionCategories;
    }

    public void setPromotionCategories(String promotionCategories) {
        this.promotionCategories = promotionCategories;
    }

    public String getUpdateAttributesCategorie() {
        return updateAttributesCategorie;
    }

    public void setUpdateAttributesCategorie(String updateAttributesCategorie) {
        this.updateAttributesCategorie = updateAttributesCategorie;
    }

    public String getAddBillingAddress() {
        return addBillingAddress;
    }

    public void setAddBillingAddress(String addBillingAddress) {
        this.addBillingAddress = addBillingAddress;
    }

    public String getPointOfServices() {
        return pointOfServices;
    }

    public void setPointOfServices(String pointOfServices) {
        this.pointOfServices = pointOfServices;
    }

    public String getSanitizedMonitoring() {
        return sanitizedMonitoring;
    }

    public void setSanitizedMonitoring(String sanitizedMonitoring) {
        this.sanitizedMonitoring = sanitizedMonitoring;
    }

    public String getOthersService() {
        return OthersService;
    }

    public void setOthersService(String othersService) {
        OthersService = othersService;
    }
}

