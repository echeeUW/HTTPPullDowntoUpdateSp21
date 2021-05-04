package edu.uw.echee.httppulldowntoupdate_sp21.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import edu.uw.echee.httppulldowntoupdate_sp21.databinding.ItemEmailBinding
import edu.uw.echee.httppulldowntoupdate_sp21.model.Email

class EmailAdapter(
    private var emails: List<Email>
): RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    var onEmailClickListener: (Email) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = ItemEmailBinding.inflate(LayoutInflater.from(parent.context))
        return EmailViewHolder(binding)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]

        with(holder.binding) {
            tvEmailAddress.text = email.from
            tvMsg.text = email.content

            root.setOnClickListener {

            }
        }
    }

    class EmailViewHolder(val binding: ItemEmailBinding): RecyclerView.ViewHolder(binding.root)

    fun updateEmails(newEmails: List<Email>) {
        val callback = EmailDiffCallback(this.emails, newEmails)
        val results = DiffUtil.calculateDiff(callback)
        results.dispatchUpdatesTo(this)

        this.emails = newEmails
    }
}

