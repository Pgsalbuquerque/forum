package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoInputDto
import br.com.alura.forum.model.Topico
import br.com.alura.forum.services.CursoService
import br.com.alura.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoInputDtoMapper(
    private val cursoService: CursoService,
    private val usuariorService: UsuarioService,
): Mapper<TopicoInputDto,Topico>{
    override fun map(t: TopicoInputDto): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuariorService.buscarPorId(t.idAutor),
        )
    }

}
