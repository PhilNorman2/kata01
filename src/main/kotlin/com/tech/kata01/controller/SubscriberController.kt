package com.tech.kata01.controller

import com.tech.kata01.model.Subscriber
import com.tech.kata01.repository.SubscriberRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class SubscriberController(private val subscriberRepository: SubscriberRepository) {

    @GetMapping("/subscribers")
    fun getAllSubscribers(): List<Subscriber> =
            subscriberRepository.findAll()

    @CrossOrigin
    @PostMapping("/subscribers")
    fun createNewSubscriber(@Valid @RequestBody subscriber: Subscriber): Subscriber =
            subscriberRepository.save(subscriber)

    @CrossOrigin
    @GetMapping("/subscribers/{id}")
    fun getSubscriberById(@PathVariable(value = "id") subscriberId: Long): ResponseEntity<Subscriber> {
        return subscriberRepository.findById(subscriberId).map { subscriber -> 
            ResponseEntity.ok(subscriber)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/subscribers/{id}")
    fun updateSubscriberById(@PathVariable(value = "id") subscriberId: Long,
                          @Valid @RequestBody newSubscriber: Subscriber): ResponseEntity<Subscriber> {

        return subscriberRepository.findById(subscriberId).map { existingSubscriber ->
            val updatedSubscriber: Subscriber = existingSubscriber
                    .copy(firstName = newSubscriber.firstName, city = newSubscriber.city)
            ResponseEntity.ok().body(subscriberRepository.save(updatedSubscriber))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/subscribers/{id}")
    fun deleteSubscriberById(@PathVariable(value = "id") subscriberId: Long): ResponseEntity<Void> {

        return subscriberRepository.findById(subscriberId).map { subscriber  ->
            subscriberRepository.delete(subscriber)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}
