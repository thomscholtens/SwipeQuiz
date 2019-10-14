package com.example.myapplication

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView


public class QuestionAdapter(private val questions: List<Question>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, index: Int) {
        holder.bind(questions[index])
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvQuestion: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(question: Question) {
            tvQuestion.text = question.question
        }

    }
}