package com.examplehello.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import com.examplehello.itemservice.domain.item.Item;
import com.examplehello.itemservice.domain.item.ItemRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

  ItemRepository itemRepository = new ItemRepository();

  @AfterEach
  void afterEach() {
    itemRepository.clearStore();
  }

  @Test
  void save() {
    // given
    Item item = new Item("itemA", 10000, 10);

    // when
    Item savedItem = itemRepository.save(item);

    // them
    Item findItem = itemRepository.findById(item.getId());
    assertThat(findItem).isEqualTo(savedItem);

  }

  @Test
  void findById() {
  }

  @Test
  void findAll() {
    Item item1 = new Item("item1", 10000, 10);
    Item item2 = new Item("item2", 20000, 20);

    Item savedItem1 = itemRepository.save(item1);
    Item savedItem2 = itemRepository.save(item2);

    List<Item> findItem = itemRepository.findAll();
    assertThat(findItem.size()).isEqualTo(2);
    assertThat(findItem).contains(item1, item2);
  }

  @Test
  void update() {
    Item item = new Item("item1", 10000, 10);

    Item savedItem = itemRepository.save(item);
    Long itemId = savedItem.getId();

    Item updateParam = new Item("item2", 20000, 20);
    itemRepository.update(itemId, updateParam);

    Item findItem = itemRepository.findById(itemId);

    assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
    assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

  }

}