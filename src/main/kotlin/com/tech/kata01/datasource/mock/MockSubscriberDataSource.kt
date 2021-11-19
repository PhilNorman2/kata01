package com.tech.kata01.datasource.mock

import org.springframework.stereotype.Repository
import com.tech.kata01.datasource.SubscriberDataSource
import com.tech.kata01.model.Subscriber
import java.time.LocalDate

@Repository
class MockSubscriberDataSource : SubscriberDataSource {  

    override fun retrieveSubscribers(): Collection<Subscriber> {
        return listOf(
            Subscriber(1, "Joe", "Podunk", (LocalDate.parse("2021-11-16"))),
            Subscriber(2, "Jill", "Hometown", (LocalDate.parse("2021-11-20"))),
            Subscriber(3, "Ringo", "Liverpool", (LocalDate.parse("2021-11-16")))       
        )
    }

}