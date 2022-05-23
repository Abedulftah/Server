package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

        session.save(new SignUp("customer service", "abed", "abed", "0542293918", "!", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("system worker", "mohammed", "mohammed", "0542293918", "!", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("elite", "I'm", "yes", "0542293918", "!", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
        session.flush();

        session.save(new SignUp("elite", "I", "no", "0542293918", "!", "kawkab main 2018500", "456486468468484", "abed", "2024/07", 656));
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
                //we need to make a new instance of CustomerWorkerRespond and send an automatic message to the user notification
                //all we need to do is save it to the database
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();
                    Date date = new Date();
                    Catalog catalog1 = msgObject.catalogList.get(0);

                    String refund = ""; // we need to check the data here and send a refund

                    int day = Integer.parseInt(catalog1.getDate().substring(8,10));
                    int hour = Integer.parseInt(catalog1.getDate().substring(11,12));

                    if(day >= date.getDay() && (hour > date.getHours())){
                        if(day > date.getDay() || hour - 3 > date.getHours())
                            refund = "According to the instruction of the shop we see that you will be refunded by 100% of the value of this order.";
                        else if(hour - 3 <= date.getHours() && hour - 1 >= date.getHours())
                            refund = "According to the instruction of the shop we see that you will be refunded by 50% of the value of this order.";
                    }
                    else
                        refund = "According to the instruction of the shop we see that you will not be refunded for canceling this order.";

                    session.save(new CustomerWorkerRespond("System", catalog1.getUser().getUsername(), catalog1.getUser().getEmail()
                    , catalog1.getUser().getPhone(), "Your Order: " + catalog1.getName() + " " + catalog1.getPrice(), refund));

                    catalog1.setUser(null);
                    session.update(catalog1);
                    session.flush();


                    for(Catalog catalog : msgObject.getCatalogList()) {
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

                msgObject.setMsg("myOrdersUser");

                try {
                    client.sendToClient(msgObject);
                } catch (IOException e) {
                    e.printStackTrace();
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

                    List<Catalog> catalogs = (List<Catalog>) msgObject.getObject();

                    if (catalogs != null) {
                        for (Catalog catalog : catalogs) {
                            catalog.setUser(null);
                            session.remove(catalog);
                            System.out.println("removing an item that exists");
                        }
                    }

                    for (Catalog catalog : msgObject.getCatalogList()) {
                        session.update(catalog);
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
            case "MakeAnOrder":
            case "complainList":
            case "specialItem":
            case "addUser":
                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    //there is a problem where I cant get the catalog.
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

                    msgObject.setCatalogList(getCatalog());
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

                try {
                    SessionFactory sessionFactory = getSessionFactory();
                    session = sessionFactory.openSession();
                    session.beginTransaction();

                    msgObject.setObject(customerWorkerResponds());
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
                                /////
                                break;

                            case "shop manager":
                                ////
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
            case "signUp":
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
