package br.com.alura.forum.services

import br.com.alura.forum.dto.TopicoInputDto
import br.com.alura.forum.dto.TopicoResponseDto
import br.com.alura.forum.mapper.TopicoInputDtoMapper
import br.com.alura.forum.mapper.TopicoResponseDtoMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoResponseDtoMapper: TopicoResponseDtoMapper,
    private val topicoInputDtoMapper: TopicoInputDtoMapper,
    ) {

    fun listar(): List<TopicoResponseDto> {
        return topicos.stream().map {
                t -> topicoResponseDtoMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoResponseDto {
        val topico = topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()

        return topicoResponseDtoMapper.map(topico)
    }

    fun cadastrar(topicoInputDto: TopicoInputDto) {
        val topico = topicoInputDtoMapper.map(topicoInputDto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}