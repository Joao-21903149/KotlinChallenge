package pt.ulusofona.cm.kotlin.challenge

import java.util.*
import javax.naming.InvalidNameException

fun checkIdade(idade : Int){
    if (idade < 18){
        throw InvalidNameException("Esta Pessoa é menor de idade, têm $idade anos.")
    }
}

fun main(){
    try {
    } catch (e : InvalidNameException){
        println(e.message)
    } catch (e : Exception){
        println(e.message)
    }
}

    abstract class Veiculo(val name: String) {
        var x = 0
        var y = 0
        var identificadorVeiculo = ""
        var posicao = Posicao(x,y,identificadorVeiculo)
        var dataDeAquisicao = Date()
        override fun toString(): String {
            return "Veiculo(identificadorVeiculo='$identificadorVeiculo')"
        }

        fun requerCarta():Boolean{
            return false
        }
    }

    abstract class Pessoa(val name: String) {
        var x = 0
        var y = 0
        var nome = ""
        val veiculos : List<Int> = listOf()
        var dataDeNascimento = Date()
        var posicao = Posicao(x,y,nome)


        override fun toString(): String {
            return "Pessoa(nome='$nome', date=$dataDeNascimento)"
        }


    }

    class Carro(x: Int, y: Int, name: String) : Posicao(x,y,name),Movimentavel, Ligavel {
        var identificadorCarro = ""
        var motor = Motor(identificadorCarro)

        override fun toString(): String {
            return "Carro(identificador='$identificadorCarro', motor=$motor)"
        }
        override fun ligar() {
        }
        override fun desligar() {
        }
        override fun estaLigado():Boolean {
            return false
        }
        override fun moverPara(x: Int, y: Int) {
        }


    }

    class Bicicleta(x: Int, y: Int,name: String) : Posicao(x,y,name), Movimentavel {
        var identificadorBicicleta = ""

        override fun toString(): String {
            return "Bicicleta(identificador='$identificadorBicicleta')"
        }
        override fun moverPara(x: Int, y: Int) {
        }


    }

    class Carta(name: String) : Pessoa(name) {
        fun carta(){}
    }

    open class Posicao(x: Int, y: Int, name: String) : Veiculo(name) {

    }

    class Motor(name: String) : Veiculo(name), Ligavel {
        var cavalos = 0
        var cilindrada = 0
        var ligado = true

        override fun toString(): String {
            return "Motor(cavalos=$cavalos, cilindrada=$cilindrada)"
        }
        override fun ligar() {
        }
        override fun desligar() {
        }
        override fun estaLigado():Boolean {
            return false
        }
    }


    interface Movimentavel {
       fun moverPara(x: Int, y: Int){

       }

    }
    interface Ligavel {
        fun ligar(){

        }
        fun desligar(){

        }
        fun estaLigado():Boolean{
            return false
        }
    }


