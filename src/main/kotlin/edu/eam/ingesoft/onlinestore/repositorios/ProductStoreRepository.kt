package edu.eam.ingesoft.onlinestore.repositorios

import edu.eam.ingesoft.onlinestore.model.Category
import edu.eam.ingesoft.onlinestore.model.Product
import edu.eam.ingesoft.onlinestore.model.ProductStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Component
@Transactional
class ProductStoreRepository{
    @Autowired

    lateinit var em: EntityManager

    fun create(productStore: ProductStore){
        em.persist(productStore)
    }
    fun find(id:Int): ProductStore?{
        return em.find(ProductStore ::class.java,id)
    }
    fun update(productStore: ProductStore){
        em.merge(productStore)
    }
    fun delete(id:Int){
        val productStore=find(id)

        if (productStore!= null){
            em.remove(productStore)
        }
    }
    fun listStoreProducts():List<Product>{
        val query = em.createQuery("SELECT product FROM ProductStore product")
        return query.resultList as List<Product>
    }

    fun listStoreProductsByCategory(category: Category):List<Product>{
        val query = em.createQuery("SELECT product FROM ProductStore product WHERE product.category = :category")
        query.setParameter("category",category)
        return query.resultList as List<Product>
    }
}
