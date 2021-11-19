package com.tech.kata01.repository

import com.tech.kata01.model.Subscriber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubscriberRepository : JpaRepository<Subscriber, Long>