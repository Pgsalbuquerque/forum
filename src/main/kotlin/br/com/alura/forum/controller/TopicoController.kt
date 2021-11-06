package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicoInputDto
import br.com.alura.forum.dto.TopicoResponseDto
import br.com.alura.forum.services.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoResponseDto> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoResponseDto {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid topicoInputDto: TopicoInputDto) {
        service.cadastrar(topicoInputDto)
    }
}