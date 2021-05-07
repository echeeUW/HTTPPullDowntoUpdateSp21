package edu.uw.echee.httppulldowntoupdate_sp21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import edu.uw.echee.httppulldowntoupdate_sp21.adapter.EmailAdapter
import edu.uw.echee.httppulldowntoupdate_sp21.databinding.ActivityMainBinding
import edu.uw.echee.httppulldowntoupdate_sp21.model.Email
import edu.uw.echee.httppulldowntoupdate_sp21.model.Inbox
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmailAdapter

    private val myApp: HPDUApplication by lazy { application as HPDUApplication }
    private val dataRepository by lazy { myApp.dataRepository }

    private lateinit var emails: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            emails = listOf()

            adapter = EmailAdapter(emails)
            rvEmails.adapter = adapter

            val emailManager = myApp.emailManager

            adapter.onEmailClickListener = {
                emailManager.onEmailClicked()
            }

            btnRefresh.setOnClickListener { loadEmails() }

            pullDownContainer.setOnRefreshListener {
                loadEmails()
                pullDownContainer.isRefreshing = false
            }
        }
    }

    private fun loadEmails() {
        lifecycleScope.launch {
            runCatching {
                Toast.makeText(this@MainActivity, "loading...", Toast.LENGTH_SHORT).show()

                val inbox: Inbox = dataRepository.getInbox()
                emails = inbox.emails

                adapter.updateEmails(emails)
            }.onFailure {
//                binding.rvEmails.visibility = View.GONE
//                binding.tvErroMsg.text = "AN ERROR HAS OCCURRED PLEASE TRY AGAIN"
                Toast.makeText(this@MainActivity, "Error occurred when fetching your inbox", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
