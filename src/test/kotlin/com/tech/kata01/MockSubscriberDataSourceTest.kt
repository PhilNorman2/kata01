package com.tech.kata01.datasource.mock

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

internal class MockSubscriberDataSourceTest {

    private val mockDataSource = MockSubscriberDataSource()

    @Test
    fun `should provide a collection of subscribers`() {

        // given

        //when
        val subscribers = mockDataSource.retrieveSubscribers()

        //then
        assertTrue(subscribers.isNotEmpty())
    }

    @Test
    fun `should provide mock data`() {

        // given

        //when
        val subscribers = mockDataSource.retrieveSubscribers()

        //then
        assertEquals(subscribers.elementAt(0).id, 1, "First ID is not 1")

        for (item in subscribers) {
             assertNotEquals(item.firstName, "", "Found blank firstName")
             assertNotEquals(item.city, "", "Found blank city")
        }
       

    }
    
}