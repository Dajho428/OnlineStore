package edu.eam.ingesoft.onlinestore.services

import edu.eam.ingesoft.onlinestore.exceptions.BusinessException
import edu.eam.ingesoft.onlinestore.model.Store
import edu.eam.ingesoft.onlinestore.repositorios.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class StoreService {
    @Autowired
    lateinit var storeRepository: StoreRepository

    fun createStore(store: Store){
        val storeAux= storeRepository.find(store.id)

        if (storeAux!=null){
            throw BusinessException("This store already exists")
        }
        storeRepository.create(store)
    }

    fun editStore(store: Store) {
        val storeAux = storeRepository.find(store.id)

        if (storeAux == null) {
            throw BusinessException("This store doesn't exist")
        }

        storeRepository.update(store)
    }
}