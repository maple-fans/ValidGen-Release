package services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import entities.CardPayment;
import entities.CashDesk;
import entities.CashPayment;
import entities.Cashier;
import entities.Item;
import entities.OrderEntry;
import entities.OrderProduct;
import entities.Payment;
import entities.ProductCatalog;
import entities.Sale;
import entities.SalesLineItem;
import entities.Store;
import entities.Supplier;
import services.*;
	
public class ServiceManager {
	
	private static Map<String, List> AllServiceInstance = new HashMap<String, List>();
	
	private static List<CoCoMESystem> CoCoMESystemInstances = new LinkedList<CoCoMESystem>();
	private static List<ThirdPartyServices> ThirdPartyServicesInstances = new LinkedList<ThirdPartyServices>();
	private static List<ProcessSaleService> ProcessSaleServiceInstances = new LinkedList<ProcessSaleService>();
	private static List<ManageStoreCRUDService> ManageStoreCRUDServiceInstances = new LinkedList<ManageStoreCRUDService>();
	private static List<ManageProductCatalogCRUDService> ManageProductCatalogCRUDServiceInstances = new LinkedList<ManageProductCatalogCRUDService>();
	private static List<ManageCashDeskCRUDService> ManageCashDeskCRUDServiceInstances = new LinkedList<ManageCashDeskCRUDService>();
	private static List<ManageCashierCRUDService> ManageCashierCRUDServiceInstances = new LinkedList<ManageCashierCRUDService>();
	private static List<ManageItemCRUDService> ManageItemCRUDServiceInstances = new LinkedList<ManageItemCRUDService>();
	private static List<ManageSupplierCRUDService> ManageSupplierCRUDServiceInstances = new LinkedList<ManageSupplierCRUDService>();
	private static List<CoCoMEOrderProducts> CoCoMEOrderProductsInstances = new LinkedList<CoCoMEOrderProducts>();
	
	static {
		AllServiceInstance.put("CoCoMESystem", CoCoMESystemInstances);
		AllServiceInstance.put("ThirdPartyServices", ThirdPartyServicesInstances);
		AllServiceInstance.put("ProcessSaleService", ProcessSaleServiceInstances);
		AllServiceInstance.put("ManageStoreCRUDService", ManageStoreCRUDServiceInstances);
		AllServiceInstance.put("ManageProductCatalogCRUDService", ManageProductCatalogCRUDServiceInstances);
		AllServiceInstance.put("ManageCashDeskCRUDService", ManageCashDeskCRUDServiceInstances);
		AllServiceInstance.put("ManageCashierCRUDService", ManageCashierCRUDServiceInstances);
		AllServiceInstance.put("ManageItemCRUDService", ManageItemCRUDServiceInstances);
		AllServiceInstance.put("ManageSupplierCRUDService", ManageSupplierCRUDServiceInstances);
		AllServiceInstance.put("CoCoMEOrderProducts", CoCoMEOrderProductsInstances);
	} 
	
	public static void save(File file) {
		
		try {
			
			ObjectOutputStream stateSave = new ObjectOutputStream(new FileOutputStream(file));
			
			stateSave.writeObject(CoCoMESystemInstances);
			stateSave.writeObject(ThirdPartyServicesInstances);
			stateSave.writeObject(ProcessSaleServiceInstances);
			stateSave.writeObject(ManageStoreCRUDServiceInstances);
			stateSave.writeObject(ManageProductCatalogCRUDServiceInstances);
			stateSave.writeObject(ManageCashDeskCRUDServiceInstances);
			stateSave.writeObject(ManageCashierCRUDServiceInstances);
			stateSave.writeObject(ManageItemCRUDServiceInstances);
			stateSave.writeObject(ManageSupplierCRUDServiceInstances);
			stateSave.writeObject(CoCoMEOrderProductsInstances);
			stateSave.close();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void load(File file) {
		
		try {
			
			ObjectInputStream stateLoad = new ObjectInputStream(new FileInputStream(file));
			
			try {
				copyList((List<CoCoMESystem>) stateLoad.readObject(), CoCoMESystemInstances);
				copyList((List<ThirdPartyServices>) stateLoad.readObject(), ThirdPartyServicesInstances);
				copyList((List<ProcessSaleService>) stateLoad.readObject(), ProcessSaleServiceInstances);
				copyList((List<ManageStoreCRUDService>) stateLoad.readObject(), ManageStoreCRUDServiceInstances);
				copyList((List<ManageProductCatalogCRUDService>) stateLoad.readObject(), ManageProductCatalogCRUDServiceInstances);
				copyList((List<ManageCashDeskCRUDService>) stateLoad.readObject(), ManageCashDeskCRUDServiceInstances);
				copyList((List<ManageCashierCRUDService>) stateLoad.readObject(), ManageCashierCRUDServiceInstances);
				copyList((List<ManageItemCRUDService>) stateLoad.readObject(), ManageItemCRUDServiceInstances);
				copyList((List<ManageSupplierCRUDService>) stateLoad.readObject(), ManageSupplierCRUDServiceInstances);
				copyList((List<CoCoMEOrderProducts>) stateLoad.readObject(), CoCoMEOrderProductsInstances);
				
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
	
	public static <T> void copyList(List<T> original, List<T> target) {
		IntStream.range(0, Math.min(original.size(), target.size())).forEach(i -> {
			try {
				copy(original.get(i), target.get(i));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		if(original.size() > target.size())
			for(Integer i = target.size(); i < original.size(); ++i)
				target.add(original.get(i));
	}
	
	public static <T> void copy(T original, T target) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()))
                continue;
            field.setAccessible(Boolean.TRUE);
            Object value = field.get(original);
            field.set(target, value);
        }
    }
	
	public static List getAllInstancesOf(String ClassName) {
			 return AllServiceInstance.get(ClassName);
	}	
	
	public static CoCoMESystem createCoCoMESystem() {
		CoCoMESystem s = new CoCoMESystemImpl();
		CoCoMESystemInstances.add(s);
		return s;
	}
	public static ThirdPartyServices createThirdPartyServices() {
		ThirdPartyServices s = new ThirdPartyServicesImpl();
		ThirdPartyServicesInstances.add(s);
		return s;
	}
	public static ProcessSaleService createProcessSaleService() {
		ProcessSaleService s = new ProcessSaleServiceImpl();
		ProcessSaleServiceInstances.add(s);
		return s;
	}
	public static ManageStoreCRUDService createManageStoreCRUDService() {
		ManageStoreCRUDService s = new ManageStoreCRUDServiceImpl();
		ManageStoreCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageProductCatalogCRUDService createManageProductCatalogCRUDService() {
		ManageProductCatalogCRUDService s = new ManageProductCatalogCRUDServiceImpl();
		ManageProductCatalogCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageCashDeskCRUDService createManageCashDeskCRUDService() {
		ManageCashDeskCRUDService s = new ManageCashDeskCRUDServiceImpl();
		ManageCashDeskCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageCashierCRUDService createManageCashierCRUDService() {
		ManageCashierCRUDService s = new ManageCashierCRUDServiceImpl();
		ManageCashierCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageItemCRUDService createManageItemCRUDService() {
		ManageItemCRUDService s = new ManageItemCRUDServiceImpl();
		ManageItemCRUDServiceInstances.add(s);
		return s;
	}
	public static ManageSupplierCRUDService createManageSupplierCRUDService() {
		ManageSupplierCRUDService s = new ManageSupplierCRUDServiceImpl();
		ManageSupplierCRUDServiceInstances.add(s);
		return s;
	}
	public static CoCoMEOrderProducts createCoCoMEOrderProducts() {
		CoCoMEOrderProducts s = new CoCoMEOrderProductsImpl();
		CoCoMEOrderProductsInstances.add(s);
		return s;
	}
}	
