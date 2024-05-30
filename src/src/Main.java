import common.AppView;
import common.PageLoop;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataSourceImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService service = new ShopService(catalogDataSource, cartDataSource, orderDataSource);
        AppView addToCardView = new AddToCartView(service);

        AppView cartView = new CartView(service);
        AppView orderView = new OrderView(service);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCardView);
        AppView catalogView = new CatalogView(service, catalogChildren);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();

//        System.out.println(service.getCatalog());
//        System.out.println(service.getCart());
//        System.out.println(service.addToCart(service.getCatalog().get(0).id, 5));
//        System.out.println(service.addToCart("dfs32", 5));
//        System.out.println(service.getCart());
    }
}