package com.tech.kata01.datasource

import com.tech.kata01.model.Subscriber

interface SubscriberDataSource {
    fun retrieveSubscribers(): Collection<Subscriber>
}