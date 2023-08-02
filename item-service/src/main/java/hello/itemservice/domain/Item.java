package hello.itemservice.domain;

import lombok.Data;

@Data //Getter나 Setter 정도 사용하는 것은 괜찮으나 Data는 주의해서 써야 함.
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity; // 수량이 Null로 들어갈 수도 있음.

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
