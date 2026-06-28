package com.gestaoeventosapi.controller;

import com.gestaoeventosapi.model.Evento;
import com.gestaoeventosapi.model.Participante;
import com.gestaoeventosapi.model.Inscricao;
import com.gestaoeventosapi.model.Credenciamento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.gestaoeventosapi.repository.EventoRepository eventoRepository;

    @Autowired
    private com.gestaoeventosapi.repository.ParticipanteRepository participanteRepository;

    @Autowired
    private com.gestaoeventosapi.repository.InscricaoRepository inscricaoRepository;

    @Autowired
    private com.gestaoeventosapi.repository.CredenciamentoRepository credenciamentoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalEvento", eventoRepository.count());
        resumo.put("somaPrecoEvento", eventoRepository.findAll().stream().map(e -> e.getPreco()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoEvento", eventoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalParticipante", participanteRepository.count());
        resumo.put("totalInscricao", inscricaoRepository.count());
        resumo.put("somaValorInscricao", inscricaoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoInscricao", inscricaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCredenciamento", credenciamentoRepository.count());
        return resumo;
    }
}
