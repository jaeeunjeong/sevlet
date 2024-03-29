package com.examplehello.itemservice.basic;

import com.examplehello.itemservice.domain.item.Item;
import com.examplehello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

  private final ItemRepository itemRepository;

  @GetMapping
  public String item(Model model) {
    List<Item> items = itemRepository.findAll();
    model.addAttribute("items", items);
    return "basic/items";
  }

  @GetMapping("/{itemId}")
  public String itme(@PathVariable long itemId, Model model) {
    Item items = itemRepository.findById(itemId);
    model.addAttribute("item", items);
    return "basic/item";
  }

  @GetMapping("/add")
  public String addForm() {
    return "basic/form";
  }

  //  @PostMapping("/add")
  public String save(@RequestParam String itemName,
      @RequestParam int price,
      @RequestParam Integer quantity,
      Model model) {
    Item item = new Item();
    item.setItemName(itemName);
    item.setPrice(price);
    item.setQuantity(quantity);

    itemRepository.save(item);

    model.addAttribute("item", item);
    return "basic/item";
  }

  @PostMapping("/add")
  public String addItemV1(@ModelAttribute("item") Item item, Model model) {

    itemRepository.save(item);
    model.addAttribute("item", item);
    return "basic/item";
  }

  @PostMapping("/add")
  public String addItemV2(@ModelAttribute("item") Item item, Model model) {
    itemRepository.save(item);
    model.addAttribute("item", item);
    return "basic/item";
  }

  @PostMapping("/add")
  public String addItemV3(@ModelAttribute("item") Item item) {
    itemRepository.save(item);
    return "basic/item";
  }

  @PostMapping("/add")
  public String addItemV4(Item item) {
    itemRepository.save(item);
    return "basic/item";
  }

  @PostMapping("/add")
  public String addItemV5(Item item) {
    itemRepository.save(item);
    return "redirect:/basic/items/"+item.getId();
  }
  @PostMapping("/add")
  public String addItemV6(Item item, RedirectAttributes attributes) {
    Item savedItem = itemRepository.save(item);
    attributes.addAttribute("itemId",savedItem.getId());
    attributes.addAttribute("status", true);
    return "redirect:/basic/items/"+item.getId();
  }

  @GetMapping("/{itemId}/edit")
  public String editForm(@PathVariable Long itemId, Model model){
    Item item = itemRepository.findById(itemId);
    model.addAttribute("item", item);
    return "basic/editForm";
  }

  @PostMapping("/{itemId}/edit")
  public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
    itemRepository.update(itemId, item);
    return "redirect:/basic/item/{itemId}";
  }

  @PostConstruct
  public void init() {
    Item item1 = new Item("item1", 10000, 10);
    Item item2 = new Item("item2", 20000, 20);
    Item savedItem1 = itemRepository.save(item1);
    Item savedItem2 = itemRepository.save(item2);
  }
}
