package com.example.simpleapplication.repository


import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.data.network.ApodApiService
import com.example.simpleapplication.data.repository.ApodRepository
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

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

        val mockResponse = listOf(
            ApodItem("2025-02-27", "Galaxy Image", "https://example.com/image.jpg", "Description")
        )

        `when`(apiService.getApod("fake_api_key", 1)).thenReturn(mockResponse)

        val result = repository.fetchApodItems("fake_api_key", 1)

        assertEquals(1, result.size)
        assertEquals("Galaxy Image", result[0].title)
    }

    @Test
    fun `fetchApodItems returns correct date`() = runBlocking {

        val mockResponse = listOf(
            ApodItem("2025-02-27", "Galaxy Image", "https://example.com/image.jpg", "Description")
        )

        `when`(apiService.getApod("fake_api_key", 1)).thenReturn(mockResponse)

        val result = repository.fetchApodItems("fake_api_key", 1)

        assertEquals(1, result.size)
        assertEquals("2025-02-27", result[0].date)
        assertNotEquals("2025-02-28", result[0].date)
    }

    @Test
    fun `fetchApodItems returns description when description is provided`() = runBlocking {

        val mockResponse = listOf(
            ApodItem("2025-02-27", "Galaxy Image", "https://example.com/image.jpg", "this image is very nice")
        )

        `when`(apiService.getApod("fake_api_key", 1)).thenReturn(mockResponse)

        val result = repository.fetchApodItems("fake_api_key", 1)

        assertEquals(1, result.size)
        assertEquals("this image is very nice", result[0].explanation)
        assertNotEquals("this image is bad", result[0].explanation)
    }
    @Test
    fun `fetchApodItems handles 500 Internal Server Error connection`() = runBlocking {

        val mockHttpException = HttpException(Response.error<List<ApodItem>>(500, "".toResponseBody()))
        `when`(apiService.getApod("fake_api_key", 1)).thenThrow(mockHttpException)
        try {
            repository.fetchApodItems("fake_api_key", 1)
            fail("Expected HttpException or custom ApiException to be thrown")
        } catch (e: HttpException) {
            assertEquals(500, e.code())
        }
    }




    @Test
    fun `fetchApodItems returns empty list when API response is empty`() = runBlocking {
        `when`(apiService.getApod("fake_api_key", 1)).thenReturn(emptyList())

        val result = repository.fetchApodItems("fake_api_key", 1)

        assertTrue(result.isEmpty())
    }
}
