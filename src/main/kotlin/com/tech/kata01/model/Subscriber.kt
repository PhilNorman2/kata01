package com.tech.kata01.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import java.time.LocalDate

@Entity
data class Subscriber (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val firstName: String = "",

    @get: NotBlank
    val city: String = "",
    
    val addedDate: LocalDate = LocalDate.now()
)