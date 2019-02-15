package es.voghdev.pdfviewpager.library.adapter

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class PDFPagerAdapterTest {

    private val context get() = InstrumentationRegistry.getContext()
    private val tempFile by lazy { File(context.cacheDir, "tempFile.pdf") }

    @Before
    fun setUp() {
        with(tempFile) {
            if (exists()) delete()
            createNewFile()
            writeText("this text does not represent a pdf file")
        }
    }

    @After
    fun tearDown() {
        with(tempFile) {
            if (exists()) delete()
        }
    }

    @Test(expected = IOException::class)
    fun shouldThrowExceptionIfPdfIsNotValid() {
        PDFPagerAdapter(context, tempFile.absolutePath)
    }
}
