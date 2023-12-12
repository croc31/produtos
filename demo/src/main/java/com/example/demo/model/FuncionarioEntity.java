package com.example.demo.model;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "funcionario")
@Entity(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O produto precisa de um id!")
    private  long funcionario_id ;
    @NotNull
    private String name;
    @CPF
    private String cpf;

    @OneToMany(mappedBy = "funcionario") //Um funcionário pode cadastrar muitos pedidos

    private List<PedidoEntity> pedidos;

    public FuncionarioEntity(FuncionarioEntity funcionario){
        this.cpf = funcionario.cpf;
        this.name = funcionario.name;
        this.funcionario_id = funcionario.funcionario_id;
        this.pedidos = funcionario.pedidos;
    }

}
