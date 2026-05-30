package com.isaac.financesync.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.isaac.financesync.dto.TransactionRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleSheetsService {

    @Value("${google.sheets.id}")
    private String spreadsheetId;

    private Sheets getSheetsService() throws Exception {
        InputStream in = getClass().getResourceAsStream("/google-credentials.json");
        if (in == null) {
            throw new RuntimeException("Arquivo google-credentials.json não encontrado na pasta resources!");
        }

        GoogleCredentials credentials = GoogleCredentials.fromStream(in)
                .createScoped(Collections.singletonList(SheetsScopes.SPREADSHEETS));

        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials))
                .setApplicationName("Finance Sync API")
                .build();
    }

    public void appendTransaction(TransactionRequestDTO dto) throws Exception {
        Sheets sheetsService = getSheetsService();

        List<Object> rowData = Arrays.asList(
                dto.getData(),
                dto.getTipo(),
                dto.getCategoria(),
                dto.getDescricao(),
                dto.getValor().toString()
        );

        ValueRange body = new ValueRange().setValues(Collections.singletonList(rowData));

        // Envia os dados para a aba "Página1" da planilha
        sheetsService.spreadsheets().values()
                .append(spreadsheetId, "Página1", body)
                .setValueInputOption("USER_ENTERED")
                .execute();
    }
}