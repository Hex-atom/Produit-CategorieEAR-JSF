package Bean;

import metier.ICategorieLocal;
import metier.entities.Categorie;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "categorieBean")
@SessionScoped
public class CategorieBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private ICategorieLocal categorieEJB;

    private Categorie categorie = new Categorie();
    private String searchKey;
    private List<Categorie> categories;

    // Getter and Setter for Categorie
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    // Getter and Setter for SearchKey
    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    // Method to add a new categorie
    public String addCategorie() {
        categorieEJB.addCategorie(categorie);
        categorie = new Categorie(); // Resetting the form
        return "listCategories?faces-redirect=true";
    }

    // Method to search for categories
    public void searchCategories() {
        categories = categorieEJB.getCategorie(searchKey);
    }

    // Method to list all categories
    public List<Categorie> getCategories() {
        if (categories == null) {
            categories = categorieEJB.listCategorie();
        }
        return categories;
    }

    // Method to delete a categorie
    public String deleteCategorie(Long id) {
        categorieEJB.deleteCategorie(id);
        return "listCategories?faces-redirect=true";
    }

    // Method to edit a categorie
    public String editCategorie(Categorie categorie) {
        this.categorie = categorie;
        return "editCategorie";
    }

    // Method to update a categorie
    public String updateCategorie() {
        categorieEJB.editCategorie(categorie);
        categorie = new Categorie(); // Resetting the form
        return "listCategories?faces-redirect=true";
    }
}
