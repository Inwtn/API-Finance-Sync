package com.isaac.financesync.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransactionRequestDTO {
    private String data;
    private String tipo;
    private String categoria;
    private String descricao;
    private BigDecimal valor;
}