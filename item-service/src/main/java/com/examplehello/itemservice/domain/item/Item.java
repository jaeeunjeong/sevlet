package com.examplehello.itemservice.domain.item;

import lombok.Data;

@Data // 절대 지양 주의에서 써야함.
public class Item {

  private Long id;
  private String itemName;

  private Integer price;

  private int quantity;

  public Item() {
  }

  public Item(String itemName, Integer price, int quantity) {
    this.itemName = itemName;
    this.price = price;
    this.quantity = quantity;
  }
}
