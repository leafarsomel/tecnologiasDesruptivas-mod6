package com.github.leafarsomel.mod6.controller;

import com.github.leafarsomel.mod6.entity.Treino;
import com.github.leafarsomel.mod6.service.TreinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treino")
public class TreinoController {
        @Autowired
        TreinoService treinoService;

        // Create
        @Operation(summary = "Registra um novo treino", description = "Registra um novo treino")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Operação bem sucedida")
        })
        @PostMapping
        public ResponseEntity<Treino> saveTreino(@RequestBody Treino treino) {
                return new ResponseEntity<>(treinoService.save(treino), HttpStatus.CREATED);
        }

        // Read
        @Operation(summary = "Retorna todos os treinos", description = "Retorna todos os treinos registrados no banco de dados")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operação bem sucedida")
        })
        @GetMapping
        public ResponseEntity<List<Treino>> getAll() {
                List<Treino> treinos = treinoService.getAll();
                if (!treinos.isEmpty()) {
                        return new ResponseEntity<>(treinos, HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
        }

        @Operation(summary = "Retorna um treino", description = "Retorna um treino relacionado ao ID fornecido na URL")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                        @ApiResponse(responseCode = "404", description = "Treino não encontrado")
        })
        @GetMapping("/{id}")
        public ResponseEntity<Treino> getById(@PathVariable Integer id) {
                Treino treino = treinoService.getById(id);
                if (treino != null) {
                        return new ResponseEntity<>(treino, HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
        }

        // Update
        @Operation(summary = "Atualiza um treino", description = "Atualiza os dados de um ou mais campos relacionados a um treino")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                        @ApiResponse(responseCode = "404", description = "Treino não encontrada")
        })
        @PutMapping("/{id}")
        public ResponseEntity<Treino> updateTreino(@PathVariable Integer id, @RequestBody Treino treino) {
                Treino treinoAtualizado = treinoService.update(id, treino);
                if (treinoAtualizado != null) {
                        return new ResponseEntity<>(treinoAtualizado, HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
        }

        // Delete
        @Operation(summary = "Exclui um treino", description = "Exclui o registro de um treino do banco de dados")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
                        @ApiResponse(responseCode = "404", description = "Treion não encontrada")
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
                if (treinoService.deletetreino(id)) {
                        return new ResponseEntity<>(true, HttpStatus.OK);
                } else {
                        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
                }
        }

}
