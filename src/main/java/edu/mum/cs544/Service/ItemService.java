package edu.mum.cs544.Service;

import java.util.List;

import edu.mum.cs544.Domain.Item;

public interface ItemService {

	List<Item> getAllitems();

	

List<Item> getItemByType(String type);



	void addItem(Item newItem);



	Item getItemId(Integer id);



	void saveOrUpdateItem(Item editedItem);



	List<Item> findByNameLike(String searchText);



	List<Item> findAllByStatus(String status);



	








	



	
	

}
