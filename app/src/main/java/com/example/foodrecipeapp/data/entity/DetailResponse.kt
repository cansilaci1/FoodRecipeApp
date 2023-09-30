import com.example.foodrecipeapp.data.entity.Update
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("recipe") val recipes: Update,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String?
)
