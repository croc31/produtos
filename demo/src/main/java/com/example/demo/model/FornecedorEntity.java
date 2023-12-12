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
@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O fornecedor precisa de um id!")
    private  long fornecedor_id ;
    @NotNull
    private String name;
    //Um fornecedor pode fornecer muitos produtos
    @OneToMany(mappedBy = "fornecedor") 
    private List<ProdutosEntity> produtos;

    public FornecedorEntity(FornecedorEntity fornecedor){
        this.fornecedor_id = fornecedor.fornecedor_id;
        this.name = fornecedor.name;
        this.produtos = fornecedor.produtos;
    }
}
