package edu.eam.ingesoft.onlinestore.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_usuarios")
data class User(
    @Id
    @Column(name = "id_usuario")
    val id: String,

    @Column(name="direccion")
    var address :String,

    @Column(name="apellido")
    var lastName:String,

    @Column(name="nombre")
    var name:String,

    @Column(name="id_ciudad")
    var citi: City

) : Serializable
