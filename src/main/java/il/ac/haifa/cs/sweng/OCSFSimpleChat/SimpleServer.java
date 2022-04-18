package il.ac.haifa.cs.sweng.OCSFSimpleChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
		configuration.addAnnotatedClass(MyImage.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();

		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static List<Catalog> getCatalog(){
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Catalog> query = builder.createQuery(Catalog.class);
		query.from(Catalog.class);
		List<Catalog> data = session.createQuery(query).getResultList();
		return data;
	}

	public static void generate(){
		session.save(new Catalog(new MyImage("/Controller/Image/All_Day_Love.png"), "All Day Love",
				65.99, "Mixed roses in a glass bowl and a teddy\nbear",
				"Approximately 11\" W x 12\" H", "ffd000"));
		session.flush();
		session.save(new Catalog(new MyImage("/Controller/Image/Basket_To_Love_You.png"), "Basket To Love You",
				59.99, "Arrangement of roses in a basket and a\nteddy bear", "Approximately 12\" W x 12\" H", "f76da9"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Beautiful_You.png"), "Beautiful You",
				69.99, "Arrangement of roses in a wicker basket",
				"Approximately 12\" W x 12\" H", "f72323"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Charming_Day.png"), "Charming Day",
				88.99, "Premium long stem roses arranged in a\nglass vase and a box of chocolates", "Approximately 20\" W x 24\" H", "ff0000"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Charming_Roses.png"), "Charming Roses",
				85.99, "Arrangement of long-stemmed roses in\na vase",
				"Approximately 27\" W. x 31\" H", "750000"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Lavender_Roses.png"), "Lavender Roses",
				57.99, "Arrangement of 12 or 18 lavender roses\nin a glass vase", "Approximately 14\" W. x 16\" H", "db7fd1"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Love_Arrangement.png"), "Love Arrangement",
				64.99, "Arrangement of pink carnations, monte\ncasino, lisianthus and others in a glass\nvase",
				"Approximately 9\" W x 11\" H", "e0a2da"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Multicoloured_Aroma.png"), "Multicoloured Aroma",
				55.99, "Arrangement of gerbera, daisies, roses\nand seasonal flowers in a glass vase", "Approximately 10\" W x 11\" H", "a200ff"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Night_Wish_Roses.png"), "Night Wish Roses",
				39.99, "Arrangement of orange roses and green\nfoliage in a glass vase",
				"Approximately 16\" W. x 18\" H", "ff8c00"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/Purple_Heaven.png"), "Purple Heaven",
				69.99, "Arrangement of lavender roses, pink\nwaxflower, fuchsia miniature carnations,\npurple stock, trachelium and alstroemeria\nin a glass vase.", "Approximately 10\" W x 10\" H", "9d00ff"));

		session.flush();
		session.save(new Catalog(new MyImage("/Controller/Image/Sweet_Tender.png"), "Sweet Tender",
				59.99, "Arrangement of mixed pink, purple and\nlavender roses in a vase",
				"Approximately 12\" W. x 16\" H", "ff0055"));
		session.flush();

		session.save(new Catalog(new MyImage("/Controller/Image/The_Best_Day.png"), "The Best Day",
				59.99, "Arrangement of roses, lilies and\nalstroemeria in a glass vase", "Approximately 10.5\" W x 11\" H", "c9c9c9"));
		session.flush();

	}


	public static void addToDataBase() {
		try {
			SessionFactory sessionFactory = getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			if(getCatalog().isEmpty()) {
				generate();
			}

			session.getTransaction().commit(); // Save everything.
		} catch (Exception exception) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			System.err.println("An error occured, changes have been rolled back.");
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
		if (msgObject.getMsg().equals("Catalog")) {
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
				System.err.println("An error occured, changes have been rolled back.");
				exception.printStackTrace();
			}
			try {
				client.sendToClient(msgObject);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(msgObject.getMsg().equals("edit")){
			List<Catalog> list = msgObject.getCatalogList();
			try {
				SessionFactory sessionFactory = getSessionFactory();
				session = sessionFactory.openSession();
				session.beginTransaction();

				for(Catalog c : list){
					session.update(c);
					session.flush();
				}

				System.out.println("updating the price");
				session.getTransaction().commit(); // Save everything.
			} catch (Exception exception) {
				if (session != null) {
					session.getTransaction().rollback();
				}
				System.err.println("An error occured, changes have been rolled back.");
				exception.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
	}



	@Override
	protected synchronized void clientDisconnected(ConnectionToClient client) {
		// TODO Auto-generated method stub
		
		System.out.println("Client Disconnected.");
		super.clientDisconnected(client);
	}
	
	

	@Override
	protected void clientConnected(ConnectionToClient client) {
		super.clientConnected(client);
		System.out.println("Client connected: " + client.getInetAddress());
	}

//	public static void main(String[] args) throws IOException {
//		if (args.length != 1) {
//			System.out.println("Required argument: <port>");
//		} else {
//			SimpleServer server = new SimpleServer(Integer.parseInt(args[0]));
//			server.listen();
//		}
//	}
}
