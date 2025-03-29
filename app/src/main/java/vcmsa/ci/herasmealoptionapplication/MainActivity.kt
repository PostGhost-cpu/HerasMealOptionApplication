package vcmsa.ci.herasmealoptionapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTime = findViewById<EditText>(R.id.edtTime)
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val btnMeal = findViewById<Button>(R.id.btnMeal)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnMeal.setOnClickListener {
            val Time = edtTime.text.toString()
            var meal : String = "Empty"
            var time : String = "Empty"

            //input time of day (morning, mid morning, afternoon, mid afternoon, dinner)
            if (Time == "Morning"){
                meal = "scrambled eggs with toast and avocado"
            }
            else if (Time == "Mid-Morning"){
                meal = "a smoothie made with spinach, banana, and almond milk"
            }
            else if (Time == "Afternoon"){
                meal = "grilled chicken salad with mixed greens, cucumbers, and a light vinaigrette dressing"
            }
            else if (Time == "Mid-Afternoon"){
                meal = "a carrot sticks with hummus or guacamole"
            }
            else if (Time == "Dinner"){
                meal = "grilled steak with mashed cauliflower and sautéed spinach"
            }
            else if(Time == "After Dinner"){
                meal = "chia Pudding with Berries"
            }
            //Display meal
            if (Time == "Morning"){
                time = "breakfast"
            }
            else if (Time == "Mid-Morning"){
                time = "snack"
            }
            else if (Time == "Afternoon"){
                time = "lunch"
            }
            else if (Time == "Mid-Afternoon"){
                time = "quick bite"
            }
            else if (Time == "Dinner"){
                time = "evening Meal"
            }
            else if (Time == "After Dinner"){
                time = "dessert"
            }


            //output meals and display suggestions
            txtDisplay.text = "Your $time, $meal"
        }

        btnReset.setOnClickListener {
            //reset button
            edtTime.text.clear()
            txtDisplay.text = " "
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}