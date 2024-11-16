import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.valdeos.flavio.laboratoriocalificado03.Teacher
import com.valdeos.flavio.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    private val context: Context,
    private val teachers: List<Teacher>
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(val binding: ItemTeacherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemTeacherBinding.inflate(LayoutInflater.from(context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.binding.tvTeacherName.text = teacher.name
        holder.binding.tvTeacherLastName.text = teacher.last_name
        Glide.with(context).load(teacher.image_url).into(holder.binding.ivTeacherImage)

        holder.itemView.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phone_number}"))
            context.startActivity(callIntent)
        }

        holder.itemView.setOnLongClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${teacher.email}"))
            context.startActivity(emailIntent)
            true
        }
    }

    override fun getItemCount(): Int = teachers.size
}
