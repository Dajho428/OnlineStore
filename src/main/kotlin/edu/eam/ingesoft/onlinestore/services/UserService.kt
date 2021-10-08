package edu.eam.ingesoft.onlinestore.services

import edu.eam.ingesoft.onlinestore.exceptions.BusinessException
import edu.eam.ingesoft.onlinestore.model.User
import edu.eam.ingesoft.onlinestore.repositorios.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(user: User){
        val userAux= userRepository.find(user.id)

        if (userAux!=null){
            throw BusinessException("This user already exists")
        }

        userRepository.create(user)
    }
    fun editStore(user: User) {
        val userAux = userRepository.find(user.id)

        if (userAux == null) {
            throw BusinessException("This user doesn't exist")
        }

        userRepository.update(user)
    }
}