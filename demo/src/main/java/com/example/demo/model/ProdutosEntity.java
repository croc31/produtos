package com.example.demo.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O produto precisa de um id!")
    private  long produto_id ;
    @NotBlank(message = "O produto precisa de um nome!")
    private  String nome_produto;
    @NotBlank(message = "O produto precisa de uma descricao!")
    private  String descricao_produto;
    private  double preco_produto = 0;
    private  String data_validade;
    private  int estoque = 0;
    @Min(0)
    @Max(1)
    private  int ativo;
    
    @ManyToMany(mappedBy = "produtos")
    private List<PedidoEntity> pedidos;

    @ManyToOne //Muitos produtos podem ser fornecidos por um fonecedor
    @JoinColumn(name="fornecedor_id")
    private FornecedorEntity fornecedor;

    public ProdutosEntity(ProdutosEntity dados){
        this.ativo = 1;
        this.nome_produto= dados.nome_produto;
        this.descricao_produto = dados.descricao_produto;
        this.preco_produto = dados.preco_produto;
        this.data_validade = dados.data_validade;
        this.estoque = dados.estoque;
    }

    public void atualizarDados(ProdutosAtualizar dados) {
        if(dados.nome_produto() != null){
            this.nome_produto = dados.nome_produto();
        }if(dados.descricao_produto() != null){
            this.descricao_produto = dados.descricao_produto();
        }if(dados.preco_produto() != 0){
            this.preco_produto = dados.preco_produto();
        }if(dados.data_validade() != null){
            this.data_validade = dados.data_validade();
        }if(dados.estoque() != 0){
            this.estoque = dados.estoque();
        }if(dados.ativo() != -1){
            this.ativo = dados.ativo();
        }
    }

    public void inativar() {
        this.ativo = 0;
    }

    public void compra(){
        estoque --;
    }

    public void devolucao(){
        estoque ++;
    }
}
