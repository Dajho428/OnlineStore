package edu.eam.ingesoft.onlinestore.repositorios

import edu.eam.ingesoft.onlinestore.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Component
@Transactional

class CategoryRepository{
    @Autowired

    lateinit var em:EntityManager

    fun create(category: Category){
        em.persist(category)
    }
    fun find(id:Int):Category?{
        return em.find(Category ::class.java,id)
    }
    fun update(category: Category){
        em.merge(category)
    }
    fun delete(id:Int){
        val category=find(id)

        if (category!= null){
            em.remove(category)
        }
    }
}
