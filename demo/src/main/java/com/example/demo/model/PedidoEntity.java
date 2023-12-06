package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "pedido")
@Entity(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O produto precisa de um id!")
    private  long pedido_id ;
    @ManyToMany
    @JoinTable(name="produto_pedido",  joinColumns = @JoinColumn(name="pedido_fk"), inverseJoinColumns = @JoinColumn(name="produto_fk"))
    private List<ProdutosEntity> produtos ;

}
