package entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Method;
import java.util.Map;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
	import org.json.JSONArray;
	import org.json.JSONObject;
	import org.yaml.snakeyaml.Yaml;
	import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;
	import java.util.ArrayList;import java.io.File;

public class EntityManager {

	private static Map<String, List> AllInstance = new HashMap<String, List>();
	
	private static List<Store> StoreInstances = new LinkedList<Store>();
	private static List<ProductCatalog> ProductCatalogInstances = new LinkedList<ProductCatalog>();
	private static List<CashDesk> CashDeskInstances = new LinkedList<CashDesk>();
	private static List<Sale> SaleInstances = new LinkedList<Sale>();
	private static List<Cashier> CashierInstances = new LinkedList<Cashier>();
	private static List<SalesLineItem> SalesLineItemInstances = new LinkedList<SalesLineItem>();
	private static List<Item> ItemInstances = new LinkedList<Item>();
	private static List<Payment> PaymentInstances = new LinkedList<Payment>();
	private static List<CashPayment> CashPaymentInstances = new LinkedList<CashPayment>();
	private static List<CardPayment> CardPaymentInstances = new LinkedList<CardPayment>();
	private static List<OrderEntry> OrderEntryInstances = new LinkedList<OrderEntry>();
	private static List<Supplier> SupplierInstances = new LinkedList<Supplier>();
	private static List<OrderProduct> OrderProductInstances = new LinkedList<OrderProduct>();

	
	/* Put instances list into Map */
	static {
		AllInstance.put("Store", StoreInstances);
		AllInstance.put("ProductCatalog", ProductCatalogInstances);
		AllInstance.put("CashDesk", CashDeskInstances);
		AllInstance.put("Sale", SaleInstances);
		AllInstance.put("Cashier", CashierInstances);
		AllInstance.put("SalesLineItem", SalesLineItemInstances);
		AllInstance.put("Item", ItemInstances);
		AllInstance.put("Payment", PaymentInstances);
		AllInstance.put("CashPayment", CashPaymentInstances);
		AllInstance.put("CardPayment", CardPaymentInstances);
		AllInstance.put("OrderEntry", OrderEntryInstances);
		AllInstance.put("Supplier", SupplierInstances);
		AllInstance.put("OrderProduct", OrderProductInstances);
	} 
		
	/* Save State */
	public static void save(File file) {
		
		try {
			
			ObjectOutputStream stateSave = new ObjectOutputStream(new FileOutputStream(file));
			
			stateSave.writeObject(StoreInstances);
			stateSave.writeObject(ProductCatalogInstances);
			stateSave.writeObject(CashDeskInstances);
			stateSave.writeObject(SaleInstances);
			stateSave.writeObject(CashierInstances);
			stateSave.writeObject(SalesLineItemInstances);
			stateSave.writeObject(ItemInstances);
			stateSave.writeObject(PaymentInstances);
			stateSave.writeObject(CashPaymentInstances);
			stateSave.writeObject(CardPaymentInstances);
			stateSave.writeObject(OrderEntryInstances);
			stateSave.writeObject(SupplierInstances);
			stateSave.writeObject(OrderProductInstances);
			
			stateSave.close();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* Load State */
			/* Load File */
		@SuppressWarnings("null")
		public static void loadFile(File file) throws ClassNotFoundException {

		 			Yaml yaml = new Yaml();
		 			System.out.println("come in yaml");
		 			if (file != null) {
		 				try {
		 				Map obj =yaml.load(new FileInputStream(file));
	 					List listdata =  new ArrayList<>();	    
	 		    	   	JSONObject rootObject = new JSONObject(obj);
		 		
	   			

if (rootObject.has("Store") )
{
	JSONArray dataArrayStore = rootObject.getJSONArray("Store");
		 		           Store iiiStore ;
		 		           for(int i = 0; i < dataArrayStore.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectStore = dataArrayStore.getJSONObject(i);
		 		            	
		 					   	iiiStore = (Store) EntityManager.createObject("Store");
		 					   	
		 					   	
iiiStore.setId(Integer.valueOf( String.valueOf(sonObjectStore.get("Id")) ));
		 					   	
iiiStore.setName((String)sonObjectStore.get("Name"));
		 					   	
iiiStore.setAddress((String)sonObjectStore.get("Address"));
		 					   	
iiiStore.setIsOpened(Boolean.parseBoolean(sonObjectStore.get("IsOpened").toString() ));
		 		            	EntityManager.addObject("Store", iiiStore);
		 		            }
		 		      }

if (rootObject.has("ProductCatalog") )
{
	JSONArray dataArrayProductCatalog = rootObject.getJSONArray("ProductCatalog");
		 		           ProductCatalog iiiProductCatalog ;
		 		           for(int i = 0; i < dataArrayProductCatalog.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectProductCatalog = dataArrayProductCatalog.getJSONObject(i);
		 		            	
		 					   	iiiProductCatalog = (ProductCatalog) EntityManager.createObject("ProductCatalog");
		 					   	
		 					   	
iiiProductCatalog.setId(Integer.valueOf( String.valueOf(sonObjectProductCatalog.get("Id")) ));
		 					   	
iiiProductCatalog.setName((String)sonObjectProductCatalog.get("Name"));
		 		            	EntityManager.addObject("ProductCatalog", iiiProductCatalog);
		 		            }
		 		      }

if (rootObject.has("CashDesk") )
{
	JSONArray dataArrayCashDesk = rootObject.getJSONArray("CashDesk");
		 		           CashDesk iiiCashDesk ;
		 		           for(int i = 0; i < dataArrayCashDesk.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectCashDesk = dataArrayCashDesk.getJSONObject(i);
		 		            	
		 					   	iiiCashDesk = (CashDesk) EntityManager.createObject("CashDesk");
		 					   	
		 					   	
iiiCashDesk.setId(Integer.valueOf( String.valueOf(sonObjectCashDesk.get("Id")) ));
		 					   	
iiiCashDesk.setName((String)sonObjectCashDesk.get("Name"));
		 					   	
iiiCashDesk.setIsOpened(Boolean.parseBoolean(sonObjectCashDesk.get("IsOpened").toString() ));
		 		            	EntityManager.addObject("CashDesk", iiiCashDesk);
		 		            }
		 		      }

if (rootObject.has("Sale") )
{
	JSONArray dataArraySale = rootObject.getJSONArray("Sale");
		 		           Sale iiiSale ;
		 		           for(int i = 0; i < dataArraySale.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectSale = dataArraySale.getJSONObject(i);
		 		            	
		 					   	iiiSale = (Sale) EntityManager.createObject("Sale");
		 					   	
		 					   	
		 					   	
iiiSale.setIsComplete(Boolean.parseBoolean(sonObjectSale.get("IsComplete").toString() ));
		 					   	
iiiSale.setAmount(Float.parseFloat(sonObjectSale.get("Amount").toString()));
		 					   	
iiiSale.setIsReadytoPay(Boolean.parseBoolean(sonObjectSale.get("IsReadytoPay").toString() ));
		 		            	EntityManager.addObject("Sale", iiiSale);
		 		            }
		 		      }

if (rootObject.has("Cashier") )
{
	JSONArray dataArrayCashier = rootObject.getJSONArray("Cashier");
		 		           Cashier iiiCashier ;
		 		           for(int i = 0; i < dataArrayCashier.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectCashier = dataArrayCashier.getJSONObject(i);
		 		            	
		 					   	iiiCashier = (Cashier) EntityManager.createObject("Cashier");
		 					   	
		 					   	
iiiCashier.setId(Integer.valueOf( String.valueOf(sonObjectCashier.get("Id")) ));
		 					   	
iiiCashier.setName((String)sonObjectCashier.get("Name"));
		 		            	EntityManager.addObject("Cashier", iiiCashier);
		 		            }
		 		      }

if (rootObject.has("SalesLineItem") )
{
	JSONArray dataArraySalesLineItem = rootObject.getJSONArray("SalesLineItem");
		 		           SalesLineItem iiiSalesLineItem ;
		 		           for(int i = 0; i < dataArraySalesLineItem.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectSalesLineItem = dataArraySalesLineItem.getJSONObject(i);
		 		            	
		 					   	iiiSalesLineItem = (SalesLineItem) EntityManager.createObject("SalesLineItem");
		 					   	
		 					   	
iiiSalesLineItem.setQuantity(Integer.valueOf( String.valueOf(sonObjectSalesLineItem.get("Quantity")) ));
		 					   	
iiiSalesLineItem.setSubamount(Float.parseFloat(sonObjectSalesLineItem.get("Subamount").toString()));
		 		            	EntityManager.addObject("SalesLineItem", iiiSalesLineItem);
		 		            }
		 		      }

if (rootObject.has("Item") )
{
	JSONArray dataArrayItem = rootObject.getJSONArray("Item");
		 		           Item iiiItem ;
		 		           for(int i = 0; i < dataArrayItem.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectItem = dataArrayItem.getJSONObject(i);
		 		            	
		 					   	iiiItem = (Item) EntityManager.createObject("Item");
		 					   	
		 					   	
iiiItem.setBarcode(Integer.valueOf( String.valueOf(sonObjectItem.get("Barcode")) ));
		 					   	
iiiItem.setName((String)sonObjectItem.get("Name"));
		 					   	
iiiItem.setPrice(Float.parseFloat(sonObjectItem.get("Price").toString()));
		 					   	
iiiItem.setStockNumber(Integer.valueOf( String.valueOf(sonObjectItem.get("StockNumber")) ));
		 					   	
iiiItem.setOrderPrice(Float.parseFloat(sonObjectItem.get("OrderPrice").toString()));
		 		            	EntityManager.addObject("Item", iiiItem);
		 		            }
		 		      }

if (rootObject.has("Payment") )
{
	JSONArray dataArrayPayment = rootObject.getJSONArray("Payment");
		 		           Payment iiiPayment ;
		 		           for(int i = 0; i < dataArrayPayment.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectPayment = dataArrayPayment.getJSONObject(i);
		 		            	
		 					   	iiiPayment = (Payment) EntityManager.createObject("Payment");
		 					   	
		 					   	
iiiPayment.setAmountTendered(Float.parseFloat(sonObjectPayment.get("AmountTendered").toString()));
		 		            	EntityManager.addObject("Payment", iiiPayment);
		 		            }
		 		      }

if (rootObject.has("CashPayment") )
{
	JSONArray dataArrayCashPayment = rootObject.getJSONArray("CashPayment");
		 		           CashPayment iiiCashPayment ;
		 		           for(int i = 0; i < dataArrayCashPayment.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectCashPayment = dataArrayCashPayment.getJSONObject(i);
		 		            	
		 					   	iiiCashPayment = (CashPayment) EntityManager.createObject("CashPayment");
		 					   	
		 					   	
iiiCashPayment.setBalance(Float.parseFloat(sonObjectCashPayment.get("Balance").toString()));
		 		            	EntityManager.addObject("CashPayment", iiiCashPayment);
		 		            }
		 		      }

if (rootObject.has("CardPayment") )
{
	JSONArray dataArrayCardPayment = rootObject.getJSONArray("CardPayment");
		 		           CardPayment iiiCardPayment ;
		 		           for(int i = 0; i < dataArrayCardPayment.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectCardPayment = dataArrayCardPayment.getJSONObject(i);
		 		            	
		 					   	iiiCardPayment = (CardPayment) EntityManager.createObject("CardPayment");
		 					   	
		 					   	
iiiCardPayment.setCardAccountNumber((String)sonObjectCardPayment.get("CardAccountNumber"));
		 					   	
		 		            	EntityManager.addObject("CardPayment", iiiCardPayment);
		 		            }
		 		      }

if (rootObject.has("OrderEntry") )
{
	JSONArray dataArrayOrderEntry = rootObject.getJSONArray("OrderEntry");
		 		           OrderEntry iiiOrderEntry ;
		 		           for(int i = 0; i < dataArrayOrderEntry.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectOrderEntry = dataArrayOrderEntry.getJSONObject(i);
		 		            	
		 					   	iiiOrderEntry = (OrderEntry) EntityManager.createObject("OrderEntry");
		 					   	
		 					   	
iiiOrderEntry.setQuantity(Integer.valueOf( String.valueOf(sonObjectOrderEntry.get("Quantity")) ));
		 					   	
iiiOrderEntry.setSubAmount(Float.parseFloat(sonObjectOrderEntry.get("SubAmount").toString()));
		 		            	EntityManager.addObject("OrderEntry", iiiOrderEntry);
		 		            }
		 		      }

if (rootObject.has("Supplier") )
{
	JSONArray dataArraySupplier = rootObject.getJSONArray("Supplier");
		 		           Supplier iiiSupplier ;
		 		           for(int i = 0; i < dataArraySupplier.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectSupplier = dataArraySupplier.getJSONObject(i);
		 		            	
		 					   	iiiSupplier = (Supplier) EntityManager.createObject("Supplier");
		 					   	
		 					   	
iiiSupplier.setId(Integer.valueOf( String.valueOf(sonObjectSupplier.get("Id")) ));
		 					   	
iiiSupplier.setName((String)sonObjectSupplier.get("Name"));
		 		            	EntityManager.addObject("Supplier", iiiSupplier);
		 		            }
		 		      }

if (rootObject.has("OrderProduct") )
{
	JSONArray dataArrayOrderProduct = rootObject.getJSONArray("OrderProduct");
		 		           OrderProduct iiiOrderProduct ;
		 		           for(int i = 0; i < dataArrayOrderProduct.length(); i++) 
		 		           {
		 		            	JSONObject sonObjectOrderProduct = dataArrayOrderProduct.getJSONObject(i);
		 		            	
		 					   	iiiOrderProduct = (OrderProduct) EntityManager.createObject("OrderProduct");
		 					   	
		 					   	
iiiOrderProduct.setId(Integer.valueOf( String.valueOf(sonObjectOrderProduct.get("Id")) ));
		 					   	
		 					   	
iiiOrderProduct.setOrderStatus((OrderStatus)sonObjectOrderProduct.get("OrderStatus"));
		 					   	
iiiOrderProduct.setAmount(Float.parseFloat(sonObjectOrderProduct.get("Amount").toString()));
		 		            	EntityManager.addObject("OrderProduct", iiiOrderProduct);
		 		            }
		 		      }
               		
               		
		 		} catch (FileNotFoundException e1) {
		 				// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
		}
		
		
public static void load(File file) {
		
		try {
			
			ObjectInputStream stateLoad = new ObjectInputStream(new FileInputStream(file));
			
			try {
				
				StoreInstances =  (List<Store>) stateLoad.readObject();
				AllInstance.put("Store", StoreInstances);
				ProductCatalogInstances =  (List<ProductCatalog>) stateLoad.readObject();
				AllInstance.put("ProductCatalog", ProductCatalogInstances);
				CashDeskInstances =  (List<CashDesk>) stateLoad.readObject();
				AllInstance.put("CashDesk", CashDeskInstances);
				SaleInstances =  (List<Sale>) stateLoad.readObject();
				AllInstance.put("Sale", SaleInstances);
				CashierInstances =  (List<Cashier>) stateLoad.readObject();
				AllInstance.put("Cashier", CashierInstances);
				SalesLineItemInstances =  (List<SalesLineItem>) stateLoad.readObject();
				AllInstance.put("SalesLineItem", SalesLineItemInstances);
				ItemInstances =  (List<Item>) stateLoad.readObject();
				AllInstance.put("Item", ItemInstances);
				PaymentInstances =  (List<Payment>) stateLoad.readObject();
				AllInstance.put("Payment", PaymentInstances);
				CashPaymentInstances =  (List<CashPayment>) stateLoad.readObject();
				AllInstance.put("CashPayment", CashPaymentInstances);
				CardPaymentInstances =  (List<CardPayment>) stateLoad.readObject();
				AllInstance.put("CardPayment", CardPaymentInstances);
				OrderEntryInstances =  (List<OrderEntry>) stateLoad.readObject();
				AllInstance.put("OrderEntry", OrderEntryInstances);
				SupplierInstances =  (List<Supplier>) stateLoad.readObject();
				AllInstance.put("Supplier", SupplierInstances);
				OrderProductInstances =  (List<OrderProduct>) stateLoad.readObject();
				AllInstance.put("OrderProduct", OrderProductInstances);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	/* create object */  
	public static Object createObject(String Classifer) {
		try
		{
			Class c = Class.forName("entities.EntityManager");
			Method createObjectMethod = c.getDeclaredMethod("create" + Classifer + "Object");
			return createObjectMethod.invoke(c);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/* add object */  
	public static Object addObject(String Classifer, Object ob) {
		try
		{
			Class c = Class.forName("entities.EntityManager");
			Method addObjectMethod = c.getDeclaredMethod("add" + Classifer + "Object", Class.forName("entities." + Classifer));
			return  (boolean) addObjectMethod.invoke(c, ob);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	
	/* add objects */  
	public static Object addObjects(String Classifer, List obs) {
		try
		{
			Class c = Class.forName("entities.EntityManager");
			Method addObjectsMethod = c.getDeclaredMethod("add" + Classifer + "Objects", Class.forName("java.util.List"));
			return  (boolean) addObjectsMethod.invoke(c, obs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/* Release object */
	public static boolean deleteObject(String Classifer, Object ob) {
		try
		{
			Class c = Class.forName("entities.EntityManager");
			Method deleteObjectMethod = c.getDeclaredMethod("delete" + Classifer + "Object", Class.forName("entities." + Classifer));
			return  (boolean) deleteObjectMethod.invoke(c, ob);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/* Release objects */
	public static boolean deleteObjects(String Classifer, List obs) {
		try
		{
			Class c = Class.forName("entities.EntityManager");
			Method deleteObjectMethod = c.getDeclaredMethod("delete" + Classifer + "Objects", Class.forName("java.util.List"));
			return  (boolean) deleteObjectMethod.invoke(c, obs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}		 	
	
	 /* Get all objects belongs to same class */
	public static List getAllInstancesOf(String ClassName) {
			 return AllInstance.get(ClassName);
	}	

   /* Sub-create object */
	public static Store createStoreObject() {
		Store o = new Store();
		return o;
	}
	
	public static boolean addStoreObject(Store o) {
		return StoreInstances.add(o);
	}
	
	public static boolean addStoreObjects(List<Store> os) {
		return StoreInstances.addAll(os);
	}
	
	public static boolean deleteStoreObject(Store o) {
		return StoreInstances.remove(o);
	}
	
	public static boolean deleteStoreObjects(List<Store> os) {
		return StoreInstances.removeAll(os);
	}
	public static ProductCatalog createProductCatalogObject() {
		ProductCatalog o = new ProductCatalog();
		return o;
	}
	
	public static boolean addProductCatalogObject(ProductCatalog o) {
		return ProductCatalogInstances.add(o);
	}
	
	public static boolean addProductCatalogObjects(List<ProductCatalog> os) {
		return ProductCatalogInstances.addAll(os);
	}
	
	public static boolean deleteProductCatalogObject(ProductCatalog o) {
		return ProductCatalogInstances.remove(o);
	}
	
	public static boolean deleteProductCatalogObjects(List<ProductCatalog> os) {
		return ProductCatalogInstances.removeAll(os);
	}
	public static CashDesk createCashDeskObject() {
		CashDesk o = new CashDesk();
		return o;
	}
	
	public static boolean addCashDeskObject(CashDesk o) {
		return CashDeskInstances.add(o);
	}
	
	public static boolean addCashDeskObjects(List<CashDesk> os) {
		return CashDeskInstances.addAll(os);
	}
	
	public static boolean deleteCashDeskObject(CashDesk o) {
		return CashDeskInstances.remove(o);
	}
	
	public static boolean deleteCashDeskObjects(List<CashDesk> os) {
		return CashDeskInstances.removeAll(os);
	}
	public static Sale createSaleObject() {
		Sale o = new Sale();
		return o;
	}
	
	public static boolean addSaleObject(Sale o) {
		return SaleInstances.add(o);
	}
	
	public static boolean addSaleObjects(List<Sale> os) {
		return SaleInstances.addAll(os);
	}
	
	public static boolean deleteSaleObject(Sale o) {
		return SaleInstances.remove(o);
	}
	
	public static boolean deleteSaleObjects(List<Sale> os) {
		return SaleInstances.removeAll(os);
	}
	public static Cashier createCashierObject() {
		Cashier o = new Cashier();
		return o;
	}
	
	public static boolean addCashierObject(Cashier o) {
		return CashierInstances.add(o);
	}
	
	public static boolean addCashierObjects(List<Cashier> os) {
		return CashierInstances.addAll(os);
	}
	
	public static boolean deleteCashierObject(Cashier o) {
		return CashierInstances.remove(o);
	}
	
	public static boolean deleteCashierObjects(List<Cashier> os) {
		return CashierInstances.removeAll(os);
	}
	public static SalesLineItem createSalesLineItemObject() {
		SalesLineItem o = new SalesLineItem();
		return o;
	}
	
	public static boolean addSalesLineItemObject(SalesLineItem o) {
		return SalesLineItemInstances.add(o);
	}
	
	public static boolean addSalesLineItemObjects(List<SalesLineItem> os) {
		return SalesLineItemInstances.addAll(os);
	}
	
	public static boolean deleteSalesLineItemObject(SalesLineItem o) {
		return SalesLineItemInstances.remove(o);
	}
	
	public static boolean deleteSalesLineItemObjects(List<SalesLineItem> os) {
		return SalesLineItemInstances.removeAll(os);
	}
	public static Item createItemObject() {
		Item o = new Item();
		return o;
	}
	
	public static boolean addItemObject(Item o) {
		return ItemInstances.add(o);
	}
	
	public static boolean addItemObjects(List<Item> os) {
		return ItemInstances.addAll(os);
	}
	
	public static boolean deleteItemObject(Item o) {
		return ItemInstances.remove(o);
	}
	
	public static boolean deleteItemObjects(List<Item> os) {
		return ItemInstances.removeAll(os);
	}
	public static Payment createPaymentObject() {
		Payment o = new Payment();
		return o;
	}
	
	public static boolean addPaymentObject(Payment o) {
		return PaymentInstances.add(o);
	}
	
	public static boolean addPaymentObjects(List<Payment> os) {
		return PaymentInstances.addAll(os);
	}
	
	public static boolean deletePaymentObject(Payment o) {
		return PaymentInstances.remove(o);
	}
	
	public static boolean deletePaymentObjects(List<Payment> os) {
		return PaymentInstances.removeAll(os);
	}
	public static CashPayment createCashPaymentObject() {
		CashPayment o = new CashPayment();
		return o;
	}
	
	public static boolean addCashPaymentObject(CashPayment o) {
		return CashPaymentInstances.add(o);
	}
	
	public static boolean addCashPaymentObjects(List<CashPayment> os) {
		return CashPaymentInstances.addAll(os);
	}
	
	public static boolean deleteCashPaymentObject(CashPayment o) {
		return CashPaymentInstances.remove(o);
	}
	
	public static boolean deleteCashPaymentObjects(List<CashPayment> os) {
		return CashPaymentInstances.removeAll(os);
	}
	public static CardPayment createCardPaymentObject() {
		CardPayment o = new CardPayment();
		return o;
	}
	
	public static boolean addCardPaymentObject(CardPayment o) {
		return CardPaymentInstances.add(o);
	}
	
	public static boolean addCardPaymentObjects(List<CardPayment> os) {
		return CardPaymentInstances.addAll(os);
	}
	
	public static boolean deleteCardPaymentObject(CardPayment o) {
		return CardPaymentInstances.remove(o);
	}
	
	public static boolean deleteCardPaymentObjects(List<CardPayment> os) {
		return CardPaymentInstances.removeAll(os);
	}
	public static OrderEntry createOrderEntryObject() {
		OrderEntry o = new OrderEntry();
		return o;
	}
	
	public static boolean addOrderEntryObject(OrderEntry o) {
		return OrderEntryInstances.add(o);
	}
	
	public static boolean addOrderEntryObjects(List<OrderEntry> os) {
		return OrderEntryInstances.addAll(os);
	}
	
	public static boolean deleteOrderEntryObject(OrderEntry o) {
		return OrderEntryInstances.remove(o);
	}
	
	public static boolean deleteOrderEntryObjects(List<OrderEntry> os) {
		return OrderEntryInstances.removeAll(os);
	}
	public static Supplier createSupplierObject() {
		Supplier o = new Supplier();
		return o;
	}
	
	public static boolean addSupplierObject(Supplier o) {
		return SupplierInstances.add(o);
	}
	
	public static boolean addSupplierObjects(List<Supplier> os) {
		return SupplierInstances.addAll(os);
	}
	
	public static boolean deleteSupplierObject(Supplier o) {
		return SupplierInstances.remove(o);
	}
	
	public static boolean deleteSupplierObjects(List<Supplier> os) {
		return SupplierInstances.removeAll(os);
	}
	public static OrderProduct createOrderProductObject() {
		OrderProduct o = new OrderProduct();
		return o;
	}
	
	public static boolean addOrderProductObject(OrderProduct o) {
		return OrderProductInstances.add(o);
	}
	
	public static boolean addOrderProductObjects(List<OrderProduct> os) {
		return OrderProductInstances.addAll(os);
	}
	
	public static boolean deleteOrderProductObject(OrderProduct o) {
		return OrderProductInstances.remove(o);
	}
	
	public static boolean deleteOrderProductObjects(List<OrderProduct> os) {
		return OrderProductInstances.removeAll(os);
	}
  
}



