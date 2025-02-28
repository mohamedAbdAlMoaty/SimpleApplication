package com.example.simpleapplication.repository


import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.data.network.ApodApiService
import com.example.simpleapplication.data.repository.ApodRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class ApodRepositoryTest {

    private lateinit var repository: ApodRepository
    private lateinit var apiService: ApodApiService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        apiService = mock(ApodApiService::class.java)
        repository = ApodRepository(apiService)
    }

    @Test
    fun `fetchApodItems returns list of APODs`() = runBlocking {
        // Mock API response
        val mockResponse = listOf(
            ApodItem("2025-02-27", "Galaxy Image", "https://example.com/image.jpg", "Description")
        )

        `when`(apiService.getApod("fake_api_key", 1)).thenReturn(mockResponse)

        // Call repository method
        val result = repository.fetchApodItems("fake_api_key", 1)

        // Assertions
        assertEquals(1, result.size)
        assertEquals("Galaxy Image", result[0].title)
    }
}
