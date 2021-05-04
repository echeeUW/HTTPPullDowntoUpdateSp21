package edu.uw.echee.httppulldowntoupdate_sp21.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.uw.echee.httppulldowntoupdate_sp21.model.Email

class EmailDiffCallback(private val oldEmails: List<Email>, private val newEmails: List<Email>): DiffUtil.Callback() {

    override fun getOldListSize() = oldEmails.size
    override fun getNewListSize() = newEmails.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldEmails[oldItemPosition]
        val newItem = newEmails[newItemPosition]
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldEmails[oldItemPosition]
        val newItem = newEmails[newItemPosition]
        return oldItem == newItem
    }

}
