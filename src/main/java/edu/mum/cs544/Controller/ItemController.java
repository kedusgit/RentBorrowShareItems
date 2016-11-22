package edu.mum.cs544.Controller;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.mum.cs544.Domain.Item;
import edu.mum.cs544.Domain.ItemCategory;
import edu.mum.cs544.Domain.ItemStatus;
import edu.mum.cs544.Domain.User;
import edu.mum.cs544.Service.ItemService;
import edu.mum.cs544.Service.UserService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/all" })
	public String list(Model model) {
		List<ItemCategory> itemCategories = Arrays.asList(ItemCategory.values());
		model.addAttribute("itemCategories", itemCategories);
		model.addAttribute("items", itemService.getAllitems());
		return "items";
	}

	@RequestMapping("/{itemCategory}")
	public @ResponseBody Item getItemById(@PathVariable("itemCategory") ItemCategory itemCategory, Model model) {
		// ItemCategory newType = ItemCategory.ACCESSORIES;
		Item item = (Item) itemService.getItemByItemCatagory(itemCategory);
		model.addAttribute("item", item);

		return item;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newItem") Item newItem, Model model) {
		List<ItemCategory> itemCategories = Arrays.asList(ItemCategory.values());
		List<ItemStatus> itemStatus = Arrays.asList(ItemStatus.values());
		model.addAttribute("itemCategories", itemCategories);
		model.addAttribute("itemStatus", itemStatus);
		return "addItem";
	}

	
	
	@RequestMapping(value = "/add", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public void processImageUpload(@RequestParam("item") MultipartFile itemImage, HttpSession session) throws IOException{
		Item item = (Item)session.getAttribute("itemImage");
		item.setItemImage(itemImage.getBytes());		
		itemService.save(item);
		return;
	}
	
	
	 @RequestMapping(value = "/image/{itemId}", produces = MediaType.IMAGE_PNG_VALUE)
	    public ResponseEntity<byte[]> getImage(@PathVariable("itemId") int itemId) throws IOException {
	    	Item item = itemService.findById(itemId);
	    	System.out.println("itemId: " + itemId);
	        byte[] imageContent = item.getItemImage();
	        final HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG);
	        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	    }
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewItemForm(@Valid @ModelAttribute("newItem") Item newItem, BindingResult result,
			Principal principal, RedirectAttributes flashAttrs) {
		if (result.hasErrors()) {

			return "addItem";
		}

		try {
			//String username = principal.getName();
			 //User user = userService.getLoggedInUser(username);
			User user = new User();
			user.setUserId(2);
			newItem.setOwner(user);
			System.out.println("created user");
			itemService.addItem(newItem);
		} catch (Exception up) {
			up.printStackTrace();
			System.out.println("Transaction Failed!!!");

		}
		List<ItemCategory> itemCategories = Arrays.asList(ItemCategory.values());
		flashAttrs.addAttribute("itemCategories", itemCategories);
		return "redirect:/items";
	}

	@RequestMapping(value = "/editItem/{id}", method = RequestMethod.GET)
	public String editItemByGet(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("item", itemService.getItemId(id));
		return "editItem";
	}

	@RequestMapping(value = "/editItem/{itemId}", method = RequestMethod.POST)
	public String editResourceFormProcess(@PathVariable("itemId") Integer itemId, Model model, Item item,
			HttpServletRequest request, RequestAttributes redirectAttributes) {
		Item editedItem = itemService.getItemId(itemId);
		editedItem.setItemName(item.getItemName());
		editedItem.setItemDescription(item.getItemDescription());
		editedItem.setItemPrice(item.getItemPrice());
		editedItem.setItemQuantity(item.getItemQuantity());
		itemService.saveOrUpdateItem(editedItem);
		return "redirect:/items" + itemId;
	}


	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchforGet(Model model){
		List<ItemCategory> itemCategories = Arrays.asList(ItemCategory.values());
		List<ItemStatus> itemStatus = Arrays.asList(ItemStatus.values());
		model.addAttribute("itemCategories", itemCategories);
		model.addAttribute("itemStatus", itemStatus);
		
		return "searchItem";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchResource(@RequestParam("category") String categoryValue, @RequestParam("searchText") String searchText,
			Model model) {
		System.out.println("we got into searching method");
		ItemCategory category = ItemCategory.valueOf(categoryValue);
		List<Item> items = itemService.findByCategoryAndNameLike(category, searchText);
		if(items == null){
			System.out.println("found no items");
		}
		System.out.println("found "+items.size()+" items");
		model.addAttribute("items", items);
		return "searchResults";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		dateFormat.setLenient(true);
		
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

}