package com.github.leafarsomel.mod6.service;

import com.github.leafarsomel.mod6.repository.TreinoRepository;
import com.github.leafarsomel.mod6.entity.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {
    @Autowired
    TreinoRepository treinoRepository;

    // Create
    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }

    // Read
    public List<Treino> getAll() {
        return treinoRepository.findAll();
    }

    public Treino getById(Integer id) {
        return treinoRepository.findById(id).orElse(null);
    }

    public Long getTreinoDuracao(Integer id) {
        Treino treino = treinoRepository.findById(id).orElse(null);
        if (treino != null) {
            return treino.getTreinoDuracao();
        } else {
            return null;
        }
    }

    // Update
    public Treino update(Integer id, Treino treino) {
        Treino treinoAtualizado = treinoRepository.findById(id).orElse(null);
        if (treinoAtualizado != null) {
            treinoAtualizado.setTreinoInicio(treino.getTreinoInicio());
            treinoAtualizado.setTreinoSeries(treino.getTreinoSeries());
            treinoAtualizado.setTreinoFinal(treino.getTreinoFinal());
            treinoAtualizado.setTreinoLocal(treino.getTreinoLocal());
            return treinoRepository.save(treinoAtualizado);
        } else {
            return null;
        }
    }

    // Delete
    public Boolean deletetreino(Integer id) {
        Treino treino = treinoRepository.findById(id).orElse(null);
        if (treino != null) {
            treinoRepository.delete(treino);
            return true;
        } else {
            return false;
        }
    }
}
