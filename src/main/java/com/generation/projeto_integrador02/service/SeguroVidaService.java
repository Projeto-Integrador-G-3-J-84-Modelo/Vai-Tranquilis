package com.generation.projeto_integrador02.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador02.model.PlanoSeguro;
import com.generation.projeto_integrador02.model.SeguroVida;
import com.generation.projeto_integrador02.model.Usuario;
import com.generation.projeto_integrador02.repository.PlanoSeguroRepository;
import com.generation.projeto_integrador02.repository.SeguroVidaRepository;
import com.generation.projeto_integrador02.repository.UsuarioRepository;

@Service
public class SeguroVidaService {

    @Autowired
    private SeguroVidaRepository seguroRepository;
    
    @Autowired
    private PlanoSeguroRepository planoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<SeguroVida> listarTodos() {
        return seguroRepository.findAll();
    }
    
    public Optional<SeguroVida> buscarPorId(Long id) {
        return seguroRepository.findById(id);
    }
    
    public SeguroVida criar(SeguroVida seguroVida) {
            // 1. Busca o plano completo no banco para saber o valor da cobertura
            PlanoSeguro plano = planoRepository.findById(seguroVida.getPlanoSeguro().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado"));
            
            // 2. Busca o usuário completo no banco de dados para popular os campos null
            Usuario usuario = usuarioRepository.findById(seguroVida.getUsuario().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

            // 3. Aplica a regra de cálculo (Exemplo: 0.1% da cobertura máxima)
            Double taxaMensal = 0.001; 
            Double mensalidadeCalculada = plano.getIndenizacaoMaxima() * taxaMensal;

            // 4. Define o valor gerado dentro do objeto do contrato
            seguroVida.setValorMensalidade(mensalidadeCalculada);
            seguroVida.setPlanoSeguro(plano); // Garante a associação completa
            seguroVida.setUsuario(usuario);

            // 5. Salva o contrato com o valor calculado automaticamente pelo sistema
            return seguroRepository.save(seguroVida);
    }
  
    
    public SeguroVida atualizar(SeguroVida seguroVida) {
        // 1. Valida se o contrato enviado realmente existe no banco
        SeguroVida contratoExistente = seguroRepository.findById(seguroVida.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato de seguro não encontrado"));

        // 2. CORRIGIDO: Busca o NOVO plano usando o planoRepository correto
        PlanoSeguro novoPlano = planoRepository.findById(seguroVida.getPlanoSeguro().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Novo Plano não encontrado"));

        // 3. Busca o usuário cadastrado para manter os dados populados na resposta da API
        Usuario usuario = usuarioRepository.findById(seguroVida.getUsuario().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        // 4. AUTOMAÇÃO: Força a nova data de contratação para a data atual (hoje)
        seguroVida.setDataContratacao(LocalDate.now());

        // 5. CORRIGIDO: Recalcula a mensalidade usando 'coberturaMaxima' da sua classe PlanoSeguro
        Double taxaMensal = 0.001; 
        Double novaMensalidade = novoPlano.getIndenizacaoMaxima() * taxaMensal;
        seguroVida.setValorMensalidade(novaMensalidade);

        // 6. Vincula as entidades completas para evitar o retorno com campos 'null'
        seguroVida.setPlanoSeguro(novoPlano);
        seguroVida.setUsuario(usuario);

        // 7. Salva e atualiza o registro no banco de dados
        return seguroRepository.save(seguroVida);
    }

}


