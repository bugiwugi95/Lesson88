package view;

import common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {

    public CatalogView(ShopService service, ArrayList<AppView> children) {
        super("Каталог", children);
        this.service = service;
    }

    public final ShopService service;

    @Override
    public void action() {
        ArrayList<Product> catalog = service.getCatalog();
        for (Product p : catalog) {
            System.out.println(p.id + " " + p.title + " " + p.price);
        }
        System.out.println();
    }
}
