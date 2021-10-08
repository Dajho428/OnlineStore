package edu.eam.ingesoft.onlinestore.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="tbl_tienda")
data class Store(
    @Id
    @Column(name="id_tienda")
    val id:Int,

    @Column(name="direccion")
    var address:String,

    @Column(name="nombre")
    var name:String,

    @Column(name="id_ciudad")
    var city: City
):Serializable
