package Bean;


import metier.IProduitLocal;
import metier.entities.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "produitBean")
@SessionScoped
public class ProduitBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private IProduitLocal produitService;

    private Produit produit;
    private List<Produit> produits;

    @PostConstruct
    public void init() {
        produit = new Produit();
        produits = produitService.listProduits(); // Fetch all products initially
    }

    // Getters and Setters
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    // Business Logic Methods
    public String addProduit() {
        produitService.addProduit(produit); // Call EJB method
        produits = produitService.listProduits(); // Refresh the list
        produit = new Produit(); // Reset the form
        return null; // Stay on the same page
    }

    public String updateProduit() {
        produitService.editProduit(produit);
        produits = produitService.listProduits();
        return null;
    }

    public String deleteProduit(Produit produitToDelete) {
        produitService.deleteProduit(produitToDelete.getCode());
        produits = produitService.listProduits();
        return null;
    }

    public String findProduitByCode(String code) {
        produit = (Produit) produitService.getProduit(code);
        return null;
    }
}

