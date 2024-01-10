package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class InventoryDecreased extends AbstractEvent {

    private Long id;
    private String name;
    private Integer stock;
}
