package br.com.fiap.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MessageResponseDTO {
    private String message;
    private List<String> erros = new ArrayList<>();
}
