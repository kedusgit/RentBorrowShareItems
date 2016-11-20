package edu.mum.cs544.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.Domain.Item;
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
		public List<Item> getItemByType(String type) {
			
			return itemRepository.findAllByType(type);
		}
		
		@Override
		public List<Item> findAllByStatus(String status) {
		
			return itemRepository.findAllByStatus(status);
		}

		@Override
		public void addItem(Item newItem) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Item getItemId(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		

		@Override
		public List<Item> findByNameLike(String searchText) {
			// TODO Auto-generated method stub
			return null;
		}

}
