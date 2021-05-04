package edu.uw.echee.httppulldowntoupdate_sp21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.httppulldowntoupdate_sp21.adapter.EmailAdapter
import edu.uw.echee.httppulldowntoupdate_sp21.databinding.ActivityMainBinding
import edu.uw.echee.httppulldowntoupdate_sp21.model.Email
import java.util.UUID
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            val emails = listOf<Email>()

            adapter = EmailAdapter(emails)
            rvEmails.adapter = adapter

        }
    }
}

/*
...
private fun createRandomSetOfEmails() = mutableListOf<Email>().apply {
    repeat(Random.nextInt(5, 30)) {
        add(Email("${UUID.randomUUID().toString().take(8)}@gmail.com", "foo bar baz hello world"))
    }
}
 */
