package edu.mum.cs544.Controller;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs544.Domain.Item;
import edu.mum.cs544.Service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = { "", "/all" })
	public String list(Model model) {
		model.addAttribute("items", itemService.getAllitems());
		return "items";
	}

	@RequestMapping("/{type}")
	public @ResponseBody Item getItemById(@PathVariable("type") String type, Model model) {
		Item item = (Item) itemService.getItemByType(type);
		model.addAttribute("item", item);
		return item;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newItem") Item newItem, Model model) {

		return "addItem";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewItemForm(@Valid @ModelAttribute("newItem") Item newItem, BindingResult result,
			Model model) {
		if (result.hasErrors()) {

			return "addItem";
		}

		try {
			itemService.addItem(newItem);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/items";
	}

	@RequestMapping(value = "/editItem/{id}", method = RequestMethod.GET)
	public String editItemByGet(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("item", itemService.getItemId(id));
		return "editItem";
	}

	@RequestMapping(value = "/editItem/{itemId}", method = RequestMethod.POST)
	public String editResourceFormProcess(@PathVariable("itemId") Integer itemId,
			@PathVariable("eventId") Integer eventId, Model model, Item item, HttpServletRequest request,
			RequestAttributes redirectAttributes) {
		Item editedItem = itemService.getItemId(itemId);
		editedItem.setItemName(item.getItemName());
		editedItem.setItemDescription(item.getItemDescription());

		editedItem.setItemQuantity(item.getItemQuantity());
		itemService.saveOrUpdateItem(editedItem);
		return "redirect:/items" + itemId;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchResource(@RequestParam("searchText") String searchText,
			RedirectAttributes redirectAttributes) {
		List<Item> items = itemService.findByNameLike(searchText);
		String viewPath = "/item/itemlist";
		ModelAndView modelAndView = new ModelAndView(viewPath);
		modelAndView.addObject("items", items);
		return modelAndView;
	}


}
