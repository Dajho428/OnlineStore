package edu.eam.ingesoft.onlinestore.services

import edu.eam.ingesoft.onlinestore.exceptions.BusinessException
import edu.eam.ingesoft.onlinestore.repositorios.ProductStoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ProductStoreService {

    @Autowired
    lateinit var productStoreRepository: ProductStoreRepository
    fun decreaseStock(idProductStore: Int, decreaseStock: Int) {
        val productStore = productStoreRepository.find(idProductStore)

        if (productStore == null) {
            throw BusinessException("This product store doesn't exist")
        }
        if (decreaseStock > productStore.stock) {
            throw BusinessException("There can't be less than zero stocks")
        }
        productStore.stock = productStore.stock - decreaseStock
        productStoreRepository.update(productStore)


    }

    fun increaseStock(idProductStore: Int, increaseStock: Int) {

        val productStore = productStoreRepository.find(idProductStore)

        if (productStore == null) {
            throw BusinessException("This product store doesn't exist")
        }
        productStore.stock = productStore.stock + increaseStock
        productStoreRepository.update(productStore)
    }
}