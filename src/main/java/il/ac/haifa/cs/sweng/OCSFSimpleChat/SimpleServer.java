package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import il.ac.haifa.cs.sweng.OCSFSimpleChat.ocsf.server.AbstractServer;
import il.ac.haifa.cs.sweng.OCSFSimpleChat.ocsf.server.ConnectionToClient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class SimpleServer extends AbstractServer {

    private static Session session;

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Catalog.class);
        configuration.addAnnotatedClass(SignUp.class);
        configuration.addAnnotatedClass(Complain.class);
        configuration.addAnnotatedClass(SpecialItem.class);
        configuration.addAnnotatedClass(CustomerWorkerRespond.class);
        configuration.addAnnotatedClass(Shop.class);
        configuration.addAnnotatedClass(Order.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static List<Catalog> getCatalog() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Catalog> query = builder.createQuery(Catalog.class);
        query.from(Catalog.class);
        return session.createQuery(query).getResultList();
    }

    public static List<SignUp> getUsersInformation() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SignUp> query = builder.createQuery(SignUp.class);
        query.from(SignUp.class);
        return session.createQuery(query).getResultList();
    }

    public static List<Complain> getComplains() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Complain> query = builder.createQuery(Complain.class);
        query.from(Complain.class);
        return session.createQuery(query).getResultList();
    }

    public static List<SpecialItem> getSpecialItems() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SpecialItem> query = builder.createQuery(SpecialItem.class);
        query.from(SpecialItem.class);
        return session.createQuery(query).getResultList();
    }

    public static List<CustomerWorkerRespond> customerWorkerResponds() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerWorkerRespond> query = builder.createQuery(CustomerWorkerRespond.class);
        query.from(CustomerWorkerRespond.class);
        return session.createQuery(query).getResultList();
    }

    public static List<Shop> getShops() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Shop> query = builder.createQuery(Shop.class);
        query.from(Shop.class);
        return session.createQuery(query).getResultList();
    }
    
    public static List<Order> getOrders() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        query.from(Order.class);
        return session.createQuery(query).getResultList();
    }

    public static void generate() {
        session.save(new Catalog("/Image/All_Day_Love.png", "All Day Love",

                "65.99", "Mixed roses in a glass bowl and a teddy bear",
                "Approximately 11\" W x 12\" H", "ffd000"));
        session.flush();
        session.save(new Catalog("/Image/Basket_To_Love_You.png", "Basket To Love You",
                "59.99", "Arrangement of roses in a basket and a teddy bear", "Approximately 12\" W x 12\" H", "f76da9"));
        session.flush();

        session.save(new Catalog("/Image/Beautiful_You.png", "Beautiful You",
                "69.99", "Arrangement of roses in a wicker basket",
                "Approximately 12\" W x 12\" H", "f72323"));
        session.flush();

        session.save(new Catalog("/Image/Charming_Day.png", "Charming Day",
                "88.99", "Premium long stem roses arranged in a glass vase and a box of chocolates", "Approximately 20\" W x 24\" H", "ff0000"));
        session.flush();

        session.save(new Catalog("/Image/Charming_Roses.png", "Charming Roses",
                "85.99", "Arrangement of long-stemmed roses in a vase",
                "Approximately 27\" W. x 31\" H", "750000"));
        session.flush();

        session.save(new Catalog("/Image/Lavender_Roses.png", "Lavender Roses",
                "57.99", "Arrangement of 12 or 18 lavender roses in a glass vase", "Approximately 14\" W. x 16\" H", "db7fd1"));
        session.flush();

        session.save(new Catalog("/Image/Love_Arrangement.png", "Love Arrangement",
                "64.99", "Arrangement of pink carnations, monte casino, lisianthus and others in a glass vase",
                "Approximately 9\" W x 11\" H", "e0a2da"));
        session.flush();

        session.save(new Catalog("/Image/Multicoloured_Aroma.png", "Multicoloured Aroma",
                "55.99", "Arrangement of gerbera, daisies, roses and seasonal flowers in a glass vase", "Approximately 10\" W x 11\" H", "a200ff"));
        session.flush();

        session.save(new Catalog("/Image/Night_Wish_Roses.png", "Night Wish Roses",
                "39.99", "Arrangement of orange roses and green foliage in a glass vase",
                "Approximately 16\" W. x 18\" H", "ff8c00"));
        session.flush();

        session.save(new Catalog("/Image/Pop_Israel_Flowers.png", "Pop Israel Flowers",
                "59.99", "Arrangement of daisies, peruvian lilies, gerberas and chrysanthemums along with a vase", "Approximately 9\" H x 8\" W", "196ef7"));

        session.flush();
        session.save(new Catalog("/Image/Sweet_Tender.png", "Sweet Tender",
                "59.99", "Arrangement of mixed pink, purple and lavender roses in a vase",
                "Approximately 12\" W. x 16\" H", "ff0055"));
        session.flush();

        session.save(new Catalog("/Image/The_Best_Day.png", "The Best Day",
                "59.99", "Arrangement of roses, lilies and alstroemeria in a glass vase", "Approximately 10.5\" W x 11\" H", "c9c9c9"));
        session.flush();

        session.save(new SignUp("customer service", "abed", "abed", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("system worker", "mohammed", "mohammed", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("elite", "I'm", "yes", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("elite", "I", "no", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("shop manager 1", "Sgier", "s", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("system manager", "haya", "h", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("shop 1", "meme", "l", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("shop 4", "lolo", "k", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("shop 3", "sheshe", "g", "0542293918", "", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();
    }

    public static void addToDataBase() {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            if (getCatalog().isEmpty()) {
                generate();
            }

            session.getTransaction().commit(); // Save everything.
        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occurred, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public SimpleServer(int port) {
        super(port);
    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {

        MsgObject msgObject = (MsgObject) msg;

        switch (msgObject.getMsg()) {
            case "catalogueUser":
            case "cartUser":
            case "Catalog":
            case "catalogueSystemWorker":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setCatalogList(getCatalog());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Catalog> list = msgObject.getCatalogList();
                    for (Catalog c : list) {
                        session.update(c);
                        session.flush();
                    }

                    System.out.println("updating the price");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;
            case "removeItem":
                //we should make a notification for a refund for a specific item
            {Order orderT = new Order();

                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Order> orders = getOrders();
                    List<Shop> shops = getShops();
                    Catalog catalog = (Catalog) msgObject.getObject();

                    for (Order order : orders) {
                        if (order.getId() == catalog.getOrder().getId()) {
                            catalog.setUser(null);
                            catalog.setOrder(null);

                            orderT = order;

                            session.remove(catalog);
                            session.flush();

                            order.setPrice(String.valueOf(Double.parseDouble(order.getPrice()) - Double.parseDouble(catalog.getPrice())));
                            order.setNumberOfItems(order.getNumberOfItems() - 1);

                            session.update(order);
                            session.flush();

                            msgObject.setObject(order);
                            msgObject.setCatalogList(getCatalog());
                            break;
                        }
                    }

                    CustomerWorkerRespond customerWorkerRespond = new CustomerWorkerRespond();
                    SignUp user = orderT.getUser();

                    for (Shop shop : shops) {
                        if (shop.getShopId().equals(user.getAccountType()) && shop.getDate().equals(orderT.getDate().substring(0, 10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(catalog.getPrice()));
                            if (shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            } else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        } else if (shop.getShopId().equals("shop 100")
                                && (user.getAccountType().equals("elite") || user.getAccountType().equals("gold"))
                                && shop.getDate().equals(orderT.getDate().substring(0, 10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(catalog.getPrice()));
                            if (shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            } else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        }
                    }

                    Date date = new Date();

                    String refund = ""; // we need to check the data here and send a refund
                    String[] stringDate = orderT.getDate().split(" ");
                    String[] stringHour = stringDate[1].split(":");
                    String[] stringDay = stringDate[0].split("-");

                    int day = Integer.parseInt(stringDay[2]);
                    int hour = Integer.parseInt(stringHour[0]);// we need to take care when the hour is one digit // done

                    if (day >= date.getDay()) {
                        if (day > date.getDay() || hour - 3 > date.getHours()) {
                            customerWorkerRespond.setRefund("" + catalog.getPrice());
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(catalog.getPrice())));
                            refund = "According to the instruction of the shop we see that you will be refunded by 100% of the value of this order.";
                        } else if (hour - 3 <= date.getHours() && hour - 1 >= date.getHours()) {
                            customerWorkerRespond.setRefund("" + (Double.parseDouble(catalog.getPrice()) * 0.5));
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(catalog.getPrice()) * 0.5));
                            refund = "According to the instruction of the shop we see that you will be refunded by 50% of the value of this order.";
                        } else {
                            customerWorkerRespond.setRefund("0");
                            refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                        }
                    } else {
                        customerWorkerRespond.setRefund("0");
                        refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                    }
                    customerWorkerRespond.setNameWorker("System");
                    customerWorkerRespond.setName(orderT.getUser().getUsername());
                    customerWorkerRespond.setEmail(orderT.getUser().getEmail());
                    customerWorkerRespond.setPhone(orderT.getPhone());
                    customerWorkerRespond.setMessage("Your Order: " + orderT.getUser().getUsername() + " " + catalog.getPrice());
                    customerWorkerRespond.setRespondMessage(refund);
                    customerWorkerRespond.setDate(date.toString());

                    session.update(user);
                    session.flush();

                    session.save(customerWorkerRespond);

                    msgObject.setUser(user);
                    msgObject.setMsg("detailedOrderUser");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    if(orderT.getNumberOfItems() == 0) {
                        orderT.setUser(null);
                        session.remove(orderT);
                        session.flush();
                        msgObject.setObject(getOrders());
                        msgObject.setMsg("myOrdersUser");
                    }


                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }


                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                break;
            case "removeItemAndOrder":
                //we should make a notification for a refund or something for all of the order
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Order> orders = getOrders();
                    List<Shop> shops = getShops();
                    Catalog catalog = (Catalog) msgObject.getObject();

                    Order orderT = new Order();
                    SignUp user = new SignUp();

                    for(Order order : orders){
                        if(order.getId() == catalog.getOrder().getId()) {
                            catalog.setUser(null);
                            catalog.setOrder(null);

                            user = order.getUser();

                            orderT = order;

                            session.remove(catalog);
                            session.flush();

                            order.setUser(null);
                            session.remove(order);
                            session.flush();
                            break;
                        }
                    }

                    for(Shop shop : shops){
                        if(shop.getShopId().equals(user.getAccountType()) && shop.getDate().equals(orderT.getDate().substring(0,10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(catalog.getPrice()));
                            shop.setNumberOfOrders(shop.getNumberOfOrders() - 1);
                            if(shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            }
                            else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        }
                        else if(shop.getShopId().equals("shop 100")
                                && (user.getAccountType().equals("elite") || user.getAccountType().equals("gold"))
                                && shop.getDate().equals(orderT.getDate().substring(0,10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(catalog.getPrice()));
                            shop.setNumberOfOrders(shop.getNumberOfOrders() - 1);
                            if(shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            }
                            else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        }
                    }


                    CustomerWorkerRespond customerWorkerRespond = new CustomerWorkerRespond();

                    Date date = new Date();

                    String refund = ""; // we need to check the data here and send a refund
                    String[] stringDate = orderT.getDate().split(" ");
                    String[] stringHour = stringDate[1].split(":");
                    String[] stringDay = stringDate[0].split("-");

                    int day = Integer.parseInt(stringDay[2]);
                    int hour = Integer.parseInt(stringHour[0]);// we need to take care when the hour is one digit // done

                    if (day >= date.getDay() && user != null) {
                        if (day > date.getDay() || hour - 3 > date.getHours()) {
                            customerWorkerRespond.setRefund("" + orderT.getPrice());
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(orderT.getPrice())));
                            refund = "According to the instruction of the shop we see that you will be refunded by 100% of the value of this order.";
                        } else if (hour - 3 <= date.getHours() && hour - 1 >= date.getHours()){
                            customerWorkerRespond.setRefund("" + (Double.parseDouble(orderT.getPrice()) * 0.5));
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(orderT.getPrice()) * 0.5));

                            refund = "According to the instruction of the shop we see that you will be refunded by 50% of the value of this order.";
                        }else {
                            customerWorkerRespond.setRefund("0");
                            refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                        }
                    } else {
                        customerWorkerRespond.setRefund("0");
                        refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                    }
                    customerWorkerRespond.setNameWorker("System");
                    customerWorkerRespond.setName(user.getUsername());
                    customerWorkerRespond.setEmail(user.getEmail());
                    customerWorkerRespond.setPhone(orderT.getPhone());
                    customerWorkerRespond.setMessage("Your Order: " + user.getUsername() + " " + orderT.getPrice());
                    customerWorkerRespond.setRespondMessage(refund);
                    customerWorkerRespond.setDate(date.toString());

                    session.update(user);
                    session.flush();

                    session.save(customerWorkerRespond);

                    msgObject.setUser(user);
                    msgObject.setObject(getOrders());
                    msgObject.setMsg("myOrdersUser");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "detailedOrderUser":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setCatalogList(getCatalog());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteItem":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    Catalog catalog = (Catalog) msgObject.getObject();
                    catalog.setUser(null);
                    session.remove(catalog);
                    session.flush();


                    System.out.println("removing catalog");

                    msgObject.setCatalogList(getCatalog());
                    msgObject.setMsg("catalogueSystemWorker");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "removeFromOrder":
                //we should send a notification about the refund he deserves
                //we need to make a new instance of CustomerWorkerRespond and send an automatic messsage to the user notification
                //all we need to do is save it to the database
                //we need to take catalog out and put order in

                //we will get an order to remove by msgObject.getObject() and we will get the catalog list to remove by msgObject.getCatalogList()
            {
                Order order = (Order) msgObject.getObject();
                SignUp user = order.getUser();
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();


                    Date date = new Date();


                    List<Catalog> catalogs = getCatalog();
                    List<Shop> shops = getShops();

                    for (Catalog catalog : catalogs) { //we remove the items that in the catalog we can find them

                        if (catalog.getUser() != null && catalog.getOrder().getId() == order.getId()) {//by searching in all the catalogs and see the catalog.order
                            catalog.setUser(null);
                            catalog.setOrder(null);
                            session.remove(catalog);
                            session.flush();
                        }
                    }

                    for(Shop shop : shops){
                        if(shop.getShopId().equals(user.getAccountType())  && shop.getDate().equals(order.getDate().substring(0,10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(order.getPrice()));
                            shop.setNumberOfOrders(shop.getNumberOfOrders() - 1);
                            if(shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            }
                            else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        }
                        else if(shop.getShopId().equals("shop 100")
                                && (user.getAccountType().equals("elite") || user.getAccountType().equals("gold"))
                                && shop.getDate().equals(order.getDate().substring(0,10))) {
                            shop.setProfit(shop.getProfit() - Double.parseDouble(order.getPrice()));
                            shop.setNumberOfOrders(shop.getNumberOfOrders() - 1);
                            if(shop.getNumberOfOrders() == 0) {
                                session.remove(shop);
                                session.flush();
                            }
                            else {
                                session.update(shop);
                                session.flush();
                            }
                            break;
                        }
                    }

                    CustomerWorkerRespond customerWorkerRespond = new CustomerWorkerRespond();


                    String refund = ""; // we need to check the data here and send a refund
                    String[] stringDate = order.getDate().split(" ");
                    String[] stringHour = stringDate[1].split(":");
                    String[] stringDay = stringDate[0].split("-");

                    int day = Integer.parseInt(stringDay[2]);
                    int hour = Integer.parseInt(stringHour[0]);// we need to take care when the hour is one digit // done

                    if (day >= date.getDay()) {
                        if (day > date.getDay() || hour - 3 > date.getHours()) {
                            customerWorkerRespond.setRefund("" + order.getPrice());
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(order.getPrice())));
                            refund = "According to the instruction of the shop we see that you will be refunded by 100% of the value of this order.";
                        } else if (hour - 3 <= date.getHours() && hour - 1 >= date.getHours()) {
                            customerWorkerRespond.setRefund("" + (Double.parseDouble(order.getPrice()) * 0.5));
                            user.setMoneyInTheBank("" + (Double.parseDouble(user.getMoneyInTheBank()) + Double.parseDouble(order.getPrice()) * 0.5));

                            refund = "According to the instruction of the shop we see that you will be refunded by 50% of the value of this order.";
                        } else {
                            customerWorkerRespond.setRefund("0");
                            refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                        }
                    } else {
                        customerWorkerRespond.setRefund("0");
                        refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";
                    }

                    customerWorkerRespond.setNameWorker("System");
                    customerWorkerRespond.setName(order.getUser().getUsername());
                    customerWorkerRespond.setEmail(order.getUser().getEmail());
                    customerWorkerRespond.setPhone(order.getPhone());
                    customerWorkerRespond.setMessage("Your Order: " + order.getUser().getUsername() + " " + order.getPrice());
                    customerWorkerRespond.setRespondMessage(refund);
                    customerWorkerRespond.setDate(date.toString());

                    session.save(customerWorkerRespond);

                    System.out.println("removing order");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                try {//we get an error when we try to remove two things that are linked
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    System.out.println(user.getMoneyInTheBank());

                    session.update(user);
                    session.flush();

                    order.setUser(null);
                    session.remove(order);
                    session.flush();

                    msgObject.setObject(getOrders());
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                msgObject.setMsg("myOrdersUser");
                msgObject.setUser(user);

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case "removeFromCart":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.getCatalogList().get(0).setUser(null);
                    session.update(msgObject.getCatalogList().get(0));
                    session.flush();

                    for (Catalog catalog : msgObject.getCatalogList()) {
                        session.remove(catalog);
                    }

                    System.out.println("removing catalog");

                    msgObject.setCatalogList(getCatalog());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                msgObject.setMsg("cartUser");

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "cartToOrder":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Catalog> catalogs = msgObject.getCatalogList();
                    Order order = (Order) msgObject.getObject(); // we get it from the confirmation page, there the client chooses the date and if he wants a shipping.

                    for (Catalog catalog : catalogs) {
                        session.update(catalog);
                        session.flush();
                    }

                    order.setUser(catalogs.get(0).getUser());
                    order.setNumberOfItems(catalogs.size());

                    for (Catalog catalog : catalogs) {
                        catalog.setOrder(order);
                        session.update(catalog);
                        session.flush();
                    }

                    session.save(order);
                    session.flush();

                    //we need to take care of elite and gold users we need to make a global shop. //done
                    //we need to take the date when the client made the order not the arrival time
                    //we have a problem with date
                    //we need to take catalog out and put order in
                    List<Shop> shops = getShops();
                    boolean found = false;
                        for (Shop shop : shops) {
                            if((shop.getDate().equals(order.getDate().substring(0,10)) && shop.getShopId().equals(order.getUser().getAccountType()))){
                                shop.setNumberOfOrders(shop.getNumberOfOrders()+1);
                                shop.setProfit(shop.getProfit() + Double.parseDouble(order.getPrice()));
                                found = true;
                                break;
                            }
                            else if (shop.getDate().equals(order.getDate().substring(0,10)) && (order.getUser().getAccountType().equals("elite") || order.getUser().getAccountType().equals("gold")) && shop.getShopId().equals("shop 11")) {
                                found = true;
                                shop.setNumberOfOrders(shop.getNumberOfOrders() + 1);
                                break;
                            }
                        }
                        if(!found){
                            if(order.getUser().getAccountType().equals("elite") || order.getUser().getAccountType().equals("gold")){
                                shops.add(new Shop("shop 11", 0, Double.parseDouble(order.getPrice()), 1, order.getDate().substring(0,10)));
                            }
                            else {
                                shops.add(new Shop(order.getUser().getAccountType(), 0, Double.parseDouble(order.getPrice()), 1, order.getDate().substring(0, 10)));
                            }
                        }

                    for(Shop shop : shops){
                        session.saveOrUpdate(shop);
                        session.flush();
                    }

                    System.out.println("updating the order of the user");

                    msgObject.setCatalogList(getCatalog());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }

                msgObject.setMsg("cartUser");

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "updateCart":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.update(msgObject.getObject());

                    System.out.println("updating cart");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;

            case "addItem":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.save(msgObject.getObject());

                    System.out.println("saving a new cart or item to catalog");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;
            case "addToCart":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.save(msgObject.getObject());

                    System.out.println("saving a new cart or item to catalog");
                    msgObject.setCatalogList(getCatalog());
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                msgObject.setMsg("catalogueUser");
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "complaintsCustomerService":

                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setObject(getComplains());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "exit":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.update(msgObject.getObject());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                break;
            case "Home":
            case "primaryUser":
            case "primaryCustomerService":
            case "primarySystemWorker":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.update(msgObject.getObject());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "complainList":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.saveOrUpdate(msgObject.getObject());

                    Complain complain = (Complain) msgObject.getObject();
                    List<Shop> shops = getShops();
                    boolean found = false;

                    for(Shop shop : shops){
                        if(shop.getDate().equals(complain.getDate().substring(0,10)) && shop.getShopId().equals(complain.getShopId())){
                            found = true;
                            shop.setNumberOfComplaints(shop.getNumberOfComplaints()+1);
                            session.update(shop);
                            session.flush();
                            break;
                        }
                    }

                    for(Shop shop : shops){
                        if (complain.getDate().substring(0,10).equals(shop.getDate()) && (complain.getShopId().equals("elite") || complain.getShopId().equals("gold")) && shop.getShopId().equals("shop 11")){
                            found = true;
                            shop.setNumberOfComplaints(shop.getNumberOfComplaints()+1);
                            session.update(shop);
                            session.flush();
                            break;
                        }
                    }

                    if(!found){
                        if(complain.getShopId().equals("elite") || complain.getShopId().equals("gold")){
                            session.save(new Shop("shop 11", 1, 0, 0, complain.getDate().substring(0,10)));
                            session.flush();
                        }
                        else {
                            session.save(new Shop(complain.getShopId(), 1, 0, 0, complain.getDate().substring(0,10)));
                            session.flush();
                        }
                    }

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;
            case "MakeAnOrder":
            case "specialItem":
            case "addUser":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    session.saveOrUpdate(msgObject.getObject());

                    System.out.println("adding a new member or a special item or a complain or an item or an order");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;

            case "myOrdersUser":

                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    //we need to take catalog out and put order in


                    msgObject.setObject(getOrders());
                    System.out.println("getting orders");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


            case "removeNotification":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    CustomerWorkerRespond complainRespond = (CustomerWorkerRespond) msgObject.getObject();
                    session.remove(complainRespond);
                    session.flush();

                    System.out.println("remove  notification");
                    msgObject.setObject(customerWorkerResponds());
                    msgObject.setMsg("notificationsUser");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "removeUserManager":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    SignUp signUp = (SignUp) msgObject.getObject();
                    session.remove(signUp);
                    session.flush();

                    System.out.println("remove User");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "specialOrdersCustomerService":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setObject(getSpecialItems());

                    System.out.println("getting special items");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "itemRefused":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    CustomerWorkerRespond customerWorkerRespond = (CustomerWorkerRespond) msgObject.getObject();
                    List<SpecialItem> specialItems = getSpecialItems();

                    session.save(customerWorkerRespond);
                    session.flush();


                    if(specialItems != null) {
                        for (SpecialItem specialItem : specialItems) {
                            if (specialItem.getData().equals(customerWorkerRespond.getMessage()) ) {
                                specialItem.setUser(null);
                                session.remove(specialItem);
                                session.flush();
                            }
                        }
                    }

                    System.out.println("refusing a special item");
                    msgObject.setMsg("specialOrdersCustomerService");
                    msgObject.setObject(getSpecialItems());
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "itemAccept":
            case "itemRespond":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    CustomerWorkerRespond customerWorkerRespond = (CustomerWorkerRespond) msgObject.getObject();
                    List<SpecialItem> specialItems = getSpecialItems();

                    session.save(customerWorkerRespond);
                    session.flush();
                    Catalog catalog = new Catalog();


                    if(specialItems != null) {
                        for (SpecialItem specialItem : specialItems) {
                            if (specialItem.getData().equals(customerWorkerRespond.getMessage()) ) {
                                catalog.setLeft(specialItem.getNumOfFlowers());
                                catalog.setName(specialItem.getContainer());
                                catalog.setPrivilege(1);
                                catalog.setItemDetails(specialItem.getData());
                                catalog.setUser(specialItem.getUser());
                                catalog.setPrice(specialItem.getPrice().substring(7));
                                catalog.setColor(specialItem.getColor());
                                catalog.setSize("Unknown (special item).");

                                specialItem.setUser(null);
                                session.remove(specialItem);
                                session.save(catalog);
                                session.flush();
                                break;
                            }
                        }
                    }

                    System.out.println("accepting a special item");
                    msgObject.setMsg("specialOrdersCustomerService");
                    msgObject.setObject(getSpecialItems());
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "messageRespond":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    //there is a problem where I cant get the catalog.
                    CustomerWorkerRespond customerWorkerRespond = (CustomerWorkerRespond) msgObject.getObject();
                    session.save(customerWorkerRespond);
                    session.flush();

                    List<Complain> complains = getComplains();

                    for(Complain complain : complains){
                        if(complain.getEmail().equals(customerWorkerRespond.getEmail())) {
                            session.remove(complain);
                            session.flush();
                            break;
                        }
                    }
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                break;
            case "messageRefused":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    //there is a problem where I cant get the catalog.
                    CustomerWorkerRespond customerWorkerRespond = (CustomerWorkerRespond) msgObject.getObject();
                    session.save(customerWorkerRespond);
                    session.flush();

                    List<Complain> complains = getComplains();

                    for(Complain complain : complains){
                        if(complain.getEmail().equals(customerWorkerRespond.getEmail()) && complain.getMessage().equals(customerWorkerRespond.getMessage())) {
                            session.remove(complain);
                            session.flush();
                            break;
                        }
                    }



                    msgObject.setObject(getComplains());

                    msgObject.setMsg("complaintsCustomerService");
                    System.out.println("responded to a complain");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "removeAllNotification":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    //there is a problem where I cant get the catalog.
                    List<CustomerWorkerRespond> complainResponds = customerWorkerResponds();
                    SignUp user = (SignUp) msgObject.getObject();

                    for(CustomerWorkerRespond complainRespond : complainResponds){
                        if(complainRespond.getEmail().equals(user.getEmail())){
                            session.remove(complainRespond);
                            session.flush();
                        }
                    }

                    System.out.println("remove all notif");
                    msgObject.setObject(customerWorkerResponds());
                    msgObject.setMsg("notificationsUser");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "notificationsUser":
                //we added an automatic refund if passed 24 hours on the complaint.
                //we need to check if it works.
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<CustomerWorkerRespond> customerWorkerResponds = customerWorkerResponds();
                    List<Complain> complains = getComplains();
                    CustomerWorkerRespond customerWorkerRespond = null;
                    SignUp user = msgObject.getUser();
                    Date date = new Date();
                    String refund = "We are sorry, we could not answer you in time, so we decided to refund you for that."; //

                    for(Complain complain : complains){
                        if(complain.getEmail().equals(user.getEmail())) {
                            String[] stringDate = complain.getDate().split(" ");
                            String[] stringHour = stringDate[1].split(":");
                            String[] stringDay = stringDate[0].split("-");

                            int day = Integer.parseInt(stringDay[2]);
                            int hour = Integer.parseInt(stringHour[0]);// we need to take care when the hour is one digit // done
                            int minutes = Integer.parseInt((stringHour[1]));

                            if (day == date.getDay()-1) {
                                if(hour < date.getHours() || hour == date.getHours() && date.getMinutes() >= minutes){
                                    customerWorkerRespond = new CustomerWorkerRespond("System", complain.getName(), complain.getEmail(), complain.getPhone(), complain.getMessage(), refund);
                                    customerWorkerResponds.add(customerWorkerRespond);
                                    session.save(customerWorkerRespond);
                                    session.flush();
                                }
                            }
                            else if(day < date.getDay()-1){
                                customerWorkerRespond = new CustomerWorkerRespond("System", complain.getName(), complain.getEmail(), complain.getPhone(), complain.getMessage(), refund);
                                customerWorkerResponds.add(customerWorkerRespond);
                                session.save(customerWorkerRespond);
                                session.flush();
                            }


                        }
                    }

                    msgObject.setObject(customerWorkerResponds);
                    System.out.println("get complain responds");
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "signIn":
            case "contactUs":
            case "signUp":
            case "editAccountInformation":
            case "editUsersManager":
            case "editUserManager":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setObject(getUsersInformation());

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "compareHist Orders":
            case "compareHist Profit":
            case "compareHist Complaints":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Shop> shops = getShops();
                    List<Shop> tempShops = new ArrayList<>();
                    String str = (String) msgObject.getObject();
                    String[] strTemp = str.split(" ");

                    for(Shop shop : shops){
                        if(shop.getShopId().equals("shop " + strTemp[0]) || shop.getShopId().equals("shop " + strTemp[1])) {
                            tempShops.add(shop);
                        }
                    }

                    msgObject.setObject(tempShops);
                    msgObject.setMsg(msgObject.getMsg() + " " + str);
                    System.out.println("getting shops");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Histogram Complaints ALL":
            case "Histogram Profit ALL":
            case "Histogram Orders ALL":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setObject(getShops());

                    System.out.println("getting shops");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "Histogram Orders":
            case "Histogram Profit":
            case "Histogram Complaints":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<Shop> shops = getShops();
                    List<Shop> tempShops = new ArrayList<>();
                    int id = (int) msgObject.getObject();

                    for(Shop shop : shops){
                        if(shop.getShopId().equals("shop " + id)) {
                            tempShops.add(shop);
                        }
                    }

                    msgObject.setObject(tempShops);
                    msgObject.setMsg(msgObject.getMsg() + " " + id);
                    System.out.println("getting shops");

                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case "signInButton":
                SignUp usr = null;
                boolean found = false;
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    List<SignUp> users = getUsersInformation();
                    String namePassword = (String) msgObject.getObject();

                    for(SignUp user : users){
                        if (((user.getEmail() + user.getPassword()).equals(namePassword) ||
                                (user.getUsername() + user.getPassword()).equals(namePassword)) && !user.isSignedIn()) {
                            found = true;
                            usr = user;
                            usr.setSignedIn(true);
                        }
                        else  if (((user.getEmail() + user.getPassword()).equals(namePassword) ||
                                (user.getUsername() + user.getPassword()).equals(namePassword)) && user.isSignedIn()) {
                            found = true;
                        }
                    }
                    msgObject.setObject(getUsersInformation());
                    session.getTransaction().commit(); // Save everything.
                } catch (Exception exception) {
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                    System.err.println("An error occurred, changes have been rolled back.");
                    exception.printStackTrace();
                }
                if(found) {
                    if(usr == null){
                        msgObject.setIn(2);
                        msgObject.setMsg("signIn");
                    }
                    else{
                        switch (usr.getAccountType()) {

                            case "system worker":
                                msgObject.setMsg("primarySystemWorker");
                                msgObject.setObject(usr);
                                break;

                            case "customer service":
                                msgObject.setMsg("primaryCustomerService");
                                msgObject.setObject(usr);
                                break;

                            case "system manager":
                                msgObject.setMsg("primaryManager");
                                msgObject.setObject(usr);
                                break;
                            case "shop manager 1":
                            case "shop manager 2":
                            case "shop manager 3":
                            case "shop manager 4":
                            case "shop manager 5":
                            case "shop manager 6":
                            case "shop manager 7":
                            case "shop manager 8":
                            case "shop manager 9":
                            case "shop manager 10":
                                msgObject.setMsg("primarySingleShopManager");
                                msgObject.setObject(usr);
                                break;

                            default:
                                msgObject.setMsg("primaryUser");
                                msgObject.setObject(usr);
                        }
                    }
                }
                else {
                    msgObject.setMsg("signIn");
                    msgObject.setIn(1);
                }
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "signUpAccountType":
            default:
                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected synchronized void clientDisconnected(ConnectionToClient client) {
        // TODO Auto-generated method stub
        //here we can close the database once
        System.out.println("Client Disconnected.");
        super.clientDisconnected(client);
    }

    @Override
    protected void clientConnected(ConnectionToClient client) {
        //here we can open the database once
        super.clientConnected(client);
        System.out.println("Client connected: " + client.getInetAddress());
    }

}
