package edu.eam.ingesoft.onlinestore.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_productos_tienda")
data class ProductStore(
    @Id
    @Column(name = "id")
    val id:Int,

    @Column(name = "id_producto")
    var product: Product,

    @Column(name = "id_tienda")
    var store: Store,

    @Column(name = "precio")
    var price:Float,

    @Column(name="cantidad")
    var stock:Int
):Serializable
