package edu.mum.cs544.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs544.Domain.Item;
import edu.mum.cs544.Domain.ItemCategory;
import edu.mum.cs544.Repository.ItemRepository;
import edu.mum.cs544.Service.ItemService;

@Service
@Transactional
public class ItemServiceImpl  implements ItemService {

	
		@Autowired
		private ItemRepository itemRepository;

		@Override
		public List<Item> getAllitems() {
			
		return itemRepository.findAll();
		}

		@Override
		public void saveOrUpdateItem(Item item) {
			
			itemRepository.save(item);
		}
	
		
		@Override
		public List<Item> findAllByStatus(String status) {
		
			return itemRepository.findAllByItemStatus(status);
		}

		@Override
		public void addItem(Item newItem) {
			itemRepository.save(newItem);
			
		}

		@Override
		public Item getItemId(Integer id) {
			
			return itemRepository.findItemByItemId(id);
		}

		

		@Override
		public List<Item> findByNameLike(String searchText) {
			
			return itemRepository.findByItemNameLike(searchText);
		}

		@Override
		public List<Item> getIByuserId(Integer userId) {
			
			return itemRepository.findAllByOwner(userId);
		}

		@Override
		public List<Item> getItemByItemCatagory(ItemCategory catagory) {
			// TODO Auto-generated method stub
			return itemRepository.findAllByItemCategory(catagory);
		}

}
