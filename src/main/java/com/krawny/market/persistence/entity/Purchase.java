package com.krawny.market.persistence.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="compras")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer idPurchase;

    @NotNull
    @Column(name="id_cliente")
    private String idClient;

    @Column(name="fecha")
    private LocalDateTime dateTime;

    @Column(name="medio_pago")
    private String paymentMethod;

    @Column(name="comentario")
    private String comment;

    @Column(name="estado")
    private boolean status;

    @ManyToOne
    @JoinColumn(name="id_cliente",insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "product")
    private List<ProductPurchase> productPurchaseList;
}
