package edu.eam.ingesoft.onlinestore.repositorios

import edu.eam.ingesoft.onlinestore.model.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Component
@Transactional
class CityRepository {
    @Autowired

    lateinit var em: EntityManager

    fun create(city: City) {
        em.persist(city)
    }

    fun find (id: Int): City? {
        return em.find(City::class.java, id)
    }

    fun update(city: City) {
        em.merge(city)
    }

    fun delete(id: Int) {
        val city = find(id)

        if (city != null) {
            em.remove(city)
        }
    }
}
