package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoResponseDto
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoResponseDtoMapper: Mapper<Topico, TopicoResponseDto> {
    override fun map(t: Topico): TopicoResponseDto {
        return TopicoResponseDto(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}