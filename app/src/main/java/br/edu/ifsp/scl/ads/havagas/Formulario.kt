package br.edu.ifsp.scl.ads.havagas

    class Formulario{
        var nome:String = ""
        var email:String = ""
        var telefone:String = ""
        var telefoneCelular:String = ""
        var sexo:String=""
        var dataDeNascimento:String=""
        var formacao:String=""
        var vagasDeInteresse:String=""

        constructor(
            formacao: String,
            vagasDeInteresse: String,
            dataDeNascimento: String,
            sexo: String,
            telefoneCelular: String,
            telefone: String,
            email: String,
            nome: String
        ) {
            this.formacao = formacao
            this.vagasDeInteresse = vagasDeInteresse
            this.dataDeNascimento = dataDeNascimento
            this.sexo = sexo
            this.telefoneCelular = telefoneCelular
            this.telefone = telefone
            this.email = email
            this.nome = nome
        }


        override fun toString(): String {
            return "nome='$nome', email='$email', telefone='$telefone', " +
                    "telefoneCelular='$telefoneCelular', sexo='$sexo', dataDeNascimento='$dataDeNascimento', " +
                    "formacao='$formacao', vagasDeInteresse='$vagasDeInteresse'"
            }
}