package br.com.mercado.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigoBarras;
    private int quantidadeInicial;
    private double precoCusto;
    private double precoVenda;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private CategoriaProduto categoria;

    private String unidadeMedida;
    private LocalDate dataEntrada;
}
