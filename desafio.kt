enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO}

class Usuario(val nome : String, val cpf: Int)

data class ConteudoEducacional(val nome: String, var duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
    
    fun alunosInscritos(){
        for(user in inscritos)
        	println(user.nome)
    }
    
    fun conteudosFormacao(){
        for(conteudo in conteudos) 
        	println("${conteudo.nome} - ${conteudo.duracao}") 
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    val javaBasico = ConteudoEducacional("Java basico", 20, Nivel.BASICO)
    val javaIntermediario = ConteudoEducacional("Java intermediario", 60, Nivel.INTERMEDIARIO)
    val javaAvancado = ConteudoEducacional("Java avançado", 100, Nivel.AVANCADO)
    
    val listaCursos = mutableListOf<ConteudoEducacional>()
    listaCursos.add(javaBasico)
    listaCursos.add(javaIntermediario)
    listaCursos.add(javaAvancado)
    
    
    val javaKotlinBackEnd = Formacao("Desenvolvimento Java/Kotlin Backend", listaCursos, Nivel.AVANCADO)
    
    val aluno1 = Usuario("Marcos", 12345)
    val aluno2 = Usuario("Yasmin", 54321)
    
    var duracaoCurso = javaBasico.duracao + javaIntermediario.duracao + javaAvancado.duracao
    
    javaKotlinBackEnd.matricular(aluno1)
    javaKotlinBackEnd.matricular(aluno2)
    
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    println("Informações sobre o Curso")
    println("O curso de ${javaKotlinBackEnd.nome} tem o nível de dificuldade ${javaKotlinBackEnd.nivel} sua duração é de $duracaoCurso horas" )
    println("O curso é composto pelas seguintes materias")
    println(javaKotlinBackEnd.conteudosFormacao())
    println("Neste curso estão matriculados os seguintes alunos")
    println(javaKotlinBackEnd.alunosInscritos())
      
    
}
