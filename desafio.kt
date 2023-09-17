data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: String)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

  // Aqui na função matricular, tem uma verificação se o usuário já possui uma matricula.
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
                println("${usuario.nome} matriculado na formação $nome")
            } else {
                println("${usuario.nome} já está matriculado na formação $nome")
            }
        }
    }
// Aqui também é feita uma verificação se o usuário está matriculado.
    fun cancelarMatricula(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("${usuario.nome} desmatriculado da formação $nome")
        } else {
            println("${usuario.nome} não estava matriculado na formação $nome")
        }
    }
//Aqui verifica se existe ou não uma matricula
    fun verificarMatricula(usuario: Usuario): Boolean {
        return inscritos.contains(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("Miguel")
    val usuario2 = Usuario("Ana")
    val usuario3 = Usuario("Inácio")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 6, "Básico")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 8, "Intermediário")
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android", 12, "Avançado")

    val formacao = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    formacao.matricular(usuario1, usuario2, usuario3)
    formacao.cancelarMatricula(usuario2)

    println("Verificar matrícula de Ana: ${formacao.verificarMatricula(usuario2)}")
    println("Verificar matrícula de Inácio: ${formacao.verificarMatricula(usuario3)}")
}
