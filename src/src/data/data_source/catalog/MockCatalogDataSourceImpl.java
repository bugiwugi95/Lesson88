package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;

public class MockCatalogDataSourceImpl extends CatalogDataSource{
    @Override
    public ArrayList<Product> getCatalog() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1","smartphone","best smartphone",1000,true));
        products.add(new Product("id2","laptop","best laptop",3000,true));
        products.add(new Product("id3","Watch","best Watch",500,true));
        products.add(new Product("id4","phone","best phone",100,true));
        return products;
    }
}
