package com.isaac.financesync.controller;

import com.isaac.financesync.dto.TransactionRequestDTO;
import com.isaac.financesync.service.GoogleSheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private GoogleSheetsService googleSheetsService;

    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequestDTO request) {
        try {
            googleSheetsService.appendTransaction(request);
            return ResponseEntity.ok("Transação salva com sucesso na planilha!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao salvar transação: " + e.getMessage());
        }
    }
}