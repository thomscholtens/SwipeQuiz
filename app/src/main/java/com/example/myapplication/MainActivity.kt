package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import com.example.myapplication.Question.Companion.QUESTIONS

class MainActivity : AppCompatActivity() {

    private val questionAdapter = QuestionAdapter(QUESTIONS)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rvQuestions.layoutManager =  LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        rvQuestions.adapter = questionAdapter
        rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
        createItemTouchHelper().attachToRecyclerView(rvQuestions)
    }


    private fun createItemTouchHelper(): ItemTouchHelper {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.LEFT && QUESTIONS[position].answer || direction == ItemTouchHelper.RIGHT && !QUESTIONS[position].answer)
                    Toast.makeText(applicationContext,getString(R.string.correct),Toast.LENGTH_SHORT).show()
                 else
                    Toast.makeText(applicationContext,getString(R.string.incorrect),Toast.LENGTH_SHORT).show()
                questionAdapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }
        return ItemTouchHelper(simpleItemTouchCallback)
    }
}
