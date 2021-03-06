package nhom8.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Bill {
	private String id;
    private Customer customer;
    private List<ProductSale> productList;
    private Date dateSale;
    private Date dateDelivery;
    private Long totalPrice;
    private Float percentDiscount;
    private String paymentType;
    private String status;
}
